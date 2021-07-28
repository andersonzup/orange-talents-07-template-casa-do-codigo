package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.AutorDto;
import br.com.zup.casadocodigo.dto.CategoriaDto;
import br.com.zup.casadocodigo.entity.Autor;
import br.com.zup.casadocodigo.entity.Categoria;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autores")
public class AutoRestController {

    AutorRepository autorRepository;


    public AutoRestController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;

    }

    @PostMapping
    @Transactional
    public String criarAutor(@RequestBody @Valid AutorDto autorDto){
        Autor autor = autorRepository.save(autorDto.toAutor());
        return autorDto.messageResponseDto(autor);
    }




}
