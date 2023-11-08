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
        return null;
    }

    public ArrayList<Animal> getAnimals(){
        GetAnimalsReq req=DTOFactory.createGetAnimalsReq();
        GetAnimalsRes res=slaughterStub.getAnimals(req);
        ArrayList<Animal> temp=new ArrayList<>();
        for(DTOAnimal item:res.getOminousList()){
            temp.add(DTOFactory.createAnimal(item));
        }
        return temp;
    }

    public ArrayList<AnimalPart> getAnimalParts(){
        GetAnimalPartsReq req=DTOFactory.createGetAnimalPartsReq();
        GetAnimalPartsRes res=slaughterStub.getAnimalParts(req);
        ArrayList<AnimalPart> temp=new ArrayList<>();
        for(DTOAnimalPart item: res.getOminousList()){
            temp.add(DTOFactory.createAnimalPart(item));
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
