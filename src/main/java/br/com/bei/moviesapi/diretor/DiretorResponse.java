package br.com.bei.moviesapi.diretor;

import java.time.LocalDate;

public class DiretorResponse {
    private String nome;
    private LocalDate dataNascimento;
    private String pais;
    // * add atribute filmes list *

    public DiretorResponse ( Diretor diretor ) {
        this.nome = diretor.getNome();
        this.dataNascimento = diretor.getDataNascimento();
        this.pais = diretor.getPais().getNome();
    }

    public String getNome () {
        return nome;
    }

    public LocalDate getDataNascimento () {
        return dataNascimento;
    }

    public String getPais () {
        return pais;
    }

}
