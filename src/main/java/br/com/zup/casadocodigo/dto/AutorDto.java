package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.dto.annotation.ValorIsDuplicated;
import br.com.zup.casadocodigo.entity.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDto {

    @NotBlank
    @NotNull
    private String nome;


    @NotBlank
    @NotNull
    @ValorIsDuplicated(domainClass = Autor.class, fieldName = "email")
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorDto() {
    }

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String messageResponseDto(Autor autor){
        return "Um autor com id " + autor.getId() + " foi criado. \n Data: " + autor.getDataCadastro();
    }

    public Autor toAutor(){
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
