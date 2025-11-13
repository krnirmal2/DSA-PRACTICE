package StandardProblemDSA.XIV_MATHS.GCD;

public class GCD {}
/*
most commonly asked Greatest Common Divisor (GCD) questions in Java,
 starting from basic to advanced.

        🔹 1. Find GCD of Two Numbers (Basic)
👉 Approach: Use Euclidean Algorithm, which is based on the formula:
GCD(a, b) = GCD(b, a % b)
This method runs in O(log(min(a, b))) time complexity.

public class GCD {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 56, b = 98;
        System.out.println("GCD of " + a + " and " + b + " is: " + findGCD(a, b));
    }
}

🔹 2. Find GCD Using Recursion
👉 Approach: Uses recursive Euclidean Algorithm.
public class RecursiveGCD {
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int a = 48, b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
}

🔹 3. Find GCD of Multiple Numbers (Array)
👉 Approach: Apply GCD pair-wise on the array.
public class GCDArray {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int findGCDArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) return 1; // Smallest possible GCD
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {8, 12, 16, 24};
        System.out.println("GCD of the array: " + findGCDArray(arr));
    }
}

🔹 4. Find LCM Using GCD
👉 Approach: Use the formula LCM(a, b) = (a * b) / GCD(a, b).
public class GCDLCM {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    public static void main(String[] args) {
        int a = 12, b = 18;
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm(a, b));
    }
}

🔹 5. Check if Two Numbers are Co-prime (GCD = 1)
👉 Approach: Two numbers are co-prime if their GCD is 1.
public class CoPrime {
    public static boolean isCoPrime(int a, int b) {
        return gcd(a, b) == 1;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 17, b = 31;
        System.out.println(a + " and " + b + " are co-prime: " + isCoPrime(a, b));
    }
}

🔹 6. Find GCD of Two Large Numbers (String Input)
👉 Approach: If a is very large, we use modulo with a string number.
import java.math.BigInteger;
public class LargeGCD {
    public static BigInteger findGCD(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("123456789123456789");
        BigInteger num2 = new BigInteger("987654321987654321");
        System.out.println("GCD: " + findGCD(num1, num2));
    }
}

🔹 7. Find GCD Using Prime Factorization (Not Efficient)
👉 Approach: Find prime factors of both numbers and take their common minimum power.
        import java.util.*;
public class PrimeFactorGCD {
    public static Map<Integer, Integer> primeFactorize(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) factors.put(n, 1);
        return factors;
    }
    public static int findGCD(int a, int b) {
        Map<Integer, Integer> factorsA = primeFactorize(a);
        Map<Integer, Integer> factorsB = primeFactorize(b);
        int gcd = 1;
        for (int key : factorsA.keySet()) {
            if (factorsB.containsKey(key)) {
                gcd *= Math.pow(key, Math.min(factorsA.get(key), factorsB.get(key)));
            }
        }
        return gcd;
    }
    public static void main(String[] args) {
        int a = 36, b = 48;
        System.out.println("GCD of " + a + " and " + b + " using prime factorization: " + findGCD(a, b));
    }
}

🔹 8. Find the Sum of GCD of All Pairs in an Array
👉 Approach: Iterate over all pairs (a, b) and sum their GCDs.
public class SumOfGCDs {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int sumOfGCDPairs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += gcd(arr[i], arr[j]);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        System.out.println("Sum of GCDs: " + sumOfGCDPairs(arr));
    }
}

🔥 Summary
Problem	Approach	Time Complexity
GCD of two numbers	Euclidean Algorithm	O(log(min(a, b)))
Recursive GCD	Recursive Euclidean	O(log(min(a, b)))
GCD of an array	Pairwise GCD	O(n log(min(arr)))
LCM using GCD	Formula: (a × b) / GCD	O(log(min(a, b)))
Co-prime check	GCD(a, b) == 1	O(log(min(a, b)))
GCD of large numbers	BigInteger.gcd()	O(log(min(a, b)))
Prime factorization GCD	Factorization	O(√n)
Sum of GCD pairs	Brute force pairs	O(n² log(min(a, b)))
Let me know if you need more problems or explanations! 🚀
*/
