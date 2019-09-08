package models;

import java.util.Objects;

public class Hero {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                Objects.equals(name, hero.name) &&
                Objects.equals(power, hero.power) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, power, weakness, id);
    }

    private String name;
    private String age;
    private String power;
    private String weakness;
    private int id;


    public Hero(String name, String age, String power, String weakness){

        this.name=name;
        this.age =age;
        this.power=power;
        this.weakness=weakness;
    }
    public String getName(){
        return name;
    }

    public void setId( int id){
        this.id = id;
    }


    public String getPower(){
        return power;
    };
    public String getWeakness(){
        return weakness;
    }

    public int getId(){
        return id;
    }

}
