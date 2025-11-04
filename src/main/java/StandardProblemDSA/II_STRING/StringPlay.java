package StandardProblemDSA.II_STRING;

import java.util.Locale;

public class StringPlay {

  public static void main(String[] args) {
    String s = "ddfdsf";
    System.out.println(solve("hgUe"));
    System.out.println("String Byte" + s.getBytes());
    System.out.println("String charSequence : " + s.toUpperCase(Locale.ROOT));
    System.out.println("String charSequence : " + s.toUpperCase());

    s = "GeeksforGeeks";
    StringBuffer stringBuffer = new StringBuffer(s);
    String newString = new String(stringBuffer);
    System.out.println("new instance of string buffer : " + newString);

    // **************************************SUBSTRING FUNCTION*************************************
    System.out.println(
        "Character at 3rd position = " + s.charAt(3)); // GET CHARACTER FROM THE STRING
    // Return the substring from the ith  index character to end of string
    System.out.println("Substring " + s.substring(3));

    // Returns the substring from i to j-1 index.
    System.out.println("Substring  = " + s.substring(2, 4));
    String s2 = "nirmal";
    s.concat(s2);

    // Returns the index within the string
    // of the first occurrence of the specified string.
    String s4 = "Learn Share Learn";
    System.out.println("Index of Share String the Sentence started with : " + s4.indexOf("Share"));

    // Returns the index within the string of the
    // first occurrence of the specified string,
    // starting at the specified index.
    System.out.println("Index of a  = " + s4.indexOf('a', 4));
    // If ASCII difference is zero then the two strings are similar
    String s1 = "Geeks";
    int out1 =
        s1.compareTo(
            s2); // Note : copare two String lexicographically if ( The result is a negative integer
    // if this String object lexicographically precedes the argument string.)
    System.out.println("the difference between ASCII value is=" + out1);

    String s3 = s2.replace('n', 'r');
    System.out.println("s3 " + s3);

    String str = "RAM";
    //   Character Encoding & Bytes
    // getBytes() - Converts string to byte array
    byte[] bytes = str.getBytes();

    // 🔹 String Comparison
    // contentEquals() - Checks if content matches CharSequence or StringBuffer
    boolean isEqual = str.contentEquals(new StringBuffer("hello"));
    // equalsIgnoreCase() - Case-insensitive comparison
    boolean isEqualIgnoreCase = str.equalsIgnoreCase("HELLO");
    // compareToIgnoreCase() - Case-insensitive lexicographic comparison
    int cmp = str.compareToIgnoreCase("world");
    // regionMatches() - Compares a specific region
    boolean matches = str.regionMatches(0, "hello world", 6, 5);

    // 🔹 Starts/Ends With
    // startsWith() check if the string starts with a specific characters or endswith speific
    // character
    boolean starts = str.startsWith("he");
    // endsWith()
    boolean ends = str.endsWith("lo");

    // 🔹 Finding Substrings (Index)
    // indexOf() - Finds first occurrence
    int idx1 = str.indexOf('o');
    // lastIndexOf() - Finds last occurrence
    int idx2 = str.lastIndexOf('o');

    // 🔹 Substring & Concatenation
    // substring() - Extracts part of the string
    String sub = str.substring(0, 3);
    // concat() - Appends string
    String result = str.concat(" world");

    // 🔹 String Replacement & Matching
    // replace() - Replace All the characters in the String by new character
    String replaced = str.replace('l', 'x');
    // matches() - Checks regex pattern
    boolean isMatch = str.matches("[a-z]+");
    // contains() - Checks if substring exists
    boolean contains = str.contains("he");
    // replaceFirst() - Replace first occurrence
    String replacedFirst = str.replaceFirst("l", "X");
    // replaceAll() - Replace all occurrences
    String replacedAll = str.replaceAll("l", "X");

    // 🔹 Splitting & Joining
    // split() - Splits string into array
    String[] parts = str.split(" ");
    // join() - Joins strings with delimiter
    String joined = String.join("-", "hello", "world");

    // 🔹 Case Conversion
    // toLowerCase()
    String lower = str.toLowerCase();
    // toUpperCase()
    String upper = str.toUpperCase();

    // 🔹 Trimming & Stripping
    // trim() - Removes leading/trailing spaces
    String trimmed = str.trim();
    // strip() - Removes leading/trailing Unicode/white spaces
    String stripped = str.strip();

    // 🔹 Checking Blank/Lines
    // isBlank() - Checks if empty or only whitespace
    boolean blank = str.isBlank();
    // lines() - Returns stream of lines
    str.lines().forEach(System.out::println);

    // 🔹 Indentation & Formatting
    // indent() - Adds indentation
    String indented = str.indent(4);
    // format() - Formats string
    String formatted = String.format("Hello, %s!", "World");

    // 🔹 Character Arrays
    // toCharArray() - Converts to char array
    char[] chars = str.toCharArray();
    // Char Array to String
    String charArrayToSting = new String(chars);
    System.out.println("char Array to String : " + charArrayToSting);
    System.out.println("subString of the character array : " + new String(chars, 0, 2));

    // 🔹 String Creation
    //    The representation is exactly the one returned by the Integer.toString method of one
    // argument.
    // valueOf() - Converts different types to String
    String numStr = String.valueOf(123); // Returns the string representation of the int argument.
    System.out.println("Value of the numStr : " + numStr);

    // 🔹 Interning & Repeating
    // intern() - Returns canonical string
    String interned = str.intern();
    // repeat() - Repeats string N times
    String repeated = str.repeat(3);
  }

  public static String solve(String A) {

    // concatenate the given string with it self
    String S = A.concat(A);
    // convert the string to toCharArray
    char[] stringToArray = S.toCharArray();

    // delete all the uppercase letters

    for (int i = 1; i < stringToArray.length; i++) {
      if (stringToArray[i - 1] >= 65 && stringToArray[i - 1] <= 90) {
        stringToArray[i - 1] = ' ';
      }
    }
    for (int i = 0; i < stringToArray.length; i++) {
      if (stringToArray[i] == 'a'
          || stringToArray[i] == 'e'
          || stringToArray[i] == 'i'
          || stringToArray[i] == 'o'
          || stringToArray[i] == 'u') {
        stringToArray[i] = '#';
      }
    }
    A = stringToArray.toString();
    return A;
  }
}
