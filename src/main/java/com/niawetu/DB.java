package com.niawetu;

import org.sql2o.Sql2o;

import java.net.URI;

public class DB {
    private static URI dbUri;


    static String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
    static Sql2o sql2o = new Sql2o(connectionString, "postgres", "");
}

