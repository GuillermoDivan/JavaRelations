/*Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual
(posición del tambor que se dispara, puede que esté el agua o no) y posición agua
(la posición del tambor donde se encuentra el agua). Estas dos posiciones, se generarán
aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)*/

package Entities;

public class Gun {
    private int actualPosition;
    private int loadedPosition;

    public Gun() {
    }

    public Gun(int actualPosition, int loadedPosition) {
        this.actualPosition = actualPosition;
        this.loadedPosition = loadedPosition;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(int actualPosition) {
        this.actualPosition = actualPosition;
    }

    public int getLoadedPosition() {
        return loadedPosition;
    }

    public void setLoadedPosition(int loadedPosition) {
        this.loadedPosition = loadedPosition;
    }

    @Override
    public String toString() {
        return "[ Posición actual: " + actualPosition + ", Posición cargada: " + loadedPosition + ".] ";
    }
}

