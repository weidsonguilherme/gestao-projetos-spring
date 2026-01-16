package com.example.gestao.service;

import com.example.gestao.model.StatusTarefa;
import com.example.gestao.model.Tarefa;
import com.example.gestao.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarStatus(Long id, StatusTarefa novoStatus) {
        // O setStatus funcionará assim que você fizer o Passo 1
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));

        tarefa.setStatus(novoStatus);
        return tarefaRepository.save(tarefa);
    }
}