package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION;

/*
Problem:
Compute factorial of a number N using recursion.

Pattern:
Recursion — problem reduces to subproblem factorial(n-1).

Approach:
1️⃣ Base Case: if n == 0 or n == 1, return 1.
2️⃣ Recursive Case: return n * factorial(n - 1).

Time Complexity:
O(n) — one recursive call per value from n down to 1.

Space Complexity:
O(n) — recursion stack.

Similar LeetCode/Interview Patterns:
- Fibonacci (top-down recursion with memoization)
- Recursion to Iteration conversion (using a stack)
- Tail-recursive optimization (in functional languages)

Follow-up:
- How to compute factorial using iteration?
- What if n > 20? (consider long or BigInteger for overflow)
*/

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
