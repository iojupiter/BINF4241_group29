import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Game {

    private char[][][] board;

    private Rook bR1 = new Rook('R', 'b', 0, 0);
    private Rook bR2 = new Rook('R', 'b', 0, 7);
    private Rook wR1 = new Rook('R', 'w', 7, 0);
    private Rook wR2 = new Rook('R', 'w', 7, 7);

    private Horse bN1 = new Horse('N', 'b', 0, 1);
    private Horse bN2 = new Horse('N', 'b', 0, 6);
    private Horse wN1 = new Horse('N', 'w', 7, 1);
    private Horse wN2 = new Horse('N', 'w', 7, 6);

    private Bishop bB1 = new Bishop('B', 'b', 0, 3);
    private Bishop bB2 = new Bishop('B', 'b', 0, 5);
    private Bishop wB1 = new Bishop('B', 'w', 7, 3);
    private Bishop wB2 = new Bishop('B', 'w', 7, 5);

    private Queen bQ1 = new Queen('Q', 'b', 0, 3);
    private Queen wQ1 = new Queen('Q', 'w', 7, 3);

    private King bK1 = new King('K', 'b', 0, 4);
    private King wK1 = new King('K', 'w', 7, 4);

    private Pawn wP1 = new Pawn('p', 'w', 6, 0);
    private Pawn wP2 = new Pawn('p', 'w', 6, 1);
    private Pawn wP3 = new Pawn('p', 'w', 6, 2);
    private Pawn wP4 = new Pawn('p', 'w', 6, 3);
    private Pawn wP5 = new Pawn('p', 'w', 6, 4);
    private Pawn wP6 = new Pawn('p', 'w', 6, 5);
    private Pawn wP7 = new Pawn('p', 'w', 6, 6);
    private Pawn wP8 = new Pawn('p', 'w', 6, 7);

    private Pawn bP1 = new Pawn('p', 'b', 1, 0);
    private Pawn bP2 = new Pawn('p', 'b', 1, 1);
    private Pawn bP3 = new Pawn('p', 'b', 1, 2);
    private Pawn bP4 = new Pawn('p', 'b', 1, 3);
    private Pawn bP5 = new Pawn('p', 'b', 1, 4);
    private Pawn bP6 = new Pawn('p', 'b', 1, 5);
    private Pawn bP7 = new Pawn('p', 'b', 1, 6);
    private Pawn bP8 = new Pawn('p', 'b', 1, 7);


    public Game() {
        board = new char[][][]
                {
                        {{bR1.getName(), bR1.getColor()}, {bN1.getName(), bN1.getColor()}, {bB1.getName(), bB1.getColor()}, {bQ1.getName(), bQ1.getColor()}, {bK1.getName(), bK1.getColor()}, {bB2.getName(), bB2.getColor()}, {bN2.getName(), bN2.getColor()}, {bR2.getName(), bR2.getColor()}},
                        {{bP1.getName(), bP1.getColor()}, {bP2.getName(), bP2.getColor()}, {bP3.getName(), bP3.getColor()}, {bP4.getName(), bP4.getColor()}, {bP5.getName(), bP5.getColor()}, {bP6.getName(), bP6.getColor()}, {bP7.getName(), bP7.getColor()}, {bP8.getName(), bP8.getColor()}},
                        {{}, {}, {}, {}, {}, {}, {}, {}},
                        {{}, {}, {}, {'3'}, {}, {}, {}, {}},
                        {{}, {}, {}, {}, {}, {}, {}, {}},
                        {{}, {}, {}, {}, {}, {}, {}, {}},
                        {{wP1.getName(), wP1.getColor()}, {wP2.getName(), wP2.getColor()}, {wP3.getName(), wP3.getColor()}, {wP4.getName(), wP4.getColor()}, {wP5.getName(), wP5.getColor()}, {wP6.getName(), wP6.getColor()}, {wP7.getName(), wP7.getColor()}, {wP8.getName(), wP8.getColor()}},
                        {{wR1.getName(), wR1.getColor()}, {wN1.getName(), wN1.getColor()}, {wB1.getName(), wB1.getColor()}, {wQ1.getName(), wQ1.getColor()}, {wK1.getName(), wK1.getColor()}, {wB2.getName(), wB2.getColor()}, {wN2.getName(), wN2.getColor()}, {wR2.getName(), wR2.getColor()}}
                };

    }

    public char[][][] getBoard() {
        return board;
    }


    public boolean validateMove(char playerColor, char figureType, int x, int y) {

        ArrayList actualPositions = new ArrayList();

        if (figureType == 'K') {
            King king = new King('K', 'C', 10, 10);
            //king.move(x, y, board);
            actualPositions = king.move(x, y, board);
        } else if (figureType == 'Q') {
            Queen queen = new Queen('Q', 'C', 10, 10);
            //queen.move(x, y, board);
            actualPositions = queen.move(x, y, board);
        } else if (figureType == 'B') {
            Bishop bishop = new Bishop('B', 'C', 10, 10);
            //bishop.move(x, y, board);
            actualPositions = bishop.move(x, y, board);
        } else if (figureType == 'N') {
            Horse horse = new Horse('N', 'C', 10, 10);
            //horse.move(x, y, board);
            actualPositions = horse.move(x, y, board);
        } else if (figureType == 'R') {
            Rook rook = new Rook('R', 'C', 10, 10);
            //rook.move(x, y, board);
            actualPositions = rook.move(x, y, board);
        } else if (figureType == 'p') {
            Pawn pawn = new Pawn('P', 'C', 10, 10);
            //pawn.move(x, y, board);
            actualPositions = pawn.move(x, y, board);
        }


        boolean validMove = false;

        for(int i=0;i<actualPositions.size();i++){
            char[] cell = Arrays.copyOf((char[]) actualPositions.get(i), 2);
            System.out.println("FIGURE TYPE: "+cell[0] + " COLOR: " + cell[1]);
            if(cell[0] == figureType && cell[1] == playerColor){
                System.out.println("FIGURE FOUND");
                validMove = true;
            }
        }

        return validMove;
    }

    public void updateBoard(char playerColor, char figureType, int[] startPosition, int[] targetPosition){

        System.out.println("START POSITION: "+ startPosition[0] + " " + startPosition[1]);
        System.out.println("TARGET POSITION: " + targetPosition[0]+ " " + targetPosition[1]);

        //create new  figure cell
        char[] newFigureCell = {figureType, playerColor};
        //create new empty cell
        char[] newEmptyCell = {};

        //Affect changes to board
        board[targetPosition[0]][targetPosition[1]] = newFigureCell;
        board[startPosition[0]][startPosition[1]] = newEmptyCell;

    }

}