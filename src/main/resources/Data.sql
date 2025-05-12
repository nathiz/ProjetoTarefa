CREATE TABLE IF NOT EXISTS tarefas (
    id UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(255) NOT NULL,
    datacriacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tarefas (id, titulo, descricao, status, datacriacao) 
VALUES (UUID(), 'Estudar Spring Boot', 'Ler a documentacao e criar um projeto simples', 'PENDENTE', NOW());

INSERT INTO tarefas (id, titulo, descricao, status, datacriacao) 
VALUES (UUID(), 'Desenvolver API', 'Criar uma API RESTful com Spring Boot', 'EM_ANDAMENTO', NOW());

INSERT INTO tarefas (id, titulo, descricao, status, datacriacao) 
VALUES (UUID(), 'Revisar Codigo', 'Revisar codigo para garantir a qualidade', 'CONCLUIDO', NOW());