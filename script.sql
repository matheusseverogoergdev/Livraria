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
	idLivro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(60) NOT NULL,
    autor VARCHAR(60) NOT NULL,
    assunto VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    estoque INT NOT NULL,
    preco FLOAT NOT NULL,
    idEditora INT NOT NULL,
    FOREIGN KEY (idEditora) REFERENCES editora(idEditora)
);

CREATE TABLE compra (
	idCompra INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    dataCompra DATE NOT NULL,
    quantidadeCompra INT NOT NULL,
    subTotal FLOAT NOT NULL,
    idCliente INT NOT NULL UNIQUE,
    idLivro INT NOT NULL UNIQUE,
    FOREIGN KEY(idCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY(idLivro) REFERENCES livro(idLivro)
);

alter table cliente add UNIQUE(cpf);

ALTER TABLE livro ADD UNIQUE(isbn);

ALTER TABLE editora ADD UNIQUE(nome);