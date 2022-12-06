public class King extends Piece{
    private boolean inCheck;

    public King(String position,boolean isBlack){
        super(position,isBlack);
        symbol = 'K';
        inCheck = false;
    }

    // Kings can move in move 1 square in any direction
    public boolean isValidMove(String targetPosition){
        //split the target position and make the letter into an int
        char letter = targetPosition.toCharArray()[0];
        int currentAsciiValue = letter;
        char number = targetPosition.toCharArray()[1];
        int currentNum = number;
        //split the target position the same way as the current
        
        
        //take the current position of the piece and check whether it is one away from the current position
        //if it is return true
        //else return false
    }
}
