package gRPC.DAO;

import Shared.HalfAnimalPackage;
import Shared.OneKindAnimalPackage;

public interface OneKindAnimalPackageDao {
    OneKindAnimalPackage getOneKindAnimalPackage(int id);

    OneKindAnimalPackage[] getOneKindAnimalPackages();

    String insertOneKindAnimalPackage(OneKindAnimalPackage x);
}
