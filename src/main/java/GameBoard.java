/**
 * A class that represents a game board for board games
 * @author Eric Wang
 * @version 1.0
 */
public class GameBoard {
    private String[][] board;
    private GamePiece[][] pieces;

    /**
     * Constructor for GameBoard given a 2d array of Strings representing the board, sets board to value provided
     * @param board the 2d String array that the game board will be set to
     */
    public GameBoard(String[][] board) {
        this.board = board;
        // may crash if the board is genuinely zero size
        pieces = new String[board.length][board[0].length];
    }
    /**
     * Default constructor for GameBoard class
     * Creates a 5x5 2d String array for board based on the following rules:
     * Top left tile is "Start", Bottom right is "End"
     * Every 4th tile starting from the top left is a "Bonus" tile
     * Every 6th tile starting from the top left is a "Penalty" tile
     * Penalty tiles override Bonus tiles
     * All remaining tiles are "Empty"
     */
    public GameBoard() {
        board = new String[5][5];
        int iter = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (iter%6 == 0) {
                    board[i][j] = "Penalty";
                } else if (iter%4 == 0) {
                    board[i][j] = "Bonus";
                } else {
                    board[i][j] = "Empty";
                }
            }
        }
        board[0][0] = "Start";
        board[board.length-1][board[0].length-1] = "End";
    }

    /**
     * Method that gets the number of rows of the board
     * @return returns the number of rows on the board as an int
     */
    public int getRows() {
        return board.length;
    }

    /**
     * Method that gets the number of columns on the board
     * @return returns the number of columns on the board as an int
     */
    public int getCols() {
        //might crash if the board is genuinely 0 length
        return board[0].length;
    }

    /**
     * A method that retrieves the String representation of the tile at a given index on the board
     * @param row the row (int, zero indexed) of the tile to be retrieved
     * @param col the column (int, zero indexed) of the tile to be retrieved
     * @return returns the tile (String) at the given location on the board
     * @throws IndexOutOfBoundsException Throws IndexOutOfBoundsException when the index of the tile isn't located inside the board
     */
    public String getTile(int row, int col) throws IndexOutOfBoundsException {
        if ((row < 0 || col < 0) || (row >= getRows() || col >= getCols())) {
            throw new IndexOutOfBoundsException("Index must be inside the board");
        }
        return board[row][col];
    }

    /**
     * A method that sets a tile (String) at a given index to a new value
     * The previous tile at that index will be overriden
     * @param row the row (int, zero indexed) of the tile to be replaced
     * @param col the column (int, zero indexed) of the tile to be replaced
     * @param type the new tile (String) that will be replacing the old tile at the given index
     * @throws IndexOutOfBoundsException Throws IndexOutOfBoundsException when index of the tile isn't located inside the board
     */
    public void setTile(int row, int col, String type) throws IndexOutOfBoundsException {
        if ((row < 0 || col < 0) || (row >= getRows() || col >= getCols())) {
            throw new IndexOutOfBoundsException("Index must be inside the board");
        }
        board[row][col] = type;
    }

    /**
     * A method that places a piece at a certain index on the board
     * Any previous piece on that tile will be overridden (?)
     * @param piece the GamePiece object that will be placed at the index on the board
     * @param row the row (int, zero indexed) that the piece will be placed
     * @param col the column (int, zero indexed) that the piece will be placed
     * @throws NullPointerException throws NullPointerException when the piece is null
     */
    public void placePiece(GamePiece piece, int row, int col) throws NullPointerException {
        if (piece == null) {
            throw new NullPointerException("piece cannot be null");
        }
        pieces[row][col] = piece;
    }

    /**
     * Method that removes and returns the GamePiece at a certain index
     * @param row the row (int, zero indexed) of the piece to be removed
     * @param col the column (int, zero indexed) of the piece to be removed
     * @return returns the GamePiece located at the index
     * @throws NullPointerException throws NullPointerException when there is no piece at the given index
     */
    public GamePiece removePiece(int row, int col) throws NullPointerException {
        if (!hasPiece(row, col)) {
            throw new NullPointerException("there must be a piece at the given index");
        }
        //it might matter if the gamepiece is literally the same one
        //probably not though
        GamePiece p = getPiece(row, col);
        pieces[row][col] = null;
        return p;
    }

    /**
     * Gets the piece at a certain index on the board
     * @param row the row (int, zero indexed) of the piece to be retrieved
     * @param col the column (int, zero indexed) of the piece to be retrieved
     * @return returns the GamePiece at the index, returns null if no piece is there
     */
    public GamePiece getPiece (int row, int col) {
        return pieces[row][col];
    }

    /**
     * Method that checks if there is a piece at a given index on the board
     * @param row row (int, zero indexed) of index to be checked
     * @param col column (int, zero indexed) of index to be checked
     * @return returns true if there is a piece, otherwise returns false if there isn't (if it is null)
     */
    public boolean hasPiece (int row, int col) {
        return pieces[row][col] != null;
    }

    public String toString () {
        String it = "";
        for (int i = 0; i < board.length; i++) {
            it += board[i][0];
            for (int j = 1; j < board[i].length; j++) {
                it += " | " + board[i][j];
                if (hasPiece(i, j)) {
                    it += "(" + pieces[i][j].toString() + ")";
                }
            }
            it += '\n';
        }
        return it;
    }
}