--SELECT: Selecció de totes les columnes (* despres de la select indica que volem tots els camps)
SELECT *
FROM CLIENTS;

--SELECT : Seleccionar determinades columnes
SELECT codi_cli, nom_cli, adreça, ciutat
FROM CLIENTS;

-- Selecció de les files d’una taula Volem els empreats del projecte 4
SELECT codi_empl,num_proj
FROM EMPLEATS
WHERE num_proj = 4;

-- Resultats sense informació repetida Sous dels empleats
SELECT DISTINCT sou 
FROM EMPLEATS;


--Tots els treballadors que tinguin un rang determinat de sou
--BETWEEN Operadors del where (entre dos rangs)

SELECT codi_empl, sou
FROM EMPLEATS
WHERE SOU BETWEEN 20000 AND 50000;


--Tots els treballadors que tinguin un rang determinat de sou
-- Operadors <,<=,>, >=  del where 

SELECT codi_empl, sou
FROM EMPLEATS
WHERE SOU >= 20000 and sou <= 50000;

--Els trballadors que estiguin a les ciutats de Barcelona o Madrid
--Filtrar resultats i ordenats per numero de columna
SELECT nom_dpt, ciutat_dpt
FROM DEPARTAMENTS
WHERE ciutat_dpt IN ('BARCELONA', 'MADRID')
order by 2;

-- Filtrar resultats i ordenats per nom de columna
SELECT nom_dpt, ciutat_dpt
FROM DEPARTAMENTS
WHERE ciutat_dpt IN ('BARCELONA', 'MADRID')
order by ciutat_dpt;


-- filtrar resultats amb LIKE (que comencin amb  el nom de l'empleat"
SELECT codi_empl, nom_empl
FROM EMPLEATS
WHERE nom_empl LIKE 'J%';

--Filtrar per null 
SELECT codi_empl, nom_empl
FROM EMPLEATS
WHERE ciutat_dpt IS NULL;

--UPPER, LOWER I ALIAS 
SELECT upper(nom_empl) AS NOM, LOWER(cognom_empl)AS COGNOM
FROM EMPLEATS;


--case
Select nom_dpt, case nom_dpt 
    when 'FAR' then 'Farmacia' 
    when 'DIR' then 'Direcció' 
    when 'PRO' then 'Programcació'
    else 'N/A' end
    as departament
from departaments ;


--to_char DATE
SELECT data_inici, TO_CHAR(data_inici, 'MM-YYYY')AS DATAFORMATADA
FROM projectes;
