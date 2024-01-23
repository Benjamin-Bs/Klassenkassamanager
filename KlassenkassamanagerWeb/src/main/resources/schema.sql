CREATE TABLE WebUser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR UNIQUE,
    password VARCHAR
);

CREATE TABLE Class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ownerId INT,
    department VARCHAR,
    dateOfFounding DATE,
    FOREIGN KEY (ownerId) REFERENCES WebUser(id)
);

CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    classId INT,
    userId INT,
    firstname VARCHAR,
    lastname VARCHAR,
    depositAmount FLOAT,
    toPayAmount FLOAT,
    FOREIGN KEY (classId) REFERENCES Class(id),
    FOREIGN KEY (userId) REFERENCES WebUser(id)
);
