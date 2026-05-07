import java.util.*;
/**
 * A class that stores a stack of event tiles that do special things
 * @author Eric Wang
 * @version 1.0.3
 */
public class TileStack {
    private ArrayList<String> stack;

    /**
     * Constructor for TileStack with a provided array of values that is converted into the stack
     * @param stack The String array of values that will become the TileStack
     */
    public TileStack (String[] stack) {
        this.stack = new ArrayList<String>();
        this.stack.addAll(Arrays.asList(stack));
    }

    /**
     * Default constructor for TileStack that creates an empty ArrayList to act as the stack. 
     */
    public TileStack () {
        this.stack = new ArrayList<String>();
    }

    /**
     * Method that returns the number of elements in the stack
     * @return the number of elements in the stack (int)
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * Method that adds a tile to the top of the stack
     * @param tile The String tile that will be added to the stack
     * @throws NullPointerException Throws NullPointerException if the tile is null
     */
    public void push(String tile) throws NullPointerException {
        if (tile == null) {
            throw new NullPointerException("Tile cannot be null");
        }
        this.stack.add(tile);
    }

    /**
     * Method that removes and returns the top element of the stack
     * @return Returns the String tile that was at the top of the stack, returns null if stack is empty
     */
    public String pop() {
        if (this.stack.size() == 0) {
            return null;
        }
        return this.stack.remove(this.stack.size()-1); 
    }

    /**
     * Method that returns the top element of the stack
     * @return Returns the top tile (String) of the stack, returns null if stack is empty
     */
    public String peek() {
        if (this.stack.size() == 0) {
            return null;
        }
        return this.stack.get(this.stack.size()-1);
    }

    /**
     * Method that removes all elements of the stack and returns them as a String array
     * @return Returns the stack as a String array
     */
    public String[] removeAll() {
        String[] temp = new String[this.stack.size()];
        for (int i = 0; i < this.stack.size(); i++) {
            temp[i] = this.stack.get(i);
        }
        this.stack.clear();
        return temp;
    }

    /**
     * Overrides toString; method that converts the stack into a String representation with a list of tiles starting from the top of the stack
     * Format goes "element_n, element_n-1, ... , element_1."
     * @return Returns String representation of the stack.
     */
    @Override
    public String toString () {
        if (this.stack.size()==0) {
            return "";
        }
        String it = this.stack.get(this.stack.size()-1);
        for (int i = this.stack.size()-2; i >= 0; i--) {
            it += ", " + this.stack.get(i);
        }
        it += ".";
        return it;
    }
}