package com.linkedby.projeto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.linkedby.projeto.model.Status;
import com.linkedby.projeto.model.Tarefas;
import com.linkedby.projeto.service.TarefasService;

import jakarta.persistence.EntityNotFoundException;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private TarefasService tarefasService;

    @Test
    void deveCriarTarefa() {
        Tarefas tarefa = Tarefas.builder()
                .titulo("Estudar Spring")
                .descricao("Ler documentação oficial")
                .status(Status.PENDENTE)
                .build();

        Tarefas salva = tarefasService.criar(tarefa);

        assertThat(salva.getId()).isNotNull();
        assertThat(salva.getTitulo()).isEqualTo("Estudar Spring");
    }

    @Test
    void deveAtualizarTarefa() {
        Tarefas tarefa = Tarefas.builder()
                .titulo("Estudar Spring")
                .descricao("Inicial")
                .status(Status.PENDENTE)
                .build();

        Tarefas salva = tarefasService.criar(tarefa);
        salva.setDescricao("Atualizada");

        Tarefas atualizada = tarefasService.atualizar(salva.getId(), salva);

        assertThat(atualizada.getDescricao()).isEqualTo("Atualizada");
    }

    @Test
    void deveExcluirTarefa() {
        Tarefas tarefa = Tarefas.builder()
                .titulo("Deletar Tarefa")
                .descricao("Será excluída")
                .status(Status.PENDENTE)
                .build();

        Tarefas salva = tarefasService.criar(tarefa);
        tarefasService.deletar(salva.getId());

        assertThrows(EntityNotFoundException.class, () -> {
            tarefasService.buscarPorId(salva.getId());
        });
    }
}