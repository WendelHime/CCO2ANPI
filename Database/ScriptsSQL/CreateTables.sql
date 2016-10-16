CREATE TABLE USERS
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	username VARCHAR(200),
	password VARCHAR(44),
	salt VARCHAR(12),
	name VARCHAR(2000),
	cpf VARCHAR(14),
	office_hours VARCHAR(200),
	type INTEGER
);

CREATE TABLE ACCESS
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	user_id INTEGER NOT NULL,
	date_in BIGINT, 
	date_out BIGINT,
	FOREIGN KEY (user_id) REFERENCES USERS(id)
);

CREATE TABLE EMPLOYERS
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	user_id INTEGER NOT NULL,
	access_hour VARCHAR(200),
	permission_temperature TINYINT(1),
	FOREIGN KEY (user_id) REFERENCES USERS(id)
);

CREATE TABLE BUILDING_SETS
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	number VARCHAR(6)
);

CREATE TABLE COMPANIES
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	building_complex_id INTEGER NOT NULL,
	cnpj VARCHAR(40),
	social_reason VARCHAR(2000),
	business_hours VARCHAR(200),
	maximum_temperature DECIMAL(2,2),
	airconditioner_hours VARCHAR(200),
	horario_funcionamento_ar_condicionado INTEGER,
	FOREIGN KEY (building_complex_id) REFERENCES BUILDING_SETS(id)
);

CREATE TABLE EMPLOYERS_COMPANIES
(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	company_id INTEGER NOT NULL,
	employer_id INTEGER NOT NULL,
	FOREIGN KEY (company_id) REFERENCES COMPANIES(id),
	FOREIGN KEY (employer_id) REFERENCES EMPLOYERS(id)
);
