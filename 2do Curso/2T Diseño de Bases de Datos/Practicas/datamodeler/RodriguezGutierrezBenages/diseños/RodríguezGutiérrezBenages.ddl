-- Generado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   en:        2023-03-09 17:01:28 CET
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



DROP TABLE arbitratge CASCADE CONSTRAINTS;

DROP TABLE classificacio CASCADE CONSTRAINTS;

DROP TABLE colegiat CASCADE CONSTRAINTS;

DROP TABLE equip CASCADE CONSTRAINTS;

DROP TABLE judici CASCADE CONSTRAINTS;

DROP TABLE jugador CASCADE CONSTRAINTS;

DROP TABLE partit CASCADE CONSTRAINTS;

DROP TABLE rol CASCADE CONSTRAINTS;

DROP TABLE temporada CASCADE CONSTRAINTS;

-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE arbitratge (
    partit_codi            INTEGER NOT NULL,
    colegiat_id_colegiat INTEGER NOT NULL
);

ALTER TABLE arbitratge ADD CONSTRAINT arbitratge_pk PRIMARY KEY ( partit_codi,
                                                                  colegiat_id_colegiat );

CREATE TABLE classificacio (
    posicio        INTEGER NOT NULL,
    guanyats       INTEGER NOT NULL,
    perduts        INTEGER NOT NULL,
    empatats       INTEGER NOT NULL,
    num_partits    INTEGER NOT NULL,
    gols_a_favor   INTEGER NOT NULL,
    gols_en_contra INTEGER NOT NULL,
    puntuacio      INTEGER
);

ALTER TABLE classificacio ADD CONSTRAINT classificacio_pk PRIMARY KEY ( posicio );

CREATE TABLE colegiat (
    id_colegiat    INTEGER NOT NULL,
    nom            VARCHAR2(20) NOT NULL,
    cognom1        VARCHAR2(30) NOT NULL,
    cognom2        VARCHAR2(30),
    "esPrincipal?" CHAR(1),
    numero_jutge   INTEGER,
    "esArbitre?"   CHAR(1),
    "esJutge?"     CHAR(1)
);

ALTER TABLE colegiat
    ADD CHECK ( "esPrincipal?" IN ( '0', '1' ) );

ALTER TABLE colegiat
    ADD CHECK ( numero_jutge IN ( 1, 2, 4 ) );

ALTER TABLE colegiat ADD CONSTRAINT colegiat_pk PRIMARY KEY ( id_colegiat );

CREATE TABLE equip (
    nom                   VARCHAR2(30) NOT NULL,
    ciutat                VARCHAR2(30) NOT NULL,
    estadi                VARCHAR2(40) NOT NULL,
    classificacio_posicio INTEGER NOT NULL,
    partit_codi           INTEGER NOT NULL
);

ALTER TABLE equip ADD CONSTRAINT equip_pk PRIMARY KEY ( nom );

CREATE TABLE judici (
    partit_codi            INTEGER NOT NULL,
    colegiat_id_colegiat INTEGER NOT NULL
);

ALTER TABLE judici ADD CONSTRAINT judici_pk PRIMARY KEY ( partit_codi,
                                                          colegiat_id_colegiat );

CREATE TABLE jugador (
    id            INTEGER NOT NULL,
    nom           VARCHAR2(30) NOT NULL,
    cognom1       VARCHAR2(30) NOT NULL,
    cognom2       VARCHAR2(30),
    num_samarreta INTEGER NOT NULL,
    codi          INTEGER NOT NULL,
    rol_id        INTEGER NOT NULL,
    datanaixement DATE,
    nacionalitat  VARCHAR2(30),
    equip_nom     VARCHAR2(30) NOT NULL
);

ALTER TABLE jugador ADD CONSTRAINT jugador_pk PRIMARY KEY ( id,
                                                            rol_id );

CREATE TABLE partit (
    codi           INTEGER NOT NULL,
    data           DATE NOT NULL,
    equip_local    VARCHAR2(30) NOT NULL,
    equip_visitant VARCHAR2(30) NOT NULL,
    gols_local     INTEGER NOT NULL,
    gols_visitant  INTEGER NOT NULL,
    ubicacio       VARCHAR2(30) NOT NULL,
    temporada_any  INTEGER NOT NULL
);

ALTER TABLE partit ADD CONSTRAINT partit_pk PRIMARY KEY ( codi );

CREATE TABLE rol (
    id    INTEGER NOT NULL,
    tipus VARCHAR2(20) NOT NULL
);

ALTER TABLE rol
    ADD CHECK ( tipus IN ( 'DEFENSA', 'DELANTER', 'PORTER' ) );

ALTER TABLE rol ADD CONSTRAINT rol_pk PRIMARY KEY ( id );

CREATE TABLE temporada (
    "any" INTEGER NOT NULL
);

ALTER TABLE temporada ADD CHECK ( "any" BETWEEN 1800 AND 2040 );

ALTER TABLE temporada ADD CONSTRAINT temporada_pk PRIMARY KEY ( "any" );

ALTER TABLE arbitratge
    ADD CONSTRAINT arbitratge_colegiat_fk FOREIGN KEY ( colegiat_id_colegiat )
        REFERENCES colegiat ( id_colegiat );

ALTER TABLE arbitratge
    ADD CONSTRAINT arbitratge_partit_fk FOREIGN KEY ( partit_codi )
        REFERENCES partit ( codi );

ALTER TABLE equip
    ADD CONSTRAINT equip_classificacio_fk FOREIGN KEY ( classificacio_posicio )
        REFERENCES classificacio ( posicio );

ALTER TABLE equip
    ADD CONSTRAINT equip_partit_fk FOREIGN KEY ( partit_codi )
        REFERENCES partit ( codi );

ALTER TABLE judici
    ADD CONSTRAINT judici_colegiat_fk FOREIGN KEY ( colegiat_id_colegiat )
        REFERENCES colegiat ( id_colegiat );

ALTER TABLE judici
    ADD CONSTRAINT judici_partit_fk FOREIGN KEY ( partit_codi )
        REFERENCES partit ( codi );

ALTER TABLE jugador
    ADD CONSTRAINT jugador_equip_fk FOREIGN KEY ( equip_nom )
        REFERENCES equip ( nom );

ALTER TABLE jugador
    ADD CONSTRAINT jugador_rol_fk FOREIGN KEY ( rol_id )
        REFERENCES rol ( id )
            ON DELETE CASCADE;

ALTER TABLE partit
    ADD CONSTRAINT partit_temporada_fk FOREIGN KEY ( temporada_any )
        REFERENCES temporada ( "any" )
            ON DELETE CASCADE;

CREATE OR REPLACE TRIGGER fkntm_equip BEFORE
    UPDATE OF partit_codi, classificacio_posicio ON equip
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table EQUIP is violated');
END;
/

CREATE OR REPLACE TRIGGER fkntm_jugador BEFORE
    UPDATE OF rol_id, equip_nom ON jugador
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table JUGADOR is violated');
END;
/

CREATE OR REPLACE TRIGGER fkntm_partit BEFORE
    UPDATE OF temporada_any ON partit
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table PARTIT is violated');
END;
/

CREATE OR REPLACE TRIGGER fkntm_arbitratge BEFORE
    UPDATE OF partit_codi, colegiat_id_colegiat ON arbitratge
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table ARBITRATGE is violated');
END;
/

CREATE OR REPLACE TRIGGER fkntm_judici BEFORE
    UPDATE OF partit_codi, colegiat_id_colegiat ON judici
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table JUDICI is violated');
END;
/

commit;



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             22
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           5
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
