package repositories;

import entities.Postazione;
import enumeration.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipo(TipoPostazione tipo);

    Postazione findByCodiceUnivoco(String codiceUnivoco);


}