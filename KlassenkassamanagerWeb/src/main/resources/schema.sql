CREATE TABLE WebUser (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR UNIQUE,
    password VARCHAR
);

CREATE TABLE Class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ownerName VARCHAR,
    department VARCHAR,
    dateOfFounding DATE,
    FOREIGN KEY (ownerName) REFERENCES WebUser(userName)
);

CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    classId INT,
    userName VARCHAR,
    firstname VARCHAR,
    lastname VARCHAR,
    depositAmount FLOAT,
    toPayAmount FLOAT,
    FOREIGN KEY (classId) REFERENCES Class(id),
    FOREIGN KEY (userName) REFERENCES WebUser(userName)
);
