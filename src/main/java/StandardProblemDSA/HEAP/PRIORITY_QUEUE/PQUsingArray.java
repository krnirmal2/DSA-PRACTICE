package StandardProblemDSA.HEAP.PRIORITY_QUEUE;


// Structure for the elements in the
// priority queue
class Item {
    public int value;
    public int priority;
}

public class PQUsingArray {

    // for create a priority queue with array
    // we need to take array of item above having value with priority
    static int queueArraySize = 1000;
    static Item[] queueUsingArray = new Item[queueArraySize];

    // now we will implement three CRUD operation
    // create (enque)
    // pick
    //Delete (deque)
    public void equeue(Item item) {
        // check if the queueUsingArray is full


        // else
        // insert
        // for insertion we follow
        // insert at the bottom or last element
        // and then heapify based on priority of the item
    }

}
