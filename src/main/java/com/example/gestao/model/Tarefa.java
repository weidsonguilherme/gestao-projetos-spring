package com.example.gestao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data; // Verifique se este import existe!

@Entity
@Data // ESSA ANOTAÇÃO É OBRIGATÓRIA
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @JsonBackReference("projeto-tarefas")
    private Projeto projeto;
}