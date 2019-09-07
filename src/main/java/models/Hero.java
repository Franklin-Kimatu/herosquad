package models;

import java.util.Objects;

public class Hero {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                Objects.equals(name, hero.name) &&
                Objects.equals(power, hero.power) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, power, weakness);
    }

    private String name;
    private int age;
    private String power;
    private String weakness;


    public Hero(String name,int age,String power, String weakness){

        this.name=name;
        this.age= age;
        this.power=power;
        this.weakness=weakness;
    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getPower(){
        return power;
    };
    public String getWeakness(){
        return weakness;
    }

}
