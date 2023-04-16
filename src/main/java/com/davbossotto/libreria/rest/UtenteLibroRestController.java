package com.davbossotto.libreria.rest;


import com.davbossotto.libreria.entities.UtenteLibro;
import com.davbossotto.libreria.services.UtenteLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/libreria")
public class UtenteLibroRestController {

    private final UtenteLibroService utenteLibroService;
    @Autowired
    public UtenteLibroRestController(UtenteLibroService utenteLibroService){
        this.utenteLibroService = utenteLibroService;
    }

    @GetMapping("")
    public List<UtenteLibro> findAll(){
        return utenteLibroService.findAll();
    }

    @GetMapping("/{idLibro}/{idUtente}")
    public UtenteLibro findById(@PathVariable int idLibro, @PathVariable int idUtente){
        return utenteLibroService.findById(idLibro, idUtente);
    }

    @GetMapping("/libro/{idLibro}")
    public List<UtenteLibro> findByIdLibro(@PathVariable int idLibro){
        return utenteLibroService.findByIdLibro(idLibro);
    }

    @GetMapping("/utente/{idUtente}")
    public List<UtenteLibro> findByIdUtente(@PathVariable int idUtente){
        return utenteLibroService.findByIdUtente(idUtente);
    }


    @PostMapping("")
    public UtenteLibro addUtenteLibro(@RequestBody UtenteLibro utenteLibro){
        //Setto l'id a 0 per essere sicuro di evitare problemi con il valore
        //passato tramite il JSON
        UtenteLibro.UtenteLibroId id = new UtenteLibro.UtenteLibroId(0, 0);
        utenteLibro.setId(id);
        return utenteLibroService.save(utenteLibro);
    }

    @PutMapping("")
    public UtenteLibro updateUtenteLibro(@RequestBody UtenteLibro utenteLibro){
        return utenteLibroService.save(utenteLibro);
    }


    @DeleteMapping("/{idLibro}/{idUtente}")
    public String deleteUtenteLibro(@PathVariable int idLibro, @PathVariable int idUtente){
        return utenteLibroService.deleteByid(idLibro, idUtente);
    }


}
