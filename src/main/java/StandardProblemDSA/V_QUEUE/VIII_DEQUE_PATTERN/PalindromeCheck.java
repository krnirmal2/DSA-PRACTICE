package StandardProblemDSA.V_QUEUE.VIII_DEQUE_PATTERN;

import java.util.*;

public class PalindromeCheck {
  public static boolean isPalindrome(String str) {
    Deque<Character> deque = new LinkedList<>();

    // Add all characters to deque
    for (char ch : str.toCharArray()) {
      deque.addLast(Character.toLowerCase(ch)); // Case-insensitive
    }

    // Check palindrome
    while (deque.size() > 1) {
      if (deque.removeFirst() != deque.removeLast()) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String test1 = "racecar";
    String test2 = "hello";
    System.out.println(isPalindrome(test1)); // Output: true
    System.out.println(isPalindrome(test2)); // Output: false
  }
}
