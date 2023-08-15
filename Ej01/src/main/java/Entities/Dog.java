package Entities;

public class Dog {
    private String name;
    private String race;
    private int age;
    private String size;

    public Dog(String name, String race, int age, String size) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.size = size;
    }

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "[Nombre: " + name + ", Raza: " + race + ", Edad: " + age + ", Tamaño: " + size + ".] ";
    }
}
