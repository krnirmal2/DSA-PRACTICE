package StandardProblemDSA.XI_GREEDYALGO.III_TWO_POINTER_PAIRING;

import java.util.Arrays;

// Note : as target sum/weight and two array  one is no of people and other infinite boats , with
// two people
// demand and supply , and minimum requirement and other no choice after picking the greedy , so
// each time pick the best combinataion
public class BoatsToSavePeople {
  /*You are given an array people where people[i] is the weight of the ith person,
   and an infinite number of boats where each boat can carry a maximum weight of limit.
    Each boat carries at most two people at the same time, provided the sum of the weight of those people
    is at most limit.
  Return the minimum number of boats to carry every given person.
  Example 1:

  Input: people = [1,2], limit = 3
  Output: 1
  Explanation: 1 boat (1, 2)
  Example 2:

  Input: people = [3,2,2,1], limit = 3
  Output: 3
  Explanation: 3 boats (1, 2), (2) and (3)
  Example 3:

  Input: people = [3,5,3,4], limit = 5
  Output: 4
  Explanation: 4 boats (3), (3), (4), (5)


  Constraints:

  1 <= people.length <= 5 * 104
  1 <= people[i] <= limit <= 3 * 104*/

  /*Core idea: After sorting, use a low and high pointer to pair or evaluate extremes in one pass.
  	• Spot it when: You need to pair light/heavy, small/large, first/last to meet a constraint.
  	• Exemplars:
  		○ 881. Boats to Save People (Medium)
  		○ 11. Container With Most Water (Medium)
  	• What you’ll learn:
  		○ How moving one pointer makes the “best next move”
  		○ Why pairing extremes often yields optimal resource use
  Decision tip: “Sorted array + pair first and last = Two‑Pointer Greedy.”*/
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people); // Sort people by weight

    int left = 0;
    int right = people.length - 1;
    int boats = 0;
    /*Greedy Strategy:
          Always try to pair the lightest (left) and heaviest (right) person.
                  If they fit in one boat (sum <= limit) → move both pointers.
                  If not → the heavier person goes alone → move right only.
                  Each iteration = one boat
     Sorted: [1, 2, 2, 3]
    - Try 1 + 3 → too much → 3 alone
    - Try 1 + 2 → fits → one boat
    - 2 alone → one more
    */

    while (left <= right) {
      // Try to pair the lightest and heaviest person
      if (people[left] + people[right] <= limit) {
        left++;
      }
      // Always remove the heaviest (right)
      right--;
      boats++;
    }

    return boats;
  }
}
