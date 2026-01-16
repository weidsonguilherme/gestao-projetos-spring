package com.example.gestao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Gera getter, setters, toString, equals e hashcode automaticamente
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do projeto é obrigatório")
    private String nome;
    private String descricao;
    private LocalDate dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    @JsonManagedReference("projeto-tarefas") // O "Lado pai" gerencia o JSON
    private List<Tarefa> tarefas;
}
