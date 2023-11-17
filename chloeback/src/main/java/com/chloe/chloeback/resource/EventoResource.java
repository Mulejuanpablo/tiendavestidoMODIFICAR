package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chloe.chloeback.model.Evento;
import com.chloe.chloeback.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoResource {
    private final EventoService eventoService;

    public EventoResource(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/allevento")
    public ResponseEntity<List<Evento>> getAllEventos () {
        List<Evento> eventos = eventoService.findAllEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/findevento/{id}")
    public ResponseEntity<Evento> getEventoById (@PathVariable("id") Long id) {
        Evento evento = eventoService.findEventoById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @PostMapping("/addevento")
    public ResponseEntity<Evento> addEvento(@RequestBody Evento evento) {
        Evento newEvento = eventoService.addEvento(evento);
        return new ResponseEntity<>(newEvento, HttpStatus.CREATED);
    }

    @PutMapping("/updateevento")
    public ResponseEntity<Evento> updateEvento(@RequestBody Evento evento) {
        Evento updateEvento = eventoService.updateEvento(evento);
        return new ResponseEntity<>(updateEvento, HttpStatus.OK);
    }

    @DeleteMapping("/deleteevento/{id}")
    public ResponseEntity<?> deleteEvento(@PathVariable("id") Long id) {
        eventoService.deleteEvento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
