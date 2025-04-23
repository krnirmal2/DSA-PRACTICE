package StandardProblemDSA.VI_RECURSION.BASIC_RECURSION;

// Problem 1: Print "Hello" N times using recursion
public class PrintHelloNTimes {

  public static void printHello(int n) {
    if (n == 0) return;
    System.out.println("Hello");
    printHello(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    printHello(n);
  }
}

// Time Complexity: O(N)
// Space Complexity: O(N) - due to call stack
