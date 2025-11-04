package StandardProblemDSA.XI_GREEDYALGO.III_TWO_POINTER_PAIRING;

public class ContainerWithMostWater {
  /*You are given an integer array height of length n. There are n vertical lines drawn such that the
         two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
    In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:

    Input: height = [1,1]
    Output: 1


    Constraints:

    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
  Pattern:
      - Two Pointers / Greedy (shrink window while tracking maximum area).

  LeetCode:
      - LeetCode 11: Container With Most Water.

  Time Complexity:
      - O(n), single pass through array.
  Space Complexity:
      - O(1), constant space.*/
  public static int maxArea(int[] height) {

    // so find that the water can hold till the minimum height between two opposite poll of height
    // so we can use two pointer as even it is not sorted
    // area = width * minimum height between two polls
    int left = 0;
    int right = height.length - 1;

    // condition for move left and right
    // if the left is lesser than right than we have to move left other wise the it will not contain
    // more water
    // similarly we also decrease the right pointer if left pointer is greater such that we can hole
    // more water
    // till left<right ==> not crossed
    int maxWater = 0;
    while (left < right) {
      maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) left++;
      else {
        right--;
      }
    }
    return maxWater;
  }

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
  }
}
