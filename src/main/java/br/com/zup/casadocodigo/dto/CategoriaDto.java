package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.dto.annotation.CategoriaIsDuplicated;
import br.com.zup.casadocodigo.dto.annotation.ValorIsDuplicated;
import br.com.zup.casadocodigo.entity.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDto {

    @NotBlank
    @ValorIsDuplicated(classeDeDominio = Categoria.class, nomeCampo = "nome")
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
