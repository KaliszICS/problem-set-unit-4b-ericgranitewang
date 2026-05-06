import java.util.Objects;

/**
 * A simple class to represent a game piece
 * @author Eric Wang
 * @version 1.1
 */
public class GamePiece {
    private String label;
    private String color;
    private int pointValue;

    /**
     * Constructor for gamepiece class, takes in label color and pointValue
     * @param label String, represents name of the piece (rook, snake, etc.)
     * @param color String, represents colour of the piece (red, black, etc.)
     * @param pointValue int, represents the point value assigned to the piece
     */
    public GamePiece (String label, String color, int pointValue) {
        this.label = label;
        this.color = color;
        this.pointValue = pointValue;
    }

    /**
     * Method that gets the label of the piece
     * @return returns the label (name) of the piece as a String
     */
    public String getLabel() {
        return label;
    }

    /**
     * Method that gets the colour of a piece
     * @return returns the colour (color) of the piece as a String
     */
    public String getColor() {
        return color;
    }

    /**
     * Method that gets the point value of the piece
     * @return returns the point value (pointValue) of the piece as an int
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * Represents the piece as a string; overriden from the original toString() method
     * @return returns the String representation of a GamePiece in format "color label" (e.g. black pawn)
     */
    @Override
    public String toString() {
        return color + " " + label;
    }

    /**
     * Method that checks if two game pieces are equal (all 3 variables must be equal)
     * @param othe the other GamePiece object to be compared
     * @return returns true if all three variables are equal, otherwise returns false
     */
    @Override
    public boolean equals(Object othe) {
        if (othe == null) {
            return false;
        }
        if (othe.getClass() != this.getClass()) {
            return false;
        }
        GamePiece other = (GamePiece)othe; // null ?
        //maybe add some more checks ? idk
        return (this.label.equals(other.getLabel()) && this.color.equals(other.getColor())) && this.pointValue==other.getPointValue();
    }

    /**
     * New override method for HashCode to make things work better
     * @return returns the hash of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(label, color, pointValue);
    }

}