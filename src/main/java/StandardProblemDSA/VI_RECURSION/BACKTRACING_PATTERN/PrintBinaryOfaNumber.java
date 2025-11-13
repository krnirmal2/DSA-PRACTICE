package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

/*
Problem:
Generate all binary representations of length n.

Pattern:
Backtracking / Recursion — generate all 2^n combinations by placing '0' and '1' at each position.

Approach:
1️⃣ Use a helper function to build the binary number position by position.
2️⃣ At each index, assign '0' and recursively fill the rest.
3️⃣ Then assign '1' and recurse again.
4️⃣ Base case: when index == n, print or store the generated binary array.

Time Complexity:
O(2^n * n) — 2^n binary strings, each of length n.
Space Complexity:
O(n) — recursion depth + array for storing current binary string.

Similar LeetCode Problems:
- 78. Subsets (similar recursion pattern)
- 401. Binary Watch

Follow-up Questions:
- How to generate binary strings with no consecutive 1’s?
- How to return them as a list instead of printing?
- How to handle large n efficiently (iterative generation)?
*/

public class PrintBinaryOfaNumber {
  public static void printBinaryReprsentation(int n, int[] result) {
    /// our approach just
    // append 0 and 1 for the array first
    int intialValue = 0;
    utility(n, result, intialValue);
  }

  // Function to print the output
  static void printTheArray(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void utility(int n, int[] result, int i) {
    // base case if i is equal to n means we generate n length binary
    // value , so we will either store it in linkedlist or
    // print it
    if (i == n) {
      printTheArray(result, n);
      return;
    }
    // case 1 : we generate first with 0
    result[i] = 0;
    utility(n, result, i + 1);

    // case 2 : we generate the second with start from 1
    result[i] = 1;
    utility(n, result, i + 1);
  }

  public static void main(String[] args) {
    int n;
    n = 4;
    int[] result = new int[n];
    printBinaryReprsentation(n, result);
  }
}
