INSERT INTO classe (codi, nom, capacitat, situacio) VALUES (1, 3.1, 60, 'Planta3');
INSERT INTO classe (codi, nom, capacitat, situacio) VALUES (2, 2.3, 30, 'Planta2');
INSERT INTO classe (codi, nom, capacitat, situacio) VALUES (3, 2.6, 30, 'Planta2');

INSERT INTO departament (codi, nom) VALUES (001, 'Inform�tica');
INSERT INTO departament (codi, nom) VALUES (002, 'Telem�tica');
INSERT INTO departament (codi, nom) VALUES (003, 'Electr�nica');

INSERT INTO professor (codi, cognom1, cognom2, nom, actiu, categoria, dedicacio, departament) VALUES (3, 'Mons', 'Adell', 'Marta', 'S', 'Director', 'TC', 002);
INSERT INTO professor (codi, cognom1, cognom2, nom, actiu, categoria, dedicacio, departament, director) VALUES (1, 'Jimenez', 'Clos', 'Josep', 'S', 'Titular', 'TC', 001, 3);
INSERT INTO professor (codi, cognom1, cognom2, nom, actiu, categoria, dedicacio, departament, director) VALUES (2, 'Marti', 'Maragall', 'Maria', 'S', 'Titular', 'TC', 001, 3);

INSERT INTO assignatura (sigles, nom, credits, curs, hores_teoria, hores_practica, num_alumnes) VALUES ('ES', 'Estad�stica', 6, '1B', 3, 1, 30);
INSERT INTO assignatura (sigles, nom, credits, curs, hores_teoria, hores_practica, num_alumnes) VALUES ('BD', 'Bases de dades', 6, '2A', 4, 0, 28);
INSERT INTO assignatura (sigles, nom, credits, curs, hores_teoria, hores_practica, num_alumnes) VALUES ('SO', 'Sistemes Operatius', 9, '3A', 5, 1, 46);

INSERT INTO docencia (id, professor, classe, assignatura, Curs_academic) VALUES (1, 2, 2, 'ES', '18_19');
INSERT INTO docencia (id, professor, classe, assignatura, Curs_academic) VALUES (2, 2, 2, 'BD', '18_19');
INSERT INTO docencia (id, professor, classe, assignatura, Curs_academic) VALUES (3, 1, 1, 'SO', '18_19');

commit;
