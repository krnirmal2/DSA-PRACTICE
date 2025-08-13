package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

public class ConversionEachPreInPost {
  /*You are given a valid arithmetic expression in prefix notation. Your task is to convert it into a fully parenthesized infix expression.
  Prefix notation (also known as Polish notation) places the operator before its operands. In contrast, infix notation places the operator between operands.
  Your goal is to convert the prefix expression into a valid fully parenthesized infix expression.
  Examples:
  Input: expression = "+ab"

  Output: "(a+b)"

  Input: expression = "*+ab-cd"

  Output: "((a+b)*(c-d))"*/
  public String preToInfix(String s) {
      int n = s.length();
      StringBuilder result = new StringBuilder();
      prefixToInfixConversion(s, 0, result);
      return result.toString();
  }

    private void prefixToInfixConversion(String s, int index, StringBuilder result) {
        // base case
        if (index == s.length() - 1) {
        }

        // hypothesis case
        // check two thing if the the priority of the operator is low then add continuously ,
        // if high then removed top two operand and add them with open and closed parenthesis

        // induction case

    }
}
