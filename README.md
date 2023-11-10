# Douglas WildLife Tracker Application
## Author
Hellen Omwono
## Description
An application that allows Rangers to track wild animals sighted in Douglas Wildlife Forest to enable an environmental impact study that will help assess a proposal to clearcut timber in the forest. 
## Setup Instructions and Installation
- Clone the repository https://github.com/omwano/JavaSparkWeek3.git to your local machine
- Open the project using Intellij or any other suitable editor
- Run gradle on the terminal
- Open localhost:4567
- To create the databases, launch postgres and psql
- Run the following commands:
  - CREATE DATABASE wildlife_tracker;
  - \c wildlife_tracker;
  - CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
  - CREATE TABLE endangered_animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
  - CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, date TIMESTAMP);
  - CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;


## Technologies Used
- Java
- Handlebar
- Spark
## License
Copyright (c) 2023 omwano
