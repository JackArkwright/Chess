import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rook extends Piece{
    private boolean hasCastled;

    public Rook(String position,boolean isBlack){
        super(position, isBlack);
        symbol = 'r';
    }
    // rooks can move horizontally or vertically arbitrarily far
    public boolean isValidMove(String targetPosition,int row,int column) {
        if (super.isValidMove(targetPosition) == false) {
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        //have we moved horizontally or vertically?
        if ((startRow == targetRow) || (startColumn == targetColumn)) {
            return true;
        }
        //all other moves are illegal
        return false;
    }
    // returns a list of all positions the piece moves through
    // excluding the start (and end)?
    public ArrayList<String> passThrough(String targetPosition){
        // position to row and column
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        ArrayList<String> squares = new ArrayList<>();
        if(isValidMove(targetPosition)){
            int row = startRow+1;
            do {
                int col = startColumn+1;
                do{
                    squares.add(ChessUtils.getPositionFromCoords(row,col));
                    col++;
                } while (col<targetColumn);
                row++;
            } while (row<targetRow);
        }
        squares.remove(0);
        return squares;
    }
}
