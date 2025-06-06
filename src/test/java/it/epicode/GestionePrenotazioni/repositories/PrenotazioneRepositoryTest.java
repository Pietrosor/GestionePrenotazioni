package it.epicode.GestionePrenotazioni.repositories;

import entities.Postazione;
import entities.Prenotazione;
import enumeration.TipoPostazione;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import repositories.PostazioneRepository;
import repositories.PrenotazioneRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PrenotazioneRepositoryTest {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Test
    @DisplayName("Test salvataggio prenotazione")
    void salvaPrenotazione() {
        Postazione postazione = new Postazione();
        postazione.setCodiceUnivoco("PS001");
        postazione.setDescvrizione("Postazione OpenSpace");
        postazione.setTipo(TipoPostazione.OPENSPACE);
        postazione.setMaxOccupanti(10);
        postazione = postazioneRepository.save(postazione);


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(LocalDate.now());

        prenotazione.setUtente(null);
        prenotazione.setPostazione(postazione);
        prenotazione = prenotazioneRepository.save(prenotazione);
        assertThat(prenotazione.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test query custom: verifica esistenza prenotazione per postazione e data")
    void testExistsByPostazioneAndData() {

        Postazione postazione = new Postazione();
        postazione.setCodiceUnivoco("PS002");
        postazione.setDescvrizione("Postazione Privato");
        postazione.setTipo(TipoPostazione.PRIVATO);
        postazione.setMaxOccupanti(1);
        postazione = postazioneRepository.save(postazione);

        LocalDate oggi = LocalDate.now();

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(oggi);
        prenotazione.setUtente(null);
        prenotazione.setPostazione(postazione);
        prenotazioneRepository.save(prenotazione);

     
        boolean exists = prenotazioneRepository.existByPostazioneAndData(postazione,oggi);// criterio: "existsBy..."
        assertThat(exists).isTrue();
    }
}