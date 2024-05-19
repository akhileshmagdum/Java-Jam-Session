--Find the 3rd highest salary
SELECT *
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 2;
--Using sub-query (No need)
SELECT *
FROM employee
WHERE salary = (SELECT salary
                FROM employee
                ORDER BY salary DESC
                LIMIT 1 OFFSET 2);

--Find duplicate rows in a table
SELECT salary, COUNT(salary)
FROM employee
GROUP BY salary
HAVING COUNT(salary) > 1;

--List of employee's working in the same department
SELECT distinct (e1.first_name), e1.dept_id
FROM employee e1,
     employee e2
WHERE e1.dept_id != e2.dept_id
  and e1.id != e2.id;

--Department-Wise highest salary and employees in each department
SELECT d.name, MAX(e.salary) as max_salary, COUNT(e.id)
FROM employee e
         JOIN department d on d.id = e.dept_id
GROUP BY d.name;