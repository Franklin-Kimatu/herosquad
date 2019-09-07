package dao;

import models.Hero;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oHeroDao implements HeroDao {
    private final Sql2o sql2o;
    public Sql2oHeroDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO heros (name,age,power,weakness) VALUES (':name',':age',':power',':weakness')";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(hero)
                    .executeUpdate()
                    .getKey();
            hero.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Hero> getAll() {
      try (Connection con =sql2o.open()){
          return con.createQuery("SELECT * FROM heros")
                  .executeAndFetch(Hero.class);
        }
    }

    @Override
    public Hero findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heros WHERE id = :id")
                    .addParameter("id", id)

                    .executeAndFetchFirst(Hero.class);

        }
    }

    @Override
    public void update(int id, String newName,  String newPower, String newWeakness) {
        String sql = "UPDATE heros SET name =:name WHERE id =:id";
        String sql1 = "UPDATE heros SET age =:age WHERE id =:id";
        String sql2 = "UPDATE heros SET power =:power WHERE id =:id";
        String sql3 = "UPDATE heros SET power =:power WHERE id =:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)

                    .addParameter("power", newPower)
                    .addParameter("weakness", newWeakness)
                    .addParameter("id", id)
            .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from heros WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllHeros() {
        String sql = "DELETE from heros";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
