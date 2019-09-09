
import models.Hero;
import org.sql2o.Sql2o;
import spark.Spark;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
//        String connectionString = "jdbc:h2:~/herosquad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

        //get to show new hero form
        get("/heros/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"hero-form.hbs");

        },new HandlebarsTemplateEngine());


        //task: process new hero form
        post ("/heros/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power= request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,age,power,weakness);
            model.put("hero",newIdentity);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());


        //get to show all heros
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAll();
            model.put("heros",heros);
            return new ModelAndView(model,"index.hbs");

        }, new HandlebarsTemplateEngine());

        //show an individual hero
        get("/heros/:id",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("id"));
            Hero foundHero= Hero.findById(idOfHeroToFind);
            model.put("hero",foundHero);
            return new ModelAndView(model,"hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get show a form to update hero
        get("/heros/:id/update",(request, response) -> {
            Map <String,Object>model = new HashMap<>();
            int idOfTaskToEdit =Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfTaskToEdit);
            model.put("editHero",editHero);
            return new ModelAndView(model,"hero-form.hbs");

        },new HandlebarsTemplateEngine());

        //task:process a form to update a hero
        post("heros/:id/update",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String newName = request.queryParams("name");
            int newAge =Integer.parseInt(request.queryParams("100"));
            String newPower = request.queryParams("power");
            String newWeakness = request.queryParams("weakness");
            int idOfTheHeroToEdit =Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfTheHeroToEdit);
            editHero.update(newName,newAge,newPower,newWeakness);

            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        //get : delete all heros
        get ("/heros/delete",(request, response) -> {
            Map<String,Object> model= new HashMap<>();
            Hero.clearAllHeros();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual hero
        get("/heros/:id/delete" ,(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));
            Hero deleteHero = Hero.findById(idOfHeroToDelete);
            deleteHero.deleteById(idOfHeroToDelete);

            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        //get to show new hero form
        get("/squads/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squad-form.hbs");

        },new HandlebarsTemplateEngine());









    }
}
