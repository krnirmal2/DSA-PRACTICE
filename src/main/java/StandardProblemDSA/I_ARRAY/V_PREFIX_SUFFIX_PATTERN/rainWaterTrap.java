package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;
import java.util.ArrayList;
import java.util.List;

/*
Question:
Given a list of non-negative integers representing the elevation map, compute how much water it is able to trap after raining.

Example:
Input: A = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation:
- Water trapped above index 2: 1 unit
- Water trapped above index 5: 2 units
- Water trapped above index 6: 1 unit
- Water trapped above index 9: 1 unit
- Water trapped above index 10: 1 unit
Total water = 6.

Approach:
1. Precompute the maximum height to the left of each bar (left_max array).
2. Precompute the maximum height to the right of each bar (right_max array).
3. For each index k (excluding first and last):
   - Water trapped = min(left_max[k-1], right_max[k+1]) - height[k].
   - If this value is positive, add to the total trapped water.
4. Return the sum of trapped water.

Pattern:
- Prefix Maximum & Suffix Maximum Pattern.
- Classic "Trapping Rain Water" problem using precomputed bounds.

Time Complexity:
- O(n) for computing prefix and suffix max arrays and calculating trapped water.
Space Complexity:
- O(n) additional space for left_max and right_max arrays.
- Can be optimized to O(1) space using two-pointer approach.

Follow-up Questions:
1. Can you optimize this to O(1) extra space using two pointers?
2. How would you solve it for a streaming elevation map (real-time input)?
3. What if the map is circular (wraps around)?
4. Can you modify it to find the index where the most water is trapped?
5. How to handle negative or zero-length arrays?

Similar LeetCode/Interview Questions:
- LeetCode 42. Trapping Rain Water
- LeetCode 407. Trapping Rain Water II (2D version)
- InterviewBit: Rain Water Trapped
*/

public class rainWaterTrap {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static int trap(List<Integer> A) {
    int n = A.size();
    //            ArrayList<Integer> left_max = new
    // ArrayList<Integer>(Collections.nCopies(A.size(),0));
    //            ArrayList<Integer> right_max = new
    // ArrayList<Integer>(Collections.nCopies(A.size(),0));

    int[] left_max = new int[A.size()]; // [ 4, 4, 5, 7, 7, 7, 7, 7, 8, 8, 8 ]
    int[] right_max = new int[A.size()]; // [ 8, 8, 8, 8, 8, 8, 8, 8, 8, 3, 3 ]
    Utility.prefixMaxValues(A, left_max);
    Utility.suffixMaxValues(A, right_max, n);

    int totalUnitOfWater = 0;
    int left_closest_max, right_closest_max;
    // find the left and right max of the currenet element during iteration
    // so need to take min(left and right max)-currenet element and them up
    int min_of_left_right_max = 0;
    for (int k = 1; k < A.size() - 1; k++) {
      // so closest max of left and right
      left_closest_max = left_max[k - 1];
      right_closest_max = right_max[k + 1];
      //                left_closest_max = left_max.get(k - 1);
      //                right_closest_max = right_max.get(k + 1);

      min_of_left_right_max = Math.min(left_closest_max, right_closest_max) - A.get(k);

      totalUnitOfWater += min_of_left_right_max;
    }

    return totalUnitOfWater;
  }

  public static void main(String[] args) {
    //        ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
    ArrayList<Integer> a = new ArrayList<>(List.of(4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3));
    //        a.add(3);
    //        a.add(1);
    //        a.add(0);
    //        a.add(2);
    //        a.add(-4);
    //        System.out.println(a.get(0));
    System.out.println(trap(a));
  }
}
