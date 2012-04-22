package cs2114.AndroidShip;

import java.util.Observable;

/**
 * This is the AndroidShipBoard class. It creates the board and sets it up.
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
     *
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
        // Ship sizes: 5, 4, 3, 3, 2
        pickRandomDirection(5);
        pickRandomDirection(4);
        pickRandomDirection(3);
        pickRandomDirection(3);
        pickRandomDirection(2);
    }


    /**
     * Once the first ship point is picked, this establishes a random direction
     * to place the rest of the ship cells in, if the space for them is present.
     *
     * @param shipCellAmount
     *            The amount of cells that the ship takes up
     */
    public void pickRandomDirection(int shipCellAmount)
    {
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        int randomDirection = (int)(Math.random() * 4);
        int shipCellSize = shipCellAmount;

        // Try going up.
        if (randomDirection == 0 && y - (shipCellSize - 1) >= 0)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                y--;
                shipCellSize--;
            }
        }

        // Try going right.
        else if (randomDirection == 1 && x + (shipCellSize - 1) <= 10)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                x++;
                shipCellSize--;
            }
        }

        // Try going down.
        else if (randomDirection == 2 && y + (shipCellSize - 1) <= 10)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                y++;
                shipCellSize--;
            }
        }

        // Try going left.
        else if (randomDirection == 3 && x - (shipCellSize - 1) >= 0)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                x--;
                shipCellSize--;
            }
        }

    }
}
