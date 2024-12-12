CREATE TABLE person(
    id int AUTO_INCREMENT PRIMARY KEY,
    username varchar(100) NOT NULL,
    year_of_birth int NOT NULL,
    password varchar(100) NOT NULL,
    role varchar(100) NOT NULL DEFAULT 'ROLE_USER'
);
-- UPDATE person SET role='ROLE_ADMIN' WHERE username='admin';