package br.com.zup.casadocodigo.cadastrolivro;

import br.com.zup.casadocodigo.config.annotation.ExistsId;
import br.com.zup.casadocodigo.config.annotation.ValorIsDuplicated;
import br.com.zup.casadocodigo.cadastroautor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;


public class RequestLivroDto {

    @NotBlank
    @ValorIsDuplicated(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(value = 20)
    private double preco;

    @Min(value = 100)
    private int numeroPaginas;

    @NotBlank
    @ValorIsDuplicated(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public RequestLivroDto() {
    }

    public RequestLivroDto(String titulo, String resumo, String sumario, double preco,
                           int numeroPaginas, String isbn, LocalDate dataLancamento,
                           Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }



    public Livro toModel(EntityManager entityManager) {
       @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);
       @NotNull Autor autor = entityManager.find(Autor.class, idAutor);
        return new Livro(titulo, resumo, sumario, preco,
                numeroPaginas, isbn, dataLancamento, categoria, autor);
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

}


