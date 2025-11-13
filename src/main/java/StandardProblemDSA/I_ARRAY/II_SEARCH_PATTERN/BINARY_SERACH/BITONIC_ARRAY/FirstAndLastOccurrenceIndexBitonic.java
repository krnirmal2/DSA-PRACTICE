package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.BITONIC_ARRAY;

/*Problem Statement:
You are given a bitonic array arr of length n — an array that first strictly increases to a peak,
 then strictly decreases (duplicates may exist).
You are also given an integer target.
Your task is to find the first and last occurrence indices of target in arr.
If the target appears in both halves (increasing and decreasing), return the first index from the left and the last index from the right.
If it appears only in one half, return its first and last index there.
If the target does not appear at all, return [-1, -1].
Example 1:
Input: arr = [1, 3, 8, 12, 14, 11, 5, 5, 2], target = 5
Output: [6, 7]
Explanation: The target 5 first occurs at index 6 and last occurs at index 7.
Example 2:

Input: arr = [1, 3, 8, 12, 14, 11, 5, 2], target = 12
Output: [3, 3]
Explanation: 12 occurs only once at index 3.

-----------------------------------------------------------------------------------
🧠 Approach (Modified Binary Search on Bitonic Array):
### 1. **Understand the structure of a bitonic array**

### 2. **Find the peak index**
### 3. **Binary search in both halves**

Because the array is not globally sorted, we cannot apply one standard binary search.
We split into two regions:

#### a) Ascending half

* Perform **binary search for first occurrence**
* Perform **binary search for last occurrence**
  (using the classic “first and last occurrence in sorted array” logic).

#### b) Descending half

* Perform **binary search for first occurrence**
* Perform **binary search for last occurrence**
  (but flip the comparison conditions, since order is descending).

---

### 4. **Combine results**

* If target exists in both halves →

  * First occurrence = **minimum index** found
  * Last occurrence = **maximum index** found
* If target exists only in one half → take those results.
* If not found anywhere → return `[-1, -1]`.

---

## 🧮 Complexity

* Peak finding = **O(log n)**
* Up to 4 binary searches (first + last in ascending, first + last in descending) = **O(log n)**
* **Total = O(log n)** time, **O(1)** extra space

---

## ✅ Why this works

* The bitonic structure allows us to break the problem into two **sorted segments** (one ascending, one descending).
* Using binary search in both segments guarantees logarithmic time.
* Checking both sides ensures we handle **duplicates** correctly (like the two `5`s in your example).

-----------------------------------------------------------------------------------
⏱️ Complexity:
-----------------------------------------------------------------------------------
- **Time:** O(log N) + O(log N) ≈ O(log N), as we perform binary search on both halves.
- **Space:** O(1), no extra data structures used.

-----------------------------------------------------------------------------------
🧩 Pattern:
-----------------------------------------------------------------------------------
- **Binary Search**
- **Bitonic Array Search**
- Uses **first occurrence / last occurrence** variants of binary search.

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ Can we handle cases where the array is strictly increasing or strictly decreasing?
2️⃣ How to modify for multiple queries with different targets?
3️⃣ Can we avoid finding the peak if the target lies entirely in one half?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- LeetCode 1095 – Find in Mountain Array -- DONE
- Find first and last occurrence in sorted array
- Peak Index in a Mountain Array DONE
*/
public class FirstAndLastOccurrenceIndexBitonic {

  public static int[] searchFirstLast(int[] arr, int target) {
    int n = arr.length;
    if (n == 0) return new int[] {-1, -1};

    int peak = findPeak(arr);

    // Search increasing part
    int firstInc = findFirstAscending(arr, 0, peak, target);
    int lastInc = findLastAscending(arr, 0, peak, target);

    // Search decreasing part only if peak < n-1
    int firstDec = -1, lastDec = -1;
    if (peak < n - 1) {
      firstDec = findFirstDescending(arr, peak + 1, n - 1, target);
      lastDec = findLastDescending(arr, peak + 1, n - 1, target);
    }

    // Determine overall first
    int first = -1;
    if (firstInc != -1 && firstDec != -1) first = Math.min(firstInc, firstDec);
    else if (firstInc != -1) first = firstInc;
    else if (firstDec != -1) first = firstDec;

    // Determine overall last
    int last = -1;
    if (lastInc != -1 && lastDec != -1) last = Math.max(lastInc, lastDec);
    else if (lastInc != -1) last = lastInc;
    else if (lastDec != -1) last = lastDec;

    return new int[] {first, last};
  }

  private static int findPeak(int[] arr) {
    int low = 0, high = arr.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] < arr[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  private static int findFirstAscending(int[] arr, int low, int high, int target) {
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        res = mid;
        high = mid - 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  private static int findLastAscending(int[] arr, int low, int high, int target) {
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        res = mid;
        low = mid + 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  private static int findFirstDescending(int[] arr, int low, int high, int target) {
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        res = mid;
        high = mid - 1;
      } else if (arr[mid] > target) {
        // Since descending, larger means go right
        low = mid + 1;
      } else {
        // arr[mid] < target → go left
        high = mid - 1;
      }
    }
    return res;
  }

  private static int findLastDescending(int[] arr, int low, int high, int target) {
    int res = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        res = mid;
        low = mid + 1;
      } else if (arr[mid] > target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  // For testing
  public static void main(String[] args) {
    int[] arr = {1, 3, 8, 12, 14, 11, 5, 5, 2};
    int target = 5;
    int[] result = searchFirstLast(arr, target);
    System.out.println("[" + result[0] + ", " + result[1] + "]");
    // Expect: [6, 7]
  }
}
