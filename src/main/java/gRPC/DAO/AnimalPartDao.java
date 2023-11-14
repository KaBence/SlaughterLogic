package gRPC.DAO;

import Shared.AnimalPart;

public interface AnimalPartDao {
    AnimalPart[] getAnimalParts();

    String insertAnimalPart(AnimalPart animalPart);
}
