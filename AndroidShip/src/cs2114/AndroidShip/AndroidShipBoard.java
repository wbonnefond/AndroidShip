package cs2114.AndroidShip;

import java.util.Observable;
import java.util.Random;

/**
 * // -------------------------------------------------------------------------
 * /** This is the AndroidShipBoard class. It creates the board and sets it up.
 *
 * @author Ward Bonnefond (wardwdb)
 * @author Tyler Ritchie (ritchie4)
 * @author Nick Crowder (crowdern)
 * @version Apr 16, 2012
 */
public class AndroidShipBoard
    extends Observable
{
    private Cell[][] shipCells;


    /**
     * Constructor for the AndroidShipBoard. Creates the board and sets all of
     * the cells to water.
     */
    public AndroidShipBoard()
    {
        shipCells = new Cell[10][10];
        setCellsToWater();
        placeShips();
    }


    /**
     * Sets all of the cells on the board to water.
     */
    public void setCellsToWater()
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                setCell(i, j, Cell.WATER);
            }
        }

        setChanged();
        notifyObservers();
    }


    /**
     * Gets the maze cell.
     *
     * @param x
     *            - column that the cell is in
     * @param y
     *            - row that the cell is in
     * @return MazeCell - returns a maze cell
     */
    public Cell getCell(int x, int y)
    {
        return shipCells[x][y];
    }


    /**
     * Sets the cell
     *
     * @param x
     *            - column that the cell is in
     * @param y
     *            - row that the cell is in
     * @param type
     *            - type of cell that the spot will be changed into
     */
    public void setCell(int x, int y, int type)
    {
        shipCells[x][y].setType(type);

        setChanged();
        notifyObservers();
    }


    /**
     * Places both users ships randomly on the board.
     */
    public void placeShips()
    {
        // 5, 4, 3, 3, 2
        int a;
    }
}
