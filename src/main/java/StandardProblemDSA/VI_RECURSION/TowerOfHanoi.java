package StandardProblemDSA.VI_RECURSION;

public class TowerOfHanoi {
  /*
  Problem:
  Solve the Tower of Hanoi problem for `n` disks using recursion.

  Approach:
  - Base case: Move disk 1 directly from source to destination.
  - Recursive steps:
    1. Move top n-1 disks from source to auxiliary.
    2. Move nth disk from source to destination.
    3. Move n-1 disks from auxiliary to destination.

  Pattern:
  - Classic Divide & Conquer recursion.

  Time Complexity:
  O(2^n) — number of moves required.
  Space Complexity:
  O(n) — recursion stack depth.

  Similar LeetCode:
  - No direct problem, but standard recursion practice.

  Follow-up:
  - Count number of moves: (2^n) - 1.
  */

  // Recursive function to solve Tower of Hanoi
  public static void solveHanoi(int n, char source, char auxiliary, char destination) {
    // Base case: If there's only one disk, move it directly
    if (n == 1) {
      System.out.println("Move disk 1 from " + source + " to " + destination);
      return;
    }

    // Step 1: Move top n-1 disks from source to auxiliary
    solveHanoi(n - 1, source, destination, auxiliary);

    // Step 2: Move the nth disk from source to destination
    System.out.println("Move disk " + n + " from " + source + " to " + destination);

    // Step 3: Move n-1 disks from auxiliary to destination
    solveHanoi(n - 1, auxiliary, source, destination);
  }

  public static void main(String[] args) {
    int n = 3; // Number of disks
    System.out.println("Steps to solve Tower of Hanoi for " + n + " disks:");
    solveHanoi(n, 'A', 'B', 'C'); // A: Source, B: Auxiliary, C: Destination
  }
}
