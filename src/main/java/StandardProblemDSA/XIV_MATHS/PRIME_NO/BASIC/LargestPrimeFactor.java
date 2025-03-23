package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

public class LargestPrimeFactor { // 6. Find the largest prime factor of a number

  public static long largestPrimeFactor(long n) {
    long maxPrime = -1;
    while (n % 2 == 0) {
      maxPrime = 2;
      n /= 2;
    }
    for (long i = 3; i * i <= n; i += 2) {
      while (n % i == 0) {
        maxPrime = i;
        n /= i;
      }
    }
    if (n > 2) maxPrime = n;
    return maxPrime;
  }

  public static void main(String[] args) {
    long num = 13195;
    System.out.println("Largest prime factor: " + largestPrimeFactor(num));
  }
}
