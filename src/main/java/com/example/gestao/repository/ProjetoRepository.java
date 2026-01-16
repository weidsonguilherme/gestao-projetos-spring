package com.example.gestao.repository;

import com.example.gestao.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    // Ao herdar de JpaRepository, ganhamos métodos como:
    // save(), findAll(), findById(), delete() sem precisar escrever muito!
    List<Projeto> findByNomeContainingIgnoreCase(String nome);

}