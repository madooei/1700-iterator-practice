package practice;

import java.util.Iterator;

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

  private class SequenceIterator implements Iterator<Integer> {
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
