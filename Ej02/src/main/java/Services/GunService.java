/*Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)*/
package Services;
import Entities.Gun;

public class GunService {
    public Gun loadGun(){
        int actualPosition = (int) ((Math.random() * 5)+1) ;
        int loadedPosition = (int) ((Math.random() * 5)+1) ;
        Gun gun1 = new Gun(actualPosition, loadedPosition);
        return gun1;
    }

    public boolean shot(Gun gun){
        if (gun.getActualPosition() == gun.getLoadedPosition()){
            return true; } else {return false; }
    }

    public void nextPosition(Gun gun){
        if (gun.getActualPosition()<6){
        gun.setActualPosition(gun.getActualPosition() + 1);
        } else { gun.setActualPosition(1); }
    }
}