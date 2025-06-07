package repositories;

import entities.Postazione;
import enumeration.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipo(TipoPostazione tipo);

    Optional<Postazione> findByCodiceUnivoco(String codiceUnivoco);

    List<Postazione> findByMaxOccupantiGreaterThanEqual(int minOccupanti);

    boolean existsByCodiceUnivoco(String abc123);
}