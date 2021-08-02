package br.com.zup.casadocodigo.cadastrocliente;


import br.com.zup.casadocodigo.config.annotation.CPFOrCNPJ;
import br.com.zup.casadocodigo.config.annotation.ExistsId;
import br.com.zup.casadocodigo.config.annotation.ValorIsDuplicated;
import br.com.zup.casadocodigo.cadastroestadopais.Estado;
import br.com.zup.casadocodigo.cadastroestadopais.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class RequestClientDto {

    @NotBlank @Email @ValorIsDuplicated(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPFOrCNPJ
    @NotBlank @ValorIsDuplicated(domainClass = Cliente.class, fieldName ="documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")// se o país tiver estados, um estado precisa ser selecionado
    private Long idPais;


    private Long idEstado; //estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public RequestClientDto() {
    }

    public RequestClientDto(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(EntityManager entityManager){
        @NotNull Pais pais = entityManager.find(Pais.class, idPais);
                Estado estado = entityManager.find(Estado.class, idEstado);
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone,cep);
    }


    /*--------------------------------
    Métodos Getter's
     --------------------------------*/


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestClientDto)) return false;
        RequestClientDto that = (RequestClientDto) o;
        return Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getSobrenome(), that.getSobrenome()) && Objects.equals(getDocumento(), that.getDocumento()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getComplemento(), that.getComplemento()) && Objects.equals(getCidade(), that.getCidade()) && Objects.equals(getIdPais(), that.getIdPais()) && Objects.equals(getIdEstado(), that.getIdEstado()) && Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(getCep(), that.getCep());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getNome(), getSobrenome(), getDocumento(), getEndereco(), getComplemento(), getCidade(), getIdPais(), getIdEstado(), getTelefone(), getCep());
    }
}
