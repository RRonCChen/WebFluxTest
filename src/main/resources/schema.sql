DROP TABLE IF EXISTS PERSON;

CREATE TABLE person(
    id INT AUTO_INCREMENT PRIMARY KEY,
    age INT NOT NULL,
    name VARCHAR(250) NOT NULL
);