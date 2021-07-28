package br.com.zup.casadocodigo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    private String sumario;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private int numeroPaginas;

    @Column(nullable = false)
    private String isbn;

    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

   @ManyToOne
   @JoinColumn(nullable = false, unique = true)
    private Autor autor;

    public Livro() {

    }

    public Livro(String titulo, String resumo, String sumario,
                 Double preco, int numeroPaginas, String isbn,
                 LocalDate dataLancamento, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
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

    public Double getPreco() {
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

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
