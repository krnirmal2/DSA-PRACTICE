package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

import java.util.HashSet;
import java.util.Stack;

/*1249. Minimum Remove to Make Valid Parentheses
Medium
Topics
Companies
Hint
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.


Constraints:

1 <= s.length <= 105
s[i] is either '(' , ')', or lowercase English letter.*/
public class MinimumRemoveValidParaenthesis {
  public static String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    HashSet<Integer> invalidIndices = new HashSet<>();

    // First pass: Identify indices of invalid parentheses
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i); // Push index of '('
      } else if (c == ')') {
        if (!stack.isEmpty()) {
          stack.pop(); // Valid pair found, pop the stack
        } else {
          invalidIndices.add(i); // Mark ')' as invalid
        }
      }
    }

    // Add remaining unmatched '(' indices to the invalid set
    while (!stack.isEmpty()) {
      invalidIndices.add(stack.pop());
    }

    // Second pass: Build the result string
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (!invalidIndices.contains(i)) {
        result.append(s.charAt(i));
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    // Example 1
    String input1 = "lee(t(c)o)de)";
    System.out.println(minRemoveToMakeValid(input1)); // Output: "lee(t(c)o)de"

    // Example 2
    String input2 = "a)b(c)d";
    System.out.println(minRemoveToMakeValid(input2)); // Output: "ab(c)d"

    // Example 3
    String input3 = "))((";
    System.out.println(minRemoveToMakeValid(input3)); // Output: ""
  }

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
