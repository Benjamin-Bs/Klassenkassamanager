INSERT INTO WebUser(userName, password) VALUES ('Default', 'Default');
INSERT INTO WebUser(userName, password) VALUES ('Bob', '123');
INSERT INTO WebUser(userName, password) VALUES ('Puzzles', 'password');
INSERT INTO WebUser(userName, password) VALUES ('Dave', 'abc');
INSERT INTO WebUser(userName, password) VALUES ('Tom', '111');
INSERT INTO WebUser(userName, password) VALUES ('Alice', 'a1b2c3');
INSERT INTO WebUser(userName, password) VALUES ('Charlie', 'pass123');
INSERT INTO WebUser(userName, password) VALUES ('Eva', 'evaPassword');
INSERT INTO WebUser(userName, password) VALUES ('John', 'johnDoe123');
INSERT INTO WebUser(userName, password) VALUES ('Lisa', 'lisaPass');
INSERT INTO WebUser(userName, password) VALUES ('Mike', 'mike123');

INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (1, 'IT', '2022-9-1');
INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (4, 'EL', '2022-9-1');
INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (3, 'CS', '2022-9-1');
INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (2, 'Math', '2022-9-1');
INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (5, 'Physics', '2022-9-1');
INSERT INTO Class(ownerId, department, dateOfFounding) VALUES (2, 'Chemistry', '2022-9-1');

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 1, 'Bob', 'Bobleau', 22.5, 10.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 2, 'Puzzles', '00Z', 50.5, 40.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 3, 'Benjamin', 'BS', 32.5, 14.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (1, 4, 'Tom', 'Turbo', 22.8, 30.5);

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (2, 4, 'Tom', 'Turbo', 2.8, 302.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (2, 5, 'Alice', 'Anderson', 15.2, 25.7);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (2, 6, 'Charlie', 'Chaplin', 12.0, 18.5);

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (3, 3, 'Charlie', 'Chaplin', 10.0, 20.0);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (3, 1, 'Bob', 'Barker', 18.7, 15.3);

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (4, 2, 'Puzzles', '00Z', 8.5, 22.0);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (4, 4, 'Tom', 'Turbo', 2.8, 302.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (4, 5, 'Alice', 'Anderson', 20.0, 30.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (4, 6, 'Charlie', 'Chaplin', 15.5, 12.8);

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (5, 7, 'Eva', 'Evans', 18.0, 25.0);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (5, 4, 'Tom', 'Turbo', 2.8, 302.5);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (5, 8, 'John', 'Johnson', 15.5, 30.0);

INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (6, 9, 'Lisa', 'Lisbon', 10.0, 18.0);
INSERT INTO Student(classId, userId, firstname, lastname, depositAmount, toPayAmount) VALUES (6, 10, 'Mike', 'Mikelson', 12.5, 22.5);
