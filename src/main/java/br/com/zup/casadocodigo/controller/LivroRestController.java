package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.LivroDto;

import br.com.zup.casadocodigo.dto.ViewLivroDto;
import br.com.zup.casadocodigo.entity.Livro;

import br.com.zup.casadocodigo.repository.Livrorepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroRestController {

    Livrorepository livrorepository;

    @PersistenceContext
    EntityManager entityManager;

    public LivroRestController(Livrorepository livrorepository) {
        this.livrorepository = livrorepository;
    }

    @PostMapping
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid LivroDto livroDto){
        Livro livro = livroDto.toModel(entityManager);
        livrorepository.save(livro);
        return livro.toString();
    }

    @GetMapping
    public List<ViewLivroDto> livrosList(){
        return ViewLivroDto.converter(livrorepository.findAll());
    }

}
