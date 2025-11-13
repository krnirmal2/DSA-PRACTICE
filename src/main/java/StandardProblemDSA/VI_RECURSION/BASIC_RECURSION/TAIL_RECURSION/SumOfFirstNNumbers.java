package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION.TAIL_RECURSION;

// Problem 5: Sum of first N numbers using recursion
public class SumOfFirstNNumbers {

  public static int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println("Sum = " + sum(n));
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
