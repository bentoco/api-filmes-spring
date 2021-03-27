package br.com.bei.moviesapi.pais;

public class Pais {
    private Long id;
    private String nome;

    public Pais ( String nome ) {
        this.nome = nome;
    }

    @Override public String toString () {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
