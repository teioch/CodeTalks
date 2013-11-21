import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/21/13
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public static void main(String[] args) throws IOException {
        List<Player> players = new ArrayList<Player>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for(ChipColor color: ChipColor.values()){
            players.add(new Player(input, color));
        }

        int col = 0;
        int row = -1;

        Board board = new Board();

        while(!board.isComplete()){
            for(Player player: players){
                board.printBoard();
                while (row < 0){
                    System.out.println("Input desired column (1-7) to put chip in: ");
                    col = Integer.parseInt(input.readLine())-1;
                    row = board.getY(col);
                }
                if (player.getChipColor() == ChipColor.YELLOW){
                    board.setCell(-1, col, row);
                }else{
                    board.setCell(1, col, row);
                }
                if(board.checkBoard(col, row)){
                    board.printBoard();
                    System.out.println("WINAR!");
                    board.setComplete();
                    break;
                }
                row = -1;
                col = 0;
            }
        }
        input.close();
    }
}
