package StandardProblemDSA.II_LINKEDLIST.xi_DOUBLY_LL;

import StandardProblemDSA.II_LINKEDLIST.DoubllyNodeWithKey;
import java.util.HashMap;
import java.util.Map;

/*
* Execution Flow


get(key):
Check if the key exists in the HashMap.
If it exists:
Retrieve the corresponding DoubllyNodeWithKey.
Remove the DoubllyNodeWithKey from its current position in the doubly linked list.
Add it to the front of the list (marking it as MRU).
If it doesn’t exist, return -1.

put(key, value):
If the key already exists:
Update the value of the corresponding DoubllyNodeWithKey.
Move the DoubllyNodeWithKey to the front of the doubly linked list.
If the key doesn’t exist:
If the cache is full:
Remove the DoubllyNodeWithKey at the tail of the list (LRU).
Delete the key from the HashMap.
Create a new DoubllyNodeWithKey and add it to the front of the list.
Insert the key and DoubllyNodeWithKey into the HashMap.
*
*
Key Concepts:
HashMap ensures O(1) time complexity for lookup.
Doubly Linked List allows efficient removal and reordering of DoubllyNodeWithKeys.
Eviction always removes the DoubllyNodeWithKey at the tail of the list, which is the least recently used.
* */

class LRUCache {

  private final int capacity;
  private final Map<Integer, DoubllyNodeWithKey> cache;
  private final DoubllyNodeWithKey head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();

    // Initialize dummy head and tail DoubllyNodeWithKeys for the doubly linked list
    this.head = new DoubllyNodeWithKey(0, 0);
    this.tail = new DoubllyNodeWithKey(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);

    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    System.out.println("Cache after adding 3 items:");
    cache.printCache(); // (3, 30) (2, 20) (1, 10)

    cache.get(2); // Access key 2
    System.out.println("Cache after accessing key 2:");
    cache.printCache(); // (2, 20) (3, 30) (1, 10)

    cache.put(4, 40); // Add key 4, evicts key 1
    System.out.println("Cache after adding key 4:");
    cache.printCache(); // (4, 40) (2, 20) (3, 30)

    cache.get(1); // Key 1 is evicted
    System.out.println("Accessing key 1: " + cache.get(1)); // -1

    cache.put(5, 50); // Add key 5, evicts key 3
    System.out.println("Cache after adding key 5:");
    cache.printCache(); // (5, 50) (4, 40) (2, 20)
  }

  // Get a value from the cache
  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1; // Key not found
    }

    // Move the accessed DoubllyNodeWithKey to the front
    DoubllyNodeWithKey DoubllyNodeWithKey = cache.get(key);
    removeDoubllyNodeWithKey(DoubllyNodeWithKey);
    addDoubllyNodeWithKeyToFront(DoubllyNodeWithKey);

    return DoubllyNodeWithKey.value;
  }

  // Put a key-value pair into the cache
  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      // Update the existing DoubllyNodeWithKey
      DoubllyNodeWithKey DoubllyNodeWithKey = cache.get(key);
      DoubllyNodeWithKey.value = value;
      removeDoubllyNodeWithKey(DoubllyNodeWithKey);
      addDoubllyNodeWithKeyToFront(DoubllyNodeWithKey);
    } else {
      // Create a new DoubllyNodeWithKey
      if (cache.size() >= capacity) {
        // Remove the least recently used DoubllyNodeWithKey
        DoubllyNodeWithKey lru = tail.prev;
        removeDoubllyNodeWithKey(lru);
        cache.remove(lru.key);
      }
      DoubllyNodeWithKey newDoubllyNodeWithKey = new DoubllyNodeWithKey(key, value);
      addDoubllyNodeWithKeyToFront(newDoubllyNodeWithKey);
      cache.put(key, newDoubllyNodeWithKey);
    }
  }

  // Remove a DoubllyNodeWithKey from the doubly linked list
  private void removeDoubllyNodeWithKey(DoubllyNodeWithKey DoubllyNodeWithKey) {
    DoubllyNodeWithKey.prev.next = DoubllyNodeWithKey.next;
    DoubllyNodeWithKey.next.prev = DoubllyNodeWithKey.prev;
  }

  // Add a DoubllyNodeWithKey to the front (most recently used) of the doubly linked list
  private void addDoubllyNodeWithKeyToFront(DoubllyNodeWithKey DoubllyNodeWithKey) {
    DoubllyNodeWithKey.next = head.next;
    DoubllyNodeWithKey.prev = head;
    head.next.prev = DoubllyNodeWithKey;
    head.next = DoubllyNodeWithKey;
  }

  // Debug: Print the current state of the cache
  public void printCache() {
    DoubllyNodeWithKey temp = head.next;
    while (temp != tail) {
      System.out.print("(" + temp.key + ", " + temp.value + ") ");
      temp = temp.next;
    }
    System.out.println();
  }
}
