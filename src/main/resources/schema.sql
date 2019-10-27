DROP TABLE animal; 
DROP TABLE sex; 

CREATE TABLE sex
(sexid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
,gender VARCHAR(50) NOT NULL);

CREATE TABLE animal (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
species VARCHAR(50) NOT NULL,
sexid BIGINT,
weight FLOAT);

INSERT INTO sex (gender) VALUES ('Naaras'), ('Uros'), ('Tuntematon');

INSERT INTO animal (name, species, sexid, weight) 
VALUES ('Bob', 'Ilves', 2, 20.5), 
('Liz','Salamanteri', 1, 0.1), 
('Ted','Karhu', 3, 3);

SELECT * FROM animal;
SELECT * FROM sex;

