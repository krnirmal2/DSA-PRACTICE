package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION.TAIL_RECURSION;

// Problem 4: Print numbers from N to 1 using recursion
public class PrintNTo1 {

  public static void printDown(int n) {
    if (n == 0) return;
    System.out.print(n + " ");
    printDown(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    printDown(n);
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
