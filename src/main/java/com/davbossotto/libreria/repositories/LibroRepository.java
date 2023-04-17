package com.davbossotto.libreria.repositories;

import com.davbossotto.libreria.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByDataEliminazioneIsNull();

    List<Libro> findByDataEliminazioneIsNotNull();

}
