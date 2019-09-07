import dao.Sql2oHeroDao;
import models.Hero;
import org.sql2o.Sql2o;
import spark.Spark;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/herosquad.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

        //get : delete all heros
        get ("/heros/delete",(request, response) -> {
            Map<String,Object> model= new HashMap<>();
            heroDao.clearAllHeros();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual list
        get("/heros/:id/delete" ,(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));
            heroDao.deleteById(idOfHeroToDelete);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get to show all heros
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            List<Hero> heros = heroDao.getAll();
            model.put("heros",heros);
            return new ModelAndView(model,"index.hbs");

        }, new HandlebarsTemplateEngine());

        //get to show new hero form
        get("/heros/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"hero-form.hbs");

        },new HandlebarsTemplateEngine());

        //task: process new hero form
        post ("/heros",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
//            Integer age = request.queryParams(100);
            String power= request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,power,weakness);
            heroDao.add(newIdentity);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
