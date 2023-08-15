package Services;
import Entities.Movie;

import java.util.Scanner;

public class MovieService {
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public Movie createMovie(){
        Movie movie = new Movie();
        System.out.println("Ingrese el nombre de la película.");
        movie.setTitle(input.next());
        System.out.println("Ingrese la duración de la película en minutos.");
        movie.setMinutesDuration(input.nextInt());
        System.out.println("Ingrese el MDA (límite de edad: 13, 16, 18).");
        movie.setMda(input.nextInt());
        System.out.println("Ingrese le directore.");
        movie.setDirector(input.next());
        return movie;
    }


}

/*Las clasificaciones de la MDA incluyen G (para todos los públicos),
PG (con supervisión de los padres),
PG13 (con supervisión de los padres para menores de 13 años),
NC16 (para mayores de 16 años) y M18 (para mayores de 18 años).*/