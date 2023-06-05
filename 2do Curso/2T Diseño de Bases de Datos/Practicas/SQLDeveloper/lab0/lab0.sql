-- Ex 1

SELECT employee_id, first_name, last_name, email, phone_number, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'yyyy') = '1998' AND job_id = 'ST_CLERK';

-- Ex 2

SELECT (365 * 24 * 60 * 60) as "segons en un any"
FROM DUAL;

-- Ex 3

SELECT last_name, job_id, salary, commission_pct
FROM EMPRESA.employees
WHERE commission_pct IS NOT NULL
ORDER BY 3 desc;

-- Ex 4

SELECT 'The salary of ' || last_name || ' after a 10% raise is ' || round(salary*1.1) as "New salary"
FROM EMPRESA.employees
WHERE commission_pct IS NULL;

-- Ex 5

SELECT last_name, trunc(months_between(sysdate, hire_date)/12) years, trunc(mod(months_between(sysdate, hire_date), 12)) months
FROM EMPRESA.employees
ORDER BY 1, 2;

-- Ex 6

SELECT last_name
FROM EMPRESA.employees
WHERE substr(last_name, 0, 1) IN ('J', 'K', 'L', 'M');

-- Ex 7

SELECT last_name, salary, DECODE (commission_pct, NULL, 'NO', 'YES') comissio
FROM EMPRESA.employees;

-- Ex 7 Alter

SELECT last_name, salary, CASE WHEN commission_pct = NULL THEN 'NO' WHEN commission_pct != NULL THEN 'YES' END as "Comissio"
FROM EMPRESA.employees;

-- Ex 8

SELECT COUNT(*)
FROM EMPRESA.employees
WHERE last_name LIKE '%n'; 

-- Ex 8 Alter

SELECT COUNT(*)
FROM EMPRESA.employees
WHERE substr(UPPER(last_name), -1) = 'N';

-- Ex 9

SELECT DISTINCT job_id
FROM EMPRESA.employees
WHERE department_id = 10 OR department_id = 20;

-- Ex 10

SELECT last_name, hire_date
FROM EMPRESA.employees
WHERE EXTRACT(DAY FROM hire_date) < 16;

-- Ex 10 Alter

SELECT last_name, hire_date
FROM EMPRESA.employees
WHERE TO_CHAR(hire_date, 'dd') < 16;

-- Ex 11

SELECT last_name, salary, TRUNC(salary/1000) as "THOUSANDS"
FROM EMPRESA.employees;

-- Ex 12

SELECT last_name, TO_CHAR(hire_date, 'month') || ' ' || TO_CHAR(hire_date, 'dd') as "BIRTHDAY"    
FROM EMPRESA.employees
ORDER BY TO_CHAR(hire_date, 'ddd') asc;

-- Ex 13

SELECT TO_CHAR(hire_date, 'day') as "data_alta", COUNT(*)
FROM EMPRESA.employees
GROUP BY TO_CHAR(hire_date, 'day')
HAVING COUNT(*) >= 3;

-- Ex 14

SELECT TO_CHAR(end_date, 'yyyy') AS "Any_fi", job_id, COUNT(*) AS "Num_empleats"
FROM EMPRESA.job_history
GROUP BY TO_CHAR(end_date, 'yyyy'), job_id
ORDER BY COUNT(*) desc;

-- Ex 14 Alter de l'Alfons

SELECT SUM(salary) / COUNT(salary)
FROM EMPRESA.employees;

-- Ex 14 Alter 2 de l'Alfons

SELECT AVG (salary)
FROM EMPRESA.employees;

-- Ex 15

SELECT department_id, job_id, sum(commission_pct)
FROM EMPRESA.employees
WHERE commission_pct IS NOT NULL
GROUP BY department_id, job_id;

