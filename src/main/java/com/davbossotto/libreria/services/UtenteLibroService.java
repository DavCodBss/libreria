package com.davbossotto.libreria.services;

import com.davbossotto.libreria.entities.Libro;
import com.davbossotto.libreria.entities.UtenteLibro;
import com.davbossotto.libreria.repositories.UtenteLibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteLibroService {
    private final UtenteLibroRepository utenteLibroRepository;

    public UtenteLibroService(UtenteLibroRepository utenteLibroRepository){
        this.utenteLibroRepository = utenteLibroRepository;
    }

    public List<UtenteLibro> findAll(){
        return utenteLibroRepository.findAll();
    }

    public UtenteLibro findById(int idLibro, int idUtente){
        UtenteLibro.UtenteLibroId id = new UtenteLibro.UtenteLibroId(idLibro, idUtente);
        Optional<UtenteLibro> risultato = utenteLibroRepository.findById(id);

        UtenteLibro utenteLibro = null;

        if(risultato.isPresent()){
            utenteLibro = risultato.get();
        }else{
            throw new RuntimeException("Nessun elemento presente con libro id: " + idLibro + " e utente id: " + idUtente);
        }

        return utenteLibro;
    }

    public List<UtenteLibro> findByIdLibro(int id) {
        return utenteLibroRepository.findByIdIdLibro(id);
    }

    public List<UtenteLibro> findByIdUtente(int id) {
        return utenteLibroRepository.findByIdIdUtente(id);
    }

    public UtenteLibro save(UtenteLibro utenteLibro){
        return this.utenteLibroRepository.save(utenteLibro);
    }


    public String deleteByid(int idLibro, int idUtente){
        UtenteLibro.UtenteLibroId id = new UtenteLibro.UtenteLibroId(idLibro, idUtente);
        Optional<UtenteLibro> utenteLibro = utenteLibroRepository.findById(id);
        if(utenteLibro.isPresent()){
            utenteLibroRepository.delete(utenteLibro.get());
            return "Eliminato libro dalla libreria" + "\nId Libro eliminato: " + idLibro;
        }else{
            return "Libro non eliminato." + "\nNessun libro nella tua libreria con id: " + idLibro;
        }
    }

}
