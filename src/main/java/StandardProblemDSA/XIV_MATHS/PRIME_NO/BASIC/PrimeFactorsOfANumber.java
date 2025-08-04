package StandardProblemDSA.XIV_MATHS.PRIME_NO.BASIC;

public class PrimeFactorsOfANumber {
    /*Goal
    Given a number n, it prints all its prime factors.
    A prime factor is a factor of n that is itself a prime number.*/
    public static void primeFactors(int n) {
    /*First, the code removes all factors of 2 (the only even prime):
              While n is divisible by 2, print 2 and divide n by 2.
              After this, n becomes odd, so we can skip even numbers.
    */
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }
        System.out.println("n = " + n);
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
/*Dry Run: n = 84
Initial: n = 84
While divisible by 2:
Print 2, n = 42
Print 2, n = 21
Now n = 21 (odd).
Loop for odd i:
i = 3, 3*3 = 9 ≤ 21
21 % 3 == 0 → print 3, n = 7
7 % 3 ≠ 0 → exit inner loop.
i = 5, 5*5 = 25 > 7 → loop ends.

Final check:

n = 7 > 2 → print 7.*/
