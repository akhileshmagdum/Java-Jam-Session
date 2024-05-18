--Window Aggregation
--Rank employee's with their salary department wise
SELECT e.first_name,
       d.name,
       e.salary,
       RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS top_by_dept
FROM employee e
         JOIN department d on d.id = e.dept_id;
