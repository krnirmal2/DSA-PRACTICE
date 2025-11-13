package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.II_PRIORITY_QUEUE;

import java.util.ArrayList;
import java.util.List;

class ItemS {
  String value;
  int pririty;

  // create new item
  public ItemS(String value, int pririty) {
    this.value = value;
    this.pririty = pririty;
  }
}

public class PriortityQueueUsingHeap {
  List<ItemS> ListItem;

  // when create priority queue heap we will intialsied
  // array list
  PriortityQueueUsingHeap() {
    this.ListItem = new ArrayList<>();
  }

  private ItemS peek() {
    if (ListItem.isEmpty()) return null;
    return ListItem.get(0);
  }

  // what ever the heap will have in the operation we will do the
  // same here
  public void insert(String value, int priority) {
    // we create new node
    ItemS newItem = new ItemS(value, priority);
    ListItem.add(newItem);
    // now acc to heap when we isert the element
    // it might violate the heap property
    // so we will do heapify from the bottom non-leaf node to top
    bottomToTopHeapify(ListItem.size() - 1);
  }

  private void swap(int i, int j) {
    ItemS temp = ListItem.get(i);
    ListItem.set(i, ListItem.get(j));
    ListItem.set(j, temp);
  }

  private void bottomToTopHeapify(int index) {
    // iterate till the index is not less than 0
    while (index > 0) {
      // check if the parent value is less than
      // current index then we will swap on max heap
      int parentIndex = (index - 1) / 2;
      if (ListItem.get(parentIndex).pririty < ListItem.get(index).pririty) {
        swap(parentIndex, index);
        // update the current index as parent index
        index = parentIndex;
      }
    }
  }

  // now we will delete a item from item from the heap
  // for that we will delete the root set this to last element
  // and then topToBottomheapify()
  private ItemS poll() {
    // check if the LsitItem is empty or not
    if (ListItem.isEmpty()) return null;

    //
    ItemS topItem = ListItem.get(0);
    // reduce the size of th e heap or ListItem
    ItemS lastItem = ListItem.remove(ListItem.size() - 1);
    if (!ListItem.isEmpty()) {
      // set the last node as a top node
      ListItem.set(0, lastItem);
      // then as this violate the heap property then
      // we need to heapify
      heapifyTopToDown(0);
    }
    return topItem;
  }

  private void heapifyTopToDown(int index) {
    // now have to check if the current index vvalue is less than
    // left or right child of it
    //  then swap with parent
    int left, right, largest;
    int size = ListItem.size();

    while (index < size) {
      left = 2 * index + 1;
      right = 2 * index + 2;
      largest = index;

      // check left index is valid and left value is less than the largest Index
      if (left < size && ListItem.get(largest).pririty < ListItem.get(left).pririty) {
        largest = left;
      }
      // check right index is valid and left value is less than the largest Index
      if (right < size && ListItem.get(largest).pririty < ListItem.get(right).pririty) {
        largest = right;
      }
      // largest is not the root root
      if (largest != index) {
        swap(largest, index);
        index = largest;
      } else break;
    }

    // if the index is valide
  }

  public static void main(String[] args) {
    PriortityQueueUsingHeap pq = new PriortityQueueUsingHeap();
    pq.insert("A", 1);
    pq.insert("B", 2);
    pq.insert("C", 3);
  }
}
