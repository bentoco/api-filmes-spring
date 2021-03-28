package br.com.bei.moviesapi.pais;

import br.com.bei.moviesapi.config.validator.MustBeUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank @MustBeUnique(target = Pais.class, column = "nome")
    private String nome;

    @JsonCreator
    public PaisRequest ( @NotBlank @JsonProperty( "nome" ) String nome ) {
        this.nome = nome;
    }

    public Pais toModel () {
        return new Pais(nome);
    }
}
