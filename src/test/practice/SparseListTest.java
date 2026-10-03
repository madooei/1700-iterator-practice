package practice;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for the SparseList iterator. */
public class SparseListTest {

  // Build a length-8 list of default 0, holding a 5 at index 3 and a 2 at index 7.
  private SparseList<Integer> lengthEightExample() {
    SparseList<Integer> list = new SparseList<>(0);
    for (int i = 0; i < 8; i++) {
      list.add(0);
    }
    list.set(3, 5);
    list.set(7, 2);
    return list;
  }

  @Test
  public void iteratorOnEmptyListHasNoElements() {
    SparseList<Integer> list = new SparseList<>(0);
    assertFalse(list.iterator().hasNext());
  }

  @Test
  public void drainedIteratorHasNoNext() {
    SparseList<Integer> list = new SparseList<>(0);
    list.add(0);
    Iterator<Integer> it = list.iterator();
    it.next();
    assertFalse(it.hasNext());
  }

  @Test
  public void nextPastEndThrows() {
    SparseList<Integer> list = new SparseList<>(0);
    list.add(0);
    Iterator<Integer> it = list.iterator();
    it.next();
    try {
      it.next();
      fail("expected NoSuchElementException after the last position");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void allDefaultPositionsAreStillVisited() {
    SparseList<Integer> list = new SparseList<>(7);
    list.add(7);
    list.add(7);
    list.add(7);
    List<Integer> seen = new ArrayList<>();
    for (Integer v : list) {
      seen.add(v);
    }
    List<Integer> expected = new ArrayList<>();
    expected.add(7);
    expected.add(7);
    expected.add(7);
    assertEquals(expected, seen);
  }

  @Test
  public void iteratorYieldsFullLogicalSequence() {
    SparseList<Integer> list = lengthEightExample();
    List<Integer> seen = new ArrayList<>();
    for (Integer v : list) {
      seen.add(v);
    }
    List<Integer> expected = new ArrayList<>();
    for (int v : new int[] {0, 0, 0, 5, 0, 0, 0, 2}) {
      expected.add(v);
    }
    assertEquals(expected, seen);
  }

  @Test
  public void addDuringIterationFailsFast() {
    SparseList<Integer> list = lengthEightExample();
    Iterator<Integer> it = list.iterator();
    it.next();
    list.add(9);
    try {
      it.next();
      fail("expected ConcurrentModificationException after an add");
    } catch (ConcurrentModificationException e) {
      return;
    }
  }

  @Test
  public void removeDuringIterationFailsFast() {
    SparseList<Integer> list = lengthEightExample();
    Iterator<Integer> it = list.iterator();
    it.next();
    list.remove(5);
    try {
      it.next();
      fail("expected ConcurrentModificationException after a remove");
    } catch (ConcurrentModificationException e) {
      return;
    }
  }

  @Test
  public void setThatInsertsNodeDuringIterationFailsFast() {
    SparseList<Integer> list = lengthEightExample();
    Iterator<Integer> it = list.iterator();
    it.next();
    list.set(5, 9);
    try {
      it.next();
      fail("expected ConcurrentModificationException after a set that inserts a node");
    } catch (ConcurrentModificationException e) {
      return;
    }
  }

  @Test
  public void setThatDropsNodeDuringIterationFailsFast() {
    SparseList<Integer> list = lengthEightExample();
    Iterator<Integer> it = list.iterator();
    it.next();
    list.set(3, 0);
    try {
      it.next();
      fail("expected ConcurrentModificationException after a set that drops a node");
    } catch (ConcurrentModificationException e) {
      return;
    }
  }
}
