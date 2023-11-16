package gRPC.DAO;

import Shared.HalfAnimalPackage;

public interface HalfAnimalPackageDao {
    HalfAnimalPackage getHalfAnimalPackage(int id);

    HalfAnimalPackage[] getHalfAnimalPackages();

    String insertHalfAnimalPackage(HalfAnimalPackage x);
    //we need to change this or create a separate create and insert method (btw for now the insert method has the functionality of create ..have funnn)
}
