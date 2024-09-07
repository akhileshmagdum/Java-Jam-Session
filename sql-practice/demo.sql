--Window Aggregation
--Rank employee's with their salary department wise
SELECT e.first_name,
       d.name,
       e.salary,
       RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS top_by_dept
FROM employee e
         JOIN department d on d.id = e.dept_id;

--GROUP BY
--Get Department wise average salary
SELECT d.name, avg(e.salary)
FROM employee e
         JOIN department d on d.id = e.dept_id
GROUP BY d.id;

--HAVING
--Get list of employee's having total tasks which require more than 20 days of time
SELECT e.first_name,
       SUM(t.time_req)
FROM employee e
         JOIN tasks t on e.id = t.emp_id
GROUP BY e.id
HAVING SUM(t.time_req) > 20;


--LIMIT
--Get list of top 2 employee's with highest salary
SELECT e.first_name, e.salary
FROM employee e
ORDER BY salary DESC
LIMIT 2;

--OFFSET
--Get list of 2nd top and 3rd top employee in terms of salary
SELECT e.first_name, e.salary
FROM employee e
ORDER BY salary DESC
LIMIT 2 OFFSET 1;

--FETCH
SELECT e.first_name, e.salary
FROM employee e
ORDER BY salary DESC
OFFSET 1 FETCH NEXT 2 ROWS ONLY;
