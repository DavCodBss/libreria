package com.davbossotto.libreria.repositories;

import com.davbossotto.libreria.entities.UtenteLibro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteLibroRepository extends JpaRepository<UtenteLibro, UtenteLibro.UtenteLibroId> {
}

