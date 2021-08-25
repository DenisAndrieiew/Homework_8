CREATE DATABASE "ProductManagement" WITH OWNER Postgres;

CREATE TABLE roles(
	identifier uuid PRIMARY KEY,
	role varchar (100) not null UNIQUE);

CREATE TABLE users (
	identifier uuid PRIMARY KEY,
	email varchar (200)  NOT NULL UNIQUE,
	firstname varchar(250) NOT NULL,
	lastname varchar (250) NOT NULL,
	password varchar NOT NULL,
	role_id uuid,
	CONSTRAINT fk_roles
		FOREIGN KEY(role_id)
			REFERENCES roles(identifier));

	CREATE TABLE manufacturers (
	identifier uuid PRIMARY KEY,
	manufacturer_name varchar(250) NOT NULL UNIQUE);

CREATE TABLE products (
	identifier uuid PRIMARY KEY,
	product_name varchar (250) NOT NULL UNIQUE,
	product_cost NUMERIC(20, 10),
	manufacturer_id uuid,
	CONSTRAINT fk_manufacturers
		FOREIGN KEY(manufacturer_id)
			REFERENCES manufacturers(identifier));
