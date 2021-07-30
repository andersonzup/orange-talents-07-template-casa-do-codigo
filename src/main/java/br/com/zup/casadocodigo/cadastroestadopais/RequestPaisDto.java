package br.com.zup.casadocodigo.cadastroestadopais;

import br.com.zup.casadocodigo.config.annotation.ValorIsDuplicated;

import javax.validation.constraints.NotBlank;

public class RequestPaisDto {

    @NotBlank
    @ValorIsDuplicated(domainClass=Pais.class, fieldName="nome", message = "País já cadastrado")
    private String nome;

    public RequestPaisDto() {
    }

    public RequestPaisDto(Pais pais) {
        this.nome = pais.getNome();
    }

    public Pais toModel(){
        return new Pais(nome);
    }


    public String getNome() {
        return nome;
    }
}
