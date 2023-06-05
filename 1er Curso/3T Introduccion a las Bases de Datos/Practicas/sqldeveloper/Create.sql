CREATE TABLE cotxe (
    id_cotxe          CHAR(7) NOT NULL,
    matrícula         VARCHAR2(10) NOT NULL,
    data_matriculació DATE,
    places            INTEGER,
    servei_public     CHAR(1),
    nif               CHAR(9) NOT NULL
);

ALTER TABLE cotxe ADD CONSTRAINT pk_cotxe PRIMARY KEY ( id_cotxe );

ALTER TABLE cotxe ADD CONSTRAINT un_cotxe_matrícula UNIQUE ( matrícula );

CREATE TABLE involucrar (
    id_cotxe    CHAR(7) NOT NULL,
    id_sinistre CHAR(7) NOT NULL
);

ALTER TABLE involucrar ADD CONSTRAINT pk_involucrar PRIMARY KEY ( id_cotxe,
                                                                  id_sinistre );

CREATE TABLE propietari (
    nif      CHAR(9) NOT NULL,
    nom      VARCHAR2(50),
    cognom_1 VARCHAR2(50),
    cognom_2 VARCHAR2(50)
);

ALTER TABLE propietari ADD CONSTRAINT pk_propietari PRIMARY KEY ( nif );

CREATE TABLE sinistre (
    id_sinistre   CHAR(7) NOT NULL,
    data_sinistre DATE,
    lloc_sinistre VARCHAR2(100),
    victimes      CHAR(1),
    informe       VARCHAR2(500)
);

ALTER TABLE sinistre ADD CONSTRAINT pk_sinistre PRIMARY KEY ( id_sinistre );

ALTER TABLE cotxe
    ADD CONSTRAINT fk_cotxe FOREIGN KEY ( nif )
        REFERENCES propietari ( nif );

ALTER TABLE involucrar
    ADD CONSTRAINT fk_involucrar FOREIGN KEY ( id_cotxe )
        REFERENCES cotxe ( id_cotxe );
        
ALTER TABLE involucrar
    ADD CONSTRAINT fk_involucrarv1 FOREIGN KEY ( id_sinistre )
        REFERENCES sinistre ( id_sinistre );
        
        commit;


