/*Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.*/

package Services;
import Entities.*;
import java.util.ArrayList;

public class GameService {
    PlayerService playerS = new PlayerService();

    public Game startGame(){
        ArrayList<Player> playerList = playerS.addPlayersToList();
        GunService gunS = new GunService();
        Gun gun = gunS.loadGun();
        Game game = new Game(playerList, gun);
        return game;
    }

    public void startGame(ArrayList<Player> playerList, Gun gun){
        Game game = new Game(playerList, gun);
    }

    public void round(Game game){
        int beginsWith = (int) (Math.random()*game.playerList.size());
        System.out.println("empieza jugador " + (beginsWith + 1));
        System.out.println("Pistola = " + game.getGun().toString());

        for (int i = beginsWith ; i < game.playerList.size(); i++) {
            Player currentPlayer = game.getPlayerList().get(i);
            boolean isShooted = playerS.shoot(game.getGun());
            if(isShooted){
                currentPlayer.setWet(true);
                System.out.println("JUGADOR MOJADO: " + currentPlayer);
                return;
            }
            System.out.println(currentPlayer + " ¡Bien! No te tocó.");
            if (i+1 == game.getPlayerList().size()){
                i = -1;
            }
        }
    }
}
