package Entities;
import lombok.Data;


@Data
public class Viewer {
    private int name;
    private int age;
    private double money;


    @Override
    public String toString() {
        return "[ Nombre: " + name + ", edad: " + age + ", dinero disponible: " + money + ".] ";
    }
}
