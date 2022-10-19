package com.agenda.batschauer.apiagenda.repository;

import com.agenda.batschauer.apiagenda.model.AgendaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaVO, Integer> {

    @Override
    List<AgendaVO> findAll();

    AgendaVO findByNrAgenda(String id);
}
