package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

import StandardProblemDSA.Utility;
import java.util.Stack;

public class EvaluateReversePolisNotation {
  public static class EvaluteReversePolishNotation {
    /* Given a list of tokens representing a Reverse Polish Notation (RPN) expression, evaluate the result.

    Example:
            📌 Input: ["2", "1", "+", "3", "*"]
            📌 Output: 9
            📌 Explanation: (2 + 1) * 3 = 9

            📌 Input: ["4", "13", "5", "/", "+"]
            📌 Output: 6
            📌 Explanation: (4 + (13 / 5)) = 6

            🔹 Approach
                Use a Stack to store operands.
                Iterate through the tokens:
                If the token is a number, push it to the stack.
                If the token is an operator (+, -, *, /), pop two elements from the stack, apply the operation, and push the result back.
                Return the final value from the stack.
    Time Complexity: O(n)
    */
    public static int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();

      for (String token : tokens) {
        // Check if the token is a number using try-catch
        if (Utility.isNumeric(token)) {
          stack.push(Integer.parseInt(token)); // Convert to integer and push
        } else {
          // take two top element from the stack
          int b = stack.pop(); // Second operand
          int a = stack.pop(); // First operand
          evaluate(stack, token, b, a);
        }
      }
      return stack.pop();
    }

    private static void evaluate(Stack<Integer> stack, String token, int b, int a) {
      // Perform the operation
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

    public static void main(String[] args) {
      System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"})); // 9
      System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"})); // 6
      System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "/", "-", "*"})); // 30
    }
    /*  🔹 Example Walkthrough
    Input: tokens = {"2", "1", "+", "3", "*"}
    Stack Operations:
            Token	Stack Before	Action	Stack After
            "2"	[]	Push 2	[2]
            "1"	[2]	Push 1	[2, 1]
            "+"	[2, 1]	Pop 1, 2 → 2+1=3, Push 3	[3]
            "3"	[3]	Push 3	[3, 3]
            "*"	[3, 3]	Pop 3, 3 → 3*3=9, Push 9	[9]
    Final Output: 9 ✅*/

  }
}
