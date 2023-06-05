
-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE cabina (
    cobertanumero VARCHAR2(5) NOT NULL,
    capacitat     INTEGER NOT NULL,
    vaixell_codi  INTEGER NOT NULL
);

ALTER TABLE cabina ADD CHECK ( capacitat > 0 );

ALTER TABLE cabina ADD CONSTRAINT cabina_pk PRIMARY KEY ( vaixell_codi,
                                                          cobertanumero );

CREATE TABLE creuer (
    codi           INTEGER NOT NULL,
    nom            VARCHAR2(100) NOT NULL,
    tipus          VARCHAR2(50) NOT NULL,
    "calenVisats?" CHAR(1) NOT NULL
);

ALTER TABLE creuer
    ADD CHECK ( tipus IN ( 'estandàrd', 'luxe', 'semiluxe' ) );

ALTER TABLE creuer
    ADD CHECK ( "calenVisats?" IN ( 'N', 'S' ) );

ALTER TABLE creuer ADD CONSTRAINT creuer_pk PRIMARY KEY ( codi );


CREATE TABLE demanar (
    reserva_localitzador    VARCHAR2(25) NOT NULL,
    passatger_identificador VARCHAR2(25) NOT NULL
);

ALTER TABLE demanar ADD CONSTRAINT demanar_pk PRIMARY KEY ( reserva_localitzador,
                                                            passatger_identificador );

CREATE TABLE escala (
    número      INTEGER NOT NULL,
    dia         INTEGER NOT NULL,
    durada      NUMBER(4, 2) NOT NULL,
    creuer_codi INTEGER NOT NULL,
    port_codi   INTEGER NOT NULL
);

ALTER TABLE escala ADD CONSTRAINT escala_pk PRIMARY KEY ( número );

CREATE TABLE passatger (
    identificador VARCHAR2(25) NOT NULL,
    nom           VARCHAR2(25) NOT NULL,
    cognom1       VARCHAR2(50) NOT NULL,
    cognom2       VARCHAR2(50),
    adreça        VARCHAR2(100) NOT NULL
);

ALTER TABLE passatger ADD CONSTRAINT passatger_pk PRIMARY KEY ( identificador );

CREATE TABLE port (
    codi      INTEGER NOT NULL,
    nomciutat VARCHAR2(25) NOT NULL,
    categoria VARCHAR2(25) NOT NULL
);

ALTER TABLE port
    ADD CHECK ( categoria IN ( 'A', 'B', 'C', 'D' ) );

ALTER TABLE port ADD CONSTRAINT port_pk PRIMARY KEY ( codi );

CREATE TABLE reserva (
    localitzador         VARCHAR2(25) NOT NULL,
    data                 DATE NOT NULL,
    pagada               CHAR(1) NOT NULL,
    sortida_creuer_codi  INTEGER NOT NULL,
    sortida_data         DATE NOT NULL,
    cabina_vaixell_codi  INTEGER NOT NULL,
    cabina_cobertanumero VARCHAR2(5) NOT NULL
);

ALTER TABLE reserva ADD CONSTRAINT  CH_dataSortida CHECK(sortida_data>data);

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( localitzador );

ALTER TABLE reserva
    ADD CHECK ( pagada IN ( 'S', 'N' ) );


CREATE TABLE sortida (
    data         DATE NOT NULL,
    creuer_codi  INTEGER NOT NULL,
    vaixell_codi INTEGER NOT NULL
);

ALTER TABLE sortida ADD CONSTRAINT sortida_pk PRIMARY KEY ( creuer_codi,
                                                            data );

CREATE TABLE vaixell (
    codi          INTEGER NOT NULL,
    nom           VARCHAR2(50) NOT NULL,
    "any"         INTEGER NOT NULL,
    numtripulants INTEGER NOT NULL,
    eslora        NUMBER(4,2) NOT NULL,
    bandera       VARCHAR2(25) NOT NULL
);

ALTER TABLE vaixell ADD CONSTRAINT vaixell_pk PRIMARY KEY ( codi );

ALTER TABLE cabina
    ADD CONSTRAINT cabina_vaixell_fk FOREIGN KEY ( vaixell_codi )
        REFERENCES vaixell ( codi );

ALTER TABLE demanar
    ADD CONSTRAINT demanar_passatger_fk FOREIGN KEY ( passatger_identificador )
        REFERENCES passatger ( identificador );

ALTER TABLE demanar
    ADD CONSTRAINT demanar_reserva_fk FOREIGN KEY ( reserva_localitzador )
        REFERENCES reserva ( localitzador );

ALTER TABLE escala
    ADD CONSTRAINT escala_creuer_fk FOREIGN KEY ( creuer_codi )
        REFERENCES creuer ( codi );

ALTER TABLE escala
    ADD CONSTRAINT escala_port_fk FOREIGN KEY ( port_codi )
        REFERENCES port ( codi );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_cabina_fk FOREIGN KEY ( cabina_vaixell_codi,
                                                   cabina_cobertanumero )
        REFERENCES cabina ( vaixell_codi,
                            cobertanumero );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_sortida_fk FOREIGN KEY ( sortida_creuer_codi,
                                                    sortida_data )
        REFERENCES sortida ( creuer_codi,
                             data );

ALTER TABLE sortida
    ADD CONSTRAINT sortida_creuer_fk FOREIGN KEY ( creuer_codi )
        REFERENCES creuer ( codi );

ALTER TABLE sortida
    ADD CONSTRAINT sortida_vaixell_fk FOREIGN KEY ( vaixell_codi )
        REFERENCES vaixell ( codi );
        
        
COMMIT;