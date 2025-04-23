package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

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
        if (isNumeric(token)) {
          stack.push(Integer.parseInt(token)); // Convert to integer and push
        } else {
          int b = stack.pop(); // Second operand
          int a = stack.pop(); // First operand

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
      }
      return stack.pop();
    }

    // ✅ Helper method to check if a string is a valid integer
    private static boolean isNumeric(String str) {
      if (str.isEmpty()) return false;
      if (str.charAt(0) == '-' && str.length() > 1)
        str = str.substring(1); // Handle negative numbers
      for (char c : str.toCharArray()) {
        if (!Character.isDigit(c)) return false; // Return false if any non-digit character is found
      }
      return true;
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
