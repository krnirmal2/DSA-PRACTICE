package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

public class PrimeFactors {
  public static void primeFactors(int n) {
    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n /= 2;
    }
    for (int i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n /= i;
      }
    }
    if (n > 2) System.out.print(n);
  }

  public static void main(String[] args) {
    int n = 84;
    primeFactors(n);
  }
}
