package practice;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** The Collatz sequence starting at a positive integer, generated on demand. */
public class MathSequence implements Iterable<Integer> {

  private final int start;

  // Throws IllegalArgumentException if n is not positive.
  public MathSequence(int n) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public Iterator<Integer> iterator() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // The whole state is the current value and a finished flag. next() hands out the
  // current value, then computes the one after it — unless the value was 1, which is
  // where the sequence ends.
  private class SequenceIterator implements Iterator<Integer> {
    private int current = start;
    private boolean finished = false;

    @Override
    public boolean hasNext() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }

    @Override
    public Integer next() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }
  }
}
