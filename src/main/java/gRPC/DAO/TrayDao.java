package gRPC.DAO;

import Shared.AnimalPart;
import Shared.Tray;

import java.util.ArrayList;

public interface TrayDao {
    String createTray(double maxWeight);
    Tray getTray(int id);
    String putIntoTray(int animalPart, int trayId);

    String takeFromTray(int trayId,int animalpartId, int packageId);
    Tray[] getAllTrays();
    AnimalPart[] getAllAnimalPartsFromTheTray(int id);

}
