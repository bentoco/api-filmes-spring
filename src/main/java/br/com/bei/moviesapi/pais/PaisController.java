package br.com.bei.moviesapi.pais;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/pais")
public class PaisController {

    @GetMapping
    public String createPais(){
        return "hello world";
    }
}
