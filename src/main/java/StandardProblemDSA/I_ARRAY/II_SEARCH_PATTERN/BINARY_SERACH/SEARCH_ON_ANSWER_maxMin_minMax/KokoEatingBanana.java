package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class KokoEatingBanana {
  /*
      Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
       The guards have gone and will come back in h hours.
  Koko can decide her bananas-per-hour eating speed of k.
  Each hour, she chooses some pile of bananas and eats k bananas from that pile.
   If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas
   during this hour.
  Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
  Return the minimum integer k such that she can eat all the bananas within h hours.

  Example 1:
  Input: piles = [3,6,7,11], h = 8
  Output: 4

  Example 2:
  Input: piles = [30,11,23,4,20], h = 5
  Output: 30

  Example 3:
  Input: piles = [30,11,23,4,20], h = 6
  Output: 23


  Constraints:

  1 <= piles.length <= 104
  piles.length <= h <= 109
  1 <= piles[i] <= 109*/

  public int minEatingSpeed(int[] piles, int h) {
    // so we need to find the min and max of the banana
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int ele : piles) {
      max = Math.max(ele, max);
    }
    int low = 1, high = max;
    // use binary search
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (canEat(mid, piles, h)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private boolean canEat(int speed, int[] piles, int h) {
    long hours = 0L;
    for (int p : piles) {
      hours += ((long) p + speed - 1) / speed; // ceil division in long
      if (hours > h) return false; // early stop
    }
    return hours <= h;
  }

  public static void main(String[] args) {}
  /*Great question 👌 Let’s carefully trace how **integer overflow** breaks your old solution.
  ```
  piles = [805306368, 805306368, 805306368]
  h = 1000000000
  ### 🔎 In Your Old Code (with `int count`)

  ```java
  count += (piles[i] + mid - 1) / mid;
  ```
  Suppose `mid = 1` (speed = 1).

  * Each pile = 805,306,368.
  * Hours for one pile = `(805306368 + 1 - 1) / 1 = 805306368`.
  * For 3 piles:
    ```
    count = 805306368 + 805306368 + 805306368
          = 2,415,919,104
    ```

  ⚠️ **But `count` is an int.**

  * `Integer.MAX_VALUE = 2,147,483,647`
  * Our sum `2,415,919,104` > max → it **overflows**.
  * Actual stored value in `count` becomes:
    ```
    2,415,919,104 - 2,147,483,648 = 268,435,456
    ```
    (That’s the wrapped value after overflow).
  ---

  ### 🔎 Effect of Overflow
  Now `count = 268,435,456`.
  Compare with `h = 1,000,000,000`:

  ```java
  count <= h   →   268,435,456 <= 1,000,000,000   →   true
  ```
  So your function says **"speed=1 is feasible"** ❌.
  But in reality, Koko would need **2.4 billion hours**, which is way more than `h`.

  ---

  ### 🔎 Why `long` Fixes It

  If we use `long`:

  ```java
  long hours = 0;
  hours += (long)(piles[i] + speed - 1) / speed;
  ```

  * For speed=1:

    ```
    hours = 805306368 + 805306368 + 805306368
          = 2,415,919,104   (fits in long, no overflow)
    ```
  * Compare with `h=1,000,000,000`:

    ```
    hours <= h → 2,415,919,104 <= 1,000,000,000 → false
    ```

  Correct ✅ → speed=1 not possible.

  ---

  ### ✅ Summary

  * Bug cause: `int count` overflowed beyond `2^31 - 1`.
  * Fix: use `long hours` to store accumulated time.
  * That’s why the wrong output was `1`, instead of the correct answer `3`.

  ---

  👉 Do you want me to also **show the binary search dry run table** for this testcase (`piles=[805306368,...], h=1000000000`) so you see how `low, high, mid, hours` evolve until answer=3?
  */
}
