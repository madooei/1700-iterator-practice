# Iterators — Practice

Two practice problems. The first makes `SparseList` iterable, so an enhanced `for` loop returns its full logical sequence, default positions included. The second, `MathSequence`, is an iterator for the Collatz sequence that computes each value when it is asked for and has no backing data structure.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      listadt/
        List.java                       # the List ADT contract
      practice/
        SparseList.java                 # the sparse list, made iterable
        MathSequence.java               # the Collatz sequence, generated on demand
        PracticeMain.java               # demo of both iterators
    test/
      practice/
        SparseListTest.java
        MathSequenceTest.java
  scripts/
    run.sh                              # compile and run the demo (practice.PracticeMain)
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.MathSequenceTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty.
- `scripts/run.sh` — compiles everything and runs `PracticeMain`, which walks a `SparseList` and a Collatz sequence with an enhanced `for` loop.

## What's here

- `listadt.List<T>` — the List ADT contract, which `SparseList` implements.
- `practice.SparseList<T>` — the sparse list from the List ADT practice, now implementing `Iterable<T>`. Its iterator moves a position cursor and a node pointer together, and fails fast when the list changes during an iteration.
- `practice.MathSequence` — implements `Iterable<Integer>`. Its iterator keeps only the current value and a finished flag.
- `practice.PracticeMain` — a demo that walks a `SparseList` and a Collatz sequence with an enhanced `for` loop.
- `practice.SparseListTest`, `practice.MathSequenceTest` — tests for the two iterators.
