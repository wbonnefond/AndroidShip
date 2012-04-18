package cs2114.AndroidShip;

import student.TestCase;

/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Tyler
 *  @version Apr 16, 2012
 */
public class CellTest
    extends TestCase
{
    private Cell cell;

    /**
     * Sets up the variables for testing.
     */
    public void setUp()
    {
        cell = new Cell(Cell.WATER);
    }

    /**
     * This tests to be sure that a cell is returned properly.
     */
    public void testGetType()
    {
        assertEquals(Cell.WATER, cell.getType());
    }

    /**
     * This tests to be sure that a cell is set to the proper type.
     */
    public void testSetType()
    {
        assertEquals(Cell.WATER, cell.getType());
        cell.setType(Cell.HIT);
        assertEquals(Cell.HIT, cell.getType());
    }
}
