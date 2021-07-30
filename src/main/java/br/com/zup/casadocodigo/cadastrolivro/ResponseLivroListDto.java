package br.com.zup.casadocodigo.cadastrolivro;

import org.springframework.data.domain.Page;

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
