
/** This class models a Delek in the game. A Delek has
 *  a position and can advance towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        if(doc.getRow() > this.getRow() && doc.getCol() > this.getCol()){
            this.row++;
            this.col++;
        }else if(doc.getRow() < this.getRow() && doc.getCol() < this.getCol()){
            this.row--;
            this.col--;
        }else if(doc.getRow() > this.getRow() && doc.getCol() < this.getCol()){
            this.row++;
            this.col--;
        }else if(doc.getRow() < this.getRow() && doc.getCol() > this.getCol()){
            this.row--;
            this.col++;
        }else if(doc.getRow() > this.getRow()){
            this.row++;
        }else if(doc.getRow() < this.getRow()){
            this.row--;
        }else if(doc.getCol() > this.getCol()){
            this.col++;
        }else if(doc.getCol() < this.getCol()){
            this.col--;
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        return this.hasCrashed;
    }

}
