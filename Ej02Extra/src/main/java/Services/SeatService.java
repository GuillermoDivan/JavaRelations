package Services;
import Entities.Seat;
import java.util.ArrayList;

public class SeatService {
    static ArrayList<ArrayList<Seat>> Screenroom = new ArrayList<ArrayList<Seat>>();
    public static int counter = 0;

    public ArrayList<ArrayList<Seat>> createScreenroom() {
        for (int i = 8; i > 0; i--) {
            ArrayList<Seat> aux = new ArrayList<Seat>();
            for (int j = 0; j < 6; j++) {
                Seat seat = new Seat();
                seat.setNumber(i);
                if (j == 0) { seat.setLetter("A"); }
                if (j == 1) { seat.setLetter("B"); }
                if (j == 2) { seat.setLetter("C"); }
                if (j == 3) { seat.setLetter("D"); }
                if (j == 4) { seat.setLetter("E"); }
                if (j == 5) { seat.setLetter("F"); }
                seat.setAvailable(true);
                aux.add(seat);
            }
            Screenroom.add(aux);
        } return Screenroom;
    }

    public void takeSeat(){
        boolean flag = true;
        while (flag) {
            int randomNumber = (int) (Math.random() * 8);
            int randomLetter = (int) (Math.random() * 6);
            System.out.println(randomNumber + " + " + randomLetter);
            Seat sortedSeat = Screenroom.get(randomNumber).get(randomLetter);
            if (sortedSeat.isAvailable()) {
                sortedSeat.setAvailable(false);
                System.out.println("El asiento " + sortedSeat.getNumber() + sortedSeat.getLetter()
                        + " ha sido reservado para vos."); counter++; flag = false;
            } else {
                System.out.println("El asiento " + sortedSeat.getNumber() + sortedSeat.getLetter()
                        + " ya está reservado para alguien más. Te buscamos otro...");
            }
        }
        }

        public void showScreenroom(){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(Screenroom.get(i).get(j).toString());
                }
                System.out.println("");
            }
        }

    }

