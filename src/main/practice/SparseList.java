package practice;

import java.util.Iterator;
import java.util.Objects;

import listadt.List;

/**
 * An implementation of the List ADT where nearly every position holds the same default value.
 *
 * @param <T> the type of element stored in this list.
 */
public class SparseList<T> implements List<T>, Iterable<T> {

  private Node<T> head;     // front sentinel; the real nodes follow it
  private T defaultValue;   // the value assumed at any position we do not store
  private int size;         // the logical length of the list

  public SparseList(T defaultValue) {
    this.defaultValue = defaultValue;
    this.head = new Node<>(-1, null);   // sentinel: not a real position
    this.size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void add(T value) {
    int index = size;
    size++;

    if (Objects.equals(value, defaultValue)) {
      return;     // a default value stores nothing: no node, no work
    }

    Node<T> prev = head;
    while (prev.next != null) {
      prev = prev.next;          // walk to the end of the chain
    }
    prev.next = new Node<>(index, value);
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> current = findNodeBeforeTarget(index).next;
    if (current != null && current.index == index) {
      return current.value;              // a value is stored here
    }
    return defaultValue;                 // nothing stored here, so it is the default
  }

  @Override
  public void set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node<T> prev = findNodeBeforeTarget(index);
    Node<T> current = prev.next;
    boolean hasNode = (current != null && current.index == index);

    if (Objects.equals(value, defaultValue)) {
      if (hasNode) {
        prev.next = current.next;       // remove the node: position returns to default
      }
    } else if (hasNode) {
      current.value = value;            // a node is already here: just update it
    } else {
      Node<T> node = new Node<>(index, value);
      node.next = current;              // insert the new node between prev and current
      prev.next = node;
    }
  }

  @Override
  public int indexOf(T value) {
    // Scan logical positions 0..size-1, reading each from the node chain or the
    // default, and return the first that matches.
    Node<T> current = head.next;
    for (int i = 0; i < size; i++) {
      T atI;
      if (current != null && current.index == i) {
        atI = current.value;
        current = current.next;
      } else {
        atI = defaultValue;
      }
      if (Objects.equals(value, atI)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  @Override
  public boolean remove(T value) {
    int index = indexOf(value);
    if (index == -1) {
      return false;
    }
    removeAt(index);
    return true;
  }

  // Return the last node whose index is below the given index (the sentinel if
  // none qualify), so its next field is the node the caller should inspect.
  // Pre: index is valid (checked by the public caller).
  private Node<T> findNodeBeforeTarget(int index) {
    Node<T> prev = head;
    while (prev.next != null && prev.next.index < index) {
      prev = prev.next;
    }
    return prev;
  }

  // Remove logical position index, closing the gap: drop the node there if one
  // exists, then shift every later node's index down by one.
  private void removeAt(int index) {
    Node<T> prev = findNodeBeforeTarget(index);
    Node<T> current = prev.next;
    if (current != null && current.index == index) {
      prev.next = current.next;   // unlink the node sitting at index
      current = current.next;
    }
    while (current != null) {
      current.index--;            // later positions all slide one earlier
      current = current.next;
    }
    size--;
  }

  private static class Node<T> {
    int index;     // the position this value occupies in the list
    T value;       // the non-default value stored at that position
    Node<T> next;

    Node(int index, T value) {
      this.index = index;
      this.value = value;
    }
  }

  @Override
  public Iterator<T> iterator() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Walks the logical positions, not the stored nodes.
  private class SparseListIterator implements Iterator<T> {
    @Override
    public boolean hasNext() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }

    @Override
    public T next() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }
  }
}
