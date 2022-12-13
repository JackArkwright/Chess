public class Knight extends Piece {
    public Knight (String position,boolean isBlack){
        super(position,isBlack);
        symbol = 'N';
    }

    public boolean isValidMove(String targetPosition,int row,int column){
        if (super.isValidMove(targetPosition)==false){
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        int rowDiff = (Math.abs(startRow - targetRow));
        int colDiff = (Math.abs(startColumn - targetColumn));
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)){
            return true;
        }
        return false;
    }
}
