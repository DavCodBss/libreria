package com.davbossotto.libreria.rest;

import com.davbossotto.libreria.entities.Libro;
import com.davbossotto.libreria.repositories.LibroRepository;
import com.davbossotto.libreria.repositories.UtenteLibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libri")
public class LibroRestController {

    private final LibroRepository libroRepository;
    private final UtenteLibroRepository utenteLibroRepository;
    @Autowired
    public LibroRestController(LibroRepository libroRepository, UtenteLibroRepository utenteLibroRepository){
        this.libroRepository = libroRepository;
        this.utenteLibroRepository = utenteLibroRepository;
    }

    @GetMapping("")
    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    @PostMapping("")
    public Libro addLibro(@RequestBody Libro libro){

        libro.setId(0);
        return this.libroRepository.save(libro);
    }

    @Transactional
    @DeleteMapping("/{idLibro}")
    public String deleteLibro(@PathVariable int idLibro){
        Optional<Libro> libro = libroRepository.findById(idLibro);
        if(libro.isPresent()){
            utenteLibroRepository.deleteById_IdLibro(idLibro);
            libroRepository.delete(libro.get());
            return "Libro eliminato con successo" + "\nId Libro eliminato: " + libro.get().getId();
        }else{
            return "Libro non eliminato." + "\nNessun libro esistente con id: " + libro.get().getId();
        }
    }

}
