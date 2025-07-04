create database ApoioDigitalDB
use ApoioDigitalDB



create table Usuario (

	id varchar(36) PRIMARY KEY,
	nome varchar(50),
	senha varchar(255),
	telefone varchar(11) UNIQUE

)

select * from Usuario 

Alter table Usuario Modify Column senha varchar(255)

select * from Atalho

select * from Requisicao where id_usuario = "4903961f-1823-4f7b-93b0-104cd1878fcb"

create table Requisicao (

	id varchar(36) PRIMARY KEY,
	id_usuario varchar(36),
	prompt varchar(500),
	timestamp DateTime,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
	
)

create table Resposta(

	id varchar(36) PRIMARY KEY,
	id_requisicao varchar(36),
	mensagem varchar(500),
	timestamp DateTime,
	FOREIGN KEY (id_requisicao) REFERENCES Requisicao(id)

)

create table Atalho(

	id varchar (36) PRIMARY KEY,
	id_usuario varchar(36),
	id_categoria bigint,
	titulo varchar(30),
	prompt varchar(500),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	FOREIGN KEY (id_categoria) REFERENCES CategoriaAtalho(id)
)

create table CategoriaAtalho(

	id bigint PRIMARY KEY,
	categoria varchar(50)

)

create table ModeloIA(
	id int primary key,
	regras varchar(500)
);

create table AppSuportado(
	id bigint primary key,
	nome varchar(20),
	descricao varchar(100),
	referencia varchar(20),
	situacao varchar(50),
	id_modeloIA int,
	FOREIGN KEY (id_modeloIA) REFERENCES ModeloIA(id)

);

select * from CategoriaAtalho
INSERT INTO CategoriaAtalho (id, categoria) VALUES (1, 'Comida');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (2, 'Transporte');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (3, 'Saúde');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (4, 'Lazer');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (5, 'Compras');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (6, 'Farmácia');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (7, 'Banco');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (8, 'Mensagens');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (9, 'Redes Sociais');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (10, 'Notícias');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (12, 'Entretenimento');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (13, 'Chamadas');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (15, 'Serviços Públicos');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (16, 'Emergência');
INSERT INTO CategoriaAtalho (id, categoria) VALUES (17, 'Agenda');

