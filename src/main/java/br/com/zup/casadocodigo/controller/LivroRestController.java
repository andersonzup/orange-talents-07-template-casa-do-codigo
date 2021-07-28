package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.controller.exception.ObjectAppNotFoundException;
import br.com.zup.casadocodigo.dto.RequestLivroDto;

import br.com.zup.casadocodigo.dto.ResponseLivroDetalhesDto;
import br.com.zup.casadocodigo.dto.ResponseLivroListDto;
import br.com.zup.casadocodigo.entity.Livro;

import br.com.zup.casadocodigo.repository.Livrorepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public String cadastrarLivro(@RequestBody @Valid RequestLivroDto requestLivroDto){
        Livro livro = requestLivroDto.toModel(entityManager);
        livrorepository.save(livro);
        return livro.toString();
    }

    @GetMapping
    public Page<ResponseLivroListDto> livrosList(Pageable paginacao){
        Page<Livro> livros = livrorepository.findAll(paginacao);
        return ResponseLivroListDto.converter(livros);
    }

    @GetMapping(path = "/{id}")
    public ResponseLivroDetalhesDto exibirDetalhesLivro(@PathVariable Long id) throws ObjectAppNotFoundException {
        Livro livro = livrorepository.findById(id).orElseThrow(() -> new ObjectAppNotFoundException(id));
        return new ResponseLivroDetalhesDto(livro);
    }

}
