package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

import java.util.Stack;

/*
* Given a string of balanced expressions, find if it contains a redundant parenthesis or not. A set of parenthesis is redundant if the same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes‘ if redundant, else ‘No‘.

Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. Given expression is valid and there are no white spaces present.

Examples:


Input: str = “((a+b))”
Output: YES
Explanation: ((a+b)) can reduced to (a+b), this Redundant


Input: str = “(a+(b)/c)”
Output: YES
Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.

*/
public class RedundantBrackets {
  /*
        💡 Approach:
  🧠 What It's Doing — In Simple Words:
          Push everything (brackets, operands, operators) to the stack.
          When a ) is found, pop elements until you find the corresponding '('.
          While popping, check if there was an operator between those brackets.
          If no operator is found (like in (a) or ((a+b))), it's redundant.
          If at least one operator is found (like in (a+b)), it's valid.
          🧪 Example Dry Run on "((a+b))+c":
              Push: (
              Push: (
              Push: a
              Push: +
              Push: b
              Encounter ):
              Pop b, +, a → found operator + → ✅
              Encounter next ):
              Immediate pop hits '(' → ❌ redundant

  . */
  public static boolean checkRedundancy(String s) {
    // Stack to track characters
    Stack<Character> st = new Stack<>();

    // Convert the string to a character array
    char[] str = s.toCharArray();

    // Traverse through each character in the expression
    for (char ch : str) {

      // If we encounter a closing parenthesis ')'
      if (ch == ')') {
        // Pop the top element from the stack immediately
        char top = st.pop();

        // This flag checks if we find any operator between '(' and ')'
        boolean operatorFound = false;

        // Pop until we find the matching opening bracket '('
        while (top != '(') {
          // If any operator is found inside, it's NOT redundant
          if (top == '+' || top == '-' || top == '*' || top == '/') {
            operatorFound = true;
          }
          top = st.pop();
        }

        // If no operator found between '(', ')' → it's redundant
        if (!operatorFound) {
          return true;
        }
      } else {
        // For all other characters including '(', operands, and operators → push to stack
        st.push(ch);
      }
    }

    // If loop finishes and no redundant brackets were found
    return false;
  }

  // Function to check redundant brackets
  static void findRedundant(String str) {
    boolean ans = checkRedundancy(str);
    if (ans) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  // Driver code
  public static void main(String[] args) {
    String str = "(a)+b";
    findRedundant(str);
  }
}
