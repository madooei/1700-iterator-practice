package practice;

/**
 * A small demo of the chapter's two practice iterators: a SparseList walked as its
 * full logical sequence (defaults included), and a Collatz MathSequence generated
 * lazily with no backing data structure.
 */
public class PracticeMain {

  public static void main(String[] args) {
    // A length-8 sparse list of default 0, holding 5 at index 3 and 2 at index 7.
    SparseList<Integer> list = new SparseList<>(0);
    for (int i = 0; i < 8; i++) {
      list.add(0);            // grow to length 8, all default
    }
    list.set(3, 5);
    list.set(7, 2);

    System.out.print("sparse list: ");
    for (Integer v : list) {
      System.out.print(v + " ");   // 0 0 0 5 0 0 0 2
    }
    System.out.println();

    // The Collatz sequence from 3, computed on demand.
    System.out.print("collatz(3):  ");
    for (int value : new MathSequence(3)) {
      System.out.print(value + " ");   // 3 10 5 16 8 4 2 1
    }
    System.out.println();
  }
}
