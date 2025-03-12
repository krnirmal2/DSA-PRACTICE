package StandardProblemDSA.LINKEDLIST.DOUBLY_LL;

import java.util.HashMap;
import java.util.Map;
/*
* Execution Flow


get(key):
Check if the key exists in the HashMap.
If it exists:
Retrieve the corresponding node.
Remove the node from its current position in the doubly linked list.
Add it to the front of the list (marking it as MRU).
If it doesn’t exist, return -1.

put(key, value):
If the key already exists:
Update the value of the corresponding node.
Move the node to the front of the doubly linked list.
If the key doesn’t exist:
If the cache is full:
Remove the node at the tail of the list (LRU).
Delete the key from the HashMap.
Create a new node and add it to the front of the list.
Insert the key and node into the HashMap.
*
*
Key Concepts:
HashMap ensures O(1) time complexity for lookup.
Doubly Linked List allows efficient removal and reordering of nodes.
Eviction always removes the node at the tail of the list, which is the least recently used.
* */

class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize dummy head and tail nodes for the doubly linked list
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
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

        // Move the accessed node to the front
        Node node = cache.get(key);
        removeNode(node);
        addNodeToFront(node);

        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the existing node
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeToFront(node);
        } else {
            // Create a new node
            if (cache.size() >= capacity) {
                // Remove the least recently used node
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            addNodeToFront(newNode);
            cache.put(key, newNode);
        }
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node to the front (most recently used) of the doubly linked list
    private void addNodeToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Debug: Print the current state of the cache
    public void printCache() {
        Node temp = head.next;
        while (temp != tail) {
            System.out.print("(" + temp.key + ", " + temp.value + ") ");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
