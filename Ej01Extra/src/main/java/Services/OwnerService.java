package Services;
import Entities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OwnerService {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    public ArrayList<Owner> OwnerList = new ArrayList<>();

    public Owner createOwner(){
        Owner owner = new Owner();
        System.out.println("Ingrese su nombre (solamente su nombre)");
        owner.setName(input.next());
        System.out.println("Ingrese su apellido (solamente su apellido)");
        owner.setSurname(input.next());
        System.out.println("Ingrese su DNI.");
        owner.setDni(input.next());
        System.out.println("Ingrese su edad.");
        owner.setAge(input.nextInt());
        OwnerList.add(owner);
        return owner;
    }

    public Owner createOwner(String name, String surname, int age, String dni){
        Owner owner = new Owner();
        owner.setName(name);
        owner.setSurname(surname);
        owner.setDni(dni);
        owner.setAge(age);
        OwnerList.add(owner);
        return owner;
    }

    public void showOwnerList(){
        System.out.println(OwnerList.toString());
    }

    public boolean findByName(){
        boolean found = false;
        System.out.println("Ingrese el nombre a buscar (sólo el nombre)");
        String name = input.next();
        System.out.println("Ingrese el apellido a buscar (sólo el apellido)");
        String surname = input.next();
        for (Owner o: OwnerList){
            if (name.equalsIgnoreCase(o.getName()) && surname.equalsIgnoreCase(o.getSurname())){
                found = true;
                System.out.println("La persona fue encontrada.");
                break;
            }
        }
        System.out.println("La persona no fue encontrada.");
        return found;
    }

    public boolean findByName(String name, String surname){
        boolean found = false;
        for (Owner o: OwnerList){
            if (name.equalsIgnoreCase(o.getName()) && surname.equalsIgnoreCase(o.getSurname())){
                found = true;
                System.out.println("La persona fue encontrada.");
                break;
            }
        }
        System.out.println("La persona no fue encontrada.");
        return found;
    }

    public Owner bringByName(String name, String surname){
        for (Owner o: OwnerList){
            if (name.equalsIgnoreCase(o.getName()) && surname.equalsIgnoreCase(o.getSurname())){
                return o;
            }
        }
        System.out.println("Error. La persona no existe.");
        return null;
    }

    public void adoptPet(DogService ds){
        System.out.println("Ingrese su nombre (sólo su nombre...)");
        String name = input.next();
        System.out.println("Ingrese su apellido (sólo su apellido...)");
        String surname = input.next();
        Owner owner = bringByName(name, surname);
        System.out.println("Ingrese el nombre de la mascota que desea adoptar");
        String dogName = input.next();
        boolean adopted = ds.adoptedTrue(dogName);
        if (adopted) { Dog dog = ds.bringByName(dogName);
            owner.setDog(dog); }
        }

}
