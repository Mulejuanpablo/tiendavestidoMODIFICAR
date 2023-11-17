package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Evento;
//import com.chloe.chloeback.model.Evento;
import com.chloe.chloeback.repo.EventoRepo;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.AlquiladoRepo;

@Transactional
@Service
public class EventoService {
    private final EventoRepo eventoRepo;

   // @Autowired
    public EventoService(EventoRepo eventoRepo) {
        this.eventoRepo = eventoRepo;
    }

    public Evento addEvento(Evento evento) {
        evento.setEvento(UUID.randomUUID().toString());
        return eventoRepo.save(evento);
    }

    public List<Evento> findAllEventos() {
        return eventoRepo.findAll();
    }

    public Evento updateEvento(Evento evento) {
        return eventoRepo.save(evento);
    }

    public Evento findEventoById(Long id) {
        return eventoRepo.findEventoById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEvento(Long id) {
        eventoRepo.deleteById(id);
    }

   

}
