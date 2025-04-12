package com.linkedby.projeto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.linkedby.projeto.model.Status;
import com.linkedby.projeto.model.Tarefas;
import com.linkedby.projeto.service.TarefasService;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private TarefasService tarefasService;

    @Test
    void criarTarefaComSucesso() {
        Tarefas novaTarefa = Tarefas.builder()
            .titulo("Título de teste")
            .descricao("Descrição de teste")
            .status(Status.PENDENTE)
            .dataCriacao(LocalDateTime.now())
            .build();

        Tarefas salva = tarefasService.criar(novaTarefa);

        assertNotNull(salva.getId(), "ID da tarefa não deve ser nulo");
        System.out.println("Tarefa salva com ID: " + salva.getId());
    }

    @Test
    void alterarTarefaComSucesso() {
        Tarefas novaTarefa = Tarefas.builder()
            .titulo("Título de teste2")
            .descricao("Descrição de teste2")
            .status(Status.PENDENTE)
            .dataCriacao(LocalDateTime.now())
            .build();

        Tarefas salva = tarefasService.criar(novaTarefa);

        assertNotNull(salva.getId(), "ID da tarefa não deve ser nulo");
        System.out.println("Tarefa salva com ID: " + salva.getId());

        // Alterar a tarefa
        salva.setTitulo("Título alterado");
        salva.setDescricao("Descrição alterada");

        Tarefas atualizada = tarefasService.atualizar(salva.getId(), salva);

        assertEquals("Título alterado", atualizada.getTitulo());
        assertEquals("Descrição alterada", atualizada.getDescricao());
    }

    @Test
    void deletarTarefaComSucesso() {
        Tarefas novaTarefa = Tarefas.builder()
            .titulo("Título de teste3")
            .descricao("Descrição de teste3")
            .status(Status.PENDENTE)
            .dataCriacao(LocalDateTime.now())
            .build();

        Tarefas salva = tarefasService.criar(novaTarefa);

        assertNotNull(salva.getId(), "ID da tarefa não deve ser nulo");
        System.out.println("Tarefa salva com ID: " + salva.getId());

		//Deletar a tarefa
        tarefasService.deletar(salva.getId());

    }
}