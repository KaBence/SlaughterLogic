package WebAPI;

import Shared.*;
import gRPC.ClientImplementation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.reader.UnicodeReader;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class StartClient {
    private static final String URL = "http://localhost:8080/";

    private static final RestTemplate rest=new RestTemplate();
    private Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {

        new StartClient().run();

    }

    private void run(){
        boolean flag=true;
        while (flag){
            System.out.println("-------------");
            System.out.println("1 --> Animal");
            System.out.println("2 --> Animal part");
            System.out.println("3 --> Tray");
            System.out.println("4 --> OneKindPackage");
            System.out.println("5 --> HalfAnimalPackage");
            System.out.println("-------------");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    animal();
                    break;
                case 2:
                    animalPart();
                    break;
                case 3:
                    tray();
                    break;
                case 4:
                    oneKindPackage();
                    break;
                case 5:
                    halfAnimalPackage();
                    break;
                default:
                    System.out.println("Wrong id");
                    System.out.println("You can't even type");
                    System.out.println("Fuck you");
                    System.out.println("╭∩╮（︶_︶）╭∩╮");
                    System.out.println("Shutting down");
                    flag=false;
                    break;
            }
        }
    }

    private void animal(){
        System.out.println("-------------");
        System.out.println("1 --> Insert animal");
        System.out.println("2 --> Get Animal");
        System.out.println("3 --> Get Animals");
        System.out.println("4 --> Recall Animal");
        System.out.println("5 --> Get Contaminated Animals");
        System.out.println("-------------");
        int choice= scanner.nextInt();

        switch (choice){
            case 1:
                System.out.print("Date of Death (dd/mm/yyyy): ");
                String  date=scanner.next();
                System.out.println("Weight: ");
                Double weight=scanner.nextDouble();
                System.out.println("Farm : ");
                int farm= scanner.nextInt();
                Animal x=new Animal(weight,date,farm);
                try {
                    rest.put( URL + "animal/" + x.getId(), x );
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                }
                break;
            case 2:
                System.out.print("ID: ");
                int animal_id = scanner.nextInt();
                try {
                    ResponseEntity<Animal> response = rest.getForEntity(URL +"animal/" + animal_id,Animal.class);
                    System.out.println(response.getBody());
                }catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                }
                break;
            case 3:
                try {
                    ResponseEntity<Animal[]> response = rest.getForEntity(URL + "animal", Animal[].class);
                    for(Animal item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting animals ***" );
                }
                break;
            case 4:
                System.out.print("Animal ID:");
                int badPart= scanner.nextInt();
                try {
                    rest.put(URL + "recall/" + badPart,badPart);
                }
                catch (HttpClientErrorException ex){
                    System.out.println("*** Something went wrong ***");
                }
                break;
            case 5:
                try {
                    ResponseEntity<Animal[]> response = rest.getForEntity(URL + "animal/contaminated", Animal[].class);
                    for(Animal item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting animals ***" );
                }
                break;
            default:
                System.out.println("Wrong id");
                System.out.println("You can't even type");
                System.out.println("Fuck you");
                System.out.println("╭∩╮（︶_︶）╭∩╮");
                System.out.println("Start one more time from the beginning");
                break;
        }
    }

    private void animalPart(){
        System.out.println("-------------");
        System.out.println("1 --> Insert Animal part");
        System.out.println("2 --> Get all Animal parts");
        System.out.println("-------------");
        int choice= scanner.nextInt();

        switch (choice){
            case 1:
                System.out.print("AnimalID : ");
                int animalId=scanner.nextInt();
                System.out.println("Weight: ");
                Double pWeight=scanner.nextDouble();
                System.out.println("Name : ");
                String name=scanner.next();
                int tray=0;
                int oneKindPackage=0;
                int haldAnAnimalPackage=0;
                AnimalPart y=new AnimalPart(name,pWeight,animalId, tray,oneKindPackage, haldAnAnimalPackage);
                try {
                    rest.put( URL + "animalpart/" + y.getAnimalId(), y );
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                }
                break;
            case 2:
                try {
                    ResponseEntity<AnimalPart[]> response = rest.getForEntity(URL + "animalpart", AnimalPart[].class);
                    for(AnimalPart item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting animal parts ***" );
                }
                break;
            default:
                System.out.println("Wrong id");
                System.out.println("You can't even type");
                System.out.println("Fuck you");
                System.out.println("╭∩╮（︶_︶）╭∩╮");
                System.out.println("Start one more time from the begging");
                break;
        }
    }

    private void tray(){
        System.out.println("-------------");
        System.out.println("1 -->Insert into tray ");
        System.out.println("2 --> Get one tray");
        System.out.println("3 --> Get all trays");
        System.out.println("4 --> Create Tray");
        System.out.println("-------------");
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                Tray tray= new Tray();
                AnimalPart animalPart= new AnimalPart();
                System.out.println("TRAY ID:");
                int trayId= scanner.nextInt();
                tray.setId(trayId);

                System.out.println("Animal part ID:");
                int animalPartId= scanner.nextInt();
         animalPart.setTrayId(trayId);

                try {
                    //modify this part to make it work
                    rest.put( URL + "tray/" + trayId, new PutTrayDTO(trayId,animalPartId));
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                }
                break;
            case 2:
                System.out.print("ID: ");
                int tray_id = scanner.nextInt();
                try {
                    ResponseEntity<Tray> response = rest.getForEntity(URL +"tray/" + tray_id,Tray.class);
                    System.out.println(response.getBody());
                }catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in get a tray ***" );
                }
                break;
            case 3:
                try {
                    ResponseEntity<Tray[]> response = rest.getForEntity(URL +"tray", Tray[].class);
                    for(Tray item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting the trays ***" );
                }
                break;
            case 4:
                try{
                    System.out.print("Max Weight: ");
                    double weight=scanner.nextDouble();
                    rest.put(URL+"tray/create",weight);

                }
                catch (HttpClientErrorException ex){
                    System.out.println("*** Something went wrong o7 ***");
                }
                break;
            default:
                System.out.println("Wrong id");
                System.out.println("You can't even type");
                System.out.println("Fuck you");
                System.out.println("╭∩╮（︶_︶）╭∩╮");
                System.out.println("Start one more time from the begging");
                break;
        }
    }

    private void oneKindPackage(){
        System.out.println("-------------");
        System.out.println("1 --> Insert OneKindAnimalPackage");
        System.out.println("2 --> Get all OneKindAnimalPackages");
        System.out.println("3 --> Get OneKindAnimalPackage");
        System.out.println("-------------");
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                System.out.print("One Kind package ID : ");
                int oneKindPackageId=scanner.nextInt();
                System.out.print("Type: ");
                String type = scanner.next();
                OneKindAnimalPackage w=new OneKindAnimalPackage(oneKindPackageId, type);
                try {
                    rest.put( URL + "onekindanimalpackage/" + w.getOne_package_id(), w);
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                }
                break;
            case 2:
                try {
                    ResponseEntity<OneKindAnimalPackage[]> response = rest.getForEntity(URL + "onekindanimalpackages", OneKindAnimalPackage[].class);
                    for(OneKindAnimalPackage item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting animals ***" );
                }
                break;
            case 3:
                System.out.print("ID: ");
                int oneKindPackade_id = scanner.nextInt();
                try {
                    ResponseEntity<OneKindAnimalPackage> response = rest.getForEntity(URL +"onekindanimalpackage/" + oneKindPackade_id,OneKindAnimalPackage.class);
                    System.out.println(response.getBody());
                }catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                }
                break;
            default:
                System.out.println("Wrong id");
                System.out.println("You can't even type");
                System.out.println("Fuck you");
                System.out.println("╭∩╮（︶_︶）╭∩╮");
                System.out.println("Start one more time from the begging");
                break;
        }
    }

    private void halfAnimalPackage(){
        System.out.println("-------------");
        System.out.println("1 --> Insert HalfAnimalPackage");
        System.out.println("2 --> Get all HalfAnimalPackages");
        System.out.println("3 --> Get HalfAnimalPackage");
        System.out.println("-------------");
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                System.out.print("Half package ID : ");
                int halfPackageId=scanner.nextInt();
                HalfAnimalPackage z=new HalfAnimalPackage(halfPackageId);
                try {
                    rest.put( URL + "halfanimalpackage/" + z.getHalf_package_id(), z);
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                }
                break;
            case 2:
                try {
                    ResponseEntity<HalfAnimalPackage[]> response = rest.getForEntity(URL + "halfanimalpackages", HalfAnimalPackage[].class);
                    for(HalfAnimalPackage item: response.getBody()){
                        System.out.println(item);
                    }
                } catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in Getting animals ***" );
                }
                break;
            case 3:
                System.out.print("ID: ");
                int halfPackade_id = scanner.nextInt();
                try {
                    ResponseEntity<HalfAnimalPackage> response = rest.getForEntity(URL +"halfanimalpackage/" + halfPackade_id,HalfAnimalPackage.class);
                    System.out.println(response.getBody());
                }catch( HttpClientErrorException ex ) {
                    System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                }
                break;
            default:
                System.out.println("Wrong id");
                System.out.println("You can't even type");
                System.out.println("Fuck you");
                System.out.println("╭∩╮（︶_︶）╭∩╮");
                System.out.println("Start one more time from the begging");
                break;
        }
    }
}
