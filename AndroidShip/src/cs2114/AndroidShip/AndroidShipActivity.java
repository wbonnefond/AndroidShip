package cs2114.AndroidShip;

import android.widget.TextView;
import android.os.Bundle;
import android.app.Activity;

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

    private AndroidShipModel model;
    private AndroidShipView playerView;
    private AndroidShipView opponentView;
    private TextView statusLabel;

    /**
     * Called when the activity starts.
     * @param savedInstanceState the saved state
     */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        model = new AndroidShipModel();

        playerView = (AndroidShipView) findViewById(R.id.shipViewPlayer);
        opponentView = (AndroidShipView) findViewById(R.id.shipViewOpponent);
        statusLabel = (TextView) findViewById(R.id.statusLabel);

        playerView.setModel(model);
        opponentView.setModel(model);
        playerView.setBoard(model.getPlayer1Board());
        opponentView.setBoard(model.getPlayer2Board());
        opponentView.setOpponent(true);
    }


}
