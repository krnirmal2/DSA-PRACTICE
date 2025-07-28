package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

import java.util.Stack;

public class EvaluateReversePolishNotation {
  /* Given a list of tokens representing a Reverse Polish Notation (RPN) expression, evaluate the result.

    Example:
            📌 Input: ["2", "1", "+", "3", "*"]
            📌 Output: 9
            📌 Explanation: (2 + 1) * 3 = 9

            📌 Input: ["4", "13", "5", "/", "+"]
            📌 Output: 6
            📌 Explanation: (4 + (13 / 5)) = 6


  ### Explanation & Approach
  - Use a stack to store operands.
  - For each token:
    - If token is a number, push it onto the stack.
    - If token is an operator, pop two operands from the stack, apply the operator, and push the result back.
  - The final value left on the stack after processing all tokens is the result.

  ---

  ### Time Complexity
  - O(n) where n = number of tokens (single pass).

  ---

  ### Similar LeetCode Questions
  - 150. Evaluate Reverse Polish Notation
  - 224. Basic Calculator
  - 227. Basic Calculator II

  ---

  ### Follow-up Questions
  1. How to handle invalid tokens or malformed RPN expressions?
  2. How to extend for floating-point operations?
  3. How to implement evaluation without using built-in stack?
    */
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if (token.matches("-?\\d+")) { // If number, push to stack
        stack.push(Integer.parseInt(token));
      } else {
        int b = stack.pop(); // Second operand
        int a = stack.pop(); // First operand
        switch (token) {
          case "+":
            stack.push(a + b);
            break;
          case "-":
            stack.push(a - b);
            break;
          case "*":
            stack.push(a * b);
            break;
          case "/":
            stack.push(a / b);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"})); // 9
    System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"})); // 6
  }
}
