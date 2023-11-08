package Shared;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Animal {
    private int id;
    private double weight;

    public Animal(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getString(){
        return "Animal "+ "--> Id: "+id+" Weight: "+weight;
    }

}
