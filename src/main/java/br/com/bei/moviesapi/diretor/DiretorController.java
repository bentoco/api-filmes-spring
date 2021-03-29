package br.com.bei.moviesapi.diretor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/diretores")
public class DiretorController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private final DiretorRepository repository;

    public DiretorController ( DiretorRepository repository ) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createDiretor( @RequestBody @Valid DiretorRequest request, UriComponentsBuilder uriBuilder ){
        Diretor diretor = request.toModel(manager);
        repository.save(diretor);

        URI uri = uriBuilder.path("/diretores/{id}").buildAndExpand(diretor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DiretorResponse(diretor));
    }
}
