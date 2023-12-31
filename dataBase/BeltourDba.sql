create database BELTOUR;

use BELTOUR;


CREATE TABLE CLIENTE (
ID_CLIENTE INTEGER PRIMARY KEY AUTO_INCREMENT,
ENDERECO VARCHAR(30),
CPF INTEGER NOT NULL,
NOME_CLIENTE VARCHAR(30) NOT NULL,
EMAIL VARCHAR(30) NOT NULL,
STATUS_CLIENTE VARCHAR(10),
TELEFONE INTEGER 
);

CREATE TABLE VIAGEM (
ID_VIAGEM INTEGER PRIMARY KEY AUTO_INCREMENT,
ID_EMPRESA_VIAGEM INTEGER,
DATA_RETORNO DATETIME,
DATA_SAIDA DATETIME,
DESTINO VARCHAR(30) NOT NULL,
STATUS_VIAGEM VARCHAR(10)
);

CREATE TABLE EMPRESA_VIAGEM (
ID_EMPRESA_VIAGEM INTEGER PRIMARY KEY AUTO_INCREMENT,
TELEFONE_EMPRESA_VIAGEM INTEGER NOT NULL,
NOME_EMPRESA_VIAGEM VARCHAR(30) NOT NULL,
EMAIL_EMPRESA_VIAGEM VARCHAR(30) NOT NULL,
ENDERECO_EMPRESA_VIAGEM VARCHAR(30),
CNPJ INTEGER NOT NULL,
STATUS_EMPRESA VARCHAR(10),
TIPO VARCHAR(10) NOT NULL
);

CREATE TABLE RESERVA_RESERVAS (
ID_RESERVA INTEGER PRIMARY KEY AUTO_INCREMENT,
ID_VIAGEM INTEGER,
ID_CLIENTE INTEGER,
DATA_RESERVA DATETIME,
STATUS_RESERVA VARCHAR(10) NOT NULL,
FOREIGN KEY(ID_VIAGEM) REFERENCES VIAGEM (ID_VIAGEM),
FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE (ID_CLIENTE)
);

ALTER TABLE VIAGEM ADD FOREIGN KEY(ID_EMPRESA_VIAGEM) REFERENCES EMPRESA_VIAGEM (ID_EMPRESA_VIAGEM);

show tables;

describe CLIENTE;