package com.davbossotto.libreria.rest;


import com.davbossotto.libreria.entities.Libro;
import com.davbossotto.libreria.entities.UtenteLibro;
import com.davbossotto.libreria.repositories.UtenteLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libreria")
public class UtenteLibroRestController {

    private final UtenteLibroRepository utenteLibroRepository;
    @Autowired
    public UtenteLibroRestController(UtenteLibroRepository utenteLibroRepository){
        this.utenteLibroRepository = utenteLibroRepository;
    }

    @GetMapping("")
    public List<UtenteLibro> findAll(){
        return utenteLibroRepository.findAll();
    }

    @GetMapping("/{libroId}")
    public UtenteLibro findByIdLibro(@PathVariable int libroId){
        return utenteLibroRepository.findByIdIdLibro(libroId);
    }


    @PostMapping("")
    public UtenteLibro addUtenteLibro(@RequestBody UtenteLibro utenteLibro){
        return this.utenteLibroRepository.save(utenteLibro);

    }

}
