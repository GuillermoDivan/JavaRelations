package Entities;

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

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "[Nombre: " + name + " " + surname + ", Edad: " + age + ", DNI: " + dni + ", Perro" + dog + ".] ";
    }
}
