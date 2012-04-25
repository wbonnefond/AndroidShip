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
        player1Board.placeShips();
        player2Board.placeShips();
        currentPlayerBoard = player1Board;
        player1Board.canTouch(false);
        player2Board.canTouch(true);
        player1Board.setTurn(true);
        player2Board.setTurn(false);
    }

    // ----------------------------------------------------------
    /**
     * Switches the current board to the other player.
     */
    public void switchBoard() {
        if (currentPlayerBoard == player1Board) {
            currentPlayerBoard = player2Board;
            player2Board.setTurn(true);
            player1Board.setTurn(false);
        }
        else {
            currentPlayerBoard = player1Board;
            player1Board.setTurn(true);
            player2Board.setTurn(false);
        }
    }

    // ----------------------------------------------------------
    /**
     * Used to fire at the board
     * @param xCoor the x coordinate
     * @param yCoor the y coordinate
     * @return whether it was successful
     */
    public boolean fireAtBoard(int xCoor, int yCoor) {
        boolean firedSuccessful = false;
        if (currentPlayerBoard == player1Board && player1Board.getTurn()) {

            player2Board.fire(xCoor, yCoor);
            firedSuccessful = true;
        }
        else {
            player1Board.fire(xCoor, yCoor);
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
