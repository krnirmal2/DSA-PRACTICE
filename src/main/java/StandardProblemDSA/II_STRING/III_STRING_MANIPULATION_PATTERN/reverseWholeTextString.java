package StandardProblemDSA.II_STRING.III_STRING_MANIPULATION_PATTERN;

public class reverseWholeTextString {
  /**
   * 🔁 Problem:
   * Reverse the order of words in a given string and remove unnecessary spaces.
   *
   * Example:
   * Input:  "  the   sky is  blue  "
   * Output: "blue is sky the"
   *
   * ✅ Pattern:
   * 1. Normalize spaces (collapse multiple spaces into one, trim edges)
   * 2. Convert string to char array
   * 3. Reverse the entire array
   * 4. Reverse each word individually in-place
   *
   * 💡 Follow-Up Questions:
   * 1. Can you do this entirely in-place without using additional result strings?
   * 2. How to handle punctuation (e.g., commas, dots) and non-ASCII whitespace (e.g., \u00A0)?
   * 3. Can you compare the performance of this method with a simple split-reverse-join approach?
   * 4. Adapt the function for languages where words are separated by other delimiters (e.g., tabs, commas)
   * 5. Can you handle Unicode grapheme clusters (e.g., emojis)?
   *
   * 🔍 LeetCode Similar Problems:
   * 1. 151. Reverse Words in a String — https://leetcode.com/problems/reverse-words-in-a-string/
   * 2. 186. Reverse Words in a String II (in-place) — https://leetcode.com/problems/reverse-words-in-a-string-ii/
   * 3. 557. Reverse Words in a String III — https://leetcode.com/problems/reverse-words-in-a-string-iii/
   * 4. 344. Reverse String — https://leetcode.com/problems/reverse-string/
   * 5. 58. Length of Last Word — https://leetcode.com/problems/length-of-last-word/
   *
   * 📊 Time Complexity:
   * - O(N) for removing extra spaces
   * - O(N) for reversing the entire array
   * - O(N) for reversing each word individually
   * Total: O(N), where N = number of characters in the trimmed string
   *
   * 📦 Space Complexity:
   * - O(1) auxiliary space if modifications are done in-place (ignoring result String building)
   * - In your implementation, result string uses O(N) additional space
   *
   */


  // take the string and then put it in character arrray
  // reverse the whole string from 0 to n-1
  // now take each word by start from 0 if no space starting other wise start from the initial
  // letter and go
  // upto if not found space and reverese this word

  // function for reverse the start to end index of an arrray
  public static char[] revereseString(int start, int end, char[] stringToCharArray) {
    while (start < end) {
      char temp = stringToCharArray[start];
      stringToCharArray[start] = stringToCharArray[end];
      stringToCharArray[end] = temp;
      start++;
      end--;
    }
    return stringToCharArray;
  }

  public static String solve(String A) {
    // Step 1: remove all the space from the text
    String removeSpaces = A.replaceAll("\\s+", " ");
    // Step 2: trim the string with and convert to character array
    char[] stringToCharArray = removeSpaces.trim().toCharArray();
    int j = stringToCharArray.length - 1, i = 0;
    String result = "";
    // Step 3 : reverse the whole string characters
    revereseString(i, j, stringToCharArray);
    // Step 4 : reverse each of the word one by when get blank space , by trace the index with start
    // and end
    int temp = -1; // trace the starting of the word
    int k = 0;
    for (; k < stringToCharArray.length; k++) {
      if (stringToCharArray[k] == ' ') {
        revereseString(temp + 1, k - 1, stringToCharArray);
        temp = k; // when reverse the word just reset the start of the next word
      }
    }
    // Step 5: now again reverse the whole character array
    revereseString(temp + 1, k - 1, stringToCharArray);

    // Step 6: create the string agian by appending it
    for (int l = 0; l < stringToCharArray.length; l++) {
      result += stringToCharArray[l];
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv "));
  }
}
