package br.com.bei.moviesapi.diretor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ( "/api/diretores" )
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
    public ResponseEntity<?> createDiretor (
            @RequestBody @Valid DiretorRequest request ,
            UriComponentsBuilder uriBuilder ) {
        Diretor diretor = request.toModel(manager);
        repository.save(diretor);

        URI uri = uriBuilder.path("/diretores/{id}").buildAndExpand(diretor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DiretorResponse(diretor));
    }

    @GetMapping ( "/{id}" )
    public ResponseEntity<?> readOneDiretor ( @PathVariable Long id ) {
        Optional<Diretor> optionalDiretor = repository.findById(id);
        if (optionalDiretor.isPresent()) {
            return ResponseEntity.ok().body(new DiretorResponse(optionalDiretor.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> readAllDiretores () {
        List<Diretor> all = repository.findAll();
        if (!all.isEmpty()) {
            return ResponseEntity.ok().body(all.stream().map(DiretorResponse::new).collect(Collectors.toList()));
        }
        return ResponseEntity.notFound().build();
    }
}
