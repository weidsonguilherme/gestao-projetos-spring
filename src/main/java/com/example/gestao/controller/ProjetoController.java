package com.example.gestao.controller;

import org.modelmapper.ModelMapper;
import com.example.gestao.dto.ProjetoResponseDTO;
import com.example.gestao.model.Projeto;
import com.example.gestao.model.StatusTarefa;
import com.example.gestao.model.Tarefa;
import com.example.gestao.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController // Indica que esta classe é um controlador de API
@RequestMapping("/projetos") // Define que todas as rotas aqui começam com /projetos
public class ProjetoController {
    @Autowired

    private ModelMapper modelMapper;

    @Autowired // Isso avisa o Spring para injetar a instância automaticamente
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<Projeto> projetos;

        if (nome != null && !nome.isEmpty()) {
            // Se vier nome na URL (?nome=...), filtra
            projetos = projetoService.buscarPorNome(nome);
        } else {
            // Se não vier nada, traz todos
            projetos = projetoService.listarTodos();
        }

        // Converte a lista de entidades para DTO usando o ModelMapper
        return projetos.stream()
                .map(projeto -> modelMapper.map(projeto, ProjetoResponseDTO.class))
                .toList();
    }

    @PostMapping // Rota para criar (POST http://localhost:8080/projetos)
    public Projeto criar(@RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);

    }

    @DeleteMapping("/{id}") // Rota: DELETE http://localhost:8080/projetos/1
    public void excluir(@PathVariable Long id){
        projetoService.excluir(id);
    }
}