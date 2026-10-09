package practice;

/** A demo of the MathSequence iterator: the Collatz sequence from 3. */
public final class MathSequenceDemo {

  private MathSequenceDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    System.out.print("collatz(3): ");
    for (int value : new MathSequence(3)) {
      System.out.print(value + " ");   // 3 10 5 16 8 4 2 1
    }
    System.out.println();
  }
}
