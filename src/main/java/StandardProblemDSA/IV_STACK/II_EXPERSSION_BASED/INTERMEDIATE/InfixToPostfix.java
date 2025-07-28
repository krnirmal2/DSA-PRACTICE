package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

/*
🔹 Infix to Postfix Conversion Using Stack (Shunting Yard Algorithm)
Your steps describe the Shunting Yard Algorithm, which is used to convert an infix expression (with parentheses and operator precedence) to a postfix expression (Reverse Polish Notation - RPN).

        🔹 Approach
1️⃣ Create a precedence method to return an integer value based on operator precedence:
Higher precedence operators get a higher positive value.
Same precedence operators return the same value.
2️⃣ Iterate over the characters in the given expression.
        3️⃣ If the character is a number, append it to the StringBuilder (output).
        4️⃣ If the character is an open bracket (, push it to the stack.
        5️⃣ If the character is a closing bracket ):
Pop all elements until an open bracket ( is found.
        Apped popped elements to the StringBuilder.
        6️⃣ After popping for closing brackets, if the stack is empty, push the current element.
        7️⃣ If the stack has operators, compare precedence:
            If the stack’s top has greater precedence than the current operator, pop and append.
            If equal precedence exists, handle left/right associativity.
        8️⃣ At the end, pop all remaining elements and append them to the StringBuilder.


Pattern: Stack-based expression parsing (operator precedence & associativity handling).

Time Complexity: O(n) — each token is pushed/popped at most once.
Space Complexity: O(n) — for the operator stack and output string.

LeetCode Similar Questions:
- 150. Evaluate Reverse Polish Notation
- 224. Basic Calculator
- 227. Basic Calculator II
- 772. Basic Calculator III

Follow-up Questions:
- Extend to handle unary operators (e.g., -5 or +3).
- Support multi-digit numbers and floating-point values.
- Add support for custom operators with different precedence.
- Modify to convert infix to prefix (Polish notation).
- Evaluate the postfix expression after conversion.
*/

import StandardProblemDSA.Utility;

import java.util.Stack;

public class InfixToPostfix {

  // ✅ Converts infix expression to postfix
  public static String infixToPostfix(String expression) {
    Stack<Character> stack = new Stack<>();
    StringBuilder output = new StringBuilder();

    for (char ch : expression.toCharArray()) {
      // 1️⃣ If it's an operand (number/letter), append to output
      if (Character.isLetterOrDigit(ch)) {
        output.append(ch);
      }
      // 2️⃣ If it's an opening bracket, push to stack
      else if (ch == '(') {
        stack.push(ch);
      }
      // 3️⃣ If it's a closing bracket, pop until '(' is found
      else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          output.append(stack.pop());
        }
        stack.pop(); // Remove '(' from stack
      }
      // 4️⃣ If it's an operator, handle precedence
      else {
        while (!stack.isEmpty() && Utility.precedence(stack.peek()) >= Utility.precedence(ch)) {
          output.append(stack.pop());
        }
        stack.push(ch);
      }
    }

    // 5️⃣ Pop all remaining operators in the stack
    while (!stack.isEmpty()) {
      output.append(stack.pop());
    }

    return output.toString();
  }

  // ✅ Driver Code
  public static void main(String[] args) {
    System.out.println(infixToPostfix("A+B*C")); // ABC*+
    System.out.println(infixToPostfix("(A+B)*C")); // AB+C*
    System.out.println(infixToPostfix("A+B*(C^D-E)")); // ABCD^E-*+
  }
} /*
  🔹 Explanation with Example
  Input: "A+B*C"
  Step-by-Step Execution
  Step	Character (ch)	Stack (top → bottom)	Output (Postfix)
  1	A	[]	A
  2	+	['+']	A
  3	B	['+']	AB
  4	*	['+', '*']	AB
  5	C	['+', '*']	ABC
  6	End	[] (Pop all)	ABC*+
  Final Output:
  Copy
          Edit
  ABC*+
          🔹 Complexity Analysis
  Operation	Complexity
  Iterating over expression (O(N))	O(N)
  Pushing/Popping in Stack (O(1))	O(1) per operation
  Final Pop of Remaining Stack (O(N))	O(N)
  Total Complexity	O(N) ✅
  Space Complexity (Stack Storage)	O(N)
          🔹 Summary
  ✔ Uses a stack-based approach to maintain precedence and order.
  ✔ Handles parentheses properly (()).
          ✔ Handles operators with correct precedence (+, -, *, /, ^).
          ✔ Efficient O(N) time complexity.*/
