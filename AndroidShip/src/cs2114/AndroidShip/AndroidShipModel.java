package cs2114.AndroidShip;

/**
 *  This defines the model for the AndroidShip game.
 *
 *  @author Ward Bonnefond (wardwdb)
 *  @author Tyler Ritchie (ritchie4)
 *  @author Nick Crowder (crowdern)
 *  @version Apr 16, 2012
 */

public class AndroidShipModel
{
    private String statusLabel;
    private String playerLabel;
    private boolean player1turn;

    /**
     * The constructor for this model.
     */
    public AndroidShipModel()
    {
        statusLabel = "";
        playerLabel = "Player 1's Turn";
        player1turn = true;
    }

    /**
     * Fires at a specific coordinate on a specified board.
     * @param x The x coordinate of the fire target
     * @param y The y coordinate of the fire target
     * @param board The board to fire on, usually the opponent's board
     */
    public void fireAtCoordinate(int x, int y, AndroidShipBoard board)
    {
        // TODO
    }

    /**
     * Switches the labels, boards, and status labels when the phone is
     * handed to the other player after a turn.
     */
    public void switchPlayers()
    {
        if(player1turn)
        {
            player1turn = false;
            playerLabel = "Player 2's Turn";
        }
        else
        {
            player1turn = true;
            playerLabel = "Player 1's Turn";
        }

        // TODO: a way to switch the boards
    }

    /**
     * Updates the status label to the most recent move.
     * @param message The message to apply to the status label
     */
    public void updateStatusLabel(String message)
    {
        statusLabel = message;
    }

}
