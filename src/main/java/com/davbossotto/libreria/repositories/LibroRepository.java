package com.davbossotto.libreria.repositories;

import com.davbossotto.libreria.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
