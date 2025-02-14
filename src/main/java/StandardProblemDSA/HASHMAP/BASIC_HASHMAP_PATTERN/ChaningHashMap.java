package StandardProblemDSA.HASHMAP.BASIC_HASHMAP_PATTERN;


public class ChaningHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Insert key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Retrieve values
        System.out.println("Alice: " + map.get("Alice")); // Output: 25
        System.out.println("Bob: " + map.get("Bob"));     // Output: 30
        System.out.println("Charlie: " + map.get("Charlie")); // Output: 35

        // Check if a key exists
        System.out.println("Contains Alice? " + map.containsKey("Alice")); // Output: true
        System.out.println("Contains Eve? " + map.containsKey("Eve"));     // Output: false

        // Remove a key-value pair
        map.remove("Bob");
        System.out.println("Bob after removal: " + map.get("Bob")); // Output: null

        // Test resizing
        for (int i = 0; i < 20; i++) {
            map.put("Key" + i, i);
        }
        System.out.println("Size after resizing: " + map.size());
    }

}

// creating a class of Node with key and value pair and with next Node pointer of it
// for handling collisions
class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    // constructor
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// create a HashMap class
//it use array of Node object as buckets , where each bucket points to
// the head of the linked list( to handle collsion)
//this contain default value 
class MyHashMap<K, V> {
    private static final double LOAD_FACTOR = 0.75;
    private Node<K, V>[] buckets; // array of buckets
    private int capacity;// no of buckets 
    private int size; // current no of eleemnts inthe hashmap

    // constructor; Intitialise the hashMap with default capacity
    public MyHashMap() {
        this.capacity = 16; // default capacity
        this.buckets = new Node[capacity];
        this.size = 0; // intial size of 
    }

    // hashing function to calculate bucket index
    private int getBucketIndex(K key) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Core Basic functionality of the HashMap
    // Put method of key and value pair
    public void put(K key, V value) {
        // step 1 : first we will check if the key is already exist
        // if exist lets get the index of the key
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        // check if it already present in the bucket, then update it with new value 
        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                head.value = value; // update value
                return;
            }
            head = head.next;
        }

        // if not exists
        // then create a new key and value of linked list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        // check load factor and if it is got changed from 0.75 recalculate it
        if ((1.0 * size) / capacity > LOAD_FACTOR) {
            // RESIZE THE BUCKET
            resize();
        }
    }

    // resize if the hashmap got capcity overload and recalculate of each node hashcode
    /*Resize the HashMap (Dynamic Hashing):
When the load factor exceeds 0.75, resize the array by doubling its capacity.
Rehash all existing key-value pairs into the new array.
*/
    private void resize() {
        int newCapcity = capacity * 2;
        // create array of nodes with new capacity size
        Node<K, V>[] newBuckets = new Node[newCapcity];

        // now loop over the old buckets and calculate the index of each key hashcode and put into new bucket
        for (Node<K, V> head : buckets) {
            while (head != null) {
                int newIndex = Math.abs((head.key == null) ? 0 : head.key.hashCode()) % newCapcity;

                // next of the head
                Node<K, V> next = head.next;

                // insert node into the new bucket array
                head.next = newBuckets[newIndex];
                newBuckets[newIndex] = head;

                head = next;
            }
        }
        // new bucket will be the new bucket
        buckets = newBuckets;
        capacity = newCapcity;

    }

    /*Find the bucket index using the hash function.
Traverse the linked list in the bucket to find the key.
Return the associated value if the key is found, or null if it is not.*/
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // Traverse the linked list to find the key
        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                return head.value; // Key found, return value
            }
            head = head.next;
        }

        return null; // Key not found
    }

    // now remove the element if present
    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index]; // check what is the Node present on that index

        Node<K, V> prevNod = null;
        // Traverse the linked list to find the key
        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                if (prevNod == null) {
                    buckets[index] = head.next; // Remove the head node
                } else {
                    prevNod.next = head.next; // Remove the current node
                }
                size--;
                return;
            }
            // make the previous node as head node

            prevNod = head;
            head = head.next;
        }
    }

    // check if key is contain return true/false
    public boolean containsKey(K key) {
        return get(key) != null;
    }


    public int size() {
        return capacity;
    }
}





















































