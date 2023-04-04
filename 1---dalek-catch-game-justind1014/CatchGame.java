import java.util.Random;
/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {
    
    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */

    private Board board;
    private Doctor doc;
    private Dalek dalekOne;
    private Dalek dalekTwo;
    private Dalek dalekThree;
    private boolean gameDone;

    /**
     * The constructor for the game.
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        Random constructorRandom = new Random();
        this.board = new Board(12,12);

        int docStartRow = constructorRandom.nextInt(12);
        int docStartCol = constructorRandom.nextInt(12);
        this.doc = new Doctor(docStartRow, docStartCol);
        this.dalekOne = new Dalek(8,9);
        this.dalekTwo = new Dalek(2,10);
        this.dalekThree = new Dalek(6,2);
        this.board.putPeg(Board.BLUE,docStartRow, docStartCol);
        this.board.putPeg(Board.BLACK,8,9);
        this.board.putPeg(Board.BLACK,2,10);
        this.board.putPeg(Board.BLACK,6,2);
        this.gameDone = false;
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while(true){
            Random random = new Random();

        if(this.gameDone == false){
            Coordinate click = this.board.getClick();
            this.board.removePeg(doc.getRow(), doc.getCol());
            if(click.getRow() == doc.getRow() && click.getCol() == doc.getCol()){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()+1 && click.getCol() == doc.getCol()){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow() && click.getCol() == doc.getCol()+1){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()+1 && click.getCol() == doc.getCol()+1){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()-1 && click.getCol() == doc.getCol()){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow() && click.getCol() == doc.getCol()-1){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()-1 && click.getCol() == doc.getCol()-1){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()+1 && click.getCol() == doc.getCol()-1){
                this.doc.move(click.getRow(), click.getCol());
            }else if(click.getRow() == doc.getRow()-1 && click.getCol() == doc.getCol()+1){
                this.doc.move(click.getRow(), click.getCol());
            }else{
                int randomRow = random.nextInt(12);
                int randomCol = random.nextInt(12);
                this.doc.move(randomRow, randomCol);
            }
            this.board.putPeg(Board.BLUE, doc.getRow(), doc.getCol());
        }

        if(this.gameDone == false){
            // move the dalek towards the doctor
            if(dalekOne.hasCrashed() == false){
                this.board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                this.dalekOne.advanceTowards(doc);
                this.board.putPeg(Board.BLACK, dalekOne.getRow(), dalekOne.getCol());
            }
           
            if(dalekTwo.hasCrashed() == false){
                this.board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                this.dalekTwo.advanceTowards(doc);
                this.board.putPeg(Board.BLACK, dalekTwo.getRow(), dalekTwo.getCol());
            }
           
            if(dalekThree.hasCrashed() == false){
                this.board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                this.dalekThree.advanceTowards(doc);
                this.board.putPeg(Board.BLACK, dalekThree.getRow(), dalekThree.getCol());
            }
        }
            
            //check if dalek overlayes with another dalek
            //if it does set it to hasCrashed
            if(dalekOne.getRow() == dalekTwo.getRow() && dalekOne.getCol() == dalekTwo.getCol()){
                dalekOne.crash();
                this.board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                this.board.putPeg(Board.RED, dalekOne.getRow(), dalekOne.getCol());
                dalekTwo.crash();
                this.board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                this.board.putPeg(Board.RED, dalekTwo.getRow(), dalekTwo.getCol());
            }else if(dalekOne.getRow() == dalekThree.getRow() && dalekOne.getCol() == dalekThree.getCol()){
                dalekOne.crash();
                this.board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                this.board.putPeg(Board.RED, dalekOne.getRow(), dalekOne.getCol());
                dalekThree.crash();
                this.board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                this.board.putPeg(Board.RED, dalekThree.getRow(), dalekThree.getCol());
            }else if(dalekTwo.getRow() == dalekThree.getRow() && dalekTwo.getCol() == dalekThree.getCol()){
                dalekTwo.crash();
                this.board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                this.board.putPeg(Board.RED, dalekTwo.getRow(), dalekTwo.getCol());
                dalekThree.crash();
                this.board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                this.board.putPeg(Board.RED, dalekThree.getRow(), dalekThree.getCol());
            }else if(dalekTwo.getRow() == dalekOne.getRow() && dalekTwo.getCol() == dalekOne.getCol()){
                dalekOne.crash();
                this.board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                this.board.putPeg(Board.RED, dalekOne.getRow(), dalekOne.getCol());
                dalekTwo.crash();
                this.board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                this.board.putPeg(Board.RED, dalekTwo.getRow(), dalekTwo.getCol());
            }else if(dalekThree.getRow() == dalekOne.getRow() && dalekThree.getCol() == dalekOne.getCol()){
                dalekOne.crash();
                this.board.removePeg(dalekOne.getRow(), dalekOne.getCol());
                this.board.putPeg(Board.RED, dalekOne.getRow(), dalekOne.getCol());
                dalekThree.crash();
                this.board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                this.board.putPeg(Board.RED, dalekThree.getRow(), dalekThree.getCol());
            }else if(dalekThree.getRow() == dalekTwo.getRow() && dalekThree.getCol() == dalekTwo.getCol()){
                dalekTwo.crash();
                this.board.removePeg(dalekTwo.getRow(), dalekTwo.getCol());
                this.board.putPeg(Board.RED, dalekTwo.getRow(), dalekTwo.getCol());
                dalekThree.crash();
                this.board.removePeg(dalekThree.getRow(), dalekThree.getCol());
                this.board.putPeg(Board.RED, dalekThree.getRow(), dalekThree.getCol());
            }

            if(dalekOne.getRow() == dalekTwo.getRow()
                && dalekOne.getRow() == dalekThree.getRow()
                && dalekOne.getCol() == dalekTwo.getCol()
                && dalekOne.getCol() == dalekThree.getCol()){
                    this.board.displayMessage("You Win!");
                    this.gameDone = true;
                }
            
            if(dalekOne.getRow() == doc.getRow()
                && dalekOne.getCol() == doc.getCol()){
                    this.board.displayMessage("You Lose...");
                    this.gameDone = true;
            }else if(dalekTwo.getRow() == doc.getRow()
                && dalekTwo.getCol() == doc.getCol()){
                    this.board.displayMessage("You Lose...");
                    this.gameDone = true;
            }else if(dalekThree.getRow() == doc.getRow()
                && dalekThree.getCol() == doc.getCol()){
                    this.board.displayMessage("You Lose...");
                    this.gameDone = true;
                }

        }
    }
}


