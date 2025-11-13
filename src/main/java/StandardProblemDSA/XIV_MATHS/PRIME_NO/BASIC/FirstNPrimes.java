package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

import java.util.ArrayList;
import java.util.List;

public class FirstNPrimes { // 3. Find the first N prime numbers

  public static List<Integer> findFirstNPrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    int num = 2;
    while (primes.size() < n) {
      if (isPrime(num)) primes.add(num);
      num++;
    }
    return primes;
  }

  private static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(findFirstNPrimes(10));
  }
}
