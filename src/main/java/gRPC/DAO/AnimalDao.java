package gRPC.DAO;

import Shared.Animal;

public interface AnimalDao {
    Animal getAnimal(int id);

    Animal[] getAnimals();

    String insertAnimal(Animal animal);
}
