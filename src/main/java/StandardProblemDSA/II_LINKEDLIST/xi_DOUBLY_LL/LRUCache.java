package StandardProblemDSA.II_LINKEDLIST.xi_DOUBLY_LL;

import java.util.HashMap;
import java.util.Map;

/*
 Problem: Design an LRU Cache with O(1) get and put operations.

 Use a HashMap for O(1) key lookup, and a doubly linked list to track usage order:
  - Most recently used (MRU) nodes are near the head.
  - Least recently used (LRU) nodes are near the tail.
 When cache reaches capacity, evict LRU node (tail.prev).

 Execution Flow:
  get(key):
    - Check if key exists in map.
    - If yes, move node to front (MRU) and return its value.
    - Else return -1.

  put(key, value):
    - If key exists, update value and move node to front.
    - Else if full, evict LRU (tail.prev), remove from map.
    - Insert new node at front and add to map.

 Pattern:
  - HashMap + Doubly Linked List
  - Cache eviction policy (LRU)
  - Data structure design

 Similar LeetCode Problems:
  - 146. LRU Cache
  - 362. Design Hit Counter
  - 460. LFU Cache (similar cache design)

 Follow-up Questions:
  - How to handle thread safety (concurrent access)?
  - How to implement LFU cache?
  - What changes for distributed caching?
  - Can we use a singly linked list instead?

 Time Complexity: O(1) for get and put
 Space Complexity: O(capacity)
*/

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

// Node class for the doubly linked list
class DoublyLinkedNode {
  int key; // Key of the cache entry
  int value; // Value of the cache entry
  DoublyLinkedNode prev; // Pointer to previous node
  DoublyLinkedNode next; // Pointer to next node

  public DoublyLinkedNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

/*       Why This Combination Works
        HashMap alone can’t track usage order efficiently.
        Linked List alone would require O(n) search to find a node.

        Together:
        HashMap gives direct access to the node.
        Doubly Linked List keeps most recently used items at the front and least recently used at the back.

*/
public class LRUCache {
  // Step 1: Define capacity and data structures
  private final int capacity; // Maximum number of items the cache can hold
  private final Map<Integer, DoublyLinkedNode> cacheMap; // Key → Node mapping for O(1) access
  private final DoublyLinkedNode headDummy; // Dummy head node (most recently used side)
  private final DoublyLinkedNode tailDummy; // Dummy tail node (least recently used side)

  // Step 2: Constructor - initialize capacity, map, and dummy nodes
  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cacheMap = new HashMap<>();

    // Create dummy head and tail to avoid null checks during insert/remove
    this.headDummy = new DoublyLinkedNode(0, 0);
    this.tailDummy = new DoublyLinkedNode(0, 0);

    // Link head and tail together initially
    headDummy.next = tailDummy;
    tailDummy.prev = headDummy;
  }

  // Step 3: Get value by key
  public int get(int key) {
    if (!cacheMap.containsKey(key)) {
      return -1; // Key not found
    }

    // Move accessed node to the front (most recently used)
    DoublyLinkedNode node = cacheMap.get(key);
    removeNode(node);
    addNodeToFront(node);

    return node.value;
  }

  // Step 4: Put key-value into cache
  public void put(int key, int value) {
    if (cacheMap.containsKey(key)) {
      // If key exists, update value and move to front
      DoublyLinkedNode existingNode = cacheMap.get(key);
      existingNode.value = value;
      removeNode(existingNode);
      addNodeToFront(existingNode);
    } else {
      // If key doesn't exist, create new node
      if (cacheMap.size() >= capacity) {
        // Remove least recently used node (before tailDummy)
        DoublyLinkedNode lruNode = tailDummy.prev;
        removeNode(lruNode);
        cacheMap.remove(lruNode.key);
      }
      DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
      addNodeToFront(newNode);
      cacheMap.put(key, newNode);
    }
  }

