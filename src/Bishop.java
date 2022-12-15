public class Bishop extends Piece{

    public Bishop(String position,Boolean isBlack){
        super(position,isBlack);
        symbol = 'b';
    }

    public boolean isValidMove(String targetPosition,int row,int column){
        if (super.isValidMove(targetPosition)==false){
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startColumn = ChessUtils.getColumnFromPosition(getPosition());
        int targetRow = ChessUtils.getRowFromPosition(targetPosition);
        int targetColumn = ChessUtils.getColumnFromPosition(targetPosition);

        if (Math.abs(startColumn - targetColumn) != (startRow - targetRow)){
            return false;
        }
        return true;
    }
}
