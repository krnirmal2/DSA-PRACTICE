package StandardProblemDSA.STACK.EXPERSSION_BASED;

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


}
