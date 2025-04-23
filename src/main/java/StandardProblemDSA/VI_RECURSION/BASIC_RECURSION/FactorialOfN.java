package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION;

// Problem 6: Factorial of N using recursion
public class FactorialOfN {

  public static int factorial(int n) {
    if (n == 0 || n == 1) return 1;
    return n * factorial(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println("Factorial = " + factorial(n));
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
