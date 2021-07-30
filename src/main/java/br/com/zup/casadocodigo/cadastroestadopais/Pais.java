package br.com.zup.casadocodigo.cadastroestadopais;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Pais() {
    }


    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
