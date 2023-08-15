package Main;
import Services.CardService;

public class Main {
    public static void main(String[] args) {
        CardService cs = new CardService();
        cs.generateDeck();
        /*for (int i = 0; i < 40; i++){ cs.nextCard();}*/
        cs.shuffleDeck();
        cs.dealCards();
        cs.remainingCardsOnDeck();
        cs.dealCards();
    }
    }

