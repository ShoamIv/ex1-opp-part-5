import java.util.ArrayList;
import java.util.Comparator;

public abstract class ConcretePiece implements Piece {
    private ConcretePlayer owner;
    String type;
    private ArrayList<Position> positionsArrayList = new ArrayList<Position>(); //should be depreciated
    private int steps = 0;
    private int squares = 0;
    private int id; // save id of piece according to the figure in the assignment


    public ConcretePiece(ConcretePlayer p, int index) {
        owner = p;
        id = index;
        p.addConcretePiece(this);
    }

    public ConcretePiece(ConcretePlayer p, int index, String t) {
        owner = p;
        id = index;
        type = t;
        p.addConcretePiece(this);
    }
    /**
     * Get the player who owns the piece.
     *
     * @return The player who is the owner of this game piece.
     */
    @Override
    public ConcretePlayer getOwner() {
        return owner;
    }

    /**
     * add squares to squares history and update total steps (moves e.g);
     * @param append
     */
    public void add_squares(int append) {
        squares += append;
        steps++;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": ";
    }

    public boolean isPawn() {
        return this instanceof Pawn;
    }

    public boolean isKing() {
        return this instanceof King;
    }

    public int getSteps() {
        return steps;
    }

    public int getSquares() {
        return squares;
    }

    public int getWins() {
        return this.owner.getWins();
    }
}

class SortBySquares implements Comparator<ConcretePiece> {

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     *
     * @param p1 the first ConcretePiece to be compared.
     * @param p2 the second ConcretePiece to be compared.
     * @return a negative integer,  or a positive integer as the
     * first argument is less than or greater than the
     * second.
     */
    @Override
    public int compare(ConcretePiece p1, ConcretePiece p2) {
        if (p1.getSquares() < p2.getSquares()) {
            return 1;
        } else {
            if (p1.getSquares() == p2.getSquares()) {
                if (p1.getId() > p2.getId()) {
                    return 1;
                } else {
                    if (p1.getId() == p2.getId()) {
                        if (p1.getWins() < p2.getWins()) {
                            return 1;
                        }
                        return -1;
                    }
                    return -1;
                }

            }
            return -1;
        }

    }
}

class SortBySteps implements Comparator<ConcretePiece> {

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * This comparator sorts ConcretePiece-s according to their steps,
     * Compares its two arguments for order.  Returns a negative integer,
     *  or a positive integer as the first argument is less than
     *  or greater than the second.
     *
     * @param p1 the first ConcretePiece to be compared.
     * @param p2 the second ConcretePiece to be compared.
     * @return a negative integer or a positive integer as the
     * first argument is less than or greater than the
     * second according to the requirements given in the exercise.
     */
    @Override
    public int compare(ConcretePiece p1, ConcretePiece p2) {
        if (p1.getSteps() > p2.getSteps()) {
            return 1;
        } else {
            if (p1.getSteps() == p2.getSteps()) {
                if (p1.getId() > p2.getId()) {
                    return 1;
                } else {
                    return -1;
                }

            }
        }
        return -1;
    }
}
