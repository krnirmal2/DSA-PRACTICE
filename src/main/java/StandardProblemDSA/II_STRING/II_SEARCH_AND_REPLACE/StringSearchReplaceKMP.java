package StandardProblemDSA.II_STRING.II_SEARCH_AND_REPLACE;

import java.util.ArrayList;
import java.util.List;

public class StringSearchReplaceKMP {

  public static void main(String[] args) {
    String mainText = "aabaacaadaabaaba";
    String patternToFind = "aaba";

    findFirstAndLastOccurrenceKMP(patternToFind, mainText);

    String mainText2 = "This is a test string. This string contains test.";
    String patternToFind2 = "test";
    String replacementText = "example";

    System.out.println("\nText: " + mainText2);
    System.out.println("Pattern: " + patternToFind2);
    System.out.println("Replacement: " + replacementText);

    System.out.println("\nFirst Occurrence: " + findFirstOccurrenceKMP(mainText2, patternToFind2));
    System.out.println("Last Occurrence: " + findLastOccurrenceKMP(mainText2, patternToFind2));
    System.out.println("All Occurrences: " + findAllOccurrencesKMP(mainText2, patternToFind2));
    System.out.println(
        "Replaced String: " + replaceSubstringKMP(mainText2, patternToFind2, replacementText));

    String mainText3 = "apple banana apple orange apple";
    String patternToFind3 = "apple";
    String replacementText3 = "pear";

    System.out.println("\nText: " + mainText3);
    System.out.println("Pattern: " + patternToFind3);
    System.out.println("Replacement: " + replacementText3);

    System.out.println("\nFirst Occurrence: " + findFirstOccurrenceKMP(mainText3, patternToFind3));
    System.out.println("Last Occurrence: " + findLastOccurrenceKMP(mainText3, patternToFind3));
    System.out.println("All Occurrences: " + findAllOccurrencesKMP(mainText3, patternToFind3));
    System.out.println(
        "Replaced String: " + replaceSubstringKMP(mainText3, patternToFind3, replacementText3));
  }

  /**
   * Computes the Longest Prefix Suffix (LPS) array for the given pattern.
   *
   * <p>Approach: 1. Initialize an LPS array of the same length as the pattern. 2. Iterate through
   * the pattern, comparing characters to find matching prefixes and suffixes. 3. Store the length
   * of the longest matching prefix/suffix at each index in the LPS array.
   *
   * @param pattern The pattern string.
   * @return The LPS array.
   */
  private static int[] computeLPSArray(String pattern) {
    int patternLength = pattern.length();
    int[] lpsArray = new int[patternLength];

    int prefixSuffixLength = 0; // Length of the previous longest prefix suffix
    int currentIndex = 1; // Start comparing from index 1 (LPS of index 0 is always 0)

    while (currentIndex < patternLength) {
      if (pattern.charAt(currentIndex) == pattern.charAt(prefixSuffixLength)) {
        prefixSuffixLength++;
        lpsArray[currentIndex] = prefixSuffixLength;
        currentIndex++;
      } else {
        if (prefixSuffixLength != 0) {
          prefixSuffixLength =
              lpsArray[prefixSuffixLength - 1]; // Move back to the previous LPS value
        } else {
          lpsArray[currentIndex] = 0; // No prefix suffix match, assign 0
          currentIndex++;
        }
      }
    }
    return lpsArray;
  }

  /**
   * Finds the first and last occurrence of a pattern in a text using KMP.
   *
   * <p>Approach: 1. Compute the LPS array for the pattern. 2. Iterate through the text using two
   * pointers, one for the text and one for the pattern. 3. If characters match, increment both
   * pointers. 4. If the pattern is found, store the first and update the last occurrence indices.
   * 5. Use the LPS array to efficiently handle mismatches.
   *
   * @param patternToFind The pattern to search for.
   * @param mainText The text to search in.
   */
  private static void findFirstAndLastOccurrenceKMP(String patternToFind, String mainText) {
    int textLength = mainText.length();
    int patternLength = patternToFind.length();
    int[] lpsArray = computeLPSArray(patternToFind);
    int textIndex = 0, patternIndex = 0;
    int firstOccurrenceIndex = -1, lastOccurrenceIndex = -1;

    while (textIndex < textLength) {
      if (mainText.charAt(textIndex) == patternToFind.charAt(patternIndex)) {
        textIndex++;
        patternIndex++;
      }
      if (patternIndex == patternLength) {
        if (firstOccurrenceIndex == -1) {
          firstOccurrenceIndex = textIndex - patternIndex;
        }
        lastOccurrenceIndex = textIndex - patternIndex;
        patternIndex = lpsArray[patternIndex - 1];
      } else if (textIndex < textLength
          && mainText.charAt(textIndex) != patternToFind.charAt(patternIndex)) {
        if (patternIndex != 0) {
          patternIndex = lpsArray[patternIndex - 1];
        } else {
          textIndex++;
        }
      }
    }
    System.out.println("First occurrence index: " + firstOccurrenceIndex);
    System.out.println("Last occurrence index: " + lastOccurrenceIndex);
  }

