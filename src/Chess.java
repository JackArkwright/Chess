import java.util.ArrayList;
import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    //set up the board for the start of the game
    public Chess() {
        board = new Piece[8][8];
        //create pieces
        for (int c=0; c<8; c++){
            board[1][c] = new Piece(1,c,false);
            board[6][c] = new Piece (6,c,true);
        }
        board[0][4] = new King("E1",false);
        board[7][4] = new King("E8",true);
        board[0][1] = new Knight("B1",false);
        board[0][6] = new Knight("G1",false);
        board[7][1] = new Knight("B8",true);
        board[7][6] = new Knight("G8",true);
        board[0][0] = new Rook("A1",false);
        board[0][7] = new Rook("H1",false);
        board[7][0] = new Rook("A8",true);
        board[7][7] = new Rook("H8",true);
    }

    //print the current board layout
    public void display(){
        int[] numbers = {1,2,3,4,5,6,7,8};
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int r=0; r<8; r++){
            System.out.print(numbers[r] + "  ");
            for (int c=0; c<8; c++) {
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + "  ");
                } else {
                    System.out.print("   "); // blank square
                }
            }
            System.out.print(numbers[r]);
            System.out.println(); // start a new row
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    //takes chess co-ords e.g. A8 and returns a piece or null
    public Piece getPieceAt(String position){
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        return board[row][column];
    }

    // take input from the user for a chess move and validate it
    public void move(){
        Scanner input  = new Scanner(System.in);
        System.out.print("Enter the piece to move: ");
        String startPosition = input.nextLine();
        System.out.print("Enter the square to move to: ");
        String endPosition = input.nextLine();
        Piece toMove = getPieceAt(startPosition);
        boolean validMove = false;
        if (toMove != null) {
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove) {

            ArrayList<String> squares = toMove.passesThrough(endPosition);
            System.out.println(toMove.getSymbol() + " moves to " + endPosition);
            int startRow = ChessUtils.getRowFromPosition(startPosition);
            int startColumn = ChessUtils.getColumnFromPosition(startPosition);
            int targetRow = ChessUtils.getRowFromPosition(endPosition);
            int targetColumn = ChessUtils.getColumnFromPosition(endPosition);
            //actually update the board
            board[targetRow][targetColumn] = board[startRow][startColumn];
            board[startRow][startColumn] = null;
        } else {
            System.out.println("You can't do that!");
        }

    }
}
