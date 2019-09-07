package dao;

import org.junit.After;
import org.junit.Before;
import models.Hero;
import org.sql2o.*;
import org.junit.*;

import static org.junit.Assert.*;

public class Sql2oHeroDaoTest {
    private Sql2oHeroDao heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
   public void addingThisWillSetId() throws Exception {
        Hero hero= new Hero("superman","height","light");
        int initialHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(initialHeroId,hero.getId());
    }

    @Test
   public void existingHerosCanBeFoundById() throws Exception{
       Hero hero = new Hero("superman","height","light");
       heroDao.add(hero);
        Hero foundHero =heroDao.findById(hero.getId());
        assertEquals(hero,foundHero);

    }

    @Test
  public void allTasksAreFoundAndReturned() throws Exception{
        Hero hero = new Hero("superman","height","light");
        heroDao.add(hero);
        assertEquals(1,heroDao.getAll().size());
    }

    @Test
   public void noHerosReturnsEmptyList() throws Exception{
        assertEquals(0,heroDao.getAll().size());
    }
}