package Shared;

public class AnimalPart {
    private int id;
    private String name;
    private double weight;
    private int animalId;
    private int trayId;
    private int OneKindPackageId;
    private int HalfAnAnimalPackageId;

    private boolean contaminated;

    public AnimalPart() {
    }

    public AnimalPart(int id, String name, double weight, int animalId,int trayId, int OneKindAnimalPackageId, int HalfAnimalPackageId,boolean cont) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.animalId = animalId;
        this.HalfAnAnimalPackageId= HalfAnimalPackageId;
        this.OneKindPackageId= OneKindAnimalPackageId;
        this.trayId= trayId;
        contaminated=cont;
    }

    public AnimalPart(String name, double weight, int animalId, int trayId, int OneKindAnimalPackageId, int HalfAnimalPackageId) {
        this.name = name;
        this.weight = weight;
        this.animalId = animalId;
        this.HalfAnAnimalPackageId= HalfAnimalPackageId;
        this.OneKindPackageId= OneKindAnimalPackageId;
        this.trayId= trayId;
    }

    public int getTrayId() {
        return trayId;
    }

    public int getOneKindPackageId() {
        return OneKindPackageId;
    }

    public int getHalfAnAnimalPackageId() {
        return HalfAnAnimalPackageId;
    }

    public void setTrayId(int trayId) {
        this.trayId = trayId;
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

    public boolean isContaminated() {
        return contaminated;
    }

    public String toString(){
        return id+" "+name+" "+weight+" AnimalID ->" +animalId+" Contaminated: "+isContaminated();
    }
}
