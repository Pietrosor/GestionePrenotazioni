package service;

import entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PrenotazioneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        boolean exists = prenotazioneRepository.existsByPostazioneAndData(
                prenotazione.getPostazione(), prenotazione.getData());
        if (exists) {
            throw new IllegalArgumentException("La postazione è già prenotata in questa data.");
        }
        return prenotazioneRepository.save(prenotazione);
    }


    public Optional<Prenotazione> getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id);
    }


    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }


    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}