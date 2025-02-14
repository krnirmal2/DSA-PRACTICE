package StandardProblemDSA.STACK.EXPERSSION_BASED;

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
    Follow the steps mentioned below to implement the approach:
We iterate through the given expression and for each character in the expression
if the character is an open parenthesis ‘(‘ or any of the operators or operands, we push it to the stack.
If the character is close parenthesis ‘)’, then pop characters from the stack till matching open parenthesis ‘(‘ is found.
Now for redundancy two conditions will arise while popping.
If immediate pop hits an open parenthesis ‘(‘, then we have found a duplicate parenthesis. For example, (((a+b))+c) has duplicate brackets around a+b. When we reach the second “)” after a+b, we have “((” in the stack. Since the top of the stack is an opening bracket, we conclude that there are duplicate brackets.
If immediate pop doesn’t hit any operand(‘*’, ‘+’, ‘/’, ‘-‘) then it indicates the presence of unwanted brackets surrounded by expression. For instance, (a)+b contains unwanted () around a thus it is redundant. */
    static boolean checkRedundancy(String s) {
        // create a stack of characters
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                // top element of stack
                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }

                // If operators not found
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
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
        String str = "((a+b))";
        findRedundant(str);

    }
}
