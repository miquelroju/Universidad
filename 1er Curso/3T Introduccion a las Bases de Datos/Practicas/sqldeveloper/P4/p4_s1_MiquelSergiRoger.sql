-- Mostra els creuers hi han de tipus luxe, amb tota la informació de la taula creuer

select codi, nom, tipus, "calenVisats?"
from creuer
where tipus = 'luxe'
order by 1;

-- Mostra els creuers hi han de tipus semiluxe i que NO sigui necessari tenir visat, amb tota la informació de la taula creuer

select codi, nom, tipus, "calenVisats?"
from creuer
where tipus = 'semiluxe' and "calenVisats?" = 'N'
order by 1;

-- Mostra els creuers hi han de tipus semiluxe i que NO sigui necessari tenir visat, amb tota la informació de la taula creuer
-- MALAMENT, AGAFA EL DISTINCT PER LES DOS COLUMNES, NO PER UNA
select DISTINCT cobertanumero, vaixellcodi
from cabina
order by 1;

-- Mostra el nom dels creuers i el seu tipus en majúscula, dona un alies a aquests camps i ordena’ls per tipus de creuer 

select upper(nom) as "NOM_CREUER", upper(tipus) as "TIPUS_CREUER"
from creuer
order by 2;

--  De les sortides, visualitza el codi del creuer, i les dates de sortides anteriors al 2022, i ordena per data

select creuer_codi, data
from sortida
where extract(year from to_date(data, 'DD-MM-YYYY')) < 22
order by 2;

-- Visualitza per a cada passatger una cadena formada pel seu nom, cognom i el seu identificador. Dona-li un àlies a la
-- nova columna 

select nom || ' ' || cognom1 || ' ' || identificador as "INFORMACIO_PASSATGER"
from passatger;

-- Visualitza els creuer que NO siguin tipus luxe , ordenat per tipus

select codi, nom, tipus
from creuer
where tipus != 'luxe'
order by tipus;

-- Mostra per cada reserva el localitzador, la data de la reserva, la data de la sortida i el numero de mesos des de que han
-- reservat la sortida fins que han realitzat el pagament arrodonint amb dos decimals, nomes per les reserves pagades
-- (utilitza àlies)

select localitzador, data as "DATARESERVA", sortida_data as "SORTIDA_DATA", round(months_between(sortida_data, data), 2) as "NUMMESOS"
from reserva
where pagada = 'S';

-- Mostra per cada reserva el localitzador, la data de la reserva, la data de la sortida i el numero de dies que queden per la
-- sortida, en les sortides posteriors a data d'avui (utilitza àlies)
-- MALAMENT NUMERO_DIES_PER_SORTIDA
select localitzador, data as "DATARESERVA", sortida_data as "SORTIDA_DATA", round(months_between(sortida_data, data)*30, 2) as "NUMERO_DIES_PER_SORTIDA"
from reserva
where sortida_data > sysdate;

-- Mostra tots els atributs de les cabines que tinguin capacitat mes gran de dos persones de la coberta A ordenat per vaixell

select *
from cabina
where capacitat >= 2 and cobertanumero like 'A%'
order by vaixell_codi;

 -- Mostra el nom, identificador, i cognom dels passatgers que no tenen informat el segon cognom 
 
 select identificador, nom, cognom1
 from passatger
 where cognom2 is null;
 
 -- Mostra les diferents categories que poden tenir els ports
 
 select DISTINCT categoria as "CATEGORIA"
 from port
 order by 1 asc;
 
 -- Mostra les escales que tenen una durada entre 1 i 4 dies, ordenat per dia i creuer, del port numero
 
 -- MALAMENT

select número, dia, durada, creuer_codi, port_codi
from escala
where durada >= 1 and durada <= 4
order by dia;

-- Mostra de cada codi de vaixell, la coberta, i la capacitat, afegint un camp nou reduint la capacitat a la meitat de les
-- cobertes que tenen capacitat de 10 persones (dona un àlies a aquesta nova columna) 
-- MALAMENT
select DISTINCT cobertanumero, vaixell_codi, capacitat, capacitat/2 as "NOVACAPACITAT"
from cabina;

-- Mostra el nom, identificador, i cognoms dels passatgers que tenen les lletres 'qu' en el seu cognom o les lletres 'ia' en
-- el seu nom 

select identificador, nom, cognom1
from passatger  
where cognom1 like '%qu%' or cognom2 like '%qu%' or nom like '%ia%';

