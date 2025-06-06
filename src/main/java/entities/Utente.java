package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utente {
    @Id
    private String username;

    private String nomeCompleto;
    private String email;
}
