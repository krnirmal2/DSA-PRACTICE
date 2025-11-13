package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBusket {
  /*   "🔢🐌 Brute Force Approach
              1️⃣Loop through each starting index i.
              2️⃣From each i, loop to find the longest subarray with at most 2 distinct elements.
              3️⃣Use a Set/Map to track types of fruits.
              4️⃣If more than 2 types are found, break and move to next i.
  5️⃣Update maxLength if longer valid subarray is found.
  🕒Time: O(n²) 📦 Space: O(1)

  "	"⚡🚀 Optimal Approach (Sliding Window + HashMap)
  1️⃣Initialize start = 0, maxLength = 0, Map<fruit, count>.
              2️⃣Loop end from 0 to n - 1:
              3️⃣   Add fruits[end] to map and increment its count.
              4️⃣       While map size > 2:
              5️⃣         Decrement count of fruits[start].
              6️⃣         If count becomes 0, remove it from map.
              7️⃣         Move start++.
              8️⃣Update maxLength = max(maxLength, end - start + 1).
  9️⃣Return maxLength.
              🕒Time: O(n) 📦 Space: O(1) → Only 2 fruits at most"*/

  /*You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are
        represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
    You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
    You only have two baskets, and each basket can only hold a single type of fruit.
    There is no limit on the amount of fruit each basket can hold.
    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
    while moving to the right. The picked fruits must fit in one of your baskets.
    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
    Given the integer array fruits, return the maximum number of fruits you can pick.
    Example 1:
    Input: fruits = [1,2,1]
    Output: 3
    Explanation: We can pick from all 3 trees.
    Example 2:
    Input: fruits = [0,1,2,2]
    Output: 3
    Explanation: We can pick from trees [1,2,2].
    If we had started at the first tree, we would only pick from trees [0,1].
    Example 3:

    Input: fruits = [1,2,3,2,2]
    Output: 4
    Explanation: We can pick from trees [2,3,2,2].
    If we had started at the first tree, we would only pick from trees [1,2].


    Constraints:

    1 <= fruits.length <= 105
    0 <= fruits[i] < fruits.length
    Pattern
  ------------------------------------------------------
  Pattern Name: Variable-Size Sliding Window (at most K distinct elements)
  - Maintain a sliding window of fruits with at most 2 distinct types.
  - Expand the window by moving `j` (right pointer).
  - If window has more than 2 types, shrink it by moving `i` (left pointer) until only 2 remain.
  - Track the maximum window size.

  Why Sliding Window?
  - Because we’re looking for the longest contiguous subarray with at most 2 distinct elements.

  ------------------------------------------------------
  Follow-up Questions
  ------------------------------------------------------
  1. What if we have `k` baskets instead of 2?
     - Generalize the solution to "Longest Subarray with At Most K Distinct Elements" by replacing `2` with `k`.

  2. Can we find the actual subarray of fruits picked?
     - Keep track of the window indices `i` and `j` when updating `max`.

  3. How would the solution change if we were allowed to skip trees?
     - Then we’d look for "any subarray" (not necessarily contiguous) → becomes a different problem (frequency counting, not sliding window).

  4. What if we have to count the number of such subarrays?
     - Modify logic to count all windows with ≤ 2 distinct types.

  5. Is it possible to solve it in O(1) space?
     - No, we must track at most 2 fruit types → O(1) extra space using a HashMap or two pointers.

  ------------------------------------------------------
  Similar LeetCode Questions
  ------------------------------------------------------
  - LeetCode 904 – Fruit Into Baskets (exact problem)
  - LeetCode 159 – Longest Substring with At Most Two Distinct Characters (string variant)
  - LeetCode 340 – Longest Substring with At Most K Distinct Characters (generalized pattern)
  - LeetCode 992 – Subarrays with K Different Integers (count subarrays with exactly K distinct elements)

  ------------------------------------------------------
  Time & Space Complexity
  ------------------------------------------------------
  - Time Complexity: O(n) – each element is added and removed from the window at most once.
  - Space Complexity: O(1) – we store at most 2 fruit types in the HashMap.*/

  public static int totalFruit(int[] fruits) {
    int n = fruits.length;
    if (n == 0) return 0;
    // maximum sum of subarray of where the no. of distinct element prsent = 2;
    // as it is left-> right and we have to contiguous pick the fruits ad if more than 2 type of
    // fruits is came then need to stop or remove the last element
    int i = 0;
    int max = 0;

    Map<Integer, Integer> fruitCount = new HashMap<>();

    for (int j = 0; j < n; j++) {
      fruitCount.put(fruits[j], fruitCount.getOrDefault(fruits[j], 0) + 1);

      // Shrink the window until there are only 2 types of fruits
      while (fruitCount.size() > 2) {
        fruitCount.put(fruits[i], fruitCount.get(fruits[i]) - 1);
        if (fruitCount.get(fruits[i]) == 0) {
          fruitCount.remove(fruits[i]);
        }
        i++; // move left of window
      }

      // Update max window size
      max = Math.max(max, j - i + 1);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] frutisArray = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    System.out.println(totalFruit(frutisArray));
  }
}
