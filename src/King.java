public class King extends Piece{
    private boolean inCheck;

    public King(String position,boolean isBlack){
        super(position,isBlack);
        symbol = 'K';
        inCheck = false;
    }

    // Kings can move in move 1 square in any direction
    public boolean isValidMove(String targetPosition,int row, int column){
        //convert position to row and column
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        // can't stand still
        if (targetRow == startRow && targetColumn == startColumn){
            return false;
        }
        // can't move more than one square in any direction
        if (Math.abs(startRow - targetRow) > 1){
            return false;
        }
        if (Math.abs(startColumn - targetColumn) > 1){
            return false;
        }
        //otherwise, we cool
        return true;
    }
}
