package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.dto.annotation.EmailIsDuplicated;
import br.com.zup.casadocodigo.entity.Autor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDto {

    @NotBlank
    private String nome;


    @NotBlank
    @Email
    @EmailIsDuplicated
    private String email;

    @NotNull
    @Size(max = 400)
    private String descricao;

    public AutorDto() {
    }

    public AutorDto(@Valid Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String exibirInformacous(Autor autor){
        return "Um autor com id " + autor.getId() + " foi criado. \n Data: " + autor.getDataCadastro();
    }

    public Autor dtoParaAutor(){
        return new Autor(nome, email, descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
