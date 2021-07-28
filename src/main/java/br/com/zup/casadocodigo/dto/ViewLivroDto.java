package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.entity.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewLivroDto {

    private Long id;
    private String titulo;


    public ViewLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public static List<ViewLivroDto> converter(List<Livro> livros) {
        List<ViewLivroDto> viewLivroDtos = new ArrayList<>();
        viewLivroDtos.addAll(livros.stream().map(ViewLivroDto::new).collect(Collectors.toList()));
        return viewLivroDtos;
    }
}
