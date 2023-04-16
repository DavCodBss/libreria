package com.davbossotto.libreria.services;

import com.davbossotto.libreria.entities.Utente;
import com.davbossotto.libreria.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    private UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> findAll(){
        return utenteRepository.findAll();
    }

    public Utente findById(int id) {
        Optional<Utente> risultato = utenteRepository.findById(id);

        Utente utente = null;

        if(risultato.isPresent()){
            utente = risultato.get();
        }else{
            throw new RuntimeException("Utente non trovato all'id: " + id);
        }

        return utente;
    }

    public Utente save(Utente utente){
        return this.utenteRepository.save(utente);
    }

    public void deleteByid(int id){
        utenteRepository.deleteById(id);
    }

}
