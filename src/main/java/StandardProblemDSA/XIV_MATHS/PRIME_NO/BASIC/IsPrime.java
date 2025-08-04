package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

public class IsPrime {
  public static boolean isPrime(int n) {
      // if a no. is less than 2 or if divisible by 2 then return false, only 2 is first prime
    if (n == 2) return true;
      if (n < 2 || n % 2 == 0) return false;
      // other wise start no. to check from 3 to n
      // if a suquare of that no. is less than the n then check if the no is divide n or not
      // if yes return false as the no. is divisible
      // other wise increament the counter by 2
    /*Why i * i <= n?
    Instead of checking all numbers up to n, we only check divisors up to the square root of n.
    If n has a factor larger than √n, the corresponding smaller factor would already have been found.*/
      for (int i = 3;
           i * i <= n;
           i +=
                   2) { // i+2 because earlier we handle even no. so this time only odd no. will divide and
          // check
      if (n % i == 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int num = 29;
    System.out.println(num + " is prime: " + isPrime(num));
  }
}
