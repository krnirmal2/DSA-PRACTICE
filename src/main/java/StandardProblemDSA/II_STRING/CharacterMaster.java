package StandardProblemDSA.II_STRING;

public class CharacterMaster {

  public static void main(String[] args) {
    // Example usage of each trick

    // 1. Check if character is Letter, Digit, Whitespace
    char ch1 = 'a';
    char ch2 = '7';
    char ch3 = ' ';

    System.out.println(Character.isLetter(ch1)); // true
    System.out.println(Character.isDigit(ch2)); // true
    System.out.println(Character.isWhitespace(ch3)); // true

    // 2. Convert character case
    char upper = Character.toUpperCase('b');
    char lower = Character.toLowerCase('G');
    System.out.println(upper); // B
    System.out.println(lower); // g

    // 3. Char to int and int to char
    char ch4 = '5';
    int num = '5' - '0'; // Char to int  //  Character.getNumericValue(ch4)
    System.out.println(num); // 5
    System.out.println(
        "Numeric Values of ch4 : "
            + Character.getNumericValue(ch4)); // NOTE : return Intger value the character
    System.out.println(
        "Character Count of ch4 : "
            + Character.charCount(ch4)); // NOTE : return Count of the characters
    System.out.println("Value of ch4 : " + Character.valueOf(ch4));
    System.out.println("Value of ch1 : " + Character.valueOf(ch1));
    System.out.println("Value of ch3  : " + Character.valueOf(ch3));

    int num2 = 8;
    char ch5 = (char) (8 + '0'); // Int to char
    System.out.println(ch5); // '8'

    // 4. Manual ASCII case conversion
    char upperManual = (char) ('c' - 32); // 'c' -> 'C'
    char lowerManual = (char) ('D' + 32); // 'D' -> 'd'
    System.out.println(upperManual); // C
    System.out.println(lowerManual); // d

    // 5. Compare ignoring case
    char c1 = 'A';
    char c2 = 'a';
    boolean sameIgnoreCase = Character.toLowerCase(c1) == Character.toLowerCase(c2);
    System.out.println(sameIgnoreCase); // true

    // 6. Find alphabet position
    char alphabet = 'f';
    int pos = ('f' - 'a') + 1; // Position in alphabet (1-based)
    System.out.println(pos); // 6

    // 7. String to Character Array
    String str = "Hello";
    char[] arr = str.toCharArray();
    for (char c : arr) {
      System.out.print(c + " ");
    }
    System.out.println();

    // 8. Reverse case of a character
    char x = 'K';
    if (Character.isLowerCase(x)) {
      x = Character.toUpperCase(x);
    } else if (Character.isUpperCase(x)) {
      x = Character.toLowerCase(x);
    }
    System.out.println(x); // k

    // 9. Check if character is vowel
    char vowel = 'E';
    if (isVowel(vowel)) {
      System.out.println(vowel + " is a vowel");
    } else {
      System.out.println(vowel + " is not a vowel");
    }

    // 10. Count letters, digits, spaces, and others
    String line = "Hi 5 times!";
    countCharacters(line);

    // 11. Check Palindrome ignoring case and non-letters
    String test = "A man, a plan, a canal: Panama";
    boolean isPalin = isPalindrome(test);
    System.out.println("Is palindrome: " + isPalin);

    // 12. Character frequency using 26-length array
    String freqTest = "Programming is fun!";
    int[] freq = getCharFrequency(freqTest);
    System.out.print("Character frequencies (a-z): ");
    for (int f : freq) {
      System.out.print(f + " ");
    }
    System.out.println();
  }

  // Function to check if a character is a vowel
  public static boolean isVowel(char ch) {
    ch = Character.toLowerCase(ch);
    return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
  }

  // Function to count letters, digits, spaces, and others
  public static void countCharacters(String str) {
    int letters = 0, digits = 0, spaces = 0, others = 0;
    for (char ch : str.toCharArray()) {
      if (Character.isLetter(ch)) {
        letters++;
      } else if (Character.isDigit(ch)) {
        digits++;
      } else if (Character.isWhitespace(ch)) {
        spaces++;
      } else {
        others++;
      }
    }
    System.out.println("Letters: " + letters);
    System.out.println("Digits: " + digits);
    System.out.println("Spaces: " + spaces);
    System.out.println("Others: " + others);
  }

  // Function to check if a string is palindrome ignoring cases and non-letters
  public static boolean isPalindrome(String str) {
    int left = 0, right = str.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  // Function to get frequency of each lowercase English letter (a-z) in a string
  public static int[] getCharFrequency(String str) {
    int[] freq = new int[26];
    for (char ch : str.toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        freq[ch - 'a']++;
      } else if (ch >= 'A' && ch <= 'Z') {
        freq[ch - 'A']++;
      }
    }
    return freq;
  }
}
