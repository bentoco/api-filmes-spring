package br.com.bei.moviesapi.diretor;

import br.com.bei.moviesapi.pais.Pais;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class DiretorRequest {

    @NotBlank
    private String nome;
    @NotNull @JsonFormat (pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    @NotNull
    private Long idPais;

    public DiretorRequest ( @NotBlank String nome , @NotNull Long idPais ) {
        this.nome = nome;
        this.idPais = idPais;
    }

    /*
     * jackson encontrou um problema ao desserializar
     * o json com a data no parâmetro pelo constructor,
     * por esse motivo foi necessário criar setter abaixo
     * @param dataPublicacao
     * */
    public void setDataNascimento ( LocalDate dataNascimento ) {
        this.dataNascimento = dataNascimento;
    }

    public Diretor toModel( EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(pais != null, "ID da pais informado não existe em nosso banco de dados " + idPais);
        return new Diretor(nome, dataNascimento, pais);
    }

    @Override public String toString () {
        return "DiretorRequest{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", idPais=" + idPais +
                '}';
    }
}
