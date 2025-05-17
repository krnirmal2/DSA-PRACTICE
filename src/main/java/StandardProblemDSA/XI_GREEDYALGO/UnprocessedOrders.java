package StandardProblemDSA.XI_GREEDYALGO;

import java.util.Arrays;

public class UnprocessedOrders {

  /*
   * 📝 Problem Description:
   * Amazon processes orders in sequential order across multiple shifts.
   * Each shift has a certain duration and each order requires some processing time.
   * If an order is not fully processed in one shift, it continues in the next.
   * Return an array representing the number of unprocessed orders after each shift.
   *
   * 📦 Function:
   * Input: int[] orderProcessTime, int[] shiftDuration
   * Output: int[] remaining orders after each shift
   *
   * 🔍 Question Type:
   * - Simulation
   * - Array traversal
   *
   * 🧠 Approach:
   * Traverse both arrays sequentially.
   * - Track current order being processed and its remaining time.
   * - After each shift, calculate how many orders are still left unprocessed.
   */

  // 🚀 Brute Force (Same as Optimal in this case due to sequential simulation)
  public static int[] countUnprocessedOrdersBF(int[] orderProcessTime, int[] shiftDuration) {
    return countUnprocessedOrdersOptimized(orderProcessTime, shiftDuration);
  }

  // ✅ Optimized Version (Sequential simulation)
  public static int[] countUnprocessedOrdersOptimized(int[] orderProcessTime, int[] shiftDuration) {
    int n = orderProcessTime.length;
    int m = shiftDuration.length;

    int[] result = new int[m];

    // State variables
    int currentOrder = 0; // pointer to current order
    int remainingTime = 0; // remaining processing time for current order

    for (int shift = 0; shift < m; shift++) {
      int time = shiftDuration[shift];

      // If we had leftover time from a previous order
      if (remainingTime > 0) {
        if (time >= remainingTime) {
          time -= remainingTime;
          currentOrder++;
          remainingTime = 0;
        } else {
          remainingTime -= time;
          result[shift] = n - currentOrder;
          continue; // move to next shift
        }
      }

      // Process full orders in this shift
      while (currentOrder < n && time >= orderProcessTime[currentOrder]) {
        time -= orderProcessTime[currentOrder];
        currentOrder++;
      }

      // If there's time but order is too large, partially process it
      if (currentOrder < n && time > 0) {
        remainingTime = orderProcessTime[currentOrder] - time;
        currentOrder++; // this order is now being tracked by remainingTime
      }

      // Store result: how many unprocessed orders are left
      result[shift] = n - currentOrder;
    }

    return result;
  }

  // ⏱ Time Complexity: O(n + m)
  // 🧠 Space Complexity: O(m) for result array
  public static void main(String[] args) {

    // ------------------------ Test for UnprocessedOrders ------------------------
    System.out.println("🔁 Test 1: UnprocessedOrders");

    int[] orderProcessTime = {2, 4, 5, 1, 1};
    int[] shiftDuration = {1, 5, 1, 5, 2};

    int[] unprocessed =
        UnprocessedOrders.countUnprocessedOrdersOptimized(orderProcessTime, shiftDuration);
    System.out.println("Remaining after each shift: " + Arrays.toString(unprocessed));
  }
}
