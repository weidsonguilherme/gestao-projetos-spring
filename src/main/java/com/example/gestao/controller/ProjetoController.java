package com.example.gestao.controller;

import com.example.gestao.model.Projeto;
import com.example.gestao.model.StatusTarefa;
import com.example.gestao.model.Tarefa;
import com.example.gestao.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // Indica que esta classe é um controlador de API
@RequestMapping("/projetos") // Define que todas as rotas aqui começam com /projetos
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping //Rota para listar (get http://localhost:8080/projetos)
    public List<Projeto> listar(@RequestParam(required = false) String nome) {
        if (nome!= null){
            return projetoService.buscarPorNome(nome);
        }
        return projetoService.listarTodos();
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