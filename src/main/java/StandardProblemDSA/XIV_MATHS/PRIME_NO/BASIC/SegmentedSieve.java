package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

import java.util.Arrays;

public class SegmentedSieve { // 7. Find all primes in a range [L, R] using segmented sieve

  public static void segmentedSieve(int L, int R) {
    boolean[] isPrime = new boolean[R - L + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i * i <= R; i++) {
      for (int j = Math.max(i * i, (L + i - 1) / i * i); j <= R; j += i) {
        isPrime[j - L] = false;
      }
    }

    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i] && i + L > 1) System.out.print((i + L) + " ");
    }
  }

  public static void main(String[] args) {
    int L = 10, R = 50;
    segmentedSieve(L, R);
  }
}
