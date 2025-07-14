package StandardProblemDSA.II_STRING;

public class Pangram {
  public static boolean isPangram(String sentence) {
    // Step 1: Convert to lowercase
    sentence = sentence.toLowerCase();

    // Step 2: Frequency array of size 26
    int[] freq = new int[26];

    // Step 3: Iterate over characters and record frequency
    for (char ch : sentence.toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        freq[ch - 'a']++;
      }
    }

    // Step 4: Check if any alphabet is missing
    for (int count : freq) {
      if (count == 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPangram("The quick brown fox jumps over a lazy dog")); // true
  }
}
