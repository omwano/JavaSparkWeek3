CREATE TABLE animals (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    health VARCHAR(50),
    timestamp TIMESTAMP,
    spotted TIMESTAMP
);

CREATE TABLE sightings (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    health VARCHAR(50),
    timestamp TIMESTAMP,
    spotted TIMESTAMP
);

CREATE TABLE rangers (id SERIAL PRIMARY KEY,
name VARCHAR,
area VARCHAR);
