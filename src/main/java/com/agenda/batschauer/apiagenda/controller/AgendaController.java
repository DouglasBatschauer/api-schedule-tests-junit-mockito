package com.agenda.batschauer.apiagenda.controller;

import com.agenda.batschauer.apiagenda.model.AgendaVO;
import com.agenda.batschauer.apiagenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "api/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaVO>> getAgendas() {
        return ResponseEntity.ok().body(agendaService.getAgendas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendaVO> getAgenda(@PathVariable String id) {
        return ResponseEntity.ok().body(agendaService.getAgenda(id));
    }

    @PostMapping
    public ResponseEntity<AgendaVO> createAgenda(@RequestBody AgendaVO agendaVO) throws URISyntaxException {
        agendaService.createAgenda(agendaVO);
        return ResponseEntity.created(new URI("path/aleatorio")).body(agendaVO);
    }
}
