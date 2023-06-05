--select employee_id || last_name "Informacio empleats", first_name, department_id
--from empresa.employees
--where last_name like 'H%'
--order by department_id; -- També es pot escriure 3 i aquest 3 significaria que agafes la columna 3 i s'ordena per la 3ª columna (la columna department_id)
                        -- Es pot escriure al final desc perquè sigui ordenació descendent
                        
--order by "Informacio empleats" asc, 2;

-- Ex 1

--desc empresa.departments;
--desc empresa.employees;

-- Ex 2

-- pestanya constraints

-- Ex 3

--select last_name, employee_id, job_id, hire_date as "STARTDATE"
--from empresa.employees
--order by 2;

-- Ex 4



-- Ex 5

--select DISTINCT job_id
--from empresa.employees
--order by 1 asc;

-- Ex 6

--select last_name || ', ' || job_id as "Employee and Title"
--from empresa.employees
--order by 1 asc;

-- Ex 7



-- Ex 8

--select last_name, salary
--from empresa.employees
--where salary > 12000
--order by 2 desc;

-- Ex 9

--select last_name, department_id
--from empresa.employees
--where employee_id = 176;

-- Ex 10

--select last_name, salary
--from empresa.employees
-- where salary < 5000 or salary > 12000 -- UNA FORMA DE FER-HO (NO LA DE LA PROFESSORA)
--where salary not between 5000 and 12000

-- Ex 11

--select last_name, job_id, hire_date
--from empresa.employees
--where last_name in ('Matos', 'Taylor')
--order by 3 asc;

-- Ex 12

--select last_name, department_id
--from empresa.employees
--where department_id in (20,50)
--order by last_name asc;

-- Ex 13

--select last_name as "Employee", salary as "Monthly Salary"
--from empresa.employees
--where (salary between 5000 and 12000) and (department_id in(20,50))

-- Ex 14

--select last_name, hire_date
--from empresa.employees
--where hire_date like '%94';

-- Ex 15

--select last_name, job_id
--from empresa.employees
--where manager_id is null;

-- Ex 16

--select last_name, salary, commission_pct
--from empresa.employees
--where commission_pct is not null;

-- Ex 17

--select last_name
--from empresa.employees
--where last_name like '__a%'

-- Ex 18

--select last_name
--from empresa.employees
--where last_name like '%a%' and last_name like '%e%'

-- Ex 19

--select last_name, job_id, salary
--from empresa.employees
--where (job_id in ("SA_REP", "ST_CLERK")) and (salary in (2500, 3500, 7000))

-- Ex 20



-- Ex 21

--select sysdate, to_char (sysdate, 'DD/MM/YYYY HH:MM:SS') as "Data i Hora"
--from dual;

-- Ex 22

--select last_name, to_char(hire_date, 'DD/MM/YY HH:MM:SS') as "Data i Hora Contractació"
--from empresa.employees
--order by 1 asc;

-- Ex 23

--select employee_id, last_name, salary, round(salary*1.155) as "Nou sou"
--from empresa.employees
--order by 1;

-- Classe Joins 13/06

--select e.last_name, e.salary, j.grade_level
--from empresa.employees e JOIN empresa.job_grades j ON
--    e.salary between j.lowest_sal and j.highest_sal;

-- Ex 51

--select e.last_name "Cognom", e.job_id "Treball", e.salary "Sou", d.department_name "Departament"
--from empresa.employees e JOIN empresa.departments d ON (e.department_id = d.department_id)
--    JOIN empresa.locations l ON (d.location_id = l.location_id)
--WHERE lower(l.city) = 'toronto';

-- Ex 53

--select e.job_id "Codi empleat", e.last_name "Cognom empleat", m.manager_id "Codi jefe", m.last_name "Cognom jefe"
--from empresa.employees e JOIN empresa.employees m ON (e.manager_id = m.employee_id)
--order by 4;

-- Ex 54

--select e.job_id "Codi empleat", e.last_name "Cognom empleat", m.manager_id "Codi jefe", m.last_name "Cognom jefe"
--from empresa.employees e LEFT OUTER JOIN empresa.employees m ON (e.manager_id = m.employee_id)
--order by 4;

-- Ex 55

--select employee_id, count(*)
--from empresa.job_history
--group by employee_id
--having count(*) = (select max(count(*)) from empresa.job_history group by employee_id);

-- Exercici classe fitxa abans examens

-- ex 25

select a.nom
from comptabilitat.pobles a JOIN comptabilitat.provincies b ON (a.codpro = b.codpro)
where lower(b.nom) = 'barcelona'
order by 1;

-- alternativa

select *
from comptabilitat.pobles
where codpro = (
                select codpro
                from comptabilitat.provincies
                where lower(nom)='barcelona'
                )
order by 1;

-- ex 24

select c.codpo, p.nom
from comptabilitat.pobles p JOIN comptabilitat.clients c ON (p.codpo = c.codpo)
order by 1;

-- ex 23

select codart, descrip, preu
from comptabilitat.articles
where preu > (select avg(preu) from comptabilitat.articles)
order by 1;

-- ex 22

select f.codven, v.nom, count(*)
from comptabilitat.factures f JOIN comptabilitat.venedors v on (f.codven = v.codven)
group by f.codven, v.nom
having count(*) = (select max(count(*)) from comptabilitat.factures group by codven);

-- ex 21

select l.codfac, l.preu
from comptabilitat.linies_fac l
where l.preu = (select min(preu) from comptabilitat.articles)
order by 1;

-- ex 19

select p.nom, count(*)
from comptabilitat.provincies p JOIN comptabilitat.pobles o ON (p.codpro = o.codpro)
                                JOIN comptabilitat.clients c ON (c.codpo = o.codpo)
group by p.nom
having count(*) > 5
order by 2;

-- ex 17

select c.codcli, c.nom, count(*), count(codfac)
from comptabilitat.clients c LEFT OUTER JOIN comptabilitat.factures f ON (c.codcli = f.codcli)
group by c.codcli, c.nom
order by 4;