package StandardProblemDSA.IV_STACK.III_EXPERSSION_BASED;

public class RemoveOuterMostParenthesis {
    /*
    * Given a valid parentheses string S, remove the outermost parentheses of every primitive substring.

    Example:
    📌 Input: S = "(()())(())"
    📌 Output: "()()()"

    💡 Approach:
    Use a count variable (openCount) instead of a stack.
    Traverse the string:
    Increment openCount when encountering (.
    Decrement openCount when encountering ).
    Only add characters if openCount > 1 before ( and after ).*/
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' && openCount++ > 0) result.append(c);
            if (c == ')' && --openCount > 0) result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        Solution sol = new Solution();
        System.out.println(removeOuterParentheses("(()())(())")); // "()()()"
    }
}
