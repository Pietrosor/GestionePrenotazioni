package entities;

import enumeration.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="postazioni")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name="edificio_id")
    private Edificio edificio;
}