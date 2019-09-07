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

        //get:
    }
}
