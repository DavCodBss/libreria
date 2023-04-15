package com.davbossotto.libreria.repositories;

import com.davbossotto.libreria.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
