package StandardProblemDSA.II_STRING;

import java.util.ArrayList;
import java.util.List;

public class BooleanExpressionEvaluation {
  /*A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
  't' that evaluates to true.
  'f' that evaluates to false.
  '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
  '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
  '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
  Given a string expression that represents a boolean expression, return the evaluation of that expression.
  It is guaranteed that the given expression is valid and follows the given rules.

  Example 1:

  Input: expression = "&(|(f))"
  Output: false
  Explanation:
  First, evaluate |(f) --> f. The expression is now "&(f)".
  Then, evaluate &(f) --> f. The expression is now "f".
  Finally, return false.
  Example 2:

  Input: expression = "|(f,f,f,t)"
  Output: true
  Explanation: The evaluation of (false OR false OR false OR true) is true.
  Example 3:

  Input: expression = "!(&(f,t))"
  Output: true
  Explanation:
  First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
  Then, evaluate !(f) --> NOT false --> true. We return true.


  Constraints:

  1 <= expression.length <= 2 * 104
  expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.

  */

  public boolean parseBoolExpr(String expression) {
    return evaluate(expression);
  }

  private boolean evaluate(String expr) {
    char first = expr.charAt(0);

    if (first == 't') return true;
    if (first == 'f') return false;

    if (first == '!') {
      return !evaluate(expr.substring(2, expr.length() - 1));
    }

    List<String> parts = split(expr.substring(2, expr.length() - 1));

    if (first == '&') {
      for (String part : parts) {
        if (!evaluate(part)) return false;
      }
      return true;
    }

    if (first == '|') {
      for (String part : parts) {
        if (evaluate(part)) return true;
      }
      return false;
    }

    return false; // fallback
  }

  private List<String> split(String s) {
    List<String> result = new ArrayList<>();
    int balance = 0;
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (c == ',' && balance == 0) {
        result.add(sb.toString());
        sb.setLength(0);
      } else {
        if (c == '(') balance++;
        if (c == ')') balance--;
        sb.append(c);
      }
    }

    result.add(sb.toString());
    return result;
  }
}