  // Step 5: Remove a node from the doubly linked list
  private void removeNode(DoublyLinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  // Step 6: Add a node right after the dummy head (most recently used position)
  private void addNodeToFront(DoublyLinkedNode node) {
    node.next = headDummy.next;
    node.prev = headDummy;
    headDummy.next.prev = node;
    headDummy.next = node;
  }

  // Step 7: Debug method to print current cache state from most to least recently used
  public void printCacheState() {
    DoublyLinkedNode current = headDummy.next;
    while (current != tailDummy) {
      System.out.print("(" + current.key + ", " + current.value + ") ");
      current = current.next;
    }
    System.out.println();
  }

  // Step 8: Test the LRUCache
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);

    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    System.out.println("After adding 3 items:");
    cache.printCacheState(); // (3, 30) (2, 20) (1, 10)

    cache.get(2); // Access key 2 → moves to front
    System.out.println("After accessing key 2:");
    cache.printCacheState(); // (2, 20) (3, 30) (1, 10)

    cache.put(4, 40); // Add key 4 → evicts key 1
    System.out.println("After adding key 4:");
    cache.printCacheState(); // (4, 40) (2, 20) (3, 30)

    System.out.println("Accessing key 1: " + cache.get(1)); // -1 (evicted)

    cache.put(5, 50); // Add key 5 → evicts key 3
    System.out.println("After adding key 5:");
    cache.printCacheState(); // (5, 50) (4, 40) (2, 20)
  }
}
/*

## **Initial State**
Capacity = 3
cacheMap: {}
Linked List: headDummy ↔ tailDummy

### **1. put(1, 10)**
- Key 1 not in map, cache not full.
- Create node `(1,10)` and insert after headDummy.
- Add to map.
```
cacheMap: { 1 → (1,10) }
Linked List: headDummy ↔ (1,10) ↔ tailDummy
```

### **2. put(2, 20)**
- Key 2 not in map, cache not full.
- Create `(2,20)` and insert after headDummy.

cacheMap: { 1 → (1,10), 2 → (2,20) }
Linked List: headDummy ↔ (2,20) ↔ (1,10) ↔ tailDummy
---

### **3. put(3, 30)**
- Key 3 not in map, cache not full.
- Create `(3,30)` and insert after headDummy.

cacheMap: { 1 → (1,10), 2 → (2,20), 3 → (3,30) }
Linked List: headDummy ↔ (3,30) ↔ (2,20) ↔ (1,10) ↔ tailDummy
---

### **4. get(2)**
- Key 2 found in map → node `(2,20)`.
- Remove `(2,20)` from current position.
- Insert `(2,20)` after headDummy.
```
cacheMap: { 1 → (1,10), 2 → (2,20), 3 → (3,30) }
Linked List: headDummy ↔ (2,20) ↔ (3,30) ↔ (1,10) ↔ tailDummy
---

### **5. put(4, 40)**
- Key 4 not in map, cache is full (size = 3).
- Remove LRU node → node before tailDummy = `(1,10)`.
- Remove `(1,10)` from list and map.
- Create `(4,40)` and insert after headDummy.

```
cacheMap: { 2 → (2,20), 3 → (3,30), 4 → (4,40) }
Linked List: headDummy ↔ (4,40) ↔ (2,20) ↔ (3,30) ↔ tailDummy
```

---

### **6. get(1)**
- Key 1 not in map → return `-1`.
- No change to list or map.

```
cacheMap: { 2 → (2,20), 3 → (3,30), 4 → (4,40) }
Linked List: headDummy ↔ (4,40) ↔ (2,20) ↔ (3,30) ↔ tailDummy
```

---

### **7. put(5, 50)**
- Key 5 not in map, cache is full.
- Remove LRU node `(3,30)` (before tailDummy).
- Remove from map.
- Create `(5,50)` and insert after headDummy.

```
cacheMap: { 2 → (2,20), 4 → (4,40), 5 → (5,50) }
Linked List: headDummy ↔ (5,50) ↔ (4,40) ↔ (2,20) ↔ tailDummy
```

---

✅ **Final Output** after all operations:
```
(5,50) (4,40) (2,20)
```
This matches the expected LRU behavior — most recently used at the front, least recently used at the back.

---

If you want, I can now **draw a visual diagram** showing the linked list arrows moving after each step so you can literally see the nodes being re-linked. That would make the dry run even more intuitive.
Do you want me to prepare that visual trace?*/
