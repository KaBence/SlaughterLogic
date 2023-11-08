package WebAPI;

import Shared.Animal;
import Shared.AnimalPart;
import gRPC.ClientImplementation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
            System.out.println("5 --> Shut channel");
            System.out.println("-------------");
            Scanner scanner=new Scanner(System.in);
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("ID : ");
                    int id=scanner.nextInt();
                    System.out.println("Weight: ");
                    Double weight=scanner.nextDouble();
                    Animal x=new Animal(id,weight);
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
                    String animalName=scanner.next();
                    AnimalPart y=new AnimalPart(animalName,animalId);
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
                        System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                    }
                    break;
                case 4:
                    try {
                        ResponseEntity<AnimalPart[]> response = rest.getForEntity(URL + "animalpart", AnimalPart[].class);
                        for(AnimalPart item: response.getBody()){
                            System.out.println(item);
                        }
                    } catch( HttpClientErrorException ex ) {
                        System.out.println( "*** Something went wrong in fetchAllFriends ***" );
                    }
                    break;
                default:
                    System.out.println("Wrong id");
                    break;
            }
        }
    }
}
