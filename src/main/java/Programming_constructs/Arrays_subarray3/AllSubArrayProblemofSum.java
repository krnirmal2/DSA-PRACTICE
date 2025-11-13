package Programming_constructs.Arrays_subarray3;

public class AllSubArrayProblemofSum {} /*
Here's a detailed breakdown of each question related to **subarrays** along with **brute force to optimized solutions**. Each question is structured with:

        1. **Problem Statement**
        2. **Approach & Explanation**
        3. **Brute Force Code**
        4. **Optimized Code (if applicable)**

        ---

        # **1️⃣ Print All Subarrays of an `N` Sized Array**
        ### **Problem Statement**
Given an array `A[]` of size `N`, print **all possible subarrays**.

        ### **Approach**
        - A **subarray** is a contiguous part of an array.
- To generate all subarrays, use **two loops**:
        - First loop: Select **start index**.
        - Second loop: Select **end index** and print subarray elements.

        ---

        ### **Brute Force Code (O(N²))**
        ```java
public class PrintAllSubarrays {
    public static void printSubarrays(int[] A) {
        int N = A.length;
        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                for (int k = start; k <= end; k++) {
                    System.out.print(A[k] + " ");
                }
                System.out.println(); // New line for each subarray
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        printSubarrays(A);
    }
}
```
        ---
        # **2️⃣ Return the Sum of a Subarray from Index `s` to `e`**
        ### **Problem Statement**
Given an array `A[]` and indices `s` and `e`, return the **sum of elements** from index `s` to `e`.

        ### **Brute Force (O(N))**
        ```java
public class SubarraySum {
    public static int subarraySum(int[] A, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(subarraySum(A, 1, 3)); // Output: 9
    }
}
```

        ### **Optimized Approach Using Prefix Sum (O(1) Query)**
        1. **Precompute prefix sum** `prefix[i] = sum(A[0] to A[i])`.
        2. **Get sum in O(1):**
        \[
        \text{sum}(s, e) = \text{prefix}[e] - \text{prefix}[s-1]
        \]
        ```java
public class SubarraySumOptimized {
    public static int subarraySum(int[] A, int s, int e, int[] prefix) {
        return s == 0 ? prefix[e] : prefix[e] - prefix[s - 1];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int N = A.length;
        int[] prefix = new int[N];

        prefix[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }

        System.out.println(subarraySum(A, 1, 3, prefix)); // Output: 9
    }
}
```
        ---
        # **3️⃣ Print the Sum of Every Subarray**
        ### **Problem Statement**
Print the **sum of all possible subarrays**.

        ### **Brute Force (O(N³))**
        ```java
public class SubarraySums {
    public static void printAllSubarraySums(int[] A) {
        int N = A.length;
        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += A[k];
                }
                System.out.println("Sum of subarray [" + start + "," + end + "] = " + sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        printAllSubarraySums(A);
    }
}
```

        ### **Optimized Using Prefix Sum (O(N²))**
        ```java
public class SubarraySumsOptimized {
    public static void printAllSubarraySums(int[] A) {
        int N = A.length;
        int[] prefix = new int[N];

        prefix[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A[i];
        }

        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                int sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                System.out.println("Sum of subarray [" + start + "," + end + "] = " + sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        printAllSubarraySums(A);
    }
}
```
        ---
        # **4️⃣ Print the Sum of All Subarrays Starting from Index `2`**
        ### **Optimized Approach (O(N))**
        ```java
public class SumFromIndex {
    public static void printSumsFromIndex(int[] A, int start) {
        int sum = 0;
        for (int i = start; i < A.length; i++) {
            sum += A[i];
            System.out.println("Sum from index " + start + " to " + i + " = " + sum);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        printSumsFromIndex(A, 2);
    }
}
```
        ---
        # **5️⃣ How Many Subarrays Contain the Element at Index `0`?**
        ### **Formula Approach**
        - Any subarray that **includes A[0]** starts at index `0` and ends anywhere from `0` to `N-1`.
        - **Count of such subarrays = N**

        ### **O(1) Code**
        ```java
public class SubarraysWithFirstElement {
    public static int countSubarraysWithFirstElement(int N) {
        return N;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(countSubarraysWithFirstElement(N)); // Output: 5
    }
}
```
        ---
        # **6️⃣ Find the Sum of Sums of All Subarrays**
        ### **Contribution Technique (O(N))**
        - **Formula for contribution** of `A[i]`:
        \[
        \text{Contribution} = A[i] \times (i + 1) \times (N - i)
  \]
          ```java
public class SumOfAllSubarrays {
    public static int sumOfSums(int[] A) {
        int totalSum = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            totalSum += A[i] * (i + 1) * (N - i);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(sumOfSums(A)); // Output: 20
    }
}
```
        ---
        ## **Final Thoughts**
        ✅ **Brute Force → Optimized** solutions
✅ **Prefix Sum, Contribution Method for Efficiency**
        ✅ **Time Complexity Improved from O(N³) → O(N²) → O(N) 🚀**
Let me know if you need more refinements! 🚀*/
