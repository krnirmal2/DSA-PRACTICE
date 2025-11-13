package StandardProblemDSA.XIII_BIT_MANIPULATION;

public class NotesWithQuestion {} /*
### **Bit Manipulation - Patterns & Popular Questions (Basic to Advanced)**
Bit manipulation is a powerful technique widely used in **competitive programming, data structures, and system design**. Below is a structured approach from **basic to advanced** concepts with categorized problems.

        ---

        ## **📌 Basic Concepts (Fundamentals)**
Before solving problems, let's review key bitwise operators:
        - `&` (AND) → Checks if both bits are 1.
        - `|` (OR) → Sets 1 if any bit is 1.
        - `^` (XOR) → Sets 1 if bits are different.
- `~` (NOT) → Flips bits.
        - `<<` (Left Shift) → Multiplies by 2^n.
- `>>` (Right Shift) → Divides by 2^n.

---

        ## **1️⃣ Basic Level Questions**
        ### **1. Check if a Number is Odd or Even**
        - **Observation:** The **last bit of even numbers is always 0**, and for odd numbers, it is 1.
        - **Approach:** Use `n & 1`.
        - **Code:**
        ```java
public class CheckOddEven {
    public static boolean isEven(int n) {
        return (n & 1) == 0; // Even if LSB is 0
    }

    public static void main(String[] args) {
        System.out.println(isEven(4)); // true
        System.out.println(isEven(7)); // false
    }
}
```
        ✅ **Time Complexity:** `O(1)`, ✅ **Space Complexity:** `O(1)`

        ---

        ### **2. Check if a Number is a Power of 2**
        - **Property:** A power of `2` has only **one** bit set (`1000` for `8`).
        - **Efficient Approach:** `n & (n - 1) == 0`
        - **Code:**
        ```java
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8)); // true
        System.out.println(isPowerOfTwo(10)); // false
    }
}
```
        ✅ **Time Complexity:** `O(1)`

        ---

        ### **3. Count Set Bits (Hamming Weight)**
        - **Naive Approach:** Iterate through all bits `O(log N)`.
        - **Optimized Approach:** **Brian Kernighan’s Algorithm** (faster).
        - **Brian Kernighan’s Trick:** `n & (n - 1)` removes the lowest set bit.
- **Code:**
        ```java
public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // Remove last set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(13)); // Output: 3 (1101)
    }
}
```
        ✅ **Time Complexity:** `O(log N)`

        ---

        ## **2️⃣ Intermediate Level Problems**
        ### **4. Find the Only Non-Repeating Element**
        #### **Given an array where every element appears twice except one, find the unique element.**
        - **Efficient Approach:** XOR all elements (`x ⊕ x = 0` cancels out duplicates).
        - **Code:**
        ```java
public class UniqueElement {
    public static int findUnique(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }
        return unique;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 2};
        System.out.println(findUnique(arr)); // Output: 5
    }
}
```
        ✅ **Time Complexity:** `O(N)`

        ---

        ### **5. Find Two Non-Repeating Elements (XOR + Rightmost Set Bit)**
        #### **Given an array where every element appears twice except two distinct elements, find them.**
        - **Step 1:** XOR all numbers to get `XOR = a ⊕ b`.
        - **Step 2:** Find the rightmost set bit in `XOR`.
        - **Step 3:** Partition numbers based on this bit and XOR separately.

        **Code:**
        ```java
public class TwoUniqueNumbers {
    public static void findUnique(int[] arr) {
        int xor = 0;
        for (int num : arr) xor ^= num;

        int rightmostSetBit = xor & -xor; // Get the rightmost set bit

        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) == 0) x ^= num;
            else y ^= num;
        }

        System.out.println("Two unique numbers: " + x + ", " + y);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 6, 2, 10, 4};
        findUnique(arr); // Output: 8, 10
    }
}
```
        ✅ **Time Complexity:** `O(N)`

        ---

        ## **3️⃣ Advanced Level Problems**
        ### **6. Find the Missing Number in Range [0, N]**
        #### **Given N numbers from `0 to N` (one missing), find the missing number.**
        - **Efficient Approach:** XOR all elements and indices.
- **Code:**
        ```java
public class MissingNumber {
    public static int findMissing(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i <= n; i++) xor ^= i; // XOR from 0 to N
        for (int num : nums) xor ^= num; // XOR with array elements
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4};
        System.out.println(findMissing(arr)); // Output: 2
    }
}
```
        ✅ **Time Complexity:** `O(N)`

        ---

        ### **7. Find the Single Number (Every Element Appears Thrice Except One)**
        #### **Problem:** Every number appears 3 times except 1 unique number. Find it in `O(N)`.
        - **Efficient Approach:** Use **bitwise count** at each bit position.
        - **Code:**
        ```java
public class SingleNumberThrice {
    public static int findSingle(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) { // Iterate over 32-bit positions
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) count++; // Count set bits at `i`
            }
            if (count % 3 != 0) result |= (1 << i); // Set the bit in the result
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        System.out.println(findSingle(arr)); // Output: 3
    }
}
```
        ✅ **Time Complexity:** `O(32 * N) ≈ O(N)`

        ---

        ## **🚀 Summary of Important Patterns**
        | **Pattern**                     | **Key Trick**                     | **Complexity** |
        |----------------------------------|----------------------------------|--------------|
        | Check even/odd                  | `n & 1 == 0`                     | `O(1)` |
        | Power of 2 check                 | `n & (n - 1) == 0`               | `O(1)` |
        | Count set bits                  | `n & (n - 1)`                    | `O(log N)` |
        | Find unique element (XOR)        | `x ⊕ x = 0`                      | `O(N)` |
        | Find two unique elements         | XOR + rightmost set bit          | `O(N)` |
        | Missing number                   | XOR indices + elements           | `O(N)` |
        | Single number (appears thrice)   | Count bits at each position      | `O(N)` |

*/
