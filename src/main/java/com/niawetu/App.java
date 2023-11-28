package com.niawetu;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        staticFileLocation("/public");

        //welcome page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //animal form
        get("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //new animal display and save in db
        post("/new-animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name=request.queryParams("animal_name");
            boolean endangered = request.queryParams("endangered") != null;
            if(endangered) {
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
                endangeredAnimal.save();
                model.put("name", name);
                model.put("health",health);
                model.put("age",age);
            }
            else {
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name,null,null);
                endangeredAnimal.save();
                model.put("name", name);
            }
            return new ModelAndView(model, "new-animal.hbs");
        }, new HandlebarsTemplateEngine());


        // list all animals
        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> endangeredAnimals = EndangeredAnimal.all();
            model.put("animals", endangeredAnimals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //sighting form
        get("/new-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        //new sighting display and save in db
        post("/new-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String animalName=request.queryParams("animalName");
            String sightLocation=request.queryParams("sightLocation");
            String ranger=request.queryParams("ranger");
            Sight newSight= new Sight(animalName,sightLocation,ranger);
            newSight.save();
            model.put("animalName",newSight.getAnimalName());
            model.put("sightLocation",newSight.getSightLocation());
            model.put("ranger",newSight.getRanger());
            model.put("Sight",newSight);
            return new ModelAndView(model, "new-sighting.hbs");
        }, new HandlebarsTemplateEngine());

        // list all sightings
        get("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sight> sight = Sight.all();
            model.put("sight", sight);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

    }
}