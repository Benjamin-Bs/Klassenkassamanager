CREATE TABLE Class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    department VARCHAR,
    dateOfFounding DATE
);

CREATE TABLE WebUser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR
);

CREATE TABLE Student (
    classId INT,
    userId INT,
    firstname VARCHAR,
    lastname VARCHAR,
    depositAmount FLOAT,
    toPayAmount FLOAT,
    FOREIGN KEY (classId) REFERENCES Class(id),
    FOREIGN KEY (userId) REFERENCES WebUser(id)
);
