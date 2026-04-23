---Tabela loja (Gabi e Tabbi)

CREATE TABLE loja (
	id_loja SERIAL PRIMARY KEY,
	nome_loja VARCHAR(100) NOT NULL,
	endereco_loja TEXT, 
	cnpj VARCHAR(20),
	n_dono VARCHAR (100)
);
---Tabela Cliente (Gabi e Tabbi)

CREATE TABLE cliente (
	id_cliente SERIAL PRIMARY KEY,
	nome_cliente VARCHAR(100) NOT NULL,
	telefone_cliente VARCHAR(20), 
	cpf VARCHAR(12)
);
---Tabela Produto (Gabi e Tabbi)

CREATE TABLE produto (
	id_produto SERIAL PRIMARY KEY,
	nome_produto VARCHAR(100) NOT NULL,
	quantidade INT NOT NULL, 
	preco NUMERIC(10,2) NOT NULL
);
-- Tabela Venda (Gabi e Tabbi)
CREATE TABLE venda (
    id_venda SERIAL PRIMARY KEY,
    id_loja INT NOT NULL,
    id_cliente INT NOT NULL,
    data_venda DATE NOT NULL,

    CONSTRAINT fk_loja
        FOREIGN KEY (id_loja)
        REFERENCES loja(id_loja),

    CONSTRAINT fk_cliente
        FOREIGN KEY (id_cliente)
        REFERENCES cliente(id_cliente)
);
-- Tabela item_venda (Gabi e Tabbi)
CREATE TABLE item_venda (
    id_item SERIAL PRIMARY KEY,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
	preco_unit NUMERIC (10,2) NOT NULL,

	 CONSTRAINT fk_venda
        FOREIGN KEY (id_venda)
        REFERENCES venda(id_venda)
        ON DELETE CASCADE,

    CONSTRAINT fk_produto
        FOREIGN KEY (id_produto)
        REFERENCES produto(id_produto)
);

	
