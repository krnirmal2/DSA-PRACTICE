package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNo {
  /*Use a HashSet to store all unique numbers for O(1) lookups.
  Iterate through each number:
  Only start a sequence if the current number does not have a left neighbor (num - 1 in set).
  Expand to the right (num + 1 exists) to find the longest streak*/
  public static int LongestConsecutiveNo(int[] nums) {
    if (nums.length == 0) return 0;

    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int maxLength = 0;

    for (int num : numSet) {
      // Start a new sequence if there is no previous consecutive number
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        // Expand the sequence to the right
        while (numSet.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        maxLength = Math.max(maxLength, currentStreak);
      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(LongestConsecutiveNo(new int[] {100, 4, 200, 1, 3, 2})); // Output: 4
    //        System.out.println(LongestConsecutiveNo(new int[]{0,3,7,2,5,8,4,6,0,1}));  // Output:
    // 9
  }
}
