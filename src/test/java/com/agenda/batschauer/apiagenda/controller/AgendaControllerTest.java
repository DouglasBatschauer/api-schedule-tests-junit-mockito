package com.agenda.batschauer.apiagenda.controller;

import com.agenda.batschauer.apiagenda.model.AgendaVO;
import com.agenda.batschauer.apiagenda.service.AgendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AgendaControllerTest {

    @InjectMocks
    private AgendaController agendaController;

    @Mock
    private AgendaService agendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenGetAgendaReturnAllDatas() {
        when(agendaService.getAgendas()).thenReturn(List.of(new AgendaVO("1", "Teste", 33367841)));

        ResponseEntity<List<AgendaVO>> agendasVOs = agendaController.getAgendas();

        assertNotNull(agendasVOs.getBody().get(0).getNmAgenda());
        assertNotNull(agendasVOs.getBody().get(0).getNrAgenda());
        assertNotNull(agendasVOs.getBody().get(0).getTelefoneAgenda());
        assertEquals("Teste", agendasVOs.getBody().get(0).getNmAgenda());
        assertEquals("1", agendasVOs.getBody().get(0).getNrAgenda());
        assertEquals(33367841, agendasVOs.getBody().get(0).getTelefoneAgenda());
    }

    @Test
    void createAgenda() {
    }

    @Test
    void whenGetAgendaByNrAgenda () {
        when(agendaService.getAgenda(anyString())).thenReturn(new AgendaVO("1", "Teste", 33367841));

        ResponseEntity<AgendaVO> agenda = agendaController.getAgenda("1");

        assertNotNull(agenda.getBody().getNrAgenda());
        assertNotNull(agenda.getBody().getTelefoneAgenda());
        assertNotNull(agenda.getBody().getNmAgenda());
    }
}