package com.agenda.batschauer.apiagenda.service;

import com.agenda.batschauer.apiagenda.model.AgendaVO;
import com.agenda.batschauer.apiagenda.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaVO> getAgendas() {
        return agendaRepository.findAll();
    }

    public AgendaVO getAgenda(String id) { return agendaRepository.findByNrAgenda(id); }

    public void createAgenda(final AgendaVO agendaVO) {
        agendaRepository.save(agendaVO);
    }
}
