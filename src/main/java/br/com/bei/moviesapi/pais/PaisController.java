package br.com.bei.moviesapi.pais;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/pais")
public class PaisController {

    @PostMapping
    public String createPais( @RequestBody @Valid PaisRequest request){
        Pais pais = request.toModel();
        return pais.toString();
    }
}
