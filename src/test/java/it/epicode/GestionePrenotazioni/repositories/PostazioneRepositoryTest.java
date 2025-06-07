package it.epicode.GestionePrenotazioni.repositories;

import entities.Postazione;
import enumeration.TipoPostazione;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import repositories.PostazioneRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostazioneRepositoryTest {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Test
    public void testSavePostazione() {
        Postazione postazione = new Postazione(null, "ABC123", "Postazione privata", TipoPostazione.PRIVATO, 4, null);
        postazioneRepository.save(postazione);
        assertTrue(postazioneRepository.existsByCodiceUnivoco("ABC123"));
    }
}