import dao.Sql2oHeroDao;
import models.Hero;
import org.sql2o.Sql2o;
import spark.Spark;
import spark.ModelAndView;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao taskDao = new Sql2oHeroDao(sql2o);
        get("/hello", (request, response) -> "Hello Friend!");
    }
}
