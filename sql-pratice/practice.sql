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
       SUM(t.time_req) FROM employee e JOIN tasks t on e.id = t.emp_id
GROUP BY e.id HAVING SUM(t.time_req) > 20;
