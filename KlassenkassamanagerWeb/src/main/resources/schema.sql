CREATE TABLE Class (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       department VARCHAR,
                       schoolLevel INT
);

CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR,
    lastname VARCHAR,
    depositAmount FLOAT,
    toPayAmount FLOAT,
    classId INT,
    FOREIGN KEY (classId) REFERENCES Class(id)
);

