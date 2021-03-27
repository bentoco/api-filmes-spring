package br.com.bei.moviesapi.pais;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank
    private String nome;

    @JsonCreator
    public PaisRequest ( @NotBlank @JsonProperty( "nome" ) String nome ) {
        this.nome = nome;
    }

    public Pais toModel () {
        return new Pais(nome);
    }
}
