package com.comp301.a02adventure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the
 * Position interface - the PositionImpl class.
 */
public class PositionImplTest {

  /**
   * Default constructor for the PositionImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public PositionImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getter methods of the Position interface. */
  @Test
  public void testPositionConstructorAndGetters() {
    Position position = new PositionImpl(2, 3);
    assertEquals(2, position.getX());
    assertEquals(3, position.getY());
  }

  /** This test case tests the equals method of the Position interface. */
  @Test
  public void testPositionEquals() {
    Position position1 = new PositionImpl(1, 2);
    Position position2 = new PositionImpl(1, 2);
    Position position3 = new PositionImpl(2, 1);

    // Case 1: Two positions with the same x and y coordinates are the same
    assertTrue(position1.equals(position2));
    // Case 2: Two positions with different x and y coordinates are not the same
    assertFalse(position1.equals(position3));
    // Case 3: A position is not the same as null or a non-position object
    assertFalse(position1.equals(null));
    // Case 4: A position is not the same as an object with a different type
    assertFalse(position1.equals("Not a position"));
  }

  /** This test case tests the toString method of the Position interface. */
  @Test
  public void testPositionToString() {
    Position position = new PositionImpl(4, 5);
    assertEquals("(4, 5)", position.toString());
  }

  /** This test case tests the getNeighbor method of the Position interface. */
  @Test
  public void testGetNeighbor() {
    Position position = new PositionImpl(3, 3);

    Position northNeighbor = position.getNeighbor(Direction.NORTH);
    assertEquals(new PositionImpl(3, 4), northNeighbor);

    Position southNeighbor = position.getNeighbor(Direction.SOUTH);
    assertEquals(new PositionImpl(3, 2), southNeighbor);

    Position eastNeighbor = position.getNeighbor(Direction.EAST);
    assertEquals(new PositionImpl(4, 3), eastNeighbor);

    Position westNeighbor = position.getNeighbor(Direction.WEST);
    assertEquals(new PositionImpl(2, 3), westNeighbor);
  }

  /**
   * This test case tests the getNeighbor method of the Position interface with an invalid
   * direction.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDirection() {
    Position position = new PositionImpl(0, 0);
    position.getNeighbor(null); // Should throw an IllegalArgumentException
  }
}
