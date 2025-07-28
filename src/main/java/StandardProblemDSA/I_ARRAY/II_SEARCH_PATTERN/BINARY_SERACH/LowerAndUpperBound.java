package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH;

public class LowerAndUpperBound {
  /*
   Problem:
     - Implement lowerBound() and upperBound()
       - lowerBound(A, B): First index where A[index] >= B.
       - upperBound(A, B): First index where A[index] > B.
     - Array A is sorted.

   Pattern:
     - Binary Search for first occurrence of an element (or next greater).
     - Maintain invariant [left, right) — search space shrinks until left == right.

   LeetCode Equivalent:
     - Similar logic is often used in problems like:
       - 34. Find First and Last Position of Element in Sorted Array
       - 744. Find Smallest Letter Greater Than Target

   Follow-ups:
     - What if array is sorted in descending order?
     - How to modify to return actual value instead of index?
     - Can we use Arrays.binarySearch() for the same?
  */

  // Returns first index where A[index] >= B
  public static int lowerBound(int[] A, int B) {
    int left = 0, right = A.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (A[mid] < B) {
        left = mid + 1; // B is larger; go right
      } else {
        right = mid; // A[mid] >= B; move left to find first occurrence
      }
    }
    return left; // Can be A.length if B > all elements
  }

  // Returns first index where A[index] > B
  public static int upperBound(int[] A, int B) {
    int left = 0, right = A.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (A[mid] <= B) {
        left = mid + 1; // B is >= A[mid]; go right
      } else {
        right = mid; // A[mid] > B; move left to find first greater
      }
    }
    return left; // Can be A.length if no element is > B
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 4, 4, 5, 6, 8};

    System.out.println("Lower Bound of 4: " + lowerBound(A, 4)); // Expected: 2
    System.out.println("Upper Bound of 4: " + upperBound(A, 4)); // Expected: 4
    System.out.println("Lower Bound of 7: " + lowerBound(A, 7)); // Expected: 6
    System.out.println("Upper Bound of 7: " + upperBound(A, 7)); // Expected: 6
    System.out.println("Lower Bound of 9: " + lowerBound(A, 9)); // Expected: 7
    System.out.println("Upper Bound of 9: " + upperBound(A, 9)); // Expected: 7
  }
}
