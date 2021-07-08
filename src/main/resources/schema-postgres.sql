CREATE USER mms-postgres;
CREATE DATABASE mms_db;
GRANT ALL PRIVILEGES ON DATABASE mms_db TO mms-postgres;

DROP TABLE IF EXISTS users;
CREATE TABLE users(id serial PRIMARY KEY, username VARCHAR(255), password VARCHAR(255));
INSERT INTO users(username, password) VALUES('bratislava', '432000xyzx');
INSERT INTO users(username, password) VALUES('budapest', '1759000xyz');
INSERT INTO users(username, password) VALUES('prague', '128000xyz0');
INSERT INTO users(username, password) VALUES('warsaw', '1748000xyz');
INSERT INTO users(username, password) VALUES('losangeles', '3971000xyz');
INSERT INTO users(username, password) VALUES('newyork', '855000xyz0');
INSERT INTO users(username, password) VALUES('edinburgh', '464000xyz');
INSERT INTO users(username, password) VALUES('berlin', '671000xyz');
