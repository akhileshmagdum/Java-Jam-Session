DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE IF NOT EXISTS department
(
    id   INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO public.department (id, name)
VALUES (1, 'Engineering');
INSERT INTO public.department (id, name)
VALUES (2, 'Marketing');

CREATE TABLE IF NOT EXISTS employee
(
    id         INTEGER NOT NULL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    dept_id    INTEGER
        CONSTRAINT fk_dept_id
            REFERENCES department (id),
    salary     NUMERIC(10, 2)
);

INSERT INTO public.employee (id, first_name, last_name, dept_id, salary)
VALUES (2, 'Jane', 'Smith', 2, 55000.00);
INSERT INTO public.employee (id, first_name, last_name, dept_id, salary)
VALUES (3, 'Michael', 'Johnson', 1, 65000.00);
INSERT INTO public.employee (id, first_name, last_name, dept_id, salary)
VALUES (4, 'Emily', 'Davis', 2, 60000.00);
INSERT INTO public.employee (id, first_name, last_name, dept_id, salary)
VALUES (1, 'John', 'Doe', 1, 45000.00),
       (5, 'Akhilesh', 'Magdum', 1, 12300.00),
       (6, 'Swapnil', 'Pathak', 1, 12300.00);

CREATE TABLE IF NOT EXISTS tasks
(
    id       INTEGER NOT NULL PRIMARY KEY,
    name     VARCHAR(50),
    time_req INTEGER,
    emp_id   INTEGER
        CONSTRAINT fk_emp_id
            REFERENCES employee (id)
);

INSERT INTO public.tasks (id, name, time_req, emp_id)
VALUES (5, 'Database Design', 6, 1),
       (6, 'Frontend Development', 7, 2),
       (7, 'Backend Development', 8, 3),
       (8, 'DevOps', 9, 4),
       (9, 'Testing', 4, 1),
       (10, 'Debugging', 2, 2),
       (11, 'Deployment', 5, 3),
       (12, 'Code Review', 3, 4),
       (13, 'Documentation', 4, 1),
       (14, 'Client Meeting', 2, 2),
       (15, 'Project Planning', 6, 3),
       (16, 'Design Review', 3, 4),
       (17, 'Security Audit', 7, 1),
       (18, 'Performance Tuning', 8, 2),
       (19, 'Server Maintenance', 9, 3),
       (20, 'Code Optimization', 5, 4);
