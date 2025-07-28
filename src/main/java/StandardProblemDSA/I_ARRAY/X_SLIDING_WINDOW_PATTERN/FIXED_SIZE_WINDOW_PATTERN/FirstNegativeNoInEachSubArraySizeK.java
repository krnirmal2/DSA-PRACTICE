package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Question:
Given an array Arr[] and an integer K, find the first negative number in every contiguous subarray of size K.
If a subarray does not contain any negative numbers, add 0 for that window.

Example:
Input: Arr = [12, -1, -7, 8, -15, 30, 16, 28], K = 3
Output: [-1, -1, -7, -15, -15, 0]

Explanation:
For each window of size 3:
[12, -1, -7] → -1
[-1, -7, 8] → -1
[-7, 8, -15] → -7
[8, -15, 30] → -15
[-15, 30, 16] → -15
[30, 16, 28] → 0

Approach:
1. Use the Sliding Window technique.
2. Maintain a queue (FIFO) that stores the negative numbers in the current window.
3. Traverse the array using two pointers (i, j):
   - Expand the window by moving j.
   - If Arr[j] is negative, add it to the queue.
   - When window size < K → keep expanding.
   - When window size == K:
        - The first element in the queue is the first negative number in this window.
        - If queue is empty, no negative number → add 0.
        - Before sliding the window, check if the outgoing element (Arr[i]) is equal to queue.peek().
          If yes, remove it from the queue.
        - Slide the window (increment i, j).
4. Collect results for each window in a list.

Pattern:
- Sliding Window (fixed size) + Queue to track first negative number.

Time Complexity:
- O(n), where n is the length of Arr (each element is added and removed from the queue at most once).

Space Complexity:
- O(k) in worst case, for storing negative numbers in the queue.

Follow-up Questions:
1. Can you solve this without extra space (queue)?
2. How would you adapt this for the first positive number in each window?
3. How would you print the indices of the first negative number instead of the value?
4. How would you handle this problem in a streaming scenario where data comes continuously?

Similar LeetCode/Interview Questions:
- First Negative Integer in Every Window of Size K (GFG)
- LeetCode 239. Sliding Window Maximum (variation)
- LeetCode 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (variation)
*/

public class FirstNegativeNoInEachSubArraySizeK {
  /*  public static List<Integer> firstNegativeBruteForce(int[] arr, int k) {
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i <= arr.length - k; i++) {
          boolean found = false;
          for (int j = i; j < i + k; j++) {
              if (arr[j] < 0) {
                  result.add(arr[j]);e
                  found = true;
                  break;
              }
          }
          if (!found) result.add(0);
      }
      return result;
  }*/
  public static List<Integer> firstNegativeInWindow(int[] Arr, int K) {
    // Aprroach for first negative no. in each window of size k
    // 1. Edge case if the k size is greater than array size then there no will not any answer
    // 2. else , what we will do
    // 3. iterate over the window , if the element is negative insert this it in to queus
    // 4. when the window size == k then if there any element present in the peek()
    // 5. we that peek in to the result
    // 6. we will remove the pick from the queue ,  if there is element present else not

    int i = 0, j = 0;
    List<Integer> result = new ArrayList<>();
    Queue<Integer> negativesQueue = new LinkedList<>();

    while (j < Arr.length) {
      // 1. If current element is negative, add it to the queue
      if (Arr[j] < 0) {
        negativesQueue.add(Arr[j]);
      }

      // 2. CASE 1 : EXPAND WINDOW
      // Check if window size is less than K
      if (j - i + 1 < K) {
        j++; // Expand window
      }
      // 3. CASE 2: WINDOW SIZE EQUALS TO K
      // When window size becomes exactly K
      else if (j - i + 1 == K) {
        // a. If there are negatives, record the first one
        if (!negativesQueue.isEmpty()) {
          result.add(negativesQueue.peek());
        } else {
          result.add(0); // No negative in this window
        }
        // CASE 3: SHRINK THE WINDOW OR SLIDE THE WINDOW
        // b. Before sliding the window, remove the outgoing element from queue if needed
        if (!negativesQueue.isEmpty() && negativesQueue.peek() == Arr[i]) {
          negativesQueue.poll();
        }

        // c. Slide the window
        i++;
        j++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] Arr = {12, -1, -7, 8, -15, 30, 16, 28};
    int K = 3;
    System.out.println(firstNegativeInWindow(Arr, K));
  }
  /*Input:

  Arr = [12, -1, -7, 8, 15, 30, 16, 28]
  K = 3

  i	j	Window	Queue	First Negative	Result
  0	0	[12]	[]	—
  0	1	[12, -1]	[-1]	—
  0	2	[12, -1, -7]	[-1, -7]	-1	[-1]
  1	3	[-1, -7, 8]	[-7]	-7	[-1, -7]
  2	4	[-7, 8, 15]	[]	0	[-1, -7, 0]
  3	5	[8, 15, 30]	[]	0	[-1, -7, 0, 0]
  4	6	[15, 30, 16]	[]	0	[-1, -7, 0, 0, 0]
  5	7	[30, 16, 28]	[]	0	[-1, -7, 0, 0, 0, 0]
  ✅ So, Final Result = [-1, -7, 0, 0, 0, 0]*/
}
