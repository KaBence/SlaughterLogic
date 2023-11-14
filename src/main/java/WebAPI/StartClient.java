package WebAPI;

import Shared.Animal;
import Shared.AnimalPart;
import Shared.HalfAnimalPackage;
import Shared.OneKindAnimalPackage;
import gRPC.ClientImplementation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.reader.UnicodeReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class StartClient {
    private static final String URL = "http://localhost:8080/";

    private static final RestTemplate rest=new RestTemplate();

    public static void main(String[] args) {
        boolean flag=true;
        while (flag){
            System.out.println("-------------");
            System.out.println("1 --> Insert Animal");
            System.out.println("2 --> Insert AnimalPart");
            System.out.println("3 --> Get all Animals");
            System.out.println("4 --> Get all AnimalParts");
            System.out.println("5 --> Get Animal");
            System.out.println("6 --> Insert HalfAnimalPackage");
            System.out.println("7 --> Get all HalfAnimalPackages");
            System.out.println("8 --> Get HalfAnimalPackage");
            System.out.println("9 --> Recall Animal");
            System.out.println("10 --> Get recalled animals");
            System.out.println("11 --> Shut channel");
            System.out.println("9 --> Insert OneKindAnimalPackage");
            System.out.println("10 --> Get all OneKindAnimalPackages");
            System.out.println("11 --> Get OneKindAnimalPackage");
            System.out.println("12 --> Shut channel");
            System.out.println("-------------");
            Scanner scanner=new Scanner(System.in);
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
                    System.out.print("AnimalID : ");
                    int animalId=scanner.nextInt();
                    System.out.println("Weight: ");
                    Double pWeight=scanner.nextDouble();
                    System.out.println("Name : ");
                    String name=scanner.next();
                    AnimalPart y=new AnimalPart(name,pWeight,animalId);
                    try {
                        rest.put( URL + "animalpart/" + y.getAnimalId(), y );
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
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
                    try {
                        ResponseEntity<AnimalPart[]> response = rest.getForEntity(URL + "animalpart", AnimalPart[].class);
                        for(AnimalPart item: response.getBody()){
                            System.out.println(item);
                        }
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in Getting animal parts ***" );
                    }
                    break;
                case 5:
                    System.out.print("ID: ");
                    int animal_id = scanner.nextInt();
                    try {
                        ResponseEntity<Animal> response = rest.getForEntity(URL +"animal/" + animal_id,Animal.class);
                        System.out.println(response.getBody());
                    }catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                    }
                    break;
                case 6:
                    System.out.print("Half package ID : ");
                    int halfPackageId=scanner.nextInt();
                    HalfAnimalPackage z=new HalfAnimalPackage(halfPackageId);
                    try {
                        rest.put( URL + "halfanimalpackage/" + z.getHalf_package_id(), z);
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** OOPS - put failed with code " + ex.getStatusCode().value() + " ***" );
                    }
                    break;
                case 7:
                    try {
                        ResponseEntity<HalfAnimalPackage[]> response = rest.getForEntity(URL + "halfanimalpackages", HalfAnimalPackage[].class);
                        for(HalfAnimalPackage item: response.getBody()){
                            System.out.println(item);
                        }
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in Getting animals ***" );
                    }
                    break;
                case 8:
                    System.out.print("ID: ");
                    int halfPackade_id = scanner.nextInt();
                    try {
                        ResponseEntity<HalfAnimalPackage> response = rest.getForEntity(URL +"halfanimalpackage/" + halfPackade_id,HalfAnimalPackage.class);
                        System.out.println(response.getBody());
                    }catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                    }
                    break;
                case 9:
                    System.out.print("Animal ID:");
                    int badPart= scanner.nextInt();
                    try {
                        rest.put(URL + "recall/" + badPart,badPart);
                    }
                    catch (HttpClientErrorException ex){
                        System.out.println("*** Something went wrong ***");
                    }
                    break;
                case 10:
                    try {
                        ResponseEntity<Animal[]> response = rest.getForEntity(URL + "animal/contaminated", Animal[].class);
                        for(Animal item: response.getBody()){
                            System.out.println(item);
                        }
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in Getting animals ***" );
                    }
                    break;
                case 11:
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
                case 10:
                    try {
                        ResponseEntity<OneKindAnimalPackage[]> response = rest.getForEntity(URL + "onekindanimalpackages", OneKindAnimalPackage[].class);
                        for(OneKindAnimalPackage item: response.getBody()){
                            System.out.println(item);
                        }
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in Getting animals ***" );
                    }
                    break;
                case 11:
                    System.out.print("ID: ");
                    int oneKindPackade_id = scanner.nextInt();
                    try {
                        ResponseEntity<OneKindAnimalPackage> response = rest.getForEntity(URL +"onekindanimalpackage/" + oneKindPackade_id,OneKindAnimalPackage.class);
                        System.out.println(response.getBody());
                    }catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                    }
                    break;
                case 12:
                    flag = false;
                    System.out.println("Fuck you");
                    System.out.println("╭∩╮（︶_︶）╭∩╮");
                    break;
                default:
                    System.out.println("Wrong id");
                    break;
            }
        }
    }
}
