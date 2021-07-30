package br.com.zup.casadocodigo.cadastrolivro;


import br.com.zup.casadocodigo.cadastroautor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ResponseLivroDetalhesDto {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private int numeroPaginas;
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    private Categoria categoria;
    private Autor autor;

    public ResponseLivroDetalhesDto() {
    }

    public ResponseLivroDetalhesDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Long getId() {
        return id;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
