package com.linkedby.projeto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkedby.projeto.model.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, UUID> {
    
}