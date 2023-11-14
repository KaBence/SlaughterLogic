package gRPC.DAO;

import Shared.AnimalPart;
import Shared.Tray;

import java.util.ArrayList;

public interface TrayDao {
    Tray getTray(int id);
    String putIntoTray(AnimalPart animalPart, int trayId);

    String takeFromTray(int trayId,int animalpartId, int packageId);
    Tray[] getAllTrays();
    AnimalPart[] getAllAnimalPartsFromTheTray(int id);

}
