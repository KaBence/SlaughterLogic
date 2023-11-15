package Shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tray {
    private int id;
    private double maxWeight;

    @JsonCreator
    public Tray(@JsonProperty("field1")int id,@JsonProperty("field2") double maxWeight){
        this.id=id;
        this.maxWeight= maxWeight;

    }
    public Tray() {
    }

    public double getMaxWeight() {
        return maxWeight;
    }



    public int getId() {
        return id;
    }
public String toString(){
        return "Tray id:" +getId() +" " +" Max weight: " + getMaxWeight();
}
}
