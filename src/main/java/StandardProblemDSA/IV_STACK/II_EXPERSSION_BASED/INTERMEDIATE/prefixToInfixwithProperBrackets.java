package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

import java.util.Stack;

public class prefixToInfixwithProperBrackets {
  /*You are given a valid arithmetic expression in prefix notation. Your task is to convert it into a fully parenthesized infix expression.
  Prefix notation (also known as Polish notation) places the operator before its operands. In contrast, infix notation places the operator between operands.
  Your goal is to convert the prefix expression into a valid fully parenthesized infix expression.
  Examples:
  Input: expression = "+ab"
  Output: "(a+b)"

  Input: expression = "*+ab-cd"
  Output: "((a+b)*(c-d))"*/

  // Global index to track current position in prefix string
  static int index = 0;

  // Check if character is operator
  private static boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
  }

  // Recursive function to convert prefix to infix
  public static String prefixToInfix(String expr) {
    // Get current character
    char c = expr.charAt(index);
    index++;

    // If operand → return as string
    if (!isOperator(c)) {
      return Character.toString(c);
    }

    // If operator → get left and right operands recursively
    String left = prefixToInfix(expr);
    String right = prefixToInfix(expr);

    // Return fully parenthesized expression
    return "(" + left + c + right + ")";
  }

  public static void main(String[] args) {
    String expr2 = "*+ab-cd";

    index = 0;
    System.out.println("Prefix: " + expr2 + " → Infix: " + prefixToInfix(expr2));
  }

  public static String prefixToInfixUsingStackAndIteration(String expression) {
    Stack<String> stack = new Stack<>();

    // Traverse from right to left
    for (int i = expression.length() - 1; i >= 0; i--) {
      char c = expression.charAt(i);

      // If operand → push
      if (!isOperator(c)) {
        stack.push(Character.toString(c));
      } else {
        // Operator → pop two operands
        String op1 = stack.pop();
        String op2 = stack.pop();

        // Form new expression with parentheses
        String newExpr = "(" + op1 + c + op2 + ")";
        stack.push(newExpr);
      }
    }

    // Final infix expression
    return stack.pop();
  }
}
