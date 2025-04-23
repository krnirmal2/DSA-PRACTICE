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

          💡 Approach:
              Use a stack to store operands.
              Push numbers onto the stack.
              Pop two numbers when an operator appears, apply the operation, and push the result back.
                      The final result will be in the stack.
  Time Complexity: O(n)
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
