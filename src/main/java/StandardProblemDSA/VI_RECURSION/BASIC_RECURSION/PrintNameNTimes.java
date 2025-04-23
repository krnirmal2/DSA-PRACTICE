package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION;

// Problem 2: Print your name N times using recursion
public class PrintNameNTimes {

  public static void printName(int n) {
    if (n == 0) return;
    System.out.println("YourName");
    printName(n - 1);
  }

  public static void main(String[] args) {
    int n = 4;
    printName(n);
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
