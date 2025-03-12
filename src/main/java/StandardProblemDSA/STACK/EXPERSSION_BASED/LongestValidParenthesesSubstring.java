package StandardProblemDSA.STACK.EXPERSSION_BASED;

import java.util.Stack;

/*
* For every opening parenthesis, we push its index onto the stack.
For every closing parenthesis, we pop the stack.
If the stack becomes empty after popping, it means we’ve encountered an unmatched closing parenthesis, so we push the current index to serve as a base for the next potential valid substring.
If the stack is not empty, we calculate the length of the valid substring by subtracting the index at the top of the stack from the current index.
A variable maxLength keeps track of the maximum length of valid parentheses encountered during the traversal.*/
public class LongestValidParenthesesSubstring {
    // Function to find the length of the
    // longest valid parentheses substring
    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();

        // Push -1 as the initial index to
        // handle the edge case
        stack.push(-1);
        int maxLen = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // If we encounter an opening parenthesis,
            // push its index
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                // If we encounter a closing parenthesis,
                // pop the stack
                stack.pop();

                // If stack is empty, push the current index
                // as a base for the next validbst suring
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {

                    // Update maxLength with the current length
                    // of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
   /* static int maxLength(String s) {
        int maxLen = 0;

        // Left to Right Traversal
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                close++;
            }

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        // Right to Left Traversal
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }*/

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(maxLength(s));
    }
}
