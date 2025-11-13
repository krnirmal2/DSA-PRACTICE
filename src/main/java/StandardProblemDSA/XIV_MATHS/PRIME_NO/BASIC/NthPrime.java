package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

public class NthPrime {
  public static int nthPrime(int n) {
    int count = 0, num = 1;
    while (count < n) {
      num++;
      if (isPrime(num)) count++;
    }
    return num;
  }

  private static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("10th prime number: " + nthPrime(10));
  }
}
