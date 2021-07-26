package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.AutorDto;
import br.com.zup.casadocodigo.entity.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CasaDoCodigoController{

    AutorRepository autorRepository;

    public CasaDoCodigoController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping(path = "/autores")
    public String criarAutor(@RequestBody @Valid AutorDto autorDto){
        Autor autor = autorRepository.save(autorDto.dtoParaAutor());
        return autorDto.exibirInformacous(autor);
    }



}
