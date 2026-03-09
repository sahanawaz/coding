CREATE TABLE employee (
    id SMALLINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    code VARCHAR(50) NOT NULL UNIQUE,
    salary NUMERIC(12,2) NOT NULL CHECK (salary > 0),
    department_id SMALLINT NOT NULL,
    stamptime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    stampuser SMALLINT
);

CREATE TABLE department (
    id SMALLINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    stamptime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    stampuser SMALLINT 
);

ALTER TABLE employee
ADD CONSTRAINT fk_employee_department
FOREIGN KEY (department_id)
REFERENCES department(id)
ON DELETE SET NULL;


INSERT INTO department (name, code, stampuser) VALUES
('Human Resources', 'HR', 1),
('Engineering',     'ENG', 1),
('Finance',         'FIN', 1),
('Sales',           'SAL', 1),
('Marketing',       'MKT', 1)
RETURNING id;

TRUNCATE TABLE employee RESTART IDENTITY;

-- Employees (15) — department_id is resolved by department.code
INSERT INTO employee (name, email, code, salary, department_id, stampuser) VALUES
('Aarav Sharma',     'aarav.sharma@example.com',     'E001',  850000.00,
    (SELECT id FROM department WHERE code = 'ENG'),  1),
('Isha Kapoor',      'isha.kapoor@yahoo.com',      'E002',  520000.00,
    (SELECT id FROM department WHERE code = 'HR'),   1),
('Rohan Verma',      'rohan.verma@outlook.com',      'E003',  910000.00,
    (SELECT id FROM department WHERE code = 'ENG'),  1),
('Sneha Rao',        'sneha.rao@outlook.com',        'E004',  600000.00,
    (SELECT id FROM department WHERE code = 'MKT'),  1),
('Vikram Iyer',      'vikram.iyer@outlook.com',      'E005',  730000.00,
    (SELECT id FROM department WHERE code = 'FIN'),  1),
('Neha Kulkarni',    'neha.kulkarni@yahoo.com',    'E006',  650000.00,
    (SELECT id FROM department WHERE code = 'SAL'),  1),
('Arjun Mehta',      'arjun.mehta@yahoo.com',      'E007',  880000.00,
    (SELECT id FROM department WHERE code = 'ENG'),  1),
('Priya Nair',       'priya.nair@rediffmail.com',       'E008',  620000.00,
    (SELECT id FROM department WHERE code = 'MKT'),  1),
('Karan Malhotra',   'karan.malhotra@rediffmail.com',   'E009',  790000.00,
    (SELECT id FROM department WHERE code = 'FIN'),  1),
('Ananya Gupta',     'ananya.gupta@rediffmail.com',     'E010',  540000.00,
    (SELECT id FROM department WHERE code = 'HR'),   1),
('Rahul Singh',      'rahul.singh@gmail.com',      'E011',  940000.00,
    (SELECT id FROM department WHERE code = 'ENG'),  1),
('Meera Joshi',      'meera.joshi@gmail.com',      'E012',  610000.00,
    (SELECT id FROM department WHERE code = 'SAL'),  1),
('Dev Patel',        'dev.patel@gmail.com',        'E013', 1000000.00,
    (SELECT id FROM department WHERE code = 'ENG'),  1),
('Ritika Desai',     'ritika.desai@example.com',     'E014',  580000.00,
    (SELECT id FROM department WHERE code = 'MKT'),  1),
('Siddharth Rao',    'siddharth.rao@hotmail.com',    'E015',  720000.00,
    (SELECT id FROM department WHERE code = 'FIN'),  1)
RETURNING id;


SELECT * FROM employee

