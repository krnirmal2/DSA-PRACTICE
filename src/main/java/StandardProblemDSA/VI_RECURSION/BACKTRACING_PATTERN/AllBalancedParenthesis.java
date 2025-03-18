package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class AllBalancedParenthesis {
    /*To form all the sequences of balanced bracket subsequences with n pairs, there are n opening brackets and n closing brackets. So the sequence will be of length 2*n.

There is a simple idea, the i’th character can be ‘{‘ if and only if the count of ‘{‘ till i’th is less than n and i’th character can be ‘}’ if and only if the count of ‘{‘ is greater than the count of ‘}’ till index i. If these two cases are followed then the resulting subsequence will always be balanced. So form the recursive function using the above two cases.

*/

    // Function which generates all possible
    // n pairs of balanced parentheses.
    static void genParenthesisUtil(int n, int open, int close,
                                   String s, List<String> ans) {

        // If the count of both open and close parentheses
        // reaches n, it means we have generated a valid parentheses.
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        // At any index i in the generation of the string s,
        // we can put an open parentheses only if its count
        // until that time is less than n.
        if (open < n) {
            genParenthesisUtil(n, open + 1, close, s + "{", ans);
        }

        // At any index i in the generation of the string s,
        // we can put a closed parentheses only if its count until
        // that time is less than the count of open parentheses.
        if (close < open) {
            genParenthesisUtil(n, open, close + 1, s + "}", ans);
        }
    }

    static List<String> AllParenthesis(int n) {

        // List for storing the answer
        List<String> ans = new ArrayList<>();
        if (n > 0) {
            genParenthesisUtil(n, 0, 0, "", ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = AllParenthesis(n);

        for (String str : ans) {
            System.out.println(str);
        }
    }
}
