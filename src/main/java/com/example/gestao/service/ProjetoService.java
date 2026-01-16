package com.example.gestao.service;

import com.example.gestao.model.Projeto;
import com.example.gestao.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetorepository;

    public List<Projeto> listarTodos() {
        return projetorepository.findAll();

    }
    public Projeto salvar(Projeto projeto) {
        return projetorepository.save(projeto);
    }

    public List<Projeto> buscarPorNome(String nome) {
        return projetorepository.findByNomeContainingIgnoreCase(nome);
    }
    public void excluir(Long id){
        projetorepository.deleteById(id);
    }
}
