import java.util.*;

/**
 * A class that represents a player of the board game
 * @author Eric Wang
 * @version 1.0
 */
public class Player {
    private String name;
    private int age;
    private ArrayList<GamePiece> inventory;

    /**
     * Constructor for Player that takes in name and age and constructs an empty GamePiece ArrayList for the inventory
     * @param name String, the name of the player
     * @param age int, the age of the player
     */
    public Player (String name, int age) {
        this.name = name;
        this.age = age;
        inventory = new ArrayList<GamePiece>();
    }

    /**
     * Constructor that takes in name, age, and a given inventory for the Player
     * @param name String, the name of the player
     * @param age int, the age of the player
     * @param inventory Gamepiece[], the player's inventory of pieces
     */
    public Player (String name, int age, GamePiece[] inventory) {
        this.name = name;
        this.age = age;
        this.inventory = new ArrayList<GamePiece>();
        this.inventory.addAll(Arrays.asList(inventory));
    }

    /**
     * Method that gets the name of the player
     * @return Returns String name of player
     */
    public String getName () {
        return name;
    }

    /**
     * Method that gets the age of the player
     * @return Returns int age of player
     */
    public int getAge () {
        return age;
    }

    /**
     * Method that gets the inventory of the player
     * @return Returns inventory of the player as a GamePiece array
     */
    public GamePiece[] getInventory () {
        GamePiece[] temp = new GamePiece[size()];
        for (int i = 0; i < size(); i++) {
            temp[i] = inventory.get(i);
        }
        return temp;
    }

    /**
     * Method that gets size of inventory
     * @return Returns size of inventory (int)
     */
    public int size() {
        return inventory.size();
    }

    /**
     * A method that allows a player to pick up a piece from a gameboard, removing the piece and adding it to their inventory
     * @param board The GameBoard object that represents the gameboard
     * @param row The row of the piece to be picked up
     * @param col The column of the piece to be picked up
     * @throws NullPointerException Throws NullPointerException when there is no piece at the given index
     */
    public void pickUp (GameBoard board, int row, int col) throws NullPointerException {
        if (!board.hasPiece(row, col)) {
            throw new NullPointerException("Piece does not exist at the given index");
        }
        inventory.add(board.removePiece(row, col));
    }

    /**
     * A method that discards a piece from the player's inventory
     * @param piece The GamePiece to be discarded
     * @throws NullPointerException Throws NullPointerException if the piece is not present in the player's inventory
     */
    public void discardPiece (GamePiece piece) throws NullPointerException {
        int index = inventory.indexOf(piece);
        if (index == -1) {
            throw new NullPointerException("Piece must exist in inventory");
        }
        inventory.remove(index);
    }

    /**
     * Method that allows the player to place a piece from their inventory onto the game board
     * @param piece The piece to be placed from the inventory
     * @param board The gameboard that is being used
     * @param row The row that the piece will be placed on
     * @param col The column that the piece will be placed on
     * @throws NullPointerException Throws NullPointerException when the piece does not exist in the inventory
     */
    public void returnPiece (GamePiece piece, GameBoard board, int row, int col) throws NullPointerException {
        if (inventory.indexOf(piece) == -1) {
            throw new NullPointerException("Piece must exist in inventory");
        }
        discardPiece(piece);
        board.placePiece(piece, row, col);
    }

    /**
     * Method that overrides toString, expresses the player as a String representation
     * Format follows name, age, item1, item2, ....
     * @return Returns the String representation of the Player
     */
    @Override
    public String toString () {
        String it = name + ", " + age;
        for (int i = 0; i < size(); i++) {
            it += ", " + inventory.get(i).toString();
        }
        it += ".";
        return it;
    }
}