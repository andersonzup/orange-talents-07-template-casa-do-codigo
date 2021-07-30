package br.com.zup.casadocodigo.categoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaRestController {

    CategoriaRepository categoriaRepository;

    public CategoriaRestController(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }


    @PostMapping
    @Transactional
    public String criarCategoria(@RequestBody @Valid CategoriaDto categoriaDto){
        Categoria categoria = categoriaRepository.save(categoriaDto.toCategoria());
        return categoriaDto.messageResponseDto(categoria);
    }



}
