package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for the MathSequence iterator. */
public class MathSequenceTest {

  private List<Integer> walk(int start) {
    List<Integer> seen = new ArrayList<>();
    for (int value : new MathSequence(start)) {
      seen.add(value);
    }
    return seen;
  }

  @Test
  public void sequenceFromOneIsJustOne() {
    List<Integer> expected = new ArrayList<>();
    expected.add(1);
    assertEquals(expected, walk(1));   // the final 1 is emitted before stopping
  }

  @Test
  public void drainedIteratorHasNoNext() {
    Iterator<Integer> it = new MathSequence(1).iterator();
    it.next();
    assertFalse(it.hasNext());
  }

  @Test
  public void nextPastEndThrows() {
    Iterator<Integer> it = new MathSequence(1).iterator();
    it.next();
    try {
      it.next();
      fail("expected NoSuchElementException after the sequence ends");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void sequenceFromTwo() {
    List<Integer> expected = new ArrayList<>();
    expected.add(2);
    expected.add(1);
    assertEquals(expected, walk(2));
  }

  @Test
  public void oddStartTriplesFirst() {
    List<Integer> expected = new ArrayList<>();
    for (int v : new int[] {3, 10, 5, 16, 8, 4, 2, 1}) {
      expected.add(v);
    }
    assertEquals(expected, walk(3));
  }

  @Test
  public void evenStartHalvesFirst() {
    List<Integer> expected = new ArrayList<>();
    for (int v : new int[] {6, 3, 10, 5, 16, 8, 4, 2, 1}) {
      expected.add(v);
    }
    assertEquals(expected, walk(6));
  }

  @Test
  public void constructorRejectsZero() {
    try {
      new MathSequence(0);
      fail("expected IllegalArgumentException for start 0");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void constructorRejectsNegative() {
    try {
      new MathSequence(-5);
      fail("expected IllegalArgumentException for start -5");
    } catch (IllegalArgumentException e) {
      return;
    }
  }
}
