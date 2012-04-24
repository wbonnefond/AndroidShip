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
    private boolean isPlaced;


    /**
     * Constructor for the AndroidShipBoard. Creates the board and sets all of
     * the cells to water.
     */
    public AndroidShipBoard()
    {
        isPlaced = false;
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
        // Keep running each method until the ship is actually placed

        if(!isPlaced)
        {
            pickRandomDirection(5);
        }
        isPlaced = false;

        if(!isPlaced)
        {
        pickRandomDirection(4);
        }
        isPlaced = false;

        if(!isPlaced)
        {
        pickRandomDirection(3);
        }
        isPlaced = false;

        if(!isPlaced)
        {
        pickRandomDirection(3);
        }
        isPlaced = false;

        if(!isPlaced)
        {
        pickRandomDirection(2);
        }
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
            if(checkAhead(x, y, shipCellSize, randomDirection))
            {
                while (shipCellSize > 0)
                {
                    setCell(x, y, Cell.SHIP);
                    y--;
                    shipCellSize--;
                }
                isPlaced = true;
            }
        }

        // Try going right.
        else if (randomDirection == 1 && x + (shipCellSize - 1) <= 9)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                x++;
                shipCellSize--;
            }
            isPlaced = true;
        }

        // Try going down.
        else if (randomDirection == 2 && y + (shipCellSize - 1) <= 9)
        {
            while(shipCellSize > 0)
            {
                setCell(x, y, Cell.SHIP);
                y++;
                shipCellSize--;
            }
            isPlaced = true;
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
            isPlaced = true;
        }
    }

    // ----------------------------------------------------------
    /**
     * Checks ahead to see if there are already ships in the new ship placement
     * path.
     * @param xCoord The xCoord to start at
     * @param yCoord The yCoord to start at
     * @param sCellSize The new ship's size
     * @return Whether the path to place the ship is clear or not
     */
    private boolean checkAhead(int xCoord, int yCoord, int sCellSize, int dir)
    {
        int x = xCoord;
        int y = yCoord;
        int shipCellSize = sCellSize;
        int randomDirection = dir;
        int truthCounter = 0;

        // Look up.
        if(randomDirection == 0)
        {
            while(y >= y-(shipCellSize-1))
            {
                if(shipCells[x][y] == Cell.WATER)
                {
                    truthCounter++;
                }
                y--;
            }
        }

        // Look right.
        else if(randomDirection == 1)
        {
            while(x <= x-(shipCellSize-1))
            {
                if(shipCells[x][y] == Cell.WATER)
                {
                    truthCounter++;
                }
                x++;
            }
        }

        // Look down.
        else if(randomDirection == 2)
        {
            while(y <= y-(shipCellSize-1))
            {
                if(shipCells[x][y] == Cell.WATER)
                {
                    truthCounter++;
                }
                y++;
            }
        }

        // Look left.
        else if(randomDirection == 3)
        {
            while(x >= x-(shipCellSize-1))
            {
                if(shipCells[x][y] == Cell.WATER)
                {
                    truthCounter++;
                }
                x--;
            }
        }
        return shipCellSize == truthCounter;
    }
}
