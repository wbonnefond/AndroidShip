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

    /**
     * The constructor for this model.
     */
    public AndroidShipModel()
    {
        statusLabel = "";
    }

    /**
     * Fires at a specific coordinate on a specified board.
     * @param x The x coordinate of the fire target
     * @param y The y coordinate of the fire target
     * @param board The board to fire on, usually the opponent's board
     */
    public void fireAtCoordinate(int x, int y, AndroidShipBoard board)
    {
        // todo
    }

    /**
     * Switches the labels, boards, and status labels when the phone is
     * handed to the other player after a turn.
     */
    public void switchPlayers()
    {
        // todo
    }

    /**
     * Updates the status label to the most recent move.
     * @param message The message to apply to the status label
     */
    public void updateLabel(String message)
    {
        statusLabel = message;
    }
}
