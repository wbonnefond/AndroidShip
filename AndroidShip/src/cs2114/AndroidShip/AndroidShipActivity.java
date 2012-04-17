package cs2114.mazesolver;

import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;

/**
 * This is the activity class for the AndroidShip game.
 *
 *  @author Ward Bonnefond (wardwdb)
 *  @author Tyler Ritchie (ritchie4)
 *  @author Nick Crowder (crowdern)
 *  @version Apr 16, 2012
 */
public class AndroidShipActivity
    extends Activity
{

    private AndroidShipBoard playerOneBoard;
    private AndroidShipBoard playerTwoBoard;
    private AndroidShipView  shipView;

    private TextView   playerLabel;
    private TextView   statusLabel;
    private CheckBox   checkBox;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     *            previous state saved by the last run of the activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        shipView = (AndroidShipView)findViewById(R.id.mazeView);
        /*
        checkBox = (CheckBox)findViewById(R.id.drawEraseMode);
        statusLabel = (TextView)findViewById(R.id.statusLabel);

        make the view components
        */

        playerOneBoard = new AndroidShipBoard();
        playerTwoBoard = new AndroidShipBoard();

        // mazeView.setModel(maze);
    }

    /**
     * This handles when the maze solver button is clicked
     *
     * @param view
     *            The view to be dealt with
     */
    public void fireButtonClicked(View view)
    {
        //
    }

    /**
     * This returns the MazeView object being used.
     *
     * @return The MazeView object
     */
    public AndroidShipView getView()
    {
        return shipView;
    }

    // maybe a getBoard method
}
