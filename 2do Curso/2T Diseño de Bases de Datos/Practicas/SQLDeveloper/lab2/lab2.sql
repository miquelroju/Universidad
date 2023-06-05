/* Ex 5 */

SELECT * from user_constraints
WHERE table_name = 'DEPARTAMENT';

ALTER TABLE departament
DROP CONSTRAINT PK_departament;

ALTER TABLE departament
ADD CONSTRAINTS departament_pk PRIMARY KEY;

/* Ex 6*/

ALTER TABLE profesors
ADD CONSTRAINT ch_professor_dedicacio
CHECK (dedicacio IN ('tc', '6h', '3h'));

UPDATE professors SET dedicacio='20m' WHERE codi=1;

/* Ex 7*/

SELECT * from user_constraints
WHERE table_name = 'CLASSE';
ALTER TABLE classe DROP CONSTRAINT SYS_C00613329;

/* Ex 8 */

ALTER TABLE departament
DISABLE CONSTRAINT SYS_C00613333;
UPDATE DEPARTAMENT
SET NOM='NULL'
WHERE CODI='001';

ALTER TABLE departament
ENABLE CONSTRAINT SYS_C00613333;
UPDATE DEPARTAMENT
SET NOM='INFORMATICA'
WHERE CODI='001';
ALTER TABLE DEPARTAMENT ENABLE CONSTRAINT SYS_C00613333;

/* Ex 9 */

ALTER TABLE ASSIGNATURA
ADD CONSTRAINT ch_assignaturaCreditsHores CHECK ((NVL(HORES_TEORIA,0) + NVL(HORES_PRACTICA,0))*1.5=CREDITS);

/* Ex 10 */

SELECT * FROM user_constraints WHERE table_name = 'ASSIGNATURA';

ALTER TABLE assignatura
ADD CONSTRAINT ch_assignaturaCredits check (credits <= 9);

/* Ex 11 */
/* És impossible de fer */

/* Ex 12 */

SELECT * FROM user_constraints WHERE table_name = 'PROFESSOR';

/* Ex 13 */

ALTER TABLE professor DROP CONSTRAINT FK_PROFESSOR_DEPARTAMENT;
ALTER TABLE PROFESSOR ADD CONSTRAINT FK_PROFESSOR_DEPARTAMENT FOREIGN KEY (DEPARTAMENT) REFERENCES DEPARTAMENT(CODI) ON DELETE SET NULL;

DELETE FROM departament WHERE codi='001';

/* Ex 14 */

ALTER TABLE professor DROP CONSTRAINT FK_PROFESSOR_DEPARTAMENT;
ALTER TABLE professor ADD CONSTRAINT FK_PROFESSOR_DEPARTAMENT FOREIGN KEY (departament) REFERENCES departament(codi) ON DELETE CASCADE;

DELETE FROM departament WHERE CODI='001';

/* Ex 15 */

ALTER TABLE professor DROP CONSTRAINT FK_PROFESSOR_DEPARTAMENT;
ALTER TABLE professor ADD CONSTRAINT FK_PROFESSOR_DEPARTAMENT FOREIGN KEY (departament) REFERENCES departament(codi);

SELECT * FROM user_constraints WHERE table_name = 'PROFESSOR';

/* Ex 16 */

ALTER TABLE departament DISABLE CONSTRAINT SYS_C00613333;
INSERT INTO departament(codi) VALUES ('&codi');

ALTER TABLE departament ENABLE CONSTRAINT SYS_C00613333; /* No funciona --> Violated */

ALTER TABLE departament ENABLE NOVALIDATE CONSTRAINT SYS_C00613333;
SELECT * FROM user_constraints WHERE table_name = 'DEPARTAMENT';

/* Ex 17 */

ALTER TABLE professor DROP CONSTRAINT FK_PROFESSOR_DIRECTOR;
ALTER TABLE professor ADD CONSTRAINT FK_PROFESSOR_DIRECTOR FOREIGN KEY (director) REFERENCES professor(codi) DEFERRABLE INITIALLY DEFERRED;

SELECT constraint_name, delete_rule, status, deferrable, deferred FROM user_constraints WHERE table_name = 'PROFESSOR';

INSERT INTO professor VALUES ('&codi', '&cognom1', '&cognom2', '&nom', '&actiu', '&categoria', '&dedicacio', '&departament', '&director');
SELECT * FROM DEPARTAMENT;

/* Ex 18 */

INSERT ALL
WHEN sal < 5000 THEN
INTO special_sal VALUES (empid, sal)
ELSE
INTO sal_history VALUES (empid, hiredate, sal)
INTO mgr_history VALUES (empid, mgr, sal)
SELECT employee_id empid, hire_date hiredate, salary sal, manager_id MGR
FROM employees
WHERE employee_id > 200;

SELECT * FROM special_sal;
SELECT * FROM sal_history;
SELECT * FROM mgr_history;





SELECT * FROM EMPLOYEES 
WHERE commission_pct IS NULL AND (last_name LIKE '%k%' OR last_name LIKE '%K%');

