package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

/*
 * Problem Statement:
 * ------------------
 * 1011. Capacity To Ship Packages Within D Days
 *
 * A conveyor belt has packages that must be shipped within `d` days.
 * The i-th package has a weight `weights[i]`. Each day, you can ship
 * packages in the order given, but the total weight cannot exceed the
 * ship's capacity. Find the minimum capacity of the ship required to
 * ship all the packages within `d` days.
 *
 Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages
* into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 *
 * Explanation:
 * - Minimum capacity needed so all packages ship in 5 days.
 *
 * Approach:
 * ---------
 * - Use **Binary Search on the Answer**:
 *     - The minimum possible capacity is `max(weights)` (at least the heaviest package).
 *     - The maximum possible capacity is `sum(weights)` (ship all packages in one day).
 * - For a mid-capacity, calculate how many days are needed using `findDays()`.
 * - If the required days <= d → capacity might be sufficient, try smaller capacity (move left).
 * - Else → capacity is too small, increase capacity (move right).
 *
 * Pattern:
 * --------
 * - **Binary Search on Answer / Search Space Reduction**
 * - Similar to problems where you minimize or maximize under constraints.
 *
 * Time and Space Complexity:
 * --------------------------
 * - Time: O(n * log(sum(weights) - max(weights)))
 *     - O(n) to check feasibility for each capacity.
 *     - Binary search range is between max and sum.
 * - Space: O(1), no extra space used.
 *
 * Related LeetCode Questions:
 * ---------------------------
 * - 1011. Capacity To Ship Packages Within D Days
 * - 875. Koko Eating Bananas
 * - 410. Split Array Largest Sum
 * - 1482. Minimum Number of Days to Make m Bouquets
 *
 * Follow-ups:
 * -----------
 * - How would the approach change if we could reorder the packages?
 * - Can we handle extremely large weights or number of days (overflow-safe)?
 */
public class CapacityToPackageWithinDdaysWithMulipleWeight {
  public static int findDays(int[] weights, int cap) {
    int days = 1; // First day.
    int load = 0;
    int n = weights.length; // size of array.
    for (int i = 0; i < n; i++) {
      if (load + weights[i] > cap) {
        days += 1; // move to next day
        load = weights[i]; // load the weight.
      } else {
        // load the weight on the same day.
        load += weights[i];
      }
    }
    return days;
  }

  public static int leastWeightCapacity(int[] weights, int d) {
    // Find the maximum and the summation:
    int low = Integer.MIN_VALUE, high = 0;
    for (int i = 0; i < weights.length; i++) {
      high += weights[i];
      low = Math.max(low, weights[i]);
    }

    while (low <= high) {
      int mid = (low + high) / 2;
      int numberOfDays = findDays(weights, mid);
      if (numberOfDays <= d) {
        // eliminate right half
        high = mid - 1;
      } else {
        // eliminate left half
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
    int d = 5;
    int ans = leastWeightCapacity(weights, d);
    System.out.println("The minimum capacity should be: " + ans);
  }
}
