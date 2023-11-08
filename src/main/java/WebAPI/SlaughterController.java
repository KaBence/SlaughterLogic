package WebAPI;

import Shared.Animal;
import Shared.AnimalPart;
import com.google.api.Http;
import gRPC.ClientImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SlaughterController {
    private ClientImplementation client;

    public SlaughterController() {
        client=new ClientImplementation();
    }

    @GetMapping("animal")
    public synchronized ResponseEntity<Animal[]> getAllAnimals(){
        Animal[] allAnimals=client.getAnimals().toArray(new Animal[client.getAnimals().size()]);
        return new ResponseEntity<Animal[]>(allAnimals, HttpStatus.OK);
    }

    @GetMapping("animal/{id}")
    public synchronized ResponseEntity<Animal> getAnimal(@PathVariable(value = "id") int id){
        Animal x=client.getAnimal(id);
        if( x == null )
            return new ResponseEntity<Animal>( HttpStatus.NOT_FOUND );
        return new ResponseEntity<Animal>(x,HttpStatus.OK);
    }

    @GetMapping("animalpart")
    public synchronized ResponseEntity<AnimalPart[]> getAllAnimalParts(){
        AnimalPart[] allAnimalParts=client.getAnimalParts().toArray(new AnimalPart[client.getAnimalParts().size()]);
        return new ResponseEntity<AnimalPart[]>(allAnimalParts, HttpStatus.OK);
    }

    @PutMapping("animal/{id}")
    public synchronized ResponseEntity<String> putAnimal(@RequestBody Animal animal, @PathVariable(value = "id")int id){
        String  x=client.insertAnimal(animal);
        return new ResponseEntity<>(x,HttpStatus.CREATED);
    }

    @PutMapping("animalpart/{id}")
    public synchronized ResponseEntity<String> putAnimalPart(@RequestBody AnimalPart animal, @PathVariable(value = "id")int id){
        String  x=client.insertAnimalPart(animal);
        return new ResponseEntity<>(x,HttpStatus.CREATED);
    }
}
