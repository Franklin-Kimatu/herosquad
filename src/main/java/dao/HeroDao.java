package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {
    List<Hero> getAll();


    //creating a hero
    void add( Hero hero);

    Hero findById(int id);

    //updating
    void update(int id,String name,String power,String weakness);

    //deleting
    void deleteById(int id);
    void clearAllHeros();
}
