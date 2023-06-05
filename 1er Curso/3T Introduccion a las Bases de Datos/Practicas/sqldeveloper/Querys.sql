--SELECTS DE COMPROVACIÓ DE LES DADES
select * from propietari;

select * from cotxe;

select * from sinistre;

select * from involucrar;

--MODIFICACIÓ DE UN CAMP

ALTER TABLE COTXE MODIFY (places NOT NULL);


--PUC FER AQUEST INSERT?

insert into cotxe values( 'P03','35556555555555DJJ','17/12/2021',5,'N','34536657K');

--MODIFICO EL CAMP
ALTER TABLE COTXE MODIFY (matrícula  VARCHAR2(25) );



--PODEM ESBORRAR EL COTXE 1?
DELETE  FROM COTXE WHERE ID_COTXE = 'P01';

select * from involucrar;

select * from cotxe;

--PODEM TRUNCAR LA TAULA SENCERA?
truncate table cotxe;



-----modificar el la restriccio de COTXE


ALTER TABLE involucrar
drop CONSTRAINT fk_involucrar;

COMMIT; 

ALTER TABLE involucrar
ADD CONSTRAINT fk_involucrar FOREIGN KEY (id_cotxe)
   REFERENCES cotxe ( id_cotxe )
  ON DELETE CASCADE;


--COMPRPVACIO
select * from cotxe;

select * from involucrar;
