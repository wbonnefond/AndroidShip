package cs2114.mazesolver;

import android.graphics.Paint;

/**
 *  This defines a cell on the AndroidShip board.
 *
 *  @author Ward Bonnefond (wardwdb)
 *  @author Tyler Ritchie (ritchie4)
 *  @author Nick Crowder (crowdern)
 *  @version Apr 16, 2012
 */
public class Cell
{
    /**
     * The enumerated type for a water cell.
     */
    public final static int WATER = 0;

    /**
     * The enumerated type for a ship cell.
     */
    public final static int SHIP = 1;

    /**
     * The enumerated type for a hit cell.
     */
    public final static int HIT = 2;

    /**
     * The enumerated type for a misfire cell.
     */
    public final static int MISS = 3;

    private Paint brush;
    private int currentType;

    /**
     * Creates a new AndroidShip Cell object.
     * @param type The type of the cell
     */
    public Cell(int type)
    {
        currentType = type;
    }

    /**
     * This sets the cell's type to a number for the enumerated types.
     * @param type The cell's enumerated type number
     */
    public void setType(int type)
    {
        currentType = type;
        setPaint();
    }

    /**
     * This returns the type of the cell.
     * @return The type of the cell
     */
    public int getType()
    {
        return currentType;
    }

    public void setPaint()
    {
        switch(currentType)
        {
            case WATER: brush.setColor(color);
                break;

            case SHIP:
                break;

            case HIT:
                break;

            case MISS:
                break;

        }
    }

    public Paint getPaint()
    {
        return
    }
}
