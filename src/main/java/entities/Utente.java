package entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="utenti")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String nomeCompleto;


    @Column(unique = true)
    private String email;
}
