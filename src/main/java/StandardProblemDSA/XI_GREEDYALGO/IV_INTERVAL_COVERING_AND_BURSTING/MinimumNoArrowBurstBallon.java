package StandardProblemDSA.XI_GREEDYALGO.IV_INTERVAL_COVERING_AND_BURSTING;

import java.util.PriorityQueue;

public class MinimumNoArrowBurstBallon {
  public static int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;

    // Step
    // As no choice , just action
    // hence no dp and  binary not came into mind right now
    // but seems like overlapping intervals
    // hence can use greedy with over lapping interval
    // 1. sort the array based on last
    // 2. and take the end of one interval and check how many other next intervval
    //  reside that point and increase the count and add to total
    // at last we return the total

    // put them in a pirority ques
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
    for (int[] p : points) {
      pq.add(new Pair(p[0], p[1]));
    }

    // now it is already sorted by priority queue based on end
    // so now
    int arrows = 0;
    int arrowPos = Integer.MIN_VALUE;
    boolean firstArrow = true;
    while (!pq.isEmpty()) {
      Pair current = pq.poll();

      // If the current balloon starts after the last arrow position, shoot a new arrow
      if (firstArrow || current.start > arrowPos) {
        arrows++;
        arrowPos = current.end; // shoot arrow at the end of the current balloon
        firstArrow = false;
      }
      // Else: this balloon is already burst by the previous arrow
    }

    return arrows;
  }

  public static void main(String[] args) {
    int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    System.out.println(findMinArrowShots(points));
  }

  /* Note : optimise
  *  * Problem: Minimum Number of Arrows to Burst Balloons
       * Approach: Greedy + Sorting by end coordinate
       *
       * 1. Sort intervals (balloons) by their end position.
       * 2. Shoot the first arrow at the end of the first balloon.
       * 3. For each next balloon:
       *      - If its start > current arrow position → shoot a new arrow and update arrow position.
       *      - Else → it’s already burst by the current arrow.
       *
       * Dry Run for points = [[10,16],[2,8],[1,6],[7,12]]:
       * - Sorted by end: [[1,6],[2,8],[7,12],[10,16]]
       * - Arrow 1 at 6 → bursts [1,6], [2,8]
       * - Next balloon [7,12]: start=7 > 6 → new arrow at 12
       * - Next balloon [10,16]: start=10 ≤ 12 → burst by arrow 2
       * - Total arrows = 2
       *
       * Edge Cases:
       * - Single balloon → always 1 arrow.
       * - All balloons fully overlapping → 1 arrow.
       * - Balloons with Integer.MIN_VALUE and Integer.MAX_VALUE handled correctly.
       *
       * Time Complexity:
       * - Sorting: O(n log n)
       * - Single pass scan: O(n)
       * - Total: O(n log n)
       *
      public static int findMinArrowShots(int[][] points) {
          if (points.length == 0) return 0;

          // Sort by end coordinate
          Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

          int arrows = 1; // at least one arrow
          int currentEnd = points[0][1];

          for (int i = 1; i < points.length; i++) {
              // If the current balloon starts after the arrow's position, we need a new arrow
              if (points[i][0] > currentEnd) {
                  arrows++;
                  currentEnd = points[i][1]; // update arrow position
              }
          }
          return arrows;
      }

  *  */

  /*There are some spherical balloons taped onto a flat wall that represents the XY-plane.
      The balloons are represented as a 2D integer array points where points[i] = [xstart, xend]
      denotes a balloon whose horizontal diameter stretches between xstart and xend.
       You do not know the exact y-coordinates of the balloons.
  Arrows can be shot up directly vertically (in the positive y-direction) from different points along
  the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
  There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely,
   bursting any balloons in its path.
  Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
  Example 1:

  Input: points = [[10,16],[2,8],[1,6],[7,12]]
  Output: 2
  Explanation: The balloons can be burst by 2 arrows:
  - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
  - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
  Example 2:

  Input: points = [[1,2],[3,4],[5,6],[7,8]]
  Output: 4
  Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
  Example 3:

  Input: points = [[1,2],[2,3],[3,4],[4,5]]
  Output: 2
  Explanation: The balloons can be burst by 2 arrows:
  - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
  - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].


  Constraints:

  1 <= points.length <= 105
  points[i].length == 2
  -231 <= xstart < xend <= 231 - 1*/
  static class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
