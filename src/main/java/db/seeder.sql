USE doughnut_counter_db;

INSERT INTO employees (name, username, password)
VALUES ('Nathan', 'nate', '$2a$12$ZR2dUU3UADdIb/PPUkOxn.oNDa2.HAZGhiQG0qETG88xyqmORfvT6');

INSERT INTO types (type)
VALUES ('Glazed'), ('Chocolate'), ('Chocolate Sprinkle'), ('Maple'), ('Old Fashioned'), ('Jelly');

INSERT INTO productions (employee_id, type_id, amount, production_date)
VALUES ('1', '1', 253, '2022-12-12');