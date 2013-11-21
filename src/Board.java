/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 11/21/13
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private int[][] board;
    private final int width = 7;
    private final int height = 6;
    private boolean complete = false;

    public Board(){
        board = new int[height][width];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                board[y][x] = 0;
            }
        }
    }

    public int getCell(int x, int y){
        return board[y][x];
    }

    public void setCell(int input, int x, int y){
        board[y][x] = input;
    }

    public boolean isComplete(){
        return complete;
    }

    public void setComplete(){
        complete = true;
    }

    public int getY (int x){
        for(int y = height-1; y >= 0; y--){
            if(board[y][x] != 0){
                continue;
            }
            else{
                return y;
            }
        }
        System.out.println("Input not possible. Try again.");
        return -1;
    }

    public boolean checkBoard(int x, int y){
        int horizontalCount = getHorizontalCount(x, y);
        int verticalCount = getVerticalCount(x, y);
        int diagonalCountSouthWest = getDiagonalCountSouthWest(x, y);
        int diagonalCountNorthWest = getDiagonalCountNortWest(x, y);

        return hasFourInARow(
                horizontalCount,
                verticalCount,
                diagonalCountNorthWest,
                diagonalCountSouthWest
        );
    }

    public boolean hasFourInARow(int one, int two, int three, int four){
        if(one >= 4){
            return true;
        }
        if(two >= 4){
            return true;
        }
        else if(three >= 4){
            return true;
        }
        else if(four >= 4){
            return true;
        }
        return false;
    }

    public int getDiagonalCountSouthWest(int x, int y){
        int chipColor = board[y][x];
        int count = 1;
        for(int k = 1; y+k < height && x-k > 0 && k < 5; k++){
            if(chipColor == board[y+k][x-k]){
                count++;
            }
            else{
                break;
            }
        }
        for(int k = 1; y-k > 0 && x+k < width && k < 5; k++){
            if(chipColor == board[y-k][x+k]){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }

    public int getDiagonalCountNortWest(int x, int y){
        int chipColor = board[y][x];
        int count = 1;
        for(int k = 1; y-k > 0 && x-k > 0 && k < 5; k++){
            if(chipColor == board[y-k][x-k]){
                count++;
            }
            else{
                break;
            }
        }
        for(int k = 1; y+k < height && x+k < width && k < 5; k++){
            if(chipColor == board[y+k][x+k]){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }

    public int getHorizontalCount(int x, int y){
        int chipColor = board[y][x];
        int count = 1;
        System.out.println(chipColor);
        for(int k = x + 1; k < width && k < x + 5; k++){
            if(chipColor == board[y][k]){
                count++;
            }
            else{
                break;
            }
        }
        for(int j = x - 1; j >= 0 && j > x - 5; j--){
            if(chipColor == board[y][j]){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }

    public int getVerticalCount(int x, int y){
        int chipColor = board[y][x];
        int count = 1;
        for(int i = y+1; i < height && i < y + 5; i++){
            if(chipColor == board[i][x]){
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }

    public void printBoard(){
        System.out.println("------------------------------------");
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(board[y][x] == -1){
                    System.out.print("| " + board[y][x] + " ");
                }
                else{
                    System.out.print("|  " + board[y][x] + " ");
                }
            }
            System.out.println("|");
            System.out.println("------------------------------------");
        }
        System.out.println("------------------------------------");
        System.out.println("|  1 |  2 |  3 |  4 |  5 |  6 |  7 |");
    }
}
