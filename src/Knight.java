public class Knight extends Piece {
    public Knight (String position,boolean isBlack){
        super(position,isBlack);
        symbol = 'N';
    }

    public boolean isValidMove(String targetPosition,int row,int column){
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);
        // can't stand still
        if (targetRow == startRow && targetColumn == startColumn){
            return false;
        }
        if (Math.abs(startRow - targetRow) > 2 || Math.abs(startRow - targetRow) < 1){
            return false;
        }
        if (Math.abs(startColumn - targetColumn) > 2 || Math.abs(startColumn - targetColumn) < 1){
            return false;
        }
        if (Math.abs(startColumn - targetColumn) == Math.abs(startRow - targetRow)){
            return false;
        }
        return true;
    }
}
