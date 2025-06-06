package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="edifici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String indirizzo;
    private String citta;
}
