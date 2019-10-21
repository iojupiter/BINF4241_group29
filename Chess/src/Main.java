import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){

        Player player1 = new Player("Alice", "white");
        Player player2 = new Player("Bob", "black");
/*
        System.out.println(player1.getName());
        System.out.println(player1.getColor());




        Game game = new Game();
        String[][] board = game.getBoard();

        for(int i = 0; i < board.length; i++){
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.print(Arrays.deepToString(board[i]));
        }


 */


        //#######STRING TRANSLATION REGEX########
        /*
        System.out.print(Pattern.matches("[KQBNR][a-h|x]", "Kx")); //main move
        System.out.print(Pattern.matches("[KQBNR][x][a-h][1-8]", "Kxb6")); //main eat
        System.out.print(Pattern.matches("[a-h][1-8]", "d8")); //move pawn
        System.out.print(Pattern.matches("[x][a-h][1-8]", "xb8")); //eat pawn
*/
        //find coordinate mapping from letter literal


        System.out.println("Please enter your move: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        boolean validInputString = Pattern.matches("(([QKNBR]([x][a-h][1-8]|[a-h][1-8]))|([x][a-h][1-8]|[a-h][1-8]))", userInput);

        if(!validInputString){
            System.out.println("Please enter a valid move: ");
        }else{
            
        }

        //######################################



/*
        //######VALIDATE MOVE##########
        Game game = new Game();
        char[][][] boardBeforeMove = game.getBoard();
        System.out.println(Arrays.deepToString(boardBeforeMove));

        //!! GET THIS FROM TRANSLATION FUNCTION
        char playerColor = 'b';
        char figureType = 'N';
        int targetX = 2;
        int targetY = 2;

        ArrayList isValidMove = game.validateMove(playerColor, figureType, targetX, targetY);

        if(isValidMove.size() < 1){
            System.out.println("INVALID MOVE! PLEASE ENTER A CORRECT MOVE: ");
            //restart turn

        }else if(isValidMove.size() > 1){
            System.out.println("DISAMBIGUOUS MOVE! PLEASE SPECIFY START FIELD: ");
            //read starting pos again with position list

        }else{
            System.out.println("VALID MOVE");

            Object[] cell = Arrays.copyOf((Object[]) isValidMove.get(0), 2);
            char[] figureData = Arrays.copyOf((char[]) cell[0], 2); //figure data
            int[] figureXY = Arrays.copyOf((int[]) cell[1], 2); // figure coordinate

            //!! GET THIS FROM TRANSLATION FUNCTION
            int[] targetPosition = {targetX, targetY};

            game.updateBoard(figureData, figureXY, targetPosition);

            char[][][] boardAfterMove = game.getBoard();
            System.out.println(Arrays.deepToString(boardAfterMove));
        }
*/
    }

}
