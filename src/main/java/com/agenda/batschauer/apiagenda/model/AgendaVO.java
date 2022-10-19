package com.agenda.batschauer.apiagenda.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaVO {

    @Id
    private String nrAgenda;
    private String nmAgenda;
    private Integer telefoneAgenda;
}
