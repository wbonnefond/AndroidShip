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

    private AndroidShipBoard player;
    private AndroidShipBoard opponent;
    private AndroidShipView playerView;
    private AndroidShipView opponentView;
    private TextView statusLabel;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        player = new AndroidShipBoard();
        opponent = new AndroidShipBoard();
        //player.placeShips();
        //opponent.placeShips();

        playerView = (AndroidShipView) findViewById(R.id.shipViewPlayer);
        opponentView = (AndroidShipView) findViewById(R.id.shipViewOpponent);
        statusLabel = (TextView) findViewById(R.id.statusLabel);

        playerView.setBoard(player);
        opponentView.setBoard(opponent);

        playerView.setClickable(true);


    }

}
