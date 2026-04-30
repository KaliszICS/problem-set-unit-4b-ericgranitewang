import java.util.*;
/**
 * A class that stores a stack of event tiles that do special things
 * @author Eric Wang
 * @version 1.0
 */
public class TileStack {
    ArrayList<String> stack;

    /**
     * Constructor for TileStack with a provided array of values that is converted into the stack
     * @param stack The String array of values that will become the TileStack
     */
    public TileStack (String[] stack) {
        this.stack = Arrays.asList(stack);
    }

    /**
     * Default constructor for TileStack that creates an empty ArrayList to act as the stack. 
     */
    public TileStack () {
        stack = new ArrayList<String>();
    }

    /**
     * Method that returns the number of elements in the stack
     * @return the number of elements in the stack (int)
     */
    public int size() {
        return stack.size();
    }

    /**
     * Method that adds a tile to the top of the stack
     * @param tile The String tile that will be added to the stack
     */
    public void push(String tile) {
        //do nothing if the tile is null or EMPTY?? what does that mean bruv like "" or "empty" or typo
        if (tile == null) {
            return;
        }
        stack.add(tile);
    }

    /**
     * Method that removes and returns the top element of the stack
     * @return Returns the String tile that was at the top of the stack
     */
    public String pop() {
        if (size() == 0) {
            return null;
        }
        String p = stack.get(size()-1);
        stack.remove(size()-1);
        return p;
    }

    /**
     * Method that returns the top element of the stack
     * @return Returns the top tile (String) of the stack
     */
    public String peek() {
        if (size() == 0) {
            return null;
        }
        return stack.get(size()-1);
    }

    /**
     * Method that removes all elements of the stack and returns them as a String array
     * @return Returns the stack as a String array
     */
    public String[] removeAll() {
        String[] temp = stack.toArray();
        stack = new ArrayList<String>();
        return temp;
    }

    /**
     * Overrides toString; method that converts the stack into a String representation
     * Format goes "element1, element2, ... , elementn"
     * @return Returns String representation of the stack.
     */
    @Override
    public String toString () {
        if (size()==0) {
            return "";
        }
        String it = stack.get(size()-1);
        for (int i = size()-2; i >= 0; i--) {
            it += ", " + stack.get(i);
        }
        return it;
    }
}