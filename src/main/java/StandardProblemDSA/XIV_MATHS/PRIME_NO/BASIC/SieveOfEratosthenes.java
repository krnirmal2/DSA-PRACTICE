package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

import java.util.Arrays;

// 2. Find all prime numbers up to N (Sieve of Eratosthenes)
public class SieveOfEratosthenes {
  public static void sieve(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) System.out.print(i + " ");
    }
  }

  public static void main(String[] args) {
    int n = 50;
    sieve(n);
  }
}
