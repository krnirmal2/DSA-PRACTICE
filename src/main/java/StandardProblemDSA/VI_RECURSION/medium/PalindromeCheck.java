package StandardProblemDSA.VI_RECURSION.medium;

// Problem 9: Check if a string is a palindrome using recursion
public class PalindromeCheck {

  public static boolean isPalindrome(String s, int left, int right) {
    if (left >= right) return true;
    if (s.charAt(left) != s.charAt(right)) return false;
    return isPalindrome(s, left + 1, right - 1);
  }

  public static void main(String[] args) {
    String str = "madam";
    boolean result = isPalindrome(str, 0, str.length() - 1);
    System.out.println("Is Palindrome: " + result);
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N) - recursion stack
