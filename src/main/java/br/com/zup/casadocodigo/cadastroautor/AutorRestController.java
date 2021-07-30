package br.com.zup.casadocodigo.cadastroautor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorRestController {

    AutorRepository autorRepository;


    public AutorRestController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;

    }

    @PostMapping
    @Transactional
    public String criarAutor(@RequestBody @Valid AutorDto autorDto){
        Autor autor = autorRepository.save(autorDto.toAutor());
        return autorDto.messageResponseDto(autor);
    }




}
