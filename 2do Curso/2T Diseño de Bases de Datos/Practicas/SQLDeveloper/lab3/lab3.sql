/* Ex 1 */

/* ver. NATURAL JOIN */

SELECT city, department_name, location_id, department_id
FROM departments NATURAL JOIN locations
WHERE department_id IN (10, 20, 30) AND city = 'Seattle';

/* ver. USING */

SELECT city, department_name, location_id, department_id
FROM departments JOIN locations USING (location_id)
WHERE department_id IN (10, 20, 30) AND city = 'Seattle';

/* ver. ON */

SELECT l.city, d.department_name, l.location_id, d.department_id
FROM departments d JOIN locations l
ON (d.location_id = l.location_id)
WHERE d.department_id IN (10,20,30) AND l.city = 'Seattle';

/* ver. classic */

SELECT l.city, d.department_name, l.location_id, d.department_id
FROM departments d, locations l
WHERE d.location_id = l.location_id AND department_id IN (10, 20, 30) AND city = 'Seattle';

/* Ex 2 */

/* SQL99 JOIN */

SELECT e.first_name, e.last_name, d.department_id
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id;

/* ver. classic SQL */

SELECT e.first_name, e.last_name, d.department_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

/* Ex 3 */

<<<<<<< HEAD
SELECT e.LAST_NAME, m.LAST_NAME
FROM employees e LEFT OUTER JOIN employees m
ON e.employee_id = m.manager_id;

/* Ex 4 */

SELECT LPAD (last_name, LENGTH(last_name) + 2 * LEVEL - 2, '-') "empleat"
FROM employees
STARTS WITH manager_id IS NULL
CONNECT BY PRIOR employee_id = manager_id;

/* Ex 5 */

SELECT LPAD (last_name, LENGTH(last_name) + 2 * LEVEL - 2, '-' employees)
FROM employees WHERE last_name != 'De Haan'
STARTS WITH manager_id IS NULL
CONNECT BY PRIOR employee_id = manager_id;

/* Ex 6 */

SELECT COUNT(*), COUNT(DISTINCT manager_id)
FROM employees;

/* Ex 7 */

SELECT TO_CHAR(hire_date, 'day'), COUNT(*)
FROM employees
GROUP BY TO_CHAR(hire_date, 'day')
HAVING COUNT(*) >= 3;

/* Ex 8 */

SELECT department_id, job_id, ROUND(AVG(salary),2) AS sou_mig
FROM employees
GROUP BY CUBE(department_id, job_id);

/* Ex 9 */

SELECT city, department_name, job_id, SUM(salary) as massa_salarial
FROM employees
JOIN departments ON employees.DEPARTMENT_ID = departments.DEPARTMENT_ID
WHERE employees.DEPARTMENT_ID > 80
GROUP BY CUBE(city, department_name, job_id);

/* Ex 10 */

SELECT MAX(salary), MIN(salary)
FROM employees
GROUP BY GROUPING SETS ((department_id, job_id), (job_id, manager_id));

/* Ex 11 */

SELECT manager_id, job_id, SUM(salary)
FROM employees
GROUP BY ROLLUP(manager_id, job_id);

/* Ex 12 */

SELECT department_id, job_id, manager_id
FROM employees
GROUP BY SETS((department_id, manager_id, job_id),(department_id, manager_id));

/* Ex 17 */

SELECT employee_id, first_name, last_name
FROM employees
WHERE employee_id NOT IN (SELECT DISTINCT employee_id 
                          FROM job_history);

/* Ex 18 */

SELECT employee_id, last_name, hire_date, salary
FROM EMPLOYEES
WHERE manager_id IN (SELECT employee_id
                     FROM employees
                     WHERE last_name = 'De Haan');

=======
/* NO SE */

/* Ex 4 */

/* Ex 5 */



/* Ex 6 */



/* Ex 7 */

/* Ex 8 */

/* Ex 9 */

/* Ex 10 */

/* Ex 11 */

/* Ex 12 */

/* Ex 13 */

/* Ex 14 */

/* Ex 15 */

/* Ex 16 */

/* Ex 17 */

/* Ex 18 */

>>>>>>> 5abf7bf3a1c8a05b864cd72daea3fca029450ea7
/* Ex 19 */

/* Ex 20 */

<<<<<<< HEAD
SELECT *
FROM employees
WHERE salary > ALL (SELECT salary
                    FROM employees
                    WHERE job_id = )

/* Ex 21 */

SELECT employee_id, last_name, salary
FROM employees
WHERE salary < (SELECT AVG(salary)
                FROM employees i);

SELECT TO_CHAR(hire_date, 'month'), COUNT(*)
FROM employees
GROUP BY TO_CHAR(hire_date, 'month');

SELECT employee_id
FROM employees
WHERE manager_id IS NULL;

SELECT department_id
FROM departments
WHERE location_id = (SELECT location_id
                                       FROM locations
                                       WHERE city = 'Seattle');

SELECT AVG(salary)
FROM employees
GROUP BY SETS(
    (department_id), 
    (department_id, manager_id), 
    (department_id, job_id)
);
=======
/* Ex 21 */

/* Ex 22 */

/* Ex 23 */




>>>>>>> 5abf7bf3a1c8a05b864cd72daea3fca029450ea7
