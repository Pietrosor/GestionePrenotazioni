package repositories;

import entities.Postazione;
import entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository  extends JpaRepository <Prenotazione, Long>{
    boolean existByPostazioneAndData(Postazione postazione, LocalDate data);
}
