package com.niawetu;

import org.sql2o.Connection;

public abstract class Animal {
    public String name;
    public int id;
    public boolean  endangered;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,endangered) VALUES (:name,:endangered)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter( "endangered",this.endangered)
                    .executeUpdate()
                    .getKey();
        }
    }

}