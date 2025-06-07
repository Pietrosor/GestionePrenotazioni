package controller;

import entities.Postazione;
import enumeration.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostazioneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {

    @Autowired
    private PostazioneService postazioneService;

    @PostMapping
    public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione postazione) {
        return ResponseEntity.ok(postazioneService.savePostazione(postazione));
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<Postazione>> getPostazioniByTipo(@PathVariable TipoPostazione tipo) {
        return ResponseEntity.ok(postazioneService.getPostazioniByTipo(tipo));
    }

    @GetMapping("/codice/{codiceUnivoco}")
    public ResponseEntity<Optional<Postazione>> getPostazioneByCodice(@PathVariable String codiceUnivoco) {
        return ResponseEntity.ok(postazioneService.getPostazioneByCodiceUnivoco(codiceUnivoco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostazione(@PathVariable Long id) {
        postazioneService.deletePostazione(id);
        return ResponseEntity.noContent().build();
    }
}