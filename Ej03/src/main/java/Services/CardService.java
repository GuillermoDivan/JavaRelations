package Services;

import Entities.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CardService {
    ArrayList<PlayingCard> RemainingDeck = new ArrayList<>();
    ArrayList<PlayingCard> DiscardedDeck = new ArrayList<>();
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void generateDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                PlayingCard card = new PlayingCard();
                if (i == 0) {
                    card.setSuit("oros");
                }
                if (i == 1) {
                    card.setSuit("copas");
                }
                if (i == 2) {
                    card.setSuit("espadas");
                }
                if (i == 3) {
                    card.setSuit("bastos");
                }
                if (j == 7 || j == 8) {
                    card.setNumber(j + 4);
                } else {
                    card.setNumber(j + 1);
                }
                RemainingDeck.add(card);
            }
        }
    }

    public void remainingCardsOnDeck(){
        System.out.println("Quedan " + RemainingDeck.size() + " cartas de las 40 totales.");
    }

    public void showRemainingDeck() {
        System.out.println(RemainingDeck);
    }

    public void showDiscardedDeck() {
        System.out.println(DiscardedDeck);
        if (DiscardedDeck.size()==0){
            System.out.println("Aún no se han solicitado cartas.");
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(RemainingDeck);
        showRemainingDeck();
    }

    public void nextCard() {
        Iterator it = RemainingDeck.iterator();
        while (it.hasNext()) {
            PlayingCard next = (PlayingCard) it.next();
            System.out.println(next);
        }
        if (!it.hasNext()){
            System.out.println("No quedan más cartas");
        }
    }

    public void dealCards () {
        System.out.println("Ingrese la cantidad de cartas que desea");
        int hand = input.nextInt();
            if (hand <= RemainingDeck.size()) {
                for (int i = 0; i < hand; i++) {
                    DiscardedDeck.add(RemainingDeck.get(i));
                }
                showDiscardedDeck();
                int k = 0;
                for (int j = 0; j < hand; j++) {
                    RemainingDeck.remove(RemainingDeck.get(j));
                    k++;
                    if (k < hand) {
                        j--;
                    } else break;
                }
                showRemainingDeck();
            } else {
                System.out.println("Cantidad de cartas insuficiente para realizar el pedido.");
            }
        }
    }




/*Corregir pedido de 40 cartas... jaja.*/
/*• cartasDisponibles(): indica el número de cartas que aún se puede repartir.*/
