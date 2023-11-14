package gRPC;

import Shared.Animal;
import Shared.AnimalPart;
import Shared.HalfAnimalPackage;
import Shared.OneKindAnimalPackage;
import gRPC.DAO.OneKindAnimalPackageDao;
import slaughter.*;

import java.util.Date;

public class DTOFactory {


    public static DTOAnimal createDTOAnimal(Animal animal){
        return DTOAnimal.newBuilder()
                .setDod(animal.getDod())
                .setWeight(animal.getWeight())
                .setFarm(animal.getFarm())
                .build();
    }

    public static Animal createAnimal(DTOAnimal dto){
        return new Animal(dto.getId(),dto.getWeight(), dto.getDod(),dto.getFarm());
    }

    public static DTOAnimalPart createDTOAnimalPart(AnimalPart animalPart){
        return DTOAnimalPart.newBuilder()
                .setAnimalId(animalPart.getAnimalId())
                .setWeight(animalPart.getWeight())
                .setName(animalPart.getName())
                .build();
    }

    public static AnimalPart createAnimalPart(DTOAnimalPart dto){
        return new AnimalPart(dto.getId(),dto.getName(),dto.getWeight(),dto.getAnimalId());
    }

    public static DTOHalfAnimalPackage createDTOHalfAnimalPackage(HalfAnimalPackage x)
    {
        return DTOHalfAnimalPackage.newBuilder()
                .setId(x.getHalf_package_id())
                .build();
    }

    public static HalfAnimalPackage createHalfAnimalPackage(DTOHalfAnimalPackage dto)
    {
        return new HalfAnimalPackage(dto.getId());
    }

    public static DTOOneKindAnimalPackage createDTOOneKindAnimalPackage(OneKindAnimalPackage x)
    {
        return DTOOneKindAnimalPackage.newBuilder()
                .setId(x.getOne_package_id())
                .setType(x.getPartType())
                .build();
    }

    public static OneKindAnimalPackage createOneKindAnimalPackage(DTOOneKindAnimalPackage dto)
    {
        return new OneKindAnimalPackage(dto.getId(),dto.getType());
    }

    public static GetAnimalsReq createGetAnimalsReq(){
        return GetAnimalsReq.newBuilder().build();
    }

    public static GetAnimalReq createGetAnimalReq(int id)
    {
        return GetAnimalReq.newBuilder().setId(id).build();
    }

    public static GetAnimalPartsReq createGetAnimalPartsReq(){
        return GetAnimalPartsReq.newBuilder().build();
    }

    public static GetHalfAnimalPackagesReq creteGetHalfAnimalPackagesReq()
    {
        return GetHalfAnimalPackagesReq.newBuilder().build();
    }

    public static GetHalfAnimalPackageReq creteGetHalfAnimalPackageReq(int x)
    {
        return GetHalfAnimalPackageReq.newBuilder().setId(x).build();
    }

    public static PutAnimalReq createPutAnimalReq(Animal animal){
        return PutAnimalReq.newBuilder()
                .setOminous(DTOFactory.createDTOAnimal(animal))
                .build();
    }


    public static PutAnimalPartReq createPutAnimalPartReq(AnimalPart animalPart){
        return PutAnimalPartReq.newBuilder()
                .setOminous(DTOFactory.createDTOAnimalPart(animalPart))
                .build();
    }

    public static PutHalfAnimalPackageReq createPutHalfAnimalPackageReq(HalfAnimalPackage halfAnimalPackage)
    {
        return PutHalfAnimalPackageReq.newBuilder()
                .setOminous(createDTOHalfAnimalPackage(halfAnimalPackage))
                .build();
    }


    public static GetOneKindAnimalPackagesReq creteGetOneKindAnimalPackagesReq()
    {
        return GetOneKindAnimalPackagesReq.newBuilder().build();
    }

    public static GetOneKindAnimalPackageReq creteGetOneKindAnimalPackageReq(int x)
    {
        return GetOneKindAnimalPackageReq.newBuilder().setId(x).build();
    }

    public static PutOneKindAnimalPackageReq createPutOneKindAnimalPackageReq(OneKindAnimalPackage oneKindAnimalPackage)
    {
        return PutOneKindAnimalPackageReq.newBuilder()
                .setOminous(createDTOOneKindAnimalPackage(oneKindAnimalPackage))
                .build();
    }
}
