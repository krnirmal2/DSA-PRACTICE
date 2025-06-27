package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

public class FruitsIntoBusket {
  /*   "🔢🐌 Brute Force Approach
              1️⃣Loop through each starting index i.
              2️⃣From each i, loop to find the longest subarray with at most 2 distinct elements.
              3️⃣Use a Set/Map to track types of fruits.
              4️⃣If more than 2 types are found, break and move to next i.
  5️⃣Update maxLength if longer valid subarray is found.
  🕒Time: O(n²) 📦 Space: O(1)

  "	"⚡🚀 Optimal Approach (Sliding Window + HashMap)
  1️⃣Initialize start = 0, maxLength = 0, Map<fruit, count>.
              2️⃣Loop end from 0 to n - 1:
              3️⃣     Add fruits[end] to map and increment its count.
              4️⃣     While map size > 2:
              5️⃣       Decrement count of fruits[start].
              6️⃣       If count becomes 0, remove it from map.
              7️⃣       Move start++.
              8️⃣Update maxLength = max(maxLength, end - start + 1).
  9️⃣Return maxLength.
              🕒Time: O(n) 📦 Space: O(1) → Only 2 fruits at most"*/
}
