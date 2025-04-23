package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION;

// Problem 3: Print numbers from 1 to N using recursion
public class Print1ToN {

  public static void printUp(int i, int n) {
    if (i > n) return;
    System.out.print(i + " ");
    printUp(i + 1, n);
  }

  public static void main(String[] args) {
    int n = 5;
    printUp(1, n);
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
