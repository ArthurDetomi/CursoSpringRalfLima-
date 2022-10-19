package br.com.projeto.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.api.model.Pessoa;

public interface Repositorio extends JpaRepository<Pessoa, Integer>{
    
    List<Pessoa> findAll();

    Pessoa findBycodigo(int codigo);

    List<Pessoa> findByOrderByNomeDesc();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

}
