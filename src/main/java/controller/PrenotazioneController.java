package controller;

import entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PrenotazioneService;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<?> createPrenotazione(@RequestBody Prenotazione prenotazione) {
        try {
            Prenotazione savedPrenotazione = prenotazioneService.createPrenotazione(prenotazione);
            return ResponseEntity.ok(savedPrenotazione);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.getPrenotazioneById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni() {
        List<Prenotazione> listaPrenotazioni = prenotazioneService.getAllPrenotazioni();
        return ResponseEntity.ok(listaPrenotazioni);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrenotazione(@PathVariable Long id) {
        if (prenotazioneService.getPrenotazioneById(id).isPresent()) {
            prenotazioneService.deletePrenotazione(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}