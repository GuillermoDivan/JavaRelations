/*Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona. Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.*/

package Main;
import Services.*;

public class Main {
    public static void main(String[] args) {
        OwnerService os = new OwnerService();
        DogService ds = new DogService();
        os.createOwner();
        os.createOwner();
        os.showOwnerList();
        ds.createDog();
        ds.createDog();
        ds.showDogList();
        os.adoptPet(ds);
        os.adoptPet(ds);
        os.adoptPet(ds);
        os.showOwnerList();
        
    }
}
