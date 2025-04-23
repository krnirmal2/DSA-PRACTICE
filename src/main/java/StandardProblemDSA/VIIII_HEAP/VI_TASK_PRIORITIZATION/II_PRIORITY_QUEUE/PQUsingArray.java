package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.II_PRIORITY_QUEUE;

import java.util.ArrayList;
import java.util.List;

// Structure for the elements in the
// priority queue
class Item {
  public int value;
  public int priority;

  public Item(int value, int priority) {
    this.value = value;
    this.priority = priority;
  }

  @Override
  public String toString() {
    return value + " (Priority: " + priority + ")";
  }
}

public class PQUsingArray {

  // for create a priority queue with array
  // we need to take array of item above having value with priority
  private List<Item> itemList;

  // instantsiate the item
  public PQUsingArray() {
    this.itemList = new ArrayList<>();
  }

  // now we will implement three CRUD operation
  // create (enque)
  // pick
  // Delete (deque)
  public void equeue(Item item) {
    // check if the queueUsingArray is full
    // 0(1)

    itemList.add(item);
  }

  public Item peekItem() {
    if (itemList.isEmpty()) return null;
    // Read: Peek task with highest priority (O(n))
    Item max = itemList.get(0);

    for (Item item : itemList) {
      if (item.priority > max.priority) {
        max = item;
      }
    }
    return max;
  }

  // to delete the highest element
  // do extract the max and then reduce the size of the array
  public Item extractItem() {
    if (itemList.isEmpty()) return null;
    int maxIndex = 0; // let say the max element is present at 0 th index of the array
    for (int i = 1; i < itemList.size(); i++) {
      if (itemList.get(i).priority > itemList.get(maxIndex).priority) {
        //         update the maxindex with the current index
        maxIndex = i;
      }
    }
    return itemList.remove(maxIndex);
  }

  public static void main(String[] args) {
    // lets create sum item and add them in the priority list
    PQUsingArray pq = new PQUsingArray();
    pq.equeue(new Item(23, 2));
    pq.equeue(new Item(2, 1));
    pq.equeue(new Item(3, 3));
    System.out.println("peek max " + pq.peekItem());
  }
}
