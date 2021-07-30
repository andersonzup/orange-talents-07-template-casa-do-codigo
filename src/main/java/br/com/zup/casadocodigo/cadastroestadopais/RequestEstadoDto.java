package br.com.zup.casadocodigo.cadastroestadopais;

import br.com.zup.casadocodigo.config.annotation.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestEstadoDto {


    @NotBlank
    //@ValorIsDuplicated(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País não cadastrado")
    private Long idPais;

    public RequestEstadoDto() {
    }

    public RequestEstadoDto(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public RequestEstadoDto(Estado estado) {
        this.nome = estado.getNome();
    }

    public Estado toModel(EntityManager entityManager) {
        @NotNull Pais pais = entityManager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
