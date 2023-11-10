package gRPC;

import Shared.Animal;
import Shared.AnimalPart;
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

    public static GetAnimalsReq createGetAnimalsReq(){
        return GetAnimalsReq.newBuilder().build();
    }

    public static GetAnimalPartsReq createGetAnimalPartsReq(){
        return GetAnimalPartsReq.newBuilder().build();
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
}
