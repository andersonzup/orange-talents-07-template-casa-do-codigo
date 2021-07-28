package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.entity.Livro;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseLivroListDto {

    private Long id;
    private String titulo;


    public ResponseLivroListDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public static Page<ResponseLivroListDto> converter(Page<Livro> livros) {
        return livros.map(ResponseLivroListDto::new);

        //List<ResponseLivroListDto> responseLivroListDtos = new ArrayList<>();
        //responseLivroListDtos.addAll(livros.stream().map(ResponseLivroListDto::new).collect(Collectors.toList()));
        //return responseLivroListDtos;
    }
}
