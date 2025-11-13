package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

public class FunctionCallSimulation {
  /*
  Problem:
  Simulate the computation of factorial (n!) using an explicit stack instead of recursion.

  Pattern:
  Manual recursion simulation using Stack — iterative factorial.

  Approach:
  1. Use a stack to mimic recursive calls.
  2. Push all values from n down to 1 onto the stack.
  3. Pop each value and multiply it to accumulate the factorial result.
  4. Continue until the stack is empty.

  Time Complexity:
  O(n) — each number from n to 1 is pushed and popped exactly once.

  Space Complexity:
  O(n) — stack stores up to n elements.

  Similar LeetCode Questions:
  - 509. Fibonacci Number (iterative/stack-based recursion)
  - 682. Baseball Game (stack operations)
  - 224. Basic Calculator (expression evaluation with stack)

  Follow-up Questions:
  - How to simulate recursive factorial with memoization?
  - Can you implement tail recursion optimization manually using a stack?
  - How would you handle very large n to avoid stack overflow or integer overflow?
  */

  // ✅ Simulate Factorial Using Stack
  public static int factorialIterative(int n) {
    Stack<Integer> stack = new Stack<>();
    int result = 1;

    // Push all recursive calls onto the stack
    while (n > 0) {
      stack.push(n);
      n--;
    }

    // Pop and compute factorial
    while (!stack.isEmpty()) {
      result *= stack.pop();
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(factorialIterative(5)); // Output: 120
    System.out.println(factorialIterative(3)); // Output: 6
  }
}
