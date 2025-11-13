package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

import java.util.Arrays;

// 2. Find all prime numbers up to N (Sieve of Eratosthenes)
public class SieveOfEratosthenes {
  public static void sieve(int n) {
    // Step 1 : take a boolean array to set each no. from 2 to n , true or false, initially with all
    // true assuming prime
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    // step 2 : iterate ove each no. sequentially with
    for (int i = 2; i * i <= n; i++) {
      // Step 3: if the boolean array say the no. block is true then
      //  second check ; set all the multiple of that no. with false , as those can be divisible by
      // this no.
      if (isPrime[i]) {
        // find all the multiple of that no start from square of i and till each jump add that no.
        for (int j = i * i;
            j <= n;
            j += i) { // Why i * i? Any smaller multiple of i would have already been marked by
          // smaller primes.
          isPrime[j] = false;
        }
      }
    }
    // Step 4: print all number still marked as true only
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) System.out.print(i + " ");
    }
  }

  /**
   * Time complexity: O(nloglogn), much faster than checking each number individually. Space: O(n).
   */
  public static void main(String[] args) {
    int n = 50;
    sieve(n);
  }
}
