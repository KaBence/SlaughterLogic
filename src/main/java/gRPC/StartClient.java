package gRPC;

import Shared.Animal;

import java.util.ArrayList;
import java.util.Scanner;

public class StartClient {
    public static void main(String[] args) {
        boolean flag=true;
        ClientImplementation client=new ClientImplementation();
        while (flag){
            System.out.println("-------------");
            System.out.println("1 --> Find Animal");
            System.out.println("2 --> Find all AnimalParts from a specified Animal");
            System.out.println("3 --> Insert Animal");
            System.out.println("4 --> Insert AnimalPart");
            System.out.println("4 --> Get all Animals");
            System.out.println("5 --> Get all AnimalParts");
            System.out.println("6 --> Shut channel");
            System.out.println("-------------");
            Scanner scanner=new Scanner(System.in);
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("ID --> ");
                    System.out.println(client.getAnimal(scanner.nextInt()));
                    break;
                case 2:
                    System.out.print("ID : ");
                    int id=scanner.nextInt();
                    System.out.println("Weight: ");
                    Double weight=scanner.nextDouble();
                    //System.out.println(client.insertAnimal(new Animal(id,weight)));
                    break;
                case 3:
                    Animal[] animals=client.getAnimals();
                    for (Animal item: animals)
                        System.out.println(item);
                    break;
                case 4:



                    break;
                case 5:
                    client.shutdown();
                    flag=false;
                    break;
                default:
                    System.out.println("Wrong id");
                    break;
            }
        }
    }
}
