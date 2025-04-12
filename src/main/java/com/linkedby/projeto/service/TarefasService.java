package com.linkedby.projeto.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.linkedby.projeto.model.Tarefas;
import com.linkedby.projeto.repository.TarefasRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;

    // Listar todas as tarefas
    public List<Tarefas> listarTodas() {
        return tarefasRepository.findAll();
    }

    // Buscar tarefa por ID
    public Tarefas buscarPorId(UUID id) {
        return tarefasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com ID: " + id));
    }

    // Criar tarefa
    public Tarefas criar(Tarefas tarefa) {
        tarefa.setDataCriacao(java.time.LocalDateTime.now());
        return tarefasRepository.save(tarefa);
    }

    // Atualizar tarefa
    public Tarefas atualizar(UUID id, Tarefas tarefaAtualizada) {
        Tarefas tarefaExistente = buscarPorId(id);
        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setStatus(tarefaAtualizada.getStatus());
        return tarefasRepository.save(tarefaExistente);
    }

    // Deletar tarefa
    public void deletar(UUID id) {
        if (!tarefasRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada para ID: " + id);
        }
        tarefasRepository.deleteById(id);
    }
}