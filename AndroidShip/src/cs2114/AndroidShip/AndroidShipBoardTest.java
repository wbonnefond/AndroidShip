package cs2114.AndroidShip;

import student.TestCase;

/**
 * This tests the methods of the AndroidShipBoard class.
 *
 * @author Ward Bonnefond (wardwdb)
 * @author Tyler Ritchie (ritchie4)
 * @author Nick Crowder (crowdern)
 * @version Apr 16, 2012
 */
public class AndroidShipBoardTest
    extends TestCase
{
    private AndroidShipBoard board;


    /**
     * Initializes all fields necessary for the tests.
     */
    public void setUp()
    {
        board = new AndroidShipBoard();
    }


    /**
     * Tests to be sure that all cells are set to water when this method is
     * called.
     */
    public void testSetCellsToWater()
    {
        board.setCellsToWater();
        assertEquals(Cell.WATER, board.getCell(0, 0));
        assertEquals(Cell.WATER, board.getCell(4, 2));
        assertEquals(Cell.WATER, board.getCell(3, 7));
        assertEquals(Cell.WATER, board.getCell(9, 9));
    }


    /**
     * Tests to be sure the setCell method sets a cell to the proper type.
     */
    public void testSetCell()
    {
        board.setCell(0, 0, Cell.HIT);
        assertEquals(Cell.HIT, board.getCell(0, 0));
    }


    /**
     * Tests to be sure that the board size returns 10.
     */
    public void testBoardSize()
    {
        assertEquals(10, board.getBoardSize());
    }


    /**
     * Tests that the place ships method places the correct ships at the correct
     * coordinates.
     */
    public void testPlaceShips()
    {
        int shipCounter = 0;
        board.placeShips();

        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                if (board.getCell(x, y) == Cell.SHIP)
                {
                    shipCounter++;
                }
            }
        }
        assertEquals(17, shipCounter);
    }
}
