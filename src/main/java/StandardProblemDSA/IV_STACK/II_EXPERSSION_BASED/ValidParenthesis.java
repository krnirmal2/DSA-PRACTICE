package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED;

import java.util.Stack;

public class ValidParenthesis {
  public static void main(String[] args) {
    int i = 0;
  }

  /*💡 Approach:
  Use a Stack to store opening brackets ('(', '{', '[').
  If we encounter a closing bracket, check:
  If the stack is empty → invalid string.
  If the top of the stack matches the current closing bracket → pop it.
  Else, return false (mismatch).
  At the end, if the stack is empty, return true; otherwise, return false.
  ⏳ Time Complexity:
  O(n) → We traverse the string once, and stack operations are O(1).*/
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c); // Push opening brackets
      } else {
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty(); // Valid if stack is empty
  }
}
