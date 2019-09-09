package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return maxNum == squad.maxNum &&
                id == squad.id &&
                Objects.equals(squadName, squad.squadName) &&
                Objects.equals(cause, squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squadName, maxNum, cause, id);
    }

    private String squadName;
    private int maxNum;
    private String cause;

    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();


        public Squad(String squadName ,int maxNum,String cause){
            this.squadName=squadName;
            this.cause=cause;
            this.maxNum=maxNum;
            instances.add(this);
        }

        public String getSquadName(){
            return squadName;
        }

        public String getCause(){
            return cause;
        }

        public int getMaxNum(){
            return maxNum;
        }
    public static ArrayList<Squad>getAll(){
        return instances;
    }



}
