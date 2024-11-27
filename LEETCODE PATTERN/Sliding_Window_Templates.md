# **Sliding Window Techniques: Shrinkable and Non-shrinkable**

---

## **Problems Solvable Using These Templates**

### **General Problems**

- Longest Substring Without Repeating Characters
- Longest Substring with At Most Two Distinct Characters
- Longest Substring with At Most K Distinct Characters
- Longest Repeating Character Replacement
- Max Consecutive Ones II
- Subarray Product Less Than K
- Max Consecutive Ones III
- Get Equal Substrings Within Budget
- Longest Subarray of 1's After Deleting One Element
- Maximum Erasure Value
- Frequency of the Most Frequent Element
- Minimum Number of Operations to Make Array Continuous
- Maximize the Confusion of an Exam

### **Problems Using "At Most to Equal" Trick**

- Binary Subarrays With Sum
- Subarrays with K Different Integers
- Count Number of Nice Subarrays
- Count Vowel Substrings of a String

---

## **Template 1: Sliding Window (Shrinkable)**

### **Description**

- Expand the window by adding the rightmost element.
- If the window becomes invalid, shrink it by moving the left pointer until it is valid again.
- The window is guaranteed to be valid at the end of each iteration.

### **Template**

```java
int i = 0, j = 0, ans = 0;
for(;j<N; ++j){
        // Update the state using A[j], which might make the window invalid.
        while(

invalid()){
        // Shrink the window by updating the state with A[i].
        ++i;
    }
// Calculate the maximum window size found so far.
ans =Math.

max(ans, j -i+1);
}
        return ans;
```

---

### **Example: Frequency of the Most Frequent Element**

#### **Problem Logic**

1. **State**: The sum of numbers in the window.
2. **Invalid Condition**: \((j - i + 1)    imes A[j] - ext{sum} > k\).

#### **Solution**

```java
import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] A, int k) {
        Arrays.sort(A); // Step 1: Sort the array.

        long sum = 0;
        int i = 0, N = A.length, ans = 1;

        // Step 2: Expand the window.
        for (int j = 0; j < N; j++) {
            sum += A[j]; // Update sum with the current element.

            // Step 3: Shrink the window if invalid.
            while ((j - i + 1) * A[j] - sum > k) {
                sum -= A[i++];
            }

            // Step 4: Update the maximum window size.
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
```

---

### **FAQ**

#### **Why is the time complexity \(O(N \log N)\)?**

- Sorting the array takes \(O(N \log N)\), and the two-pointer traversal takes \(O(N)\), resulting in \(O(N \log N)\)
  overall.

#### **Why is \((j - i + 1)    imes A[j] - ext{sum} \leq k\) valid?**

- \((j - i + 1)\) is the window size, and we want to increment all elements to \(A[j]\). The cost of this operation
  is \((j - i + 1)    imes A[j] - ext{sum}\), which must not exceed \(k\).

---

## **Template 2: Sliding Window (Non-shrinkable)**

### **Description**

- Expand the window by adding the rightmost element.
- Shift the window by moving the left pointer ONLY when the window becomes invalid.
- The window either grows or shifts but never shrinks.

### **Template**

```java
int i = 0, j = 0;
for(;j<N; ++j){
        // Update the state using A[j], which might make the window invalid.
        if(

invalid()){
        // Shift the window by updating the state with A[i].
        ++i;
    }
            // After `++j`, the window `[i, j)` may be valid.
            }
            return j -i; // The maximum window size.
```

---

### **Example: Frequency of the Most Frequent Element**

#### **Solution**

```java
import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] A, int k) {
        Arrays.sort(A); // Step 1: Sort the array.

        long sum = 0;
        int i = 0, j = 0, N = A.length;

        // Step 2: Expand the window.
        for (; j < N; j++) {
            sum += A[j]; // Update sum with the current element.

            // Step 3: Shift the window if invalid.
            if ((j - i + 1) * A[j] - sum > k) {
                sum -= A[i++];
            }
        }
        return j - i; // The size of the valid window.
    }
}
```

---

## **Apply to Other Problems**

### **1493. Longest Subarray of 1's After Deleting One Element**

#### **Shrinkable Template**

- **State**: `cnt` is the number of `0`s in the window.
- **Invalid Condition**: \(cnt > 1\).

```java
class Solution {
    public int longestSubarray(int[] A) {
        int i = 0, cnt = 0, ans = 0;

        for (int j = 0; j < A.length; j++) {
            cnt += (A[j] == 0 ? 1 : 0); // Update count of zeros in the window.

            // Shrink the window if invalid.
            while (cnt > 1) {
                cnt -= (A[i++] == 0 ? 1 : 0);
            }

            // Calculate max size (excluding deleted element).
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
```

#### **Non-shrinkable Template**

```java
class Solution {
    public int longestSubarray(int[] A) {
        int i = 0, cnt = 0;

        for (int j = 0; j < A.length; j++) {
            cnt += (A[j] == 0 ? 1 : 0); // Update count of zeros in the window.

            // Shift the window if invalid.
            if (cnt > 1) {
                cnt -= (A[i++] == 0 ? 1 : 0);
            }
        }
        return A.length - i - 1; // The size of the maximum valid window.
    }
}
```

---

### **713. Subarray Product Less Than K**

#### **Shrinkable Template**

- **State**: `prod` is the product of numbers in the window.
- **Invalid Condition**: \(prod \geq k\).

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] A, int k) {
        if (k <= 1) return 0; // Edge case.

        long prod = 1;
        int i = 0, ans = 0;

        for (int j = 0; j < A.length; j++) {
            prod *= A[j]; // Update product.

            // Shrink the window if invalid.
            while (i <= j && prod >= k) {
                prod /= A[i++];
            }

            // Count all subarrays ending at j.
            ans += j - i + 1;
        }
        return ans;
    }
}
```

---

Everything is now formatted properly in **markdown**, with all examples and explanations clearly enclosed within the
markdown structure. Let me know if further tweaks are needed!
