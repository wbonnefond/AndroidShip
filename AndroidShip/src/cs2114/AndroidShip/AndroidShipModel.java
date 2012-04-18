package cs2114.AndroidShip;

/**
 *  This defines the model for the AndroidShip game.
 *
 *  @author Ward Bonnefond (wardwdb)
 *  @author Tyler Ritchie (ritchie4)
 *  @author Nick Crowder (crowdern)
 *  @version Apr 16, 2012
 */

public class AndroidShipModel {

    private AndroidShipBoard player1Board;
    private AndroidShipBoard player2Board;
    private AndroidShipBoard currentPlayerBoard;

    /**
     * Constructor for AndroidShipModel
     */
    public AndroidShipModel() {
        player1Board = new AndroidShipBoard();
        player2Board = new AndroidShipBoard();
        currentPlayerBoard = player1Board;
    }

    // ----------------------------------------------------------
    /**
     * Switches the current board to the other player.
     */
    public void switchBoard() {
        if (currentPlayerBoard == player1Board) {
            currentPlayerBoard = player2Board;
        }
        else {
            currentPlayerBoard = player1Board;
        }
    }

    public boolean fireAtBoard(int xCoor, int yCoor) {
        boolean firedSuccessful = false;
        if (currentPlayerBoard == player1Board) {
            if (player2Board.getCell(xCoor, yCoor) == Cell.SHIP) {
                player2Board.setCell(xCoor, yCoor, Cell.HIT);
                firedSuccessful = true;
            }
            else if (player2Board.getCell(xCoor, yCoor) == Cell.WATER) {
                player2Board.setCell(xCoor, yCoor, Cell.MISS);
                firedSuccessful = true;
            }
        }
        else {
            if (player1Board.getCell(xCoor, yCoor) == Cell.SHIP) {
                player1Board.setCell(xCoor, yCoor, Cell.HIT);
                firedSuccessful = true;
            }
            else if (player1Board.getCell(xCoor, yCoor) == Cell.WATER) {
                player1Board.setCell(xCoor, yCoor, Cell.MISS);
                firedSuccessful = true;
        }
            return firedSuccessful;
    }






    /**
     * Returns the current board for testing purposes.
     * @return the current board
     */
    public AndroidShipBoard getCurrentBoard() {
        return currentPlayerBoard;
    }

    /**
     * Returns the player 1 board for testing purposes.
     * @return the player 1 board
     */
    public AndroidShipBoard getPlayer1Board() {
        return player1Board;
    }

    /**
     * Returns the player 2 board for testing purposes.
     * @return the player 2 board
     */
    public AndroidShipBoard getPlayer2Board() {
        return player2Board;
    }


}
