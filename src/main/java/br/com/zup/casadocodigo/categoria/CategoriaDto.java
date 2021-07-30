package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.config.annotation.ValorIsDuplicated;

import javax.validation.constraints.NotBlank;

public class CategoriaDto {

    @NotBlank
    @ValorIsDuplicated(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public Categoria toCategoria(){
        return new Categoria(nome);
    }
    public String messageResponseDto(Categoria categoria){
        return "Categoria " + categoria.getNome() + " criada com sucesso";
    }
    public String getNome() {
        return nome;
    }
}
