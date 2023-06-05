CREATE TABLE classe
(
    codi VARCHAR(5) NOT NULL CONSTRAINT PK_classe PRIMARY KEY,
    nom VARCHAR(40) NOT NULL,
    capacitat INT,
    situacio VARCHAR(40)
);

CREATE TABLE departament
(
    codi VARCHAR(3) NOT NULL CONSTRAINT PK_departament PRIMARY KEY,
    nom VARCHAR(40) NOT NULL
);

CREATE TABLE professor
(
    codi INT NOT NULL CONSTRAINT PK_professor PRIMARY KEY,
    cognom1 VARCHAR(25) NOT NULL,
    cognom2 VARCHAR(25) NOT NULL,
    nom VARCHAR(20) NOT NULL,
    actiu VARCHAR(1) NOT NULL,
    categoria VARCHAR(40) NOT NULL,
    dedicacio VARCHAR(3) NOT NULL,
    departament VARCHAR(3) NOT NULL CONSTRAINT FK_professor_departament REFERENCES departament(codi),
    director NUMBER(3) CONSTRAINT FK_professor_director REFERENCES professor(codi)
);

CREATE TABLE assignatura
(
    sigles VARCHAR(6) NOT NULL CONSTRAINT PK_assignatura PRIMARY KEY,
    nom VARCHAR(40) NOT NULL CONSTRAINT UK_assignatura UNIQUE,
    credits INT,
    curs VARCHAR(3),
    hores_teoria INT,
    hores_practica INT,
    num_alumnes INT
);

CREATE TABLE docencia
(
    id NUMBER NOT NULL CONSTRAINT PK_docencia PRIMARY KEY,
    professor INT NOT NULL CONSTRAINT FK_docencia_professor REFERENCES professor(codi),
    classe VARCHAR(5) NOT NULL CONSTRAINT FK_docencia_classe REFERENCES classe(codi),
    assignatura VARCHAR(6) NOT NULL CONSTRAINT FK_docencia_assignatura REFERENCES assignatura(sigles),
    Curs_academic VARCHAR(5)
);

commit;
