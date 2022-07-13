CREATE TABLE cliente (
	idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nomeCliente VARCHAR(60) NOT NULL,
    cpfCnpj VARCHAR(20) UNIQUE NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(100) NOT NULL
);

CREATE TABLE editora (
	idEditora INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    gerente VARCHAR(60) NOT NULL
);

CREATE TABLE livro (
	
);

alter table cliente add UNIQUE(cpf);