package com.niawetu;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;
import java.util.Objects;

    public class Animals {
        private int id;
        private String name;
        private int rangerId;
        private String age;
        private String location;
        private String health;

        public Animals(String name, int rangerId, String age, String location, String health,){
            this.name = name;
            this.rangerId = rangerId;
            this.age = age;
            this.location = location;
            this.health = health;

        }
        public String getName() {
            return name;
        }
        public String getLocation() {
            return location;
        }

        public int getRangerId() {
            return rangerId;
        }

        public String getHealth() {
            return health;
        }

        public String getAge() {
            return age;
        }

        }
