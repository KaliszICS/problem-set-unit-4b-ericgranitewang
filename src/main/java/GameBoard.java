/**
 * A class that represents a game board for board games
 * @author Eric Wang
 * @version 1.1
 */
public class GameBoard {
    private String[][] board;
    private GamePiece[][] pieces;

    /**
     * Constructor for GameBoard given a 2d array of Strings representing the board, sets board to value provided
     * @param board the 2d String array that the game board will be set to
     */
    public GameBoard(String[][] board) throws IllegalArgumentException {
        if ((board.length <= 0 || board[0].length <= 0) || (board.length == 1 && board[0].length == 1)) {
            throw new IllegalArgumentException("The board must be at least 2 tiles in size");
        }
        this.board = board;
        this.pieces = new GamePiece[board.length][board[0].length];
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
        this.board = new String[5][5];
        int iter = 1;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (iter%6 == 0) {
                    this.board[i][j] = "Penalty";
                } else if (iter%4 == 0) {
                    this.board[i][j] = "Bonus";
                } else {
                    this.board[i][j] = "Empty";
                }
                iter++;
            }
        }
        this.board[0][0] = "Start";
        this.board[this.board.length-1][this.board[0].length-1] = "End";
        this.pieces = new GamePiece[this.board.length][this.board[0].length];
    }

    /**
     * Method that gets the number of rows of the board
     * @return returns the number of rows on the board as an int
     */
    public int getRows() {
        return this.board.length;
    }

    /**
     * Method that gets the number of columns on the board
     * @return returns the number of columns on the board as an int
     */
    public int getCols() {
        return this.board[0].length;
    }

    /**
     * A method that retrieves the String representation of the tile at a given index on the board
     * @param row the row (int, zero indexed) of the tile to be retrieved
     * @param col the column (int, zero indexed) of the tile to be retrieved
     * @return returns the tile (String) at the given location on the board
     * @throws IndexOutOfBoundsException Throws IndexOutOfBoundsException when the index of the tile isn't located inside the board
     */
    public String getTile(int row, int col) throws IndexOutOfBoundsException {
        if ((row < 0 || col < 0) || (row >= this.board.length || col >= this.board[0].length)) {
            throw new IndexOutOfBoundsException("Index must be inside the board");
        }
        return this.board[row][col];
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
        if ((row < 0 || col < 0) || (row >= this.board.length || col >= this.board[0].length)) {
            throw new IndexOutOfBoundsException("Index must be inside the board");
        }
        this.board[row][col] = type;
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
        this.pieces[row][col] = piece;
    }

    /**
     * Method that removes and returns the GamePiece at a certain index
     * @param row the row (int, zero indexed) of the piece to be removed
     * @param col the column (int, zero indexed) of the piece to be removed
     * @return returns the GamePiece located at the index
     * @throws NullPointerException throws NullPointerException when there is no piece at the given index
     */
    public GamePiece removePiece(int row, int col) throws NullPointerException {
        if (!this.hasPiece(row, col)) {
            throw new NullPointerException("there must be a piece at the given index");
        }
        GamePiece p = this.pieces[row][col];
        this.pieces[row][col] = null;
        return p;
    }

    /**
     * Gets the piece at a certain index on the board
     * @param row the row (int, zero indexed) of the piece to be retrieved
     * @param col the column (int, zero indexed) of the piece to be retrieved
     * @return returns the GamePiece at the index, returns null if no piece is there
     */
    public GamePiece getPiece (int row, int col) {
        return this.pieces[row][col];
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

    /**
     * Overrides toString method; expresses the board as a String representation
     * The board is formatted as tiles separated by |
     * If a tile has a piece on it, it is appended to the end of the tile in parentheses
     * @return returns the String representation of the board
     */
    @Override
    public String toString () {
        String it = "";
        for (int i = 0; i < this.board.length; i++) {
            it += this.board[i][0];
            if (this.hasPiece(i, 0)) {
                it += "(" + this.pieces[i][0].toString() + ")";
            }
            for (int j = 1; j < this.board[i].length; j++) {
                it += " | " + this.board[i][j];
                if (this.hasPiece(i, j)) {
                    it += "(" + this.pieces[i][j].toString() + ")";
                }
            }
            if (i != this.board.length - 1) {
                it += '\n';
            }
        }
        return it;
    }

    /**
     * Method that resets the board and pieces
     * All tiles on the board except "Start" and "End" are set to empty
     * All GamePieces on the board are removed
     */
    public void resetBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (!(this.board[i][j].equals("Start") || this.board[i][j].equals("End"))) {
                    this.board[i][j] = "Empty";
                }
            }
        }
        this.pieces = new GamePiece[this.board.length][this.board[0].length];
    }

    /**
     * Method that fills board based on a given array of tiles
     * If there aren't enough tiles in the array it loops around to index 0
     * @param tiles the String array from which tiles are taken and put onto the board
     */
    public void fillFrom(String[] tiles) {
        int iter = 0;
        if (tiles == null || tiles.length == 0) {
            return;
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = tiles[iter%tiles.length];
                iter++;
            }
        }
    }
}