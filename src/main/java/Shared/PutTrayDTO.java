package Shared;

public class PutTrayDTO {
    private int trayID;
    private int animalPartID;

    public PutTrayDTO(int trayID, int animalPartID) {
        this.trayID = trayID;
        this.animalPartID = animalPartID;
    }

    public int getTrayID() {
        return trayID;
    }

    public int getAnimalPartID() {
        return animalPartID;
    }
}
