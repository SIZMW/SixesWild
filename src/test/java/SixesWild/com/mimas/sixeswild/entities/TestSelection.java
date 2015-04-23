package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles all coverage for the Selection class.
 * 
 * @author Aditya Nivarthi
 */
public class TestSelection extends TestCase {

	Selection selection;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		selection = new Selection();
	}

	/**
	 * Tests adding and removing Squares.
	 */
	public void testSquares() {
		assertTrue(selection.add(new Square(new NullTile(), 1, 1, false)));
		assertFalse(selection.add(null));

		assertTrue(selection.remove(new Square(new NullTile(), 1, 1, false)));
		assertFalse(selection.remove(null));

		assertTrue(selection.clear());
		assertEquals(selection.getArray().length, 0);
	}

	/**
	 * Tests the continuous check of the valid sum of tiles in Squares.
	 */
	public void testSumStillValid() {
		selection.add(new Square(new NumberTile(1, 1), 1, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 2, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 3, 1, false));
		assertTrue(selection.isSelectionSumStillValid());

		selection.add(new Square(new NumberTile(2, 1), 4, 1, false));
		assertFalse(selection.isSelectionSumStillValid());

		selection.remove(new Square(new NumberTile(2, 1), 4, 1, false));
		selection.add(new Square(new NullTile(), 1, 1, false));
		assertFalse(selection.isSelectionSumStillValid());
	}

	/**
	 * Tests the valid selection methods.
	 */
	public void testValidSelection() {
		selection.add(new Square(new NumberTile(1, 1), 1, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 2, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 3, 1, false));
		assertFalse(selection.isValidSelection());

		selection.add(new Square(new NumberTile(1, 1), 4, 1, false));
		assertTrue(selection.isValidSelection());

		selection.remove(new Square(new NumberTile(1, 1), 4, 1, false));
		selection.add(new Square(new NumberTile(1, 1), 5, 1, false));
		assertFalse(selection.isValidSelection());

		selection.remove(new Square(new NumberTile(1, 1), 5, 1, false));
		selection.add(new Square(new NullTile(), 4, 1, false));

		assertFalse(selection.isValidSelection());
	}

	/**
	 * Tests validity of a single square in selection.
	 */
	public void testSingleSquareSelection() {
		selection.add(new Square(new NumberTile(2, 1), 3, 1, false));
		assertFalse(selection.isValidSelection());
	}

	/**
	 * Tests the square next to validity checking.
	 */
	public void testSquareNextTo() {
		selection.add(new Square(new NumberTile(1, 1), 1, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 1, 2, false));
		selection.add(new Square(new NumberTile(2, 1), 1, 3, false));
		selection.add(new Square(new NumberTile(1, 1), 5, 1, false));
		assertFalse(selection.isValidSelection());

		selection.remove(new Square(new NumberTile(1, 1), 5, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 2, 1, false));
		assertFalse(selection.isValidSelection());
	}

	/**
	 * Test the selection validity by square positions in selection.
	 */
	public void testValidPositionSelection() {
		selection.add(new Square(new NumberTile(1, 1), 1, 1, false));
		assertTrue(selection.isValidPositionSelection());
		
		selection.add(new Square(new NumberTile(2, 1), 2, 1, false));
		selection.add(new Square(new NumberTile(2, 1), 3, 1, false));
		assertTrue(selection.isValidPositionSelection());

		selection.add(new Square(new NumberTile(1, 1), 5, 1, false));
		assertFalse(selection.isValidPositionSelection());
	}
}
