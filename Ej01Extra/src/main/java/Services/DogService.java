package Services;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Dog;

public class DogService {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    public ArrayList<Dog> DogList = new ArrayList<>();
    public Dog createDog(){
        Dog dog = new Dog();
        System.out.println("Ingrese el nombre del perro");
        dog.setName(input.next());
        System.out.println("Ingrese la raza");
        dog.setRace(input.next());
        System.out.println("Ingrese el tamaño.");
        dog.setSize(input.next());
        System.out.println("Ingrese la edad.");
        dog.setAge(input.nextInt());
        dog.setAdopted(false);
        DogList.add(dog);
        System.out.println(dog);
        return dog;
    }

    public Dog createDog(String name, String race, int age, String size){
        Dog dog = new Dog();
        dog.setName(name);
        dog.setRace(race);
        dog.setSize(size);
        dog.setAge(age);
        dog.setAdopted(false);
        DogList.add(dog);
        return dog;
    }

    public void showDogList(){
        System.out.println(DogList.toString());
    }

    public boolean findByName(){
        boolean found = false;
        System.out.println("Ingrese el nombre a buscar (sólo el nombre)");
        String name = input.next();
        for (Dog d: DogList){
            if (name.equals(d.getName())){
                found = true;
                System.out.println("La mascota fue encontrada.");
                break;
            }
        }
        System.out.println("La mascota no fue encontrada.");
        return found;
    }

    public boolean findByName(String name){
        boolean found = false;
        for (Dog d: DogList){
            if (name.equals(d.getName())){
                found = true;
                System.out.println("La mascota fue encontrada.");
                return found;
            }
        }
        System.out.println("La mascota no fue encontrada.");
        return found;
    }

    public Dog bringByName(String name){
        for (Dog d: DogList){
            if (name.equals(d.getName())){
                return d;
            }
        }
        System.out.println("Error. La mascota no existe.");
        return null;
    }

    public boolean adoptedTrue(String name){
        boolean adopted = false;
        boolean found = findByName(name);
        if (found) {
            for (Dog d : DogList) {
                if (d.getName().equals(name) && !d.isAdopted()) {
                    System.out.println("Felicidades, has adoptado a " + name + ".");
                    d.setAdopted(true);
                    adopted = true;
                    return adopted;
                }
            }
            System.out.println("La mascota ya se encuentra adoptada.");
            } return adopted;
    }

}
