CREATE TABLE IF NOT EXISTS USERS (
    id VARCHAR(10) PRIMARY KEY,
    password VARCHAR(10),
    name VARCHAR(10)
);

INSERT INTO USERS (id, password, name) VALUES ('admin', '1234', 'Admin');
INSERT INTO USERS (id, password, name) VALUES ('user1', 'pass2', 'Bob');
INSERT INTO USERS (id, password, name) VALUES ('user2', 'pass3', 'Charlie');