DROP SEQUENCE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS us_state;
DROP TABLE IF EXISTS us_county;
DROP TABLE IF EXISTS us_city;

CREATE SEQUENCE hibernate_sequence START WITH 1000;

CREATE TABLE us_state (
state_id    INT AUTO_INCREMENT  PRIMARY KEY,
state_code  VARCHAR(2) NOT NULL,
state_name  VARCHAR(250) NOT NULL
);

CREATE UNIQUE INDEX us_state_code_ux ON us_state(state_code);
CREATE UNIQUE INDEX us_state_name_ux ON us_state(state_name);

CREATE TABLE us_county (
county_id    INT AUTO_INCREMENT  PRIMARY KEY,
state_id     int NOT NULL,
county_name  VARCHAR(250) NOT NULL
);

CREATE UNIQUE INDEX us_county_name_ux ON us_county(county_name);

CREATE TABLE us_city (
city_id    INT AUTO_INCREMENT  PRIMARY KEY,
county_id  int not null ,
city_name  VARCHAR(250) NOT NULL
);

CREATE UNIQUE INDEX us_city_name_ux ON us_city(city_name);

INSERT INTO us_state (state_id, state_code, state_name) VALUES
(1, 'CA', 'California'),
(2, 'NV', 'Nevada'),
(3, 'UT', 'Uteh')
;

INSERT INTO us_county (county_id, state_id, county_name) VALUES
(1, 1, 'Santa Clara County'),
(2, 1, 'Marin County')
;

INSERT INTO us_city (city_id, county_id, city_name) VALUES
(1, 1, 'Palo Alto'),
(2, 1, 'Mountain View'),
(3, 1, 'Menlo Park')
;
