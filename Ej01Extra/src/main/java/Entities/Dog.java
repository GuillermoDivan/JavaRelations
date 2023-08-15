package Entities;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Dog {
    private String name;
    private String race;
    private int age;
    private String size;
    private boolean adopted;

    public Dog() {}

    @Override
    public String toString() {
        return "[Nombre: " + name + ", Raza: " + race + ", Edad: " + age + ", Tamaño: " + size + ".] ";
    }
}
