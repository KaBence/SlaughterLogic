package Shared;

public class AnimalPart {
    private int id;
    private String name;
    private double weight;
    private int animalId;

    private boolean contaminated;

    public AnimalPart() {
    }

    public AnimalPart(int id, String name, double weight, int animalId,boolean cont) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.animalId = animalId;
        contaminated=cont;
    }

    public AnimalPart(String name, double weight, int animalId) {
        this.name = name;
        this.weight = weight;
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }


    public String getName() {
        return name;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String toString(){
        return id+" "+name+" "+weight+" AnimalID ->" +animalId;
    }
}
