package com.davbossotto.libreria.services;

import com.davbossotto.libreria.entities.Libro;
import com.davbossotto.libreria.repositories.LibroRepository;
import com.davbossotto.libreria.repositories.UtenteLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final UtenteLibroRepository utenteLibroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository, UtenteLibroRepository utenteLibroRepository){
        this.libroRepository = libroRepository;
        this.utenteLibroRepository = utenteLibroRepository;
    }

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }


    //Filtra la tabella libri e restituisce tutti i libri senza data di eliminazione o con data di eliminazione
    // in base alla richiesta dell'utente bool
    public List<Libro> findByEliminazione(boolean eliminato){
        if(eliminato){
            return libroRepository.findByDataEliminazioneIsNotNull();
        }else{
            return libroRepository.findByDataEliminazioneIsNull();
        }

    }

    public Libro findById(int id) {
        Optional<Libro> risultato = libroRepository.findById(id);

        Libro libro = null;

        if(risultato.isPresent()){
            libro = risultato.get();
        }else{
            throw new RuntimeException("Libro non trovato all'id: " + id);
        }

        return libro;
    }

    public Libro save(Libro utente){
        return this.libroRepository.save(utente);
    }

    public String deleteByid(int id){
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isPresent()){
            utenteLibroRepository.deleteById_IdLibro(id);
            libroRepository.delete(libro.get());
            return "Libro eliminato con successo" + "\nId Libro eliminato: " + libro.get().getId();
        }else{
            return "Libro non eliminato." + "\nNessun libro esistente con id: " + id;
        }
    }

}
