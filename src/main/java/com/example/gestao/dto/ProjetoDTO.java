package com.example.gestao.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProjetoDTO {
    private String nome;
    private String descricao;
    private int quantidadeTarefas; // Exemplo de campo calculado que não existe no banco!
}
