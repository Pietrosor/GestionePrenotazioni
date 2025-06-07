package service;

import entities.Postazione;
import enumeration.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PostazioneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> getPostazioniByTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipo(tipo);
    }

    public Optional<Postazione> getPostazioneByCodiceUnivoco(String codiceUnivoco) {
        return postazioneRepository.findByCodiceUnivoco(codiceUnivoco);
    }

    public void deletePostazione(Long id) {
        postazioneRepository.deleteById(id);
    }
}