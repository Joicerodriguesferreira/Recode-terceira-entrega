-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE cliente (
uf VARCHAR(10),
cidade VARCHAR(10),
bairro VARCHAR(10),
numero VARCHAR(10),
rua VARCHAR(10),
cep VARCHAR(10),
telefone VARCHAR(20),
email VARCHAR(50),
cpf VARCHAR(11) PRIMARY KEY,
dataNascimento VARCHAR(10),
senha VARCHAR(6),
nomeCompleto VARCHAR(50)
)

CREATE TABLE passagem  (
idPassagem NUMERIC(10) PRIMARY KEY,
dataViagem DATETIME,
horaViagem DATETIME,
quantidade NUMERIC(10),
destino VARCHAR(50),
tipoTransporte VARCHAR(20)
)

CREATE TABLE reserva (
idReserva NUMERIC(20) PRIMARY KEY
)

CREATE TABLE efetua (
idReserva NUMERIC(20),
cpf VARCHAR(11),
FOREIGN KEY(idReserva) REFERENCES reserva (idReserva),
FOREIGN KEY(cpf) REFERENCES cliente (cpf)
)

CREATE TABLE contem (
idPassagem NUMERIC(10),
idReserva NUMERIC(20),
FOREIGN KEY(idPassagem) REFERENCES passagem  (idPassagem),
FOREIGN KEY(idReserva) REFERENCES reserva (idReserva)
)

