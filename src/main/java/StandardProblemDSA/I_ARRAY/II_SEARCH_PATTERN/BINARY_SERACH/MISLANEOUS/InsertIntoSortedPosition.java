package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MISLANEOUS; // package

public class InsertIntoSortedPosition {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 5, 6, 7, 9};
    int left = 0;
    int right = A.length - 1;

    System.out.println(solve(A, left, right, 4));
  }

  private static int solve(int[] A, int left, int right, int B) {
    if (left > right) return -1; // base case: not found

    int mid = (left + right) / 2;
    if (A[mid] == B) return mid;

    if (A[mid] > B) return solve(A, left, mid - 1, B);
    else return solve(A, mid + 1, right, B);
  }
  /*O(log N)
    Where N is the number of elements in array A.
    At each step, the array is divided in half (binary division).
    So the number of steps required to search an element in N elements is:
  )*/
}
