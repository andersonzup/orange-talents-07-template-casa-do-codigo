package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.RequestPaisDto;
import br.com.zup.casadocodigo.entity.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisRestController {

    PaisRepository paisRepository;

    public PaisRestController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public String savePais(@RequestBody @Valid RequestPaisDto paisDto){
        Pais pais = paisDto.toModel();
        paisRepository.save(pais);
        return   pais.getNome() + " criado com sucesso";
    }



}
