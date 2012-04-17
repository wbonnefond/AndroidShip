package cs2114.AndroidShip;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Canvas;
import android.view.MotionEvent;
import java.util.Observable;
import java.util.Observer;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 *  This is the view for the AndroidShip game.
 *
 *  @author Ward Bonnefond (wardwdb)
 *  @author Tyler Ritchie (ritchie4)
 *  @author Nick Crowder (crowdern)
 *  @version Apr 16, 2012
 */
public class AndroidShipView
    extends View
{

    private AndroidShipBoard playerOneBoard;
    private AndroidShipBoard playerTwoBoard;

    private int     pixelWidth;
    private int     pixelHeight;
    private boolean wallDrawing;


    /**
     * Creates a new MazeView. A constructor with these arguments is required
     * for any view that will be added to a layout XML file.
     *
     * @param context
     *            the Context that the view is running in
     * @param attrs
     *            the attributes of the XML tag that is inflating the view
     */
    public AndroidShipView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }


    /**
     * Sets the model that will be rendered by this view. Calling this method
     * also adds the view as an observer for the model.
     *
     * @param theMaze
     *            the model
     */
    public void setModel(AndroidShipBoard oneBoard, AndroidShipBoard twoBoard)
    {
        playerOneBoard = oneBoard;
        playerTwoBoard = twoBoard;
        pixelWidth = getWidth() / 10;
        pixelHeight = getHeight() / 10;

        playerOneBoard.addObserver(new AndroidShipObserver());
        playerTwoBoard.addObserver(new AndroidShipObserver());
    }

    /**
     * Called when a touch event occurs on the view; either pressing the finger
     * down for the first time, moving it on the screen, or lifting it back up.
     *
     * @param e
     *            a MotionEvent object that describes the touch event
     * @return true if this method handled the touch, or false if it did not
     */
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        maze.resetPaths();

        int cellX = (int)(e.getX() / pixelWidth);
        int cellY = (int)(e.getY() / pixelHeight);

        boolean isTouched = false;
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (wallDrawing)
                {
                    maze.setCell(cellX, cellY, MazeCell.WALL);
                }
                else
                {
                    maze.setCell(cellX, cellY, MazeCell.UNEXPLORED);
                }
                isTouched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (wallDrawing)
                {
                    maze.setCell(cellX, cellY, MazeCell.WALL);
                }
                else
                {
                    maze.setCell(cellX, cellY, MazeCell.UNEXPLORED);
                }
                isTouched = true;
                break;
            case MotionEvent.ACTION_UP:
                isTouched = true;
                break;
        }
        return isTouched;

    }


    // ----------------------------------------------------------
    /**
     * Called when the view is asked to redraw its contents.
     *
     * @param canvas
     *            an object that represents the canvas to be drawn on
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        if (maze == null)
        {
            return;
        }

        Paint brush1 = new Paint();
        brush1.setStyle(Style.FILL);

        Paint brush2 = new Paint();
        brush2.setStyle(Style.STROKE);
        brush2.setColor(Color.rgb(140, 138, 140));

        pixelWidth = getWidth() / maze.size();
        pixelHeight = getHeight() / maze.size();

        for (int x = 0; x < maze.size(); x++)
        {
            for (int y = 0; y < maze.size(); y++)
            {
                brush1.setColor(manipulateColor(x, y));
                canvas.drawRect(x * pixelWidth, y * pixelHeight, (x + 1)
                    * pixelWidth, (y + 1) * pixelHeight, brush1);
                canvas.drawRect(x * pixelWidth, y * pixelHeight, (x + 1)
                    * pixelWidth, (y + 1) * pixelHeight, brush2);
            }
        }

    }


    /**
     * Returns the a cell's color based on what type of cell it is.
     *
     * @param x
     *            The x coordinate of the cell
     * @param y
     *            The y coorindate of the cell
     * @return The color that the cell should be
     */
    private int manipulateColor(int x, int y)
    {
        int color;
        if (maze.getCell(x, y) == MazeCell.CURRENT_PATH)
        {
            color = Color.GREEN;
        }
        else if (maze.getCell(x, y) == MazeCell.FAILED_PATH)
        {
            color = Color.RED;
        }
        else if (maze.getCell(x, y) == MazeCell.WALL)
        {
            color = Color.WHITE;
        }
        else
        {
            color = Color.BLACK;
        }
        return color;
    }


    /**
     * Overridden to force the view to be square (have the same width and
     * height).
     *
     * @param widthMeasureSpec
     *            the desired width as determined by the layout
     * @param heightMeasureSpec
     *            the desired height as determined by the layout
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // Choose the smallest of the two dimensions to use for both.
        int measureSpec = Math.min(widthMeasureSpec, heightMeasureSpec);

        // Call the superclass implementation but pass it our modified width
        // and height instead of the incoming ones.
        super.onMeasure(measureSpec, measureSpec);
    }


    // ----------------------------------------------------------
    /**
     * An observer that listens for changes made to the DotsModel. This is a
     * nested class inside the view so that it can still access methods that
     * belong to the surrounding view.
     */
    private class AndroidShipObserver
        implements Observer
    {
        // ~ Methods ...........................................................

        // ----------------------------------------------------------
        /**
         * Called when the RubberLinesModel is changed (for example, when the
         * user drags a finger around the view).
         *
         * @param observable
         *            the Observable object that was changed
         * @param data
         *            extra data about the notification; unused here
         */
        public void update(Observable observable, Object data)
        {
            // The invalidate() method is used to force a view to be repainted
            // at the earliest opportunity (which in most cases is essentially
            // immediately, but may not always be). Note that this is a method
            // on the View class, not the Observer.

            invalidate();
        }
    }
}
