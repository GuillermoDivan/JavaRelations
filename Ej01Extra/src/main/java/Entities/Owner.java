package Entities;
import lombok.Data;

@Data
public class Owner {
    private String name;
    private String surname;
    private int age;
    private String dni;
    private Dog dog;

    public Owner(String name, String surname, int age, String dni) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
    }

    public Owner() {}


    @Override
    public String toString() {
        return "[Nombre: " + name + " " + surname + ", Edad: " + age + ", DNI: " + dni + ", Perro" + dog + ".] ";
    }
}
