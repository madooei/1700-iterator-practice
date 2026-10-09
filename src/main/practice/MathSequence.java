package practice;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** The Collatz sequence starting at a positive integer, generated on demand. */
public class MathSequence implements Iterable<Integer> {

  private final int start;

  // Throws IllegalArgumentException if n is not positive.
  public MathSequence(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("start must be positive");
    }
    this.start = n;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new SequenceIterator();
  }

  private class SequenceIterator implements Iterator<Integer> {
    private int current = start;
    private boolean finished = false;

    @Override
    public boolean hasNext() {
      return !finished;
    }

    @Override
    public Integer next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      int value = current;
      if (current == 1) {
        finished = true;  // we just handed out the final 1
      } else if (current % 2 == 0) {
        current = current / 2;
      } else {
        current = current * 3 + 1;
      }
      return value;
    }
  }
}
