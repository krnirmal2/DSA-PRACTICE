package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.VALLY_PATTERN;

public class FindValleyInValleyArray {
    /* Problem Statement:
       Given an array that first decreases and then increases (a "valley" array),
       find the minimum element (the valley point).

       Pattern: Binary Search on a unimodal (valley) array.
       - Compare mid with neighbors to determine the direction of the slope.
       - Move towards the side where a smaller element may exist.

       LeetCode Equivalent:
         - No direct problem, but opposite of "Peak Index in a Mountain Array" (LeetCode 852).

       Follow-ups:
         1. What if the array is strictly decreasing or strictly increasing?
         2. How to find both valley index and value?
    */
  public static int findValley(int[] arr) {
    // approach
    int low = 0, high = arr.length - 1; // 1. low and high pointer

    while (low < high) { // 2. iterate over the array till low doesno't cross high
      int mid = low + (high - low) / 2; // 3. find middle in each

      // If mid is the valley point
      if (arr[mid] < arr[mid - 1]
          && arr[mid] < arr[mid + 1]) { // check the mid value is wher gretaer
        // return the value
        return arr[mid];
      }

      // If left side is decreasing, move left
      if (arr[mid] > arr[mid - 1]) { // 4. if not matched then check left if
        high = mid - 1;
      } else {
        // Else move right
        low = mid + 1;
      }
    }
    return arr[low]; // Final valley element
  }

  public static void main(String[] args) {
    int[] valleyArr = {9, 7, 5, 3, 1, 2, 4, 6, 8}; // Valley at 1
    System.out.println("Valley Element: " + findValley(valleyArr));
  }
}
