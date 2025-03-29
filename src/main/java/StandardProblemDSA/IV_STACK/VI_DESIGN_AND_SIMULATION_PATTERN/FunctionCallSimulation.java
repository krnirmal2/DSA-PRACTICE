package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

public class FunctionCallSimulation {

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
