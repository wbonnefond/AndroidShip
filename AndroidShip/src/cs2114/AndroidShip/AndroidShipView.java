package cs2114.AndroidShip;

import java.util.Observable;
import java.util.Observer;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
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
    private AndroidShipBoard board;

    /**
     * Constructor for View.
     * @param context the context
     * @param attrs the attrs
     */
    public AndroidShipView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    /**
     * Sets the board that this view will display.
     * @param newBoard the board to set
     */
    public void setBoard(AndroidShipBoard newBoard) {
        board = newBoard;
        board.addObserver(new BoardObserver());
    }

    /**
     * Handles touch events on the board.
     * @param e the type of touch
     * @return whether the screen was touched
     */
    public boolean onTouchEvent(MotionEvent e) {
        boolean touched = false;

        switch(e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                touched = true;
                break;
            case MotionEvent.ACTION_UP:
                touched = true;
                break;
        }

        return touched;
    }

    // ----------------------------------------------------------
    /**
     * Draws the board
     * @param canvas the canvas
     */
    public void onDraw(Canvas canvas) {
        if (board == null) {
            return;
        }
        Paint brush = new Paint();
        Paint brush2 = new Paint();
        brush2.setStyle(Style.STROKE);
        brush2.setColor(Color.GRAY);
        float cellWidth = getWidth() / board.getBoardSize();
        float cellHeight = getHeight() / board.getBoardSize();

        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCell(i, j) == Cell.SHIP) {
                    brush.setColor(Color.BLACK);
                }
                else if (board.getCell(i, j) == Cell.MISS) {
                    brush.setColor(Color.GRAY);
                }
                else if (board.getCell(i, j) == Cell.WATER) {
                    brush.setColor(Color.BLUE);
                }
                else if (board.getCell(i, j) == Cell.HIT) {
                    brush.setColor(Color.RED);
                }
                brush.setStyle(Style.FILL);
                canvas.drawRect(i * cellWidth, j * cellHeight,
                    (i + 1) * cellWidth, (j + 1) * cellHeight, brush);
                canvas.drawRect(i * cellWidth, j * cellHeight,
                    (i + 1) * cellWidth, (j + 1) * cellHeight, brush2);

            }
        }
    }

 // ----------------------------------------------------------
    /**
     * Overridden to force the view to be square (have the same width and
     * height).
     *
     * @param widthMeasureSpec the desired width as determined by the layout
     * @param heightMeasureSpec the desired height as determined by the layout
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

    /**
     *  Creates an observer that will keep track of the cells in the maze.
     **/

    private class BoardObserver implements Observer {

        /**
         * Updates the view.
         * @param observable the model
         * @param data the data to get
         */
        public void update(Observable observable, Object data) {
            postInvalidate();
        }

    }

}
