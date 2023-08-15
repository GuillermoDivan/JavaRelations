package Entities;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class Cinema {
    private Movie movie;
    private double price;
    private static ArrayList<ArrayList<Seat>> Screenroom;

    public static ArrayList<ArrayList<Seat>> getScreenroom() {
        return Screenroom;
    }

    public static void setScreenroom(ArrayList<ArrayList<Seat>> screenroom) {
        Screenroom = screenroom;
    }
}
