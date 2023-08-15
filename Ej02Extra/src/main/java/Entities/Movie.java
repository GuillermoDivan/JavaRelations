package Entities;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Movie {
    private String title;
    private int minutesDuration;
    private int mda;
    private String director;
}

/*
Las clasificaciones de la MDA incluyen G (para todos los públicos),
PG (con supervisión de los padres),
PG13 (con supervisión de los padres para menores de 13 años),
NC16 (para mayores de 16 años) y M18 (para mayores de 18 años).
*/