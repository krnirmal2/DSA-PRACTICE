package StandardProblemDSA.II_STRING.III_STRING_MANIPULATION_PATTERN;

import static StandardProblemDSA.II_STRING.StringUtility.trimSpaces;

public class TrimLeadAndTrailWhiteSpace {

  public static void main(String[] args) {
    String input = "   Hello World!   ";

    String trimmed = trimSpaces(input);

    System.out.println("Original: \"" + input + "\"");
    System.out.println("Trimmed: \"" + trimmed + "\"");
  }
}
