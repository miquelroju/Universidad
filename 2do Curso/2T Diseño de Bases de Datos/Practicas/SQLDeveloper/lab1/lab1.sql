-- Ex 1

SELECT first_name, last_name, salary
FROM employees
WHERE last_name LIKE '%a%' AND salary > 10000 AND salary < 20000 AND commission_pct IS NOT NULL;


-- Ex 10 ver. USING

SELECT city, department_name, location_id, department_id
FROM EMPRESA.locations INNER JOIN EMPRESA.departments USING(location_id)
WHERE location_id = location_id AND UPPER(city) = 'SEATTLE';

-- Ex 10 ver. ON

SELECT l.city, d.department_name, l.location_id, d.department_id
FROM EMPRESA.locations l JOIN EMPRESA.departments d ON(l.location_id = d.location_id)
WHERE UPPER(city) = 'SEATTLE';

-- Ex 10 ver. classic

SELECT l.city, d.department_name, l.location_id, d.department_id
FROM EMPRESA.locations l, EMPRESA.departments d
WHERE l.location_id = d.location_id AND UPPER(city) = 'SEATTLE';

-- Ex 10 ver. NATURAL

SELECT e.first_name, e.last_name, d.department_name
FROM EMPRESA.employees e LEFT OUTER JOIN EMPRESA.departments d
ON (e.department_id = d.department_id);

-- Ex 13 i 14 no hauriem de saber fer-ho en principi

