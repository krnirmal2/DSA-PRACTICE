package StandardProblemDSA.XII_HASHMAP.FREQUENCY_AND_COUNTING_PATTERN;

import java.util.*;

public class GroupAnagram {
  public static List<List<String>> groupAnagrams(String[] strs) {
    // Step 1: initail configuration take a map where will put the string and its corresponding
    // matched anagram
    Map<String, List<String>> map = new HashMap<>();
    // Step 2: iterate over the list of strings
    for (String str : strs) {
      // Step 3: convert each string to character array and sort that array
      // and put that string into map with new string and add to the list
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedKey = new String(charArray);
      map.putIfAbsent(sortedKey, new ArrayList<>());

      map.get(sortedKey).add(str);
    }
    // step 4: return the map.values();
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] arr = {"act", "god", "cat", "dog", "tac"};
    System.out.println(groupAnagrams(arr));
  }
}
/*Here’s a **step-by-step dry run with throw comments** for the enhanced code on
nums = [2, 1, 4, 5, 3, 3], k = 3
### **Initial Setup**
totalSum = 18; target = 6
nums sorted descending = [5, 4, 3, 3, 2, 1]
### **First subset formation (k = 3)**

* **Pick 5** → currentSum = 5

  * Try 4 → 5 + 4 > 6 **(throw: prune, too big)**
  * Try 3 → 5 + 3 > 6 **(throw: prune)**
  * Try 3 → 5 + 3 > 6 **(throw: prune)**
  * Try 2 → 5 + 2 > 6 **(throw: prune)**
  * Try 1 → 5 + 1 = 6 **(subset found: \[5, 1])**

→ **Throw forward**: subset complete, k = 2
### **Second subset formation (k = 2)**
* **Pick 4** → currentSum = 4
  * Try 3 → 4 + 3 > 6 **(throw: prune)**
  * Try 3 → 4 + 3 > 6 **(throw: prune)**
  * Try 2 → 4 + 2 = 6 **(subset found: \[4, 2])**
→ **Throw forward**: subset complete, k = 1
### **Third subset formation (k = 1)**
* Remaining: \[3, 3]
* **Pick 3** → currentSum = 3
  * Try next 3 → 3 + 3 = 6 **(subset found: \[3, 3])**
→ **Throw success**: all subsets complete, return true.
### **Comments (“throws”) explained**

* **“throw: prune, too big”** – when adding an element exceeds `target`, backtrack immediately.
* **“throw forward”** – when a subset matches the target, reduce `k` and start filling the next subset.
* **“throw success”** – all `k` subsets found; terminate recursion with `true`.

---

Would you like me to **rewrite your code with these throw comments inserted inline** (so you can see exactly where each throw happens)?
*/
