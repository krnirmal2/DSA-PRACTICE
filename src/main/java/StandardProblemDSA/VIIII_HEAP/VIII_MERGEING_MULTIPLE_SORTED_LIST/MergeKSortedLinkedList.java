package StandardProblemDSA.VIIII_HEAP.VIII_MERGEING_MULTIPLE_SORTED_LIST;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
  /*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

  Merge all the linked-lists into one sorted linked-list and return it.
          Example 1:
  Input: lists = [[1,4,5],[1,3,4],[2,6]]
  Output: [1,1,2,3,4,4,5,6]
  Explanation: The linked-lists are:
          [
          1->4->5,
          1->3->4,
          2->6
          ]
  merging them into one sorted list:
          1->1->2->3->4->4->5->6*/
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    // Min Heap to store nodes based on value
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
    // Add the head of each list into the priority queue
    for (ListNode node : lists) {
      if (node != null) {
        pq.offer(node);
      }
    }
    // Dummy node to start building the result list
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!pq.isEmpty()) {
      // extract the smallest node each time
      ListNode curr = pq.poll();
      // linked the new samllest element to the next of the element
      tail.next = curr;
      tail = tail.next;

      // If there are more nodes in this list, add the next one
      if (curr.next != null) {
        // push that element in to pq which sort acc to min heap rule as we set erlier
        pq.offer(curr.next);
      }
    }
    return dummy.next; // head of the new node
  }
  /*
      Let's walk through an example step-by-step and match the code to each part of the process.
  ### **Example**:
  Given 3 linked lists:
  1. **List 1**: `1 -> 4 -> 5`
  2. **List 2**: `1 -> 3 -> 4`
  3. **List 3**: `2 -> 6`

  The goal is to merge them into one sorted list.

  ---

  ### **Step-by-Step Execution**:

  1. **Initial Setup**:

     ```java
     PriorityQueue<ListNode> pq = new PriorityQueue<>(
         (a, b) -> Integer.compare(a.val, b.val)
     );
     ```

     - **Action**: A priority queue (min-heap) is initialized. It will store the nodes sorted by their `val` in ascending order.
     - **Reason**: Min-heap will help us pick the smallest node efficiently at every step.

  ---

  2. **Add Head of Each List to the Priority Queue**:

     ```java
     for (ListNode node : lists) {
         if (node != null) {
             pq.offer(node);
         }
     }
     ```

     - **Action**: Adds the head node of each list into the priority queue.
       - First, `ListNode` with value `1` from List 1 is added.
       - Then, `ListNode` with value `1` from List 2 is added.
       - Lastly, `ListNode` with value `2` from List 3 is added.

     - **Priority Queue State**: After inserting, the priority queue will look like this:
       ```
       [1 (from List 1), 1 (from List 2), 2 (from List 3)]
       ```
     - **Reason**: The priority queue is sorted by node values, so the smallest nodes are at the top.

  ---

  3. **Dummy Node & Tail Pointer**:

     ```java
     ListNode dummy = new ListNode(0);
     ListNode tail = dummy;
     ```

     - **Action**: A dummy node is created to act as a placeholder, and the `tail` pointer is initialized to point to this dummy node.
     - **Reason**: The dummy node allows us to easily build the result list without worrying about special handling for the head node.

  ---

  4. **Start Merging the Lists**:

     ```java
     while (!pq.isEmpty()) {
     ```

     - **Action**: The loop continues while the priority queue is not empty. This ensures we keep merging until all the nodes are processed.
     - **Reason**: As long as there are nodes left to merge, the loop will keep iterating.

  ---

  5. **Poll the Smallest Node from the Priority Queue**:

     ```java
     ListNode curr = pq.poll();
     ```

     - **Action**: The smallest node is removed from the priority queue.
       - In the first iteration, `1` from List 1 is removed (because it has the smallest value).

     - **Priority Queue State**: After polling, the priority queue looks like:
       ```
       [1 (from List 2), 2 (from List 3)]
       ```

     - **Reason**: We poll the smallest element, which will be added to the result list.

  ---

  6. **Add the Smallest Node to the Result List**:

     ```java
     tail.next = curr;
     tail = tail.next;
     ```

     - **Action**: The smallest node (`curr`) is added to the merged result list by linking it to the `tail`.
       - The `tail` is then updated to point to the newly added node.

     - **Result List**:
       ```
       dummy -> 1
       ```

     - **Reason**: This connects the smallest node to the merged list.

  ---

  7. **Add the Next Node of the Pollled Node (If Any)**:

     ```java
     if (curr.next != null) {
         pq.offer(curr.next);
     }
     ```

     - **Action**: If the node we just added (`curr`) has a next node, it is added to the priority queue.
       - The node with value `4` (from List 1) is added to the priority queue.

     - **Priority Queue State**: After this operation, the priority queue looks like:
       ```
       [1 (from List 2), 2 (from List 3), 4 (from List 1)]
       ```

     - **Reason**: We want to keep track of the remaining nodes from the lists, so if the node has a next value, it gets pushed into the priority queue.

  ---

  8. **Repeat the Process**:

     The above steps are repeated until the priority queue is empty. Let's continue:

     - **Second Poll**:
       - `1` (from List 2) is polled.
       - It's added to the result list: `dummy -> 1 -> 1`.
       - Add the next node (`3` from List 2) to the priority queue.

       **Priority Queue State**: `[2, 3, 4]`

     - **Third Poll**:
       - `2` (from List 3) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2`.
       - Add the next node (`6` from List 3) to the priority queue.

       **Priority Queue State**: `[3, 4, 6]`

     - **Fourth Poll**:
       - `3` (from List 2) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2 -> 3`.
       - Add the next node (`4` from List 2) to the priority queue.

       **Priority Queue State**: `[4, 4, 6]`

     - **Fifth Poll**:
       - `4` (from List 1) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2 -> 3 -> 4`.
       - Add the next node (`5` from List 1) to the priority queue.

       **Priority Queue State**: `[4, 5, 6]`

     - **Sixth Poll**:
       - `4` (from List 2) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> 4`.
       - No more nodes from List 2.

       **Priority Queue State**: `[5, 6]`

     - **Seventh Poll**:
       - `5` (from List 1) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5`.
       - No more nodes from List 1.

       **Priority Queue State**: `[6]`

     - **Eighth Poll**:
       - `6` (from List 3) is polled.
       - It's added to the result list: `dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6`.
       - No more nodes from List 3.

       **Priority Queue State**: `[]`

  ---

  9. **Return the Merged List**:

     ```java
     return dummy.next;
     ```

     - **Action**: The merged list is returned, excluding the dummy node.
     - **Final Merged List**:
       ```
       1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
       ```

  ---

  ### **Summary of Code's Actions**:

  - **Add the first node from each list to the priority queue**.
  - **Poll the smallest node** and add it to the result list.
  - **Add the next node from the same list** to the queue, if available.
  - **Repeat** until all nodes are processed.
  - **Return the merged result**.

  This approach ensures that the smallest nodes are always processed first, using the power of the priority queue to efficiently merge the lists.*/
}
