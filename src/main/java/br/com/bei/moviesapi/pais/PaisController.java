package br.com.bei.moviesapi.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ( "/api/pais" )
public class PaisController {

    @Autowired
    private final PaisRepository repository;

    public PaisController ( PaisRepository repository ) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PaisResponse> createPais (
            @RequestBody @Valid PaisRequest request ,
            UriComponentsBuilder uriBuilder ) {
        Pais pais = request.toModel();
        repository.save(pais);

        URI uri = uriBuilder.path("/pais/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisResponse(pais));
    }

    @GetMapping ( "/{id}" )
    @Transactional
    public ResponseEntity<PaisResponse> readPais ( @PathVariable Long id ) {
        Optional<Pais> pais = repository.findById(id);
        return pais.map(value -> ResponseEntity.ok().body(new PaisResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Collection<PaisResponse> listPais () {
        List<Pais> all = repository.findAll();
        return all.stream().map(PaisResponse::new).collect(Collectors.toList());
    }
}
