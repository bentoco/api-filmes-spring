package br.com.bei.moviesapi.diretor;

import br.com.bei.moviesapi.pais.Pais;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Diretor {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column ( nullable = false )
    private String nome;
    @NotNull
    @Column ( nullable = false )
    @JsonFormat ( pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING )
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn ( name = "pais_id", foreignKey = @ForeignKey ( name = "PAIS_ID_FK" ) )
    private Pais pais;

    public Diretor ( String nome , LocalDate dataNascimento , Pais pais ) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.pais = pais;
    }

    public Diretor () {

    }

    public Long getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public LocalDate getDataNascimento () {
        return dataNascimento;
    }

    public Pais getPais () {
        return pais;
    }

    @Override public String toString () {
        return "Diretor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", pais=" + pais +
                '}';
    }
}
