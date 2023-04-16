package com.davbossotto.libreria.services;

import com.davbossotto.libreria.entities.Libro;
import com.davbossotto.libreria.entities.Utente;
import com.davbossotto.libreria.repositories.UtenteLibroRepository;
import com.davbossotto.libreria.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;
    private final UtenteLibroRepository utenteLibroRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository, UtenteLibroRepository utenteLibroRepository){
        this.utenteRepository = utenteRepository;
        this.utenteLibroRepository = utenteLibroRepository;
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

    public String deleteByid(int id){
        Optional<Utente> utente = utenteRepository.findById(id);
        if(utente.isPresent()){
            utenteLibroRepository.deleteById_IdUtente(id);
            utenteRepository.delete(utente.get());
            return "Utente eliminato con successo" + "\nId utente eliminato: " + utente.get().getId();
        }else{
            return "Utente non eliminato." + "\nNessun utente esistente con id: " + id;
        }
    }

}
