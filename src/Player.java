import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/21/13
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;
    private int chipsRemaining;
    private ChipColor chipColor;

    public Player(BufferedReader input, ChipColor color) throws IOException {
        System.out.println("Input desired name: ");
        this.name = input.readLine();
        this.chipsRemaining = 21;
        this.chipColor = color;
    }

    public void setName(String name){
       this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void removeChip(){
        this.chipsRemaining--;
    }

    public int getChipsRemaining(){
        return chipsRemaining;
    }

    public ChipColor getChipColor(){
        return chipColor;
    }
}
