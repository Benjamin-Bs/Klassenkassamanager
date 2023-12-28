CREATE TABLE WebUser (
    userName VARCHAR PRIMARY KEY
);

CREATE TABLE Class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ownerName VARCHAR,
    department VARCHAR,
    dateOfFounding DATE,
    FOREIGN KEY (ownerName) REFERENCES WebUser(userName)
);

CREATE TABLE Student (
    classId INT,
    userName VARCHAR,
    firstname VARCHAR,
    lastname VARCHAR,
    depositAmount FLOAT,
    toPayAmount FLOAT,
    FOREIGN KEY (classId) REFERENCES Class(id),
    FOREIGN KEY (userName) REFERENCES WebUser(userName)
);
