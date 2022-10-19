package br.com.projeto.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repositories.Repositorio;

@RestController
@RequestMapping("/")
public class Controle {
    
    //O Spring fará o new
    @Autowired
    private Repositorio acao;

    @PostMapping("/cadastro")
    public Pessoa cadastrar(@RequestBody Pessoa obj){

        return acao.save(obj);

    }

    @GetMapping
    public String hello(){

        return "Hello World!";

    }

    @GetMapping("/boasvindas")
    public String boasVindasSem(){

        return "Bem vindo!";

    }

    @GetMapping("/boasvindas/{nome}")
    public String boasVindas(@PathVariable String nome){

        return "Bem vindo"+" "+nome;

    }

    @PostMapping("/pessoa")
    @Transactional
    public Pessoa pessoa(@RequestBody Pessoa p){

        return p;

    } 

    @GetMapping("/api")
    public List<Pessoa> selecionar(){

        return acao.findAll();

    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){

        return acao.findBycodigo(codigo);

    }   

    @PutMapping("/api")
    @Transactional
    public Pessoa editar(@RequestBody Pessoa obj){

        return acao.save(obj);

    }

    @DeleteMapping("/api/{codigo}")
    @Transactional
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    @GetMapping("/api/contador")
    public Long contador(){

        return acao.count();

    }

    @GetMapping("/api/ordenar")
    public List<Pessoa> ordenarNomes(){

        return acao.findByOrderByNomeDesc();

    }

    @GetMapping("/api/ordenar2/{nome}")
    public List<Pessoa> ordenarNomes2(@PathVariable String nome){

        return acao.findByNomeOrderByIdadeDesc(nome);

    }
}
