package gRPC;

import Shared.Animal;
import Shared.AnimalPart;
import Shared.HalfAnimalPackage;
import Shared.OneKindAnimalPackage;
import gRPC.DAO.AnimalDao;
import gRPC.DAO.AnimalPartDao;
import gRPC.DAO.HalfAnimalPackageDao;
import gRPC.DAO.OneKindAnimalPackageDao;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughter.*;

import java.sql.Array;
import java.util.ArrayList;

public class ClientImplementation implements AnimalDao, AnimalPartDao, HalfAnimalPackageDao, OneKindAnimalPackageDao {
    private ManagedChannel managedChannel;

    private SlaughterServiceGrpc.SlaughterServiceBlockingStub slaughterStub;

    public ClientImplementation(){
        managedChannel= ManagedChannelBuilder.forAddress("localhost",1337).usePlaintext().build();
        slaughterStub=SlaughterServiceGrpc.newBlockingStub(managedChannel);
    }

    @Override
    public Animal getAnimal(int id){

        GetAnimalReq req = DTOFactory.createGetAnimalReq(id);
        GetAnimalRes res = slaughterStub.getAnimal(req);

        return DTOFactory.createAnimal(res.getOminous());
    }

    @Override
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
    @Override
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
    public Animal[] getContaminatedAnimals(){
        GetContaminatedReq req=DTOFactory.createGetContaminatedReq();
        GetContaminatedRes res=slaughterStub.getContaminated(req);
        Animal[] temp=new Animal[res.getOminousList().size()];
        int counter=0;
        for (DTOAnimal item:res.getOminousList()){
            temp[counter]=DTOFactory.createAnimal(item);
            counter++;
        }
        return temp;
    }

    @Override
    public HalfAnimalPackage getHalfAnimalPackage(int id){
        GetHalfAnimalPackageReq req = DTOFactory.creteGetHalfAnimalPackageReq(id);
        GetHalfAnimalPackageRes res = slaughterStub.getHalfAnimalPackage(req);

        return DTOFactory.createHalfAnimalPackage(res.getOminous());
    }
    @Override
    public HalfAnimalPackage[] getHalfAnimalPackages(){
        GetHalfAnimalPackagesReq req = DTOFactory.creteGetHalfAnimalPackagesReq();
        GetHalfAnimalPackagesRes res = slaughterStub.getHalfAnimalPackages(req);

        HalfAnimalPackage[] temp=new HalfAnimalPackage[res.getOminousCount()];
        int counter=0;
        for (DTOHalfAnimalPackage item:res.getOminousList()){
            temp[counter]=DTOFactory.createHalfAnimalPackage(item);
            counter++;
        }
        return temp;
    }
    @Override
    public String  insertAnimal(Animal animal){
        PutAnimalReq req=DTOFactory.createPutAnimalReq(animal);
        PutAnimalRes res=slaughterStub.putAnimal(req);
        return res.getResp();
    }
    @Override
    public String  insertAnimalPart(AnimalPart animalPart){
        PutAnimalPartReq req=DTOFactory.createPutAnimalPartReq(animalPart);
        PutAnimalPartRes res=slaughterStub.putAnimalPart(req);
        return res.getResp();
    }
    @Override
    public String insertHalfAnimalPackage(HalfAnimalPackage x)
    {
     PutHalfAnimalPackageReq req = DTOFactory.createPutHalfAnimalPackageReq(x);
     PutHalfAnimalPackageRes res = slaughterStub.putHalfAnimalPackage(req);
     return  res.getResp();
    }

    public String recallAnimalPart(int id){
        RecallReq req=DTOFactory.createRecallReq(id);
        RecallRes res=slaughterStub.recall(req);
        return res.getRes();
    }


    @Override
    public OneKindAnimalPackage getOneKindAnimalPackage(int id) {
        GetOneKindAnimalPackageReq req = DTOFactory.creteGetOneKindAnimalPackageReq(id);
        GetOneKindAnimalPackageRes res = slaughterStub.getOneKindAnimalPackage(req);

        return DTOFactory.createOneKindAnimalPackage(res.getOminous());
    }

    @Override
    public OneKindAnimalPackage[] getOneKindAnimalPackages() {
        GetOneKindAnimalPackagesReq req = DTOFactory.creteGetOneKindAnimalPackagesReq();
        GetOneKindAnimalPackagesRes res = slaughterStub.getOneKindAnimalPackages(req);

        OneKindAnimalPackage[] x = new OneKindAnimalPackage[res.getOminousCount()];
        int counter=0;
        for (DTOOneKindAnimalPackage item:res.getOminousList()){
            x[counter]=DTOFactory.createOneKindAnimalPackage(item);
            counter++;
        }
        return x;
    }

    @Override
    public String insertOneKindAnimalPackage(OneKindAnimalPackage x) {
        PutOneKindAnimalPackageReq req = DTOFactory.createPutOneKindAnimalPackageReq(x);
        PutOneKindAnimalPackageRes res = slaughterStub.putOneKindAnimalPackage(req);
        return res.getResp();
    }

    public void shutdown(){
        managedChannel.shutdown();
    }
}
