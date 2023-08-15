package Services;
import Entities.*;

import java.util.ArrayList;

public class CinemaService {

    public Cinema createCinema(Movie movie){
        Cinema cinema = new Cinema();
        cinema.setMovie(movie);
        cinema.setPrice(Math.random()*100);
        System.out.println("Valor de entrada: "+ cinema.getPrice());
        cinema.setScreenroom(SeatService.Screenroom);
        return cinema;
    }

    public boolean allowViewer(Viewer viewer, Cinema cinema){
        boolean allowed = true;

        System.out.println(viewer.toString());
        if (viewer.getMoney() < cinema.getPrice()){
            System.out.println("No te alcanza el dinero para la entrada. No podés pasar.");
            allowed = false;
        }
        if (viewer.getAge() < cinema.getMovie().getMda()) {
            System.out.println("No tenés la edad requerida para ver esta película. No podés pasar.");
            allowed = false;
        }
        if (SeatService.counter == 48) {
            System.out.println("Desafortunadamente, la sala ya está llena. No podés pasar.");
            allowed = false;
        }
        SeatService seatService = new SeatService();
        if (allowed) { seatService.takeSeat(); }
        return allowed;
    }
}
