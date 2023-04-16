package com.davbossotto.libreria.rest;

import com.davbossotto.libreria.entities.Utente;
import com.davbossotto.libreria.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/utenti")
public class UtenteRestController {

    private final UtenteService utenteService;

    @Autowired
    public UtenteRestController(UtenteService utenteService){
        this.utenteService = utenteService;
    }

    @GetMapping("")
    public List<Utente> findAll(){
        return utenteService.findAll();
    }

    @GetMapping("/{idUtente}")
    public Utente findById(@PathVariable int idUtente){
        return utenteService.findById(idUtente);
    }

    @PostMapping("")
    public Utente addUtente(@RequestBody Utente utente){
        //Setto l'id a 0 per essere sicuro di evitare problemi con il valore
        //passato tramite il JSON
        utente.setId(0);
        return utenteService.save(utente);
    }

    @PutMapping("")
    public Utente updateUtente(@RequestBody Utente utente){
        return utenteService.save(utente);
    }


    @DeleteMapping("{idUtente}")
    public String deleteUtente(@PathVariable int idUtente){
        //Utente utente = utenteService.findById(idUtente);
        //if(utente == null){
        //   throw new RuntimeException("Utente non trovato all'id: " + idUtente);
        //}

        return utenteService.deleteByid(idUtente);

    }



}
