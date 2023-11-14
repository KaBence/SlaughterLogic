package gRPC.DAO;

import Shared.HalfAnimalPackage;

public interface HalfAnimalPackageDao {
    HalfAnimalPackage getHalfAnimalPackage(int id);

    HalfAnimalPackage[] getHalfAnimalPackages();

    String insertHalfAnimalPackage(HalfAnimalPackage x);
}
