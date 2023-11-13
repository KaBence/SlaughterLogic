package gRPC;

import Shared.Animal;
import Shared.AnimalPart;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughter.*;

import java.util.ArrayList;

public class ClientImplementation {
    private ManagedChannel managedChannel;

    private SlaughterServiceGrpc.SlaughterServiceBlockingStub slaughterStub;

    public ClientImplementation(){
        managedChannel= ManagedChannelBuilder.forAddress("localhost",1337).usePlaintext().build();
        slaughterStub=SlaughterServiceGrpc.newBlockingStub(managedChannel);
    }

    public Animal getAnimal(int id){

        GetAnimalReq req = DTOFactory.createGetAnimalReq(id);
        GetAnimalRes res = slaughterStub.getAnimal(req);

        return DTOFactory.createAnimal(res.getOminous());
    }

    public Animal[] getAnimals(){
        GetAnimalsReq req=DTOFactory.createGetAnimalsReq();
        GetAnimalsRes res=slaughterStub.getAnimals(req);
        Animal[] temp=new Animal[res.getOminousList().size()];
        int counter=0;
        for (DTOAnimal item:res.getOminousList()){
            temp[counter]=DTOFactory.createAnimal(item);
            counter++;
        }
        return temp;
    }

    public AnimalPart[] getAnimalParts(){
        GetAnimalPartsReq req=DTOFactory.createGetAnimalPartsReq();
        GetAnimalPartsRes res=slaughterStub.getAnimalParts(req);
        AnimalPart[] temp=new AnimalPart[res.getOminousCount()];
        int counter=0;
        for (DTOAnimalPart item:res.getOminousList()){
            temp[counter]=DTOFactory.createAnimalPart(item);
            counter++;
        }
        return temp;
    }

    public String  insertAnimal(Animal animal){
        PutAnimalReq req=DTOFactory.createPutAnimalReq(animal);
        PutAnimalRes res=slaughterStub.putAnimal(req);
        return res.getResp();
    }

    public String  insertAnimalPart(AnimalPart animalPart){
        PutAnimalPartReq req=DTOFactory.createPutAnimalPartReq(animalPart);
        PutAnimalPartRes res=slaughterStub.putAnimalPart(req);
        return res.getResp();
    }


    public void shutdown(){
        managedChannel.shutdown();
    }
}
