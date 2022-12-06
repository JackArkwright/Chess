public class King extends Piece{
    private boolean inCheck;

    public King(String position,boolean isBlack){
        super(position,isBlack);
        symbol = 'K';
        inCheck = false;
    }

    // Kings can move in move 1 square in any direction
    public boolean isValidMove(String targetPosition){
        //take in the new position they want to move into
        char letter = targetPosition[0].;
        //split the target position and make the letter into an int
        //take the current position of the piece and check whether it is one away from the current position
        //if it is return true
        //else return false
    }
}
