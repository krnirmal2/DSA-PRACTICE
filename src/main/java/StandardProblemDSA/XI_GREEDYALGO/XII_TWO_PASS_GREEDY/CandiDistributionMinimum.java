package StandardProblemDSA.XI_GREEDYALGO.XII_TWO_PASS_GREEDY;

import java.util.Arrays;

public class CandiDistributionMinimum {
  /*There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

    Example 1:

    Input: ratings = [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
    Example 2:

    Input: ratings = [1,2,2]
    Output: 4
    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
    The third child gets 1 candy because it satisfies the above two conditions.


    Constraints:

    n == ratings.length
    1 <= n <= 2 * 104
    0 <= ratings[i] <= 2 * 104

    Pattern:
  - Greedy with two passes:
    Left-to-right: ensure right child > left if rating higher.
    Right-to-left: ensure left child > right if rating higher.

  LeetCode Similar:
  - LC 135 (Candy)

  Follow-up:
  - Can you do in O(1) extra space? (Tricky but possible by keeping track of slopes)
  - Why do we need both passes?

  Time Complexity:
  - O(n) time, O(n) space (two passes + sum).*/
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[n];

    // Step 1: Give each child at least one candy
    Arrays.fill(candies, 1);

    // Step 2: Left to right - handle increasing slope
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    // Step 3: Right to left - handle decreasing slope
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
    }

    // Step 4: Sum up the total candies
    int total = 0;
    for (int candy : candies) {
      total += candy;
    }

    return total;
  }
}
