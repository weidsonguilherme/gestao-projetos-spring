package com.example.gestao.controller;

import com.example.gestao.model.StatusTarefa;
import com.example.gestao.model.Tarefa;
import com.example.gestao.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodas();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return tarefaService.salvar(tarefa);
    }

    @PatchMapping("/{id}/status")
    public Tarefa atualizarStatus(@PathVariable Long id, @RequestBody StatusTarefa novoStatus) {
        return tarefaService.atualizarStatus(id, novoStatus);
    }
}