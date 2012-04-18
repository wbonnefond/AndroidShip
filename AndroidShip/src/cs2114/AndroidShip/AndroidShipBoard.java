package cs2114.AndroidShip;

import java.util.Observable;
import java.util.Random;

/**
 *  This is the AndroidShipBoard class. It creates the board and sets it up.
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
     * @param c
     *            - type of cell that the spot will be changed into
     */
    public void setCell(int x, int y, Cell c)
    {
        shipCells[x][y] = c;

        setChanged();
        notifyObservers();
    }

    /**
     * Returns the size of the board.
     * @return returns board size
     */
    public int getBoardSize()
    {
        return 10;
    }


    /**
     * Places both users ships randomly on the board.
     */
    public void placeShips()
    {
        // 5, 4, 3, 3, 2
        int a;

        placeFive();
        placeFour();
        placeThree();
        placeThree();
        placeTwo();
    }

    /**
     * Places the ship that takes up five cells.
     */
    public void placeFive()
    {
        int x = (int)(Math.random()*11);
        int y = (int)(Math.random()*11);
        pickRandomDirection(x, y, 5);
    }

    /**
     * Places the ship that takes up four cells.
     */
    public void placeFour()
    {

    }

    /**
     * Places the ship that takes up three cells.
     */
    public void placeThree()
    {

    }

    /**
     * Places the ship that takes up two cells.
     */
    public void placeTwo()
    {

    }

    /**
     * Once the first ship point is picked, this establishes a random direction
     * to place the rest of the ship cells in, if the space for them is
     * present.
     */
    public void pickRandomDirection(int coordX, int coordY, int shipCells)
    {
        int x = coordX;
        int y = coordY;
        int randomDirection = (int)(Math.random()*4);
        int shipCellSize = shipCells;

        // Try going up.
        if(randomDirection == 0 && y - (shipCellSize-1) >= 0)
        {
            for(int i = shipCellSize; shipCellSize > 0; shipCellSize--)
            {
                setCell(x, y, Cell.SHIP); //
                y--;
            }
        }

        // Try going right.
        else if(randomDirection == 1 && x + (shipCellSize-1) <= 10)
        {
            for(int i = shipCellSize; shipCellSize > 0; shipCellSize--)
            {
                setCell(x, y, Cell.SHIP);
                y--;
            }
        }

    }
}
