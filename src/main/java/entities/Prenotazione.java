package entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="prenotazioni", uniqueConstraints = @UniqueConstraint(columnNames = {"utente_id", "postazione_id", "data"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
}