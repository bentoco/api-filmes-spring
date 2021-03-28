package br.com.bei.moviesapi.pais;

import javax.persistence.*;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Pais ( String nome ) {
        this.nome = nome;
    }

    public Pais () {

    }

    public Long getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    @Override public String toString () {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
