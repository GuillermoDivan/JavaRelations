package Entities;
import lombok.Data;

@Data
public class Seat {
    private int number;
    private String letter;
    private boolean available;

    @Override
    public String toString() {
        String x = "X";
        if (isAvailable()) { x = "0"; }
        return "[ " + number + "." + letter + " = " + x + "]";
    }
}
