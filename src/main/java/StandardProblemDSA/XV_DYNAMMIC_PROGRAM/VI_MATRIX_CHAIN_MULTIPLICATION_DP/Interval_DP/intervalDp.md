**Interval DP** is a dynamic programming technique used for problems where:

* You have to combine or partition **contiguous subarrays** (intervals) of an array.
* The **cost** or **value** of solving a bigger interval depends on solutions to its **smaller subintervals**.

---

### **Key Characteristics**

1. **State definition** usually has two indices:
   `dp[i][j]` = best answer for the subarray from index `i` to `j`.
2. We build solutions for **short intervals** first and then extend to longer intervals.
3. There’s often a **third dimension** if we need to merge into multiple piles, like
   `dp[i][j][t]` = min cost to merge `stones[i..j]` into `t` piles.
4. Transition typically involves trying all possible **splits**:

   ```
   dp[i][j] = min over m [dp[i][m] + dp[m+1][j] + cost(i, j)]
   ```

   where `m` splits the interval `[i..j]`.

---

### **Classic Problems that use Interval DP**

* **Matrix Chain Multiplication** (optimal order of multiplying matrices).
* **Burst Balloons** (maximize coins by bursting balloons in some order).
* **Minimum Cost to Merge Stones** (this problem).
* **Optimal BST construction**.
* **Palindrome Partitioning**.

---

### **Why it works here?**

In **Minimum Cost to Merge Stones**:

* To merge `stones[i..j]` into one pile:

    * First, merge `[i..m]` and `[m+1..j]` into smaller piles.
    * The cost of merging the full `[i..j]` depends on the **sum of stones\[i..j]** plus costs of subinterval merges.
* Overlapping subproblems appear because different merge orders reuse the same `dp[i][j][t]`.

---

### **How to know if a problem is Interval DP?**

Ask:

* Are you **merging or splitting contiguous ranges** repeatedly?
* Does the answer for `[i..j]` depend only on answers for **smaller sub-ranges**?
* Do you need to **try all partition points m** between i and j?

If yes → **Interval DP**.

---
Here’s a **practical cheat sheet** on how to **identify and solve Interval DP problems**.

---

## **1. When to suspect Interval DP**

Ask yourself:

* Am I repeatedly **merging, partitioning, or evaluating contiguous subarrays**?
* Does the solution for `[i..j]` **depend only on smaller subproblems inside `[i..j]`**?
* Do I need to **try all split points m** between `i` and `j`?
* Are there **overlapping subproblems** due to different orders of merging?

If **yes** → likely Interval DP.

**Examples:**

* Merge Stones, Matrix Chain Multiplication, Burst Balloons, Optimal BST.

---

## **2. Standard State Definition**

Most interval DP states have:

* **`dp[i][j]`** → best result (min/max cost) for subarray `i..j`.
* Sometimes extra dimensions, e.g.,
  `dp[i][j][t]` → best result for subarray `i..j` when merged into `t` groups.

---

## **3. How to build it**

* **Base case**:

    * `dp[i][i] = 0` (single element, no cost to merge).
* **Transition**:

  ```
  for (len = 2; len <= n; len++) {       // interval length
      for (i = 0; i + len - 1 < n; i++) {
          j = i + len - 1;
          for (m = i; m < j; m++) {      // try all splits
              dp[i][j] = min(dp[i][j], dp[i][m] + dp[m+1][j] + cost(i, j));
          }
      }
  }
  ```
* **Order of computation**:

    * Solve **smaller intervals first**, then larger ones (bottom-up) OR memoize top-down.

---

## **4. Common patterns**

* **Sum-based problems**:

    * Precompute **prefix sums** to get sum(i..j) in O(1).
* **Merging multiple piles**:

    * `(n - 1) % (k - 1) == 0` check for feasibility.
* **Skip unnecessary splits**:

    * When merging k piles, you only split at `m = i + t*(k - 1)`.

---

## **5. Pitfalls**

* Forgetting to add the merge cost `sum(i, j)` only when reducing to **1 pile**, not intermediate piles.
* Wrong loop order — must fill for small intervals first.
* Missing feasibility conditions like `(n - 1) % (k - 1) == 0`.

---

## **6. Quick Identification Heuristic**

If a problem involves:

* **“merge in any order”**,
* **“find min/max cost of merging”**,
* or **“split intervals optimally”**,
  then try **Interval DP** before greedy or standard DP.

---
Here’s a **Master Template for Interval DP** — designed so you can quickly adapt it in interviews.

---

## **1. Problem Pattern**

* You’re given an array (or string).
* You repeatedly **merge/split contiguous intervals**.
* You must find the **minimum/maximum cost/value**.
* The cost of merging `[i..j]` depends on **results of its subintervals** and sometimes on the **sum(i..j)**.

---

## **2. State Definition**

```java
// dp[i][j] = optimal cost (min or max) to process subarray stones[i..j]
int[][] dp;
```

If the problem involves merging into multiple piles:

```java
// dp[i][j][t] = optimal cost to merge stones[i..j] into t piles
int[][][] dp;
```

---

## **3. Preprocessing**

Most problems need **prefix sums** for O(1) range sum calculation:

```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stones[i];

int sum(int i, int j) {
    return prefix[j + 1] - prefix[i];
}
```

---

## **4. Base Case**

* A single element costs **0** to merge:

```java
for (int i = 0; i < n; i++) dp[i][i] = 0;
```

---

## **5. Transition Formula**

```java
for (int len = 2; len <= n; len++) {        // interval length
    for (int i = 0; i + len - 1 < n; i++) { // start index
        int j = i + len - 1;                // end index
        dp[i][j] = Integer.MAX_VALUE;       // or MIN_VALUE for max problems

        for (int m = i; m < j; m++) {       // all possible splits
            dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j] + cost(i, j));
        }
    }
}
```

* **`cost(i, j)`** is added only if the problem requires a merge cost for `[i..j]`.

---

## **6. For Multiple Piles (K-way merge)**

Use 3D DP:

```java
// dp[i][j][t] = min cost to merge stones[i..j] into t piles
for (int len = 2; len <= n; len++) {
    for (int i = 0; i + len - 1 < n; i++) {
        int j = i + len - 1;
        for (int t = 2; t <= K; t++) { 
            dp[i][j][t] = Integer.MAX_VALUE;
            for (int m = i; m < j; m += (K - 1)) {
                dp[i][j][t] = Math.min(dp[i][j][t], dp[i][m][1] + dp[m + 1][j][t - 1]);
            }
        }
        dp[i][j][1] = dp[i][j][K] + sum(i, j);
    }
}
```

---

## **7. Complexity**

* Time: `O(n^3)` for standard 2D DP,
  `O(n^3 / k)` for K-way merges (skipping splits).
* Space: `O(n^2)` or `O(n^2 * K)`.

---

## **8. Quick Adaptation Checklist**

* [ ] Is the problem about merging/splitting contiguous subarrays?
* [ ] Do I need the sum of an interval? → Precompute prefix sums.
* [ ] Is cost added only when reducing to 1 pile?
* [ ] Loop order: smaller intervals first, then bigger ones.

---

## **Common Interval DP Problems**

* **Merge Stones** (min cost to merge into one pile).
* **Matrix Chain Multiplication** (min cost of multiplying matrices).
* **Burst Balloons** (max coins).
* **Optimal BST** (min cost of search tree).

---

### Would you like me to give you a **“Mini Practice Set: 5 Interval DP Problems (easy → hard)** with **hints + state
definitions** so you can test and reinforce this template?

I’ll prepare them so you can apply this pattern directly.

Proceed?

