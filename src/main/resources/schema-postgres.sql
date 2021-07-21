CREATE USER mms-postgres;
CREATE DATABASE mms_db;
GRANT ALL PRIVILEGES ON DATABASE mms_db TO mms-postgres;

DROP TABLE IF EXISTS mms_user;

CREATE TABLE IF NOT EXISTS mms_user(
	id serial PRIMARY KEY, 
	username VARCHAR(255) UNIQUE NOT NULL, 
	password VARCHAR(255) NOT NULL,
	email_address VARCHAR(255) UNIQUE NOT NULL,
	verification_token VARCHAR(255),
	verified BOOLEAN,
	created_ts TIMESTAMP WITH TIME ZONE,
	updated_ts TIMESTAMP WITH TIME ZONE
	
);

INSERT INTO mms_user(username, password, email_address) VALUES('bratislava', '432000xyzx', 'bratislava@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('budapest', '1759000xyz', 'budapest@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('prague', '128000xyz0', 'prague@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('warsaw', '1748000xyz', 'warsaw@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('losangeles', '3971000xyz', 'la@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('newyork', '855000xyz0', 'ny@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('edinburgh', '464000xyz', 'edinburgh@europe.eu');
INSERT INTO mms_user(username, password, email_address) VALUES('berlin', '671000xyz', 'berlin@europe.eu');

DROP TABLE IF EXISTS organizations;
CREATE TABLE organizations (
	id serial PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	ph_number VARCHAR(255) NOT NULL,
	description VARCHAR(1000) NOT NULL,
	created_ts TIMESTAMP WITH TIME ZONE,
	updated_ts TIMESTAMP WITH TIME ZONE
);