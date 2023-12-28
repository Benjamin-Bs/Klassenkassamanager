INSERT INTO Class (department, dateOfFounding) VALUES ('IT','2022-9-1');
INSERT INTO Class (department, dateOfFounding) VALUES ('EL','2022-9-1');

INSERT INTO WebUser(userName) VALUES ('Bob');
INSERT INTO WebUser(userName) VALUES ('Puzzles');
INSERT INTO WebUser(userName) VALUES ('Dave');
INSERT INTO WebUser(userName) VALUES ('Tom');

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 1, 'Bob', 'Bobleau', 22.5, 10.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 2, 'Puzzles', '00Z', 50.5, 40.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 3, 'Benjamin', 'BS', 32.5, 14.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 4, 'Tom', 'Turbo', 22.8, 30.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (2, 4, 'Tom', 'Turbo', 22.8, 30.5);
