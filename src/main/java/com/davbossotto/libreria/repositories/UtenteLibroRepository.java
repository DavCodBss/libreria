package com.davbossotto.libreria.repositories;

import com.davbossotto.libreria.entities.UtenteLibro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteLibroRepository extends JpaRepository<UtenteLibro, UtenteLibro.UtenteLibroId> {

    UtenteLibro findByIdIdLibro(
            int idLibro);

    void deleteById_IdLibro(
            int idLibro);

    void deleteById_IdUtente(
            int id);
}

