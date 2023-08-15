/*Realizar un programa para que una Persona pueda adoptar un Perro.
Vamos a contar de dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño;
y la clase Persona con atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.*/

package Main;

import Entities.*;

public class Main {
    public static void main(String[] args) {

    Owner o1 = new Owner("Cosme", "Fulanito", 35, "32323232");
    Owner o2 = new Owner("Natalia", "Natalia", 32, "34456456");
    Dog d1 = new Dog("Manchita", "Dogo Argentino", 2, "Medio");
    Dog d2 = new Dog("Satanás", "Caniche", 4, "Pequeño");

    o1.setDog(d1);
    o2.setDog(d2);
    System.out.println(o1.toString());
    System.out.println(o2.toString());

    }
}
