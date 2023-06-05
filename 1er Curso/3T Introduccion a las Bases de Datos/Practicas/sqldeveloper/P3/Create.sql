
CREATE TABLE creuer (
    codi                INTEGER NOT NULL,
    nom                 VARCHAR2(100) NOT NULL,
    tipus               VARCHAR2(50) NOT NULL,
    calenVisats         CHAR(1) NOT NULL
);

ALTER TABLE creuer 
    ADD CONSTRAINT creuer_pk 
    PRIMARY KEY (codi);
    
ALTER TABLE creuer    
    ADD CONSTRAINT CH_tipus_creuer
    CHECK (tipus IN('luxe', 'semiluxe', 'estandar'));
    
ALTER TABLE creuer
    ADD CONSTRAINT CH_calenVisats
    CHECK (calenVisats IN('S', 'N'));

CREATE TABLE escala (
    numero              INTEGER NOT NULL,
    dia                 INTEGER NOT NULL,
    durada              NUMBER(4,2) NOT NULL,
    CREUER_codi         INTEGER NOT NULL,
    PORT_codi           INTEGER NOT NULL
);

ALTER TABLE escala 
    ADD CONSTRAINT escala_pk 
    PRIMARY KEY (numero);

CREATE TABLE puerto (
    codi                INTEGER NOT NULL,
    nomCiutat           VARCHAR2(25) NOT NULL,
    categoria           VARCHAR2(25) NOT NULL
);

ALTER TABLE puerto 
    ADD CONSTRAINT port_pk 
    PRIMARY KEY (codi);

ALTER TABLE puerto
    ADD CONSTRAINT CH_categoria
    CHECK (categoria IN('A', 'B', 'C', 'D'));


CREATE TABLE sortida (
    fecha               DATE NOT NULL,
    CREUER_codi         INTEGER NOT NULL,
    VAIXELL_codi        INTEGER NOT NULL
);

ALTER TABLE sortida 
    ADD CONSTRAINT sortida_pk 
    PRIMARY KEY (CREUER_codi, fecha);

CREATE TABLE vaixell (
    codi                INTEGER NOT NULL,
    nom                 VARCHAR2(25) NOT NULL,
    año                 INTEGER NOT NULL,
    numTripulants       INTEGER NOT NULL,
    eslora              NUMBER(4,2) NOT NULL,
    bandera             VARCHAR2(25) NOT NULL
);

ALTER TABLE vaixell 
    ADD CONSTRAINT vaixell_pk 
    PRIMARY KEY (codi);

CREATE TABLE reserva (
    localitzador            VARCHAR2(25) NOT NULL,
    fecha                   DATE NOT NULL,
    pagada                  CHAR(1) NOT NULL,
    SORTIDA_CREUER_codi     INTEGER NOT NULL,
    SORTIDA_fecha           DATA NOT NULL,
    CABINA_VAIXELL_codi     INTEGER NOT NULL,
    CABINA_cobertaNumero    VARCHAR2(5) NOT NULL
);

ALTER TABLE reserva 
    ADD CONSTRAINT reserva_pk 
    PRIMARY KEY (localitzador);
    
ALTER TABLE reserva
    ADD CONSTRAINT CH_pagada
    CHECK (pagada IN('S', 'N'));
    
ALTER TABLE reserva
    ADD CONSTRAINT CH_reserva
    CHECK (SORTIDA_data > fecha);

CREATE TABLE cabina (
    cobertaNumero       VARCHAR2(5) NOT NULL,
    capacitat           INTEGER NOT NULL,
    VAIXELL_codi        INTEGER NOT NULL
);

ALTER TABLE cabina 
    ADD CONSTRAINT cabina_pk 
    PRIMARY KEY (VAIXELL_codi, cobertaNumero);
    
ALTER TABLE cabina
    ADD CONSTRAINT CH_capacitat
    CHECK (capacitat > 0);

CREATE TABLE demanar (
    RESERVA_localitzador        VARCHAR2(25) NOT NULL,
    PASSATGER_indentificador    VARCHAR2(25) NOT NULL    
);

ALTER TABLE demanar 
    ADD CONSTRAINT demanar_pk 
    PRIMARY KEY (RESERVA_localitzador, PASSATGER_identificador);
                                                    
CREATE TABLE passatger (
    identificador       VARCHAR2(25) NOT NULL,
    nom                 VARCHAR2(25) NOT NULL,
    cognom1             VARCHAR2(50) NOT NULL,
    adreça              VARCHAR2(100) NOT NULL
);

ALTER TABLE passatger ADD CONSTRAINT passatger_pk PRIMARY KEY (identificador);

ALTER TABLE escala 
    ADD CONSTRAINT escala_port_fk 
    FOREIGN KEY (PUERTO_codi) 
    REFERENCES port (codi);
ALTER TABLE escala 
    ADD CONSTRAINT escala_creuer_fk 
    FOREIGN KEY (CREUER_codi) 
    REFERENCES creuer (codi);

ALTER TABLE sortida 
    ADD CONSTRAINT sortida_creuer_fk 
    FOREIGN KEY (CREUER_codi) 
    REFERENCES creuer (codi);
ALTER TABLE sortida 
    ADD CONSTRAINT sortida_vaixell_fk 
    FOREIGN KEY (VAIXELL_codi) 
    REFERENCES vaixell (codi);

ALTER TABLE reserva 
    ADD CONSTRAINT reserva_sortida_fk 
    FOREIGN KEY (SORTIDA_CREUER_codi, SORTIDA_fecha) 
    REFERENCES sortida (CREUER_codi, fecha);
ALTER TABLE reserva 
    ADD CONSTRAINT reserva_cabina_fk 
    FOREIGN KEY (CABINA_VAIXELL_codi, CABINA_cobertaNumero)
    REFERENCES cabina (VAIXELL_codi, cobertaNumero);
    
ALTER TABLE cabina
    ADD CONSTRAINT cabina_vaixell_fk
    FOREIGN KEY (VAIXELL_codi)
    REFERENCES vaixell (codi);
    
ALTER TABLE demanar
    ADD CONSTRAINT demanar_reserva_fk
    FOREIGN KEY (RESERVA_localitzador)
    REFERENCES reserva (localitzador);
ALTER TABLE demanar
    ADD CONSTRAINT demanar_passatger_fk
    FOREIGN KEY (PASSATGER_identificador)
    REFERENCES passatger (identificador);

commit;
