package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.HashMap;

/*
Question:
Given an array A[] and an integer B, find the number of distinct (unique) elements in every contiguous subarray of size B.

Example:
Input:  A = [1, 2, 1, 3, 4, 2, 3], B = 4
Output: [3, 4, 4, 3]
Explanation:
- Windows: [1,2,1,3] → {1,2,3} → 3
            [2,1,3,4] → {1,2,3,4} → 4
            [1,3,4,2] → {1,2,3,4} → 4
            [3,4,2,3] → {2,3,4} → 3

Approach:
1. **Use a HashMap to store frequencies of elements in the current window**:
   - Key → element, Value → frequency.
2. Iterate through the array with a sliding window:
   - Add the current element to the map.
   - When the window size equals B:
     - The size of the map = number of unique elements → add to result.
     - Before sliding, decrease frequency of the outgoing element.
     - If its frequency becomes 0, remove it from the map.
     - Move the window forward.

Pattern:
- Fixed-size sliding window + frequency map.

Time Complexity:
- O(n), as each element is added and removed from the map once.

Space Complexity:
- O(k), where k = number of unique elements in a window.

Follow-up Questions:
1. How would you modify the code to count distinct elements in variable-sized windows?
2. Can you do this with O(1) additional space (without HashMap)?

Similar Problems:
- LeetCode 992: Subarrays with K Different Integers.
- Sliding Window Maximum Number of Distinct Elements.
*/

public class UniqueElementINEachSubArrrayOfSizeB {
  // No of unique eleemnt in each array with size k
  // subarray with size k
  // Number of unique elements in each subarray of size B
  public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
    ArrayList<Integer> result = new ArrayList<>();
    // frequency of the elemet
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    int startWindow = 0;
    // start from the zero and go till end
    for (int endWindow = 0; endWindow < A.size(); endWindow++) {
      int endElem = A.get(endWindow);
      // if found increase else put the element and its frequency
      freqMap.put(endElem, freqMap.getOrDefault(endElem, 0) + 1);

      // Check if window size matches
      if (endWindow - startWindow + 1 == B) {
        // add the size of  the map give no. of unique element in the window
        result.add(freqMap.size());

        int startElem = A.get(startWindow);
        // before sliding he windown need to decreased the
        // frequency by one as next window may contain same element
        //
        freqMap.put(startElem, freqMap.get(startElem) - 1);
        // if the frequency of the element at start is zero remove that element
        if (freqMap.get(startElem) == 0) {
          freqMap.remove(startElem);
        }
        startWindow++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(1);
    A.add(2);
    A.add(1);
    A.add(3);
    A.add(4);
    A.add(3);

    int B = 3;
    ArrayList<Integer> result = dNums(A, B);
    for (Integer i : result) {
      System.out.println(i);
    }
  }
  /*A = [1, 2, 1, 3, 4, 3]
  B = 3
  We want to find number of unique elements in each subarray of size 3.

  Initial:
  startWindow = 0

  freqMap = {}

  result = []

  Step-by-Step:

  endWindow	A[endWindow]	Action	freqMap	Window	result
  0	1	Insert 1 ➔ freqMap(1 → 1)	{1=1}	[1]
  1	2	Insert 2 ➔ freqMap(2 → 1)	{1=1, 2=1}	[1,2]
  2	1	Insert 1 ➔ freqMap(1 → 2) (Already present, so count++)	{1=2, 2=1}	[1,2,1]
  Window size == B (3) ➔ Add freqMap.size() ➔ 2 unique elements	{1=2, 2=1}	[1,2,1]	[2]
  Remove A[startWindow] (1) ➔ Decrease count (1→1)	{1=1, 2=1}
  Move startWindow++ ➔ startWindow = 1
  3	3	Insert 3 ➔ freqMap(3 → 1)	{1=1, 2=1, 3=1}	[2,1,3]	[2]
  Window size == B (3) ➔ Add freqMap.size() ➔ 3 unique elements			[2,3]
  Remove A[startWindow] (2) ➔ Decrease count (2→0) ➔ remove 2 from map	{1=1, 3=1}
  Move startWindow++ ➔ startWindow = 2
  4	4	Insert 4 ➔ freqMap(4 → 1)	{1=1, 3=1, 4=1}	[1,3,4]	[2,3]
  Window size == B (3) ➔ Add freqMap.size() ➔ 3 unique elements			[2,3,3]
  Remove A[startWindow] (1) ➔ Decrease count (1→0) ➔ remove 1 from map	{3=1, 4=1}
  Move startWindow++ ➔ startWindow = 3
  5	3	Insert 3 ➔ freqMap(3 → 2)	{3=2, 4=1}	[3,4,3]	[2,3,3]
  Window size == B (3) ➔ Add freqMap.size() ➔ 2 unique elements		(But no more window)
  Final Output:
  java
  Copy
  Edit
  [2, 3, 3]
  ✅

  Key Points Observed:
  A duplicate inside the window reduces unique count.

  Window slides by moving startWindow forward, carefully adjusting the freqMap.

  We maintain the frequency in the map so we always know how many unique elements are in current window.

  */
}
