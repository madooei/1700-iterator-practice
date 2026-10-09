package practice;

/** A demo of the SparseList iterator: an enhanced for loop over the full logical sequence. */
public final class SparseListDemo {

  private SparseListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // A length-8 sparse list of default 0, holding 5 at index 3 and 2 at index 7.
    SparseList<Integer> list = new SparseList<>(0);
    for (int i = 0; i < 8; i++) {
      list.add(0);
    }
    list.set(3, 5);
    list.set(7, 2);

    System.out.print("sparse list: ");
    for (Integer v : list) {
      System.out.print(v + " ");   // 0 0 0 5 0 0 0 2
    }
    System.out.println();
  }
}
