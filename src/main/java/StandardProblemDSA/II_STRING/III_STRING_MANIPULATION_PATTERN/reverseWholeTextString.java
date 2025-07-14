package StandardProblemDSA.II_STRING.III_STRING_MANIPULATION_PATTERN;

public class reverseWholeTextString {

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