  /**
   * Finds the first occurrence of a pattern in a text using KMP.
   *
   * <p>Approach: 1. Compute the LPS array for the pattern. 2. Iterate through the text, using the
   * LPS array to handle mismatches. 3. Return the index of the first match, or -1 if not found.
   *
   * @param mainText The text to search in.
   * @param patternToFind The pattern to search for.
   * @return The index of the first occurrence, or -1 if not found.
   */
  public static int findFirstOccurrenceKMP(String mainText, String patternToFind) {
    return findOccurrenceKMP(mainText, patternToFind, true);
  }

  /**
   * Finds the last occurrence of a pattern in a text using KMP.
   *
   * <p>Approach: 1. Compute the LPS array for the pattern. 2. Iterate through the text, using the
   * LPS array to handle mismatches. 3. Update the last occurrence index whenever a match is found.
   * 4. Return the last occurrence index, or -1 if not found.
   *
   * @param mainText The text to search in.
   * @param patternToFind The pattern to search for.
   * @return The index of the last occurrence, or -1 if not found.
   */
  public static int findLastOccurrenceKMP(String mainText, String patternToFind) {
    return findOccurrenceKMP(mainText, patternToFind, false);
  }

  private static int findOccurrenceKMP(String mainText, String patternToFind, boolean findFirst) {
    int textLength = mainText.length();
    int patternLength = patternToFind.length();
    int[] lpsArray = computeLPSArray(patternToFind);
    int textIndex = 0, patternIndex = 0;
    int occurrenceIndex = -1;

    while (textIndex < textLength) {
      if (mainText.charAt(textIndex) == patternToFind.charAt(patternIndex)) {
        textIndex++;
        patternIndex++;
      }
      if (patternIndex == patternLength) {
        occurrenceIndex = textIndex - patternIndex;
        if (findFirst) {
          return occurrenceIndex;
        }
        patternIndex = lpsArray[patternIndex - 1];
      } else if (textIndex < textLength
          && mainText.charAt(textIndex) != patternToFind.charAt(patternIndex)) {
        if (patternIndex != 0) {
          patternIndex = lpsArray[patternIndex - 1];
        } else {
          textIndex++;
        }
      }
    }
    return occurrenceIndex;
  }

  /**
   * Finds all occurrences of a pattern in a text using KMP.
   *
   * <p>Approach: 1. Compute the LPS array for the pattern. 2. Iterate through the text, using the
   * LPS array to handle mismatches. 3. Store the index of each match in a list. 4. Return the list
   * of indices.
   *
   * @param mainText The text to search in.
   * @param patternToFind The pattern to search for.
   * @return A list of indices of all occurrences.
   */
  public static List<Integer> findAllOccurrencesKMP(String mainText, String patternToFind) {
    int textLength = mainText.length();
    int patternLength = patternToFind.length();
    int[] lpsArray = computeLPSArray(patternToFind);
    int textIndex = 0, patternIndex = 0;
    List<Integer> occurrences = new ArrayList<>();

    while (textIndex < textLength) {
      if (mainText.charAt(textIndex) == patternToFind.charAt(patternIndex)) {
        textIndex++;
        patternIndex++;
      }
      if (patternIndex == patternLength) {
        occurrences.add(textIndex - patternIndex);
        patternIndex = lpsArray[patternIndex - 1]; // Continue searching for more occurrences
      } else if (textIndex < textLength
          && mainText.charAt(textIndex) != patternToFind.charAt(patternIndex)) {
        if (patternIndex != 0) {
          patternIndex = lpsArray[patternIndex - 1];
        } else {
          textIndex++;
        }
      }
    }
    return occurrences;
  }

  /**
   * Replaces all occurrences of a pattern in a text with a replacement string using KMP.
   *
   * <p>Approach: 1. Find all occurrences of the pattern using findAllOccurrencesKMP. 2. Build a new
   * string using a StringBuilder. 3. Iterate through the occurrences, appending the parts of the
   * original string before and after each occurrence, along with the replacement string. 4. Return
   * the new string.
   *
   * @param mainText The text to perform replacement on.
   * @param patternToFind The pattern to replace.
   * @param replacementText The string to replace with.
   * @return The string with all replacements made.
   */
  public static String replaceSubstringKMP(
      String mainText, String patternToFind, String replacementText) {
    List<Integer> occurrences = findAllOccurrencesKMP(mainText, patternToFind);
    StringBuilder result = new StringBuilder();
    int previousEnd = 0;

    for (int occurrence : occurrences) {
      result.append(mainText, previousEnd, occurrence);
      result.append(replacementText);
      previousEnd = occurrence + patternToFind.length();
    }
    result.append(mainText.substring(previousEnd)); // Append the remaining part of the string
    return result.toString();
  }
}
