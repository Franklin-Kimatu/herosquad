package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//    @Test
//    public void newHeroInstantiatesCorrectly_true(){
//        Hero hero= setUpNewHero();
//        assertEquals(true,hero instanceof Hero);
//    }
//
//    @Test
//    public void heroMustHaveAName(){
//        Hero hero =setUpNewHero();
//        assertEquals("superman",hero.getName());
//    }
//    //test age
//
//
//    //tests power
//    @Test
//    public void getPowerChecksTheHerosPower(){
//        Hero hero =setUpNewHero();
//        assertEquals("height",hero.getPower());
//    }

    @Test
    public void newSquadInstantiatesCorectly_true(){
        Squad squad=setUpNewSquad();
        assertEquals(true,squad instanceof Squad);
    }

    @Test
    public void getSquadNameGetsTheSquadName()throws Exception{
        Squad squad =setUpNewSquad();
        assertEquals("superheros",squad.getSquadName());
    }
    @Test
    public void getMaxNumGetsTheNumberInASquad(){
        Squad squad= setUpNewSquad();
        assertEquals(20,squad.getMaxNum());
    }
    @Test
    public void getCauseGetstheCauseOfAction(){
        Squad squad =setUpNewSquad();
        assertEquals("guarding the city",squad.getCause());
    }

    private Squad setUpNewSquad(){
        return new Squad("superheros",20,"guarding the city");
    }
}