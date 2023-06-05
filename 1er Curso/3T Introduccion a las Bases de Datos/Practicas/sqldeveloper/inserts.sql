

--inserts propietari
INSERT INTO PROPIETARI VALUES('34536657K','Marc','Solanes',NULL);

INSERT INTO PROPIETARI (nif,nom,cognom_1,cognom_2) VALUES('65676549L','Monica','Abril',NULL);

INSERT INTO PROPIETARI (nif,nom,cognom_1) VALUES('6555679L','Teresa','Sanchez');

--insert into cotxe
insert into cotxe values( 'P01','354FDJJ','17/12/2021',5,'N','34536657K');

insert into cotxe values( 'P02','3556JJJ','17/01/2021',5,'N','65676549L');


insert into sinistre VALUES ('T01','22/05/2022', 'Carretera Padra s/n', 'N', 'Rodes punxades');

--select * from sinistre;

--insert involcurar

insert into involucrar values ('P01','T01');

insert into involucrar values ('P02','T01');

--select * from involucrar;

