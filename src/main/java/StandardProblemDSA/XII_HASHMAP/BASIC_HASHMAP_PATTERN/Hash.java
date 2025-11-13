package StandardProblemDSA.XII_HASHMAP.BASIC_HASHMAP_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class Hash {
  // step 1 : use the table size == bucket count
  private int bucketCount;
  // No of element that we will put into the bucket
  private int noOfElements;
  // table which hold the list of element
  private List<List<Integer>> table;

  // Step 2 : constuctor when create any hash map we have to provide the hashtable bukcet count
  public Hash(int buckets) {
    bucketCount = buckets;
    noOfElements = 0;
    table = new ArrayList<>();

    // like graph implmentation of adjacency list we have to put same
    for (int i = 0; i < bucketCount; i++) {
      table.add(new ArrayList<>());
    }
  }

  // Step 3 : now after create the hashmap we will insert key and value pair to it
  public void insert(int key) {
    // Step 3.1 Before insert check
    // if load factor exceeds 0.5 perform rehasing if yes called rehash to calculate laod factor
    // again
    while (getLoadFactor() > 0.5) {
      rehash();
    }
    // Step 3.2 to put the key we have to calculate where we have to put
    // using hash function mathemitical
    int index = getHashIndex(key);

    // Step 3.3 , after get index we have to add this to adjacency list
    // by that particular index
    table.get(index).add(key);
    // Step 3.4 increment the element that will help how many element
    noOfElements++;
  }

  // step 4 : Remove a key from the hash table
  public void remove(int key) {
    int index = getHashIndex(key);
    // as we get the index we can remove this from adjacency list
    table.get(index).remove((Integer) key);

    // reduce the no. of elemet
    noOfElements--;
  }

  private double getLoadFactor() {
    return (float) noOfElements / bucketCount;
  }

  private int getHashIndex(int key) {
    return key % bucketCount;
  }

  // Step 5 : double the size of the table bukcet and create a new adjacencey list of that no.
  // of bukcet count and again put the earlier element to the new arraylist
  private void rehash() {
    // Step 5.1 increase the bucket count to double
    List<List<Integer>> oldTable = table; // used for populate old table value new table value
    bucketCount *= 2;
    // Step 5.2 create a new adjacency list with new bucket count
    table = new ArrayList<>();
    for (int i = 0; i < bucketCount; i++) {
      table.add(new ArrayList<>());
    }
    noOfElements = 0;
    // Step 5.3 put the oldatble value to the new table by picking one by one
    for (List<Integer> bucket : oldTable) { // iterate over each of the older array
      for (int key : bucket) { // take key of each bucket
        insert(key); // call the insert  implement method that we have implemented
      }
    }
  }

  // Step 6 . create a client/main class for calling
  public static void main(String[] args) {
    int[] keys = {15, 11, 27};
    Hash hashTable = new Hash(5); // bucket with 5

    for (int key : keys) {
      hashTable.insert(key);
    }
    hashTable.display();

    // hashTable
    hashTable.remove(11);
    hashTable.insert(19);
    hashTable.display();
  }

  /*Complexity analysis of Insert:

  Time Complexity: O(n), as we are checking the load factor each time and when it is greater than 0.5 we call rehashing function which takes O(n) time.
  Auxiliary Space: O(n)
  Complexity analysis of Search:

  Time Complexity: O(n)
  Auxiliary Space: O(1)*/

  // Display all buckets and elements
  public void display() {
    for (int i = 0; i < bucketCount; i++) {
      System.out.print(i);
      for (int key : table.get(i)) {
        System.out.print(" --> " + key);
      }
      System.out.println();
    }
  }
}
