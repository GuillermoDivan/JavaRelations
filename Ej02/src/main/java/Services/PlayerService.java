/*Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.*/

package Services;
import Entities.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerService {
    private ArrayList<Player> playerList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public ArrayList<Player> addPlayersToList(){
        System.out.println("Ingrese la cantidad de jugadores que van a participar.");
        int amount = input.nextInt();
        if (amount < 0 || amount > 6){
            System.out.println("Cantidad no válida. Se ha configurado para 6 jugadores por defecto.");
            amount = 6;
        }
        for (int i = 0; i < amount; i++){
            String player = "Player " + String.valueOf(i+1);
            boolean wet = false;
            Player p1 = new Player(player, wet);
            playerList.add(p1);
        }
        return playerList;
    }

    public boolean shoot(Gun g1){
        GunService gunS = new GunService();
        boolean hasBeenShot = gunS.shot(g1);
        if (hasBeenShot) { return true; }
        else { gunS.nextPosition(g1); return false; }
    }
}
