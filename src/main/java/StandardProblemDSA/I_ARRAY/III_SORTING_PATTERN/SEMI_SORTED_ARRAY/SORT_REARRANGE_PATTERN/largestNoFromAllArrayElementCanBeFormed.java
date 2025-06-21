package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestNoFromAllArrayElementCanBeFormed {
  // DO NOT MODIFY THE LIST
  public static String largestNumber(final List<Integer> A) {
//    Let n = number of integers in the list
//    Let k = average number of digits per number
    // we convert the string array from list of integer
    String[] nums  = new String[A.size()];//O(n × k)
    // now put each element of the A to nums
    for(int i=0 ;i<A.size();i++){
      nums[i] = String.valueOf(A.get(i));//: O(n), as each number is converted to a string (constant-time per element)
    }
    // now we have to sort the string using comparator for lexicographicaly
    Arrays.sort(nums, (a,b)->(b+a).compareTo(a+b));/*Sorting takes O(n log n) comparisons
    Each comparison takes O(k) time to concatenate and compare two strings ,So total time for sorting = O(n log n × k)*/

    if(nums[0].equals("0")) return "0";
    // now we have join the result
    StringBuilder sb = new StringBuilder();
    for(String num :nums){
      sb.append(num);// O(n × k)
    }
    return sb.toString();

  }

  public static void main(String[] args) {
    List<Integer> a;
    a = new ArrayList<>(List.of(3, 30, 34, 5, 9));
    System.out.println(largestNumber(a));
  }



  /*✅ Comparator: (b + a).compareTo(a + b) (for largest number)
| Compare a | Compare b | a+b    | b+a    | Result                     | Larger comes first   |
| --------- | --------- | ------ | ------ | -------------------------- | -------------------- |
| `"3"`     | `"30"`    | "330"  | "303"  | "330" > "303" → return -1  | `"3"` before `"30"`  |
| `"30"`    | `"34"`    | "3034" | "3430" | "3430" > "3034" → return 1 | `"34"` before `"30"` |
| `"34"`    | `"5"`     | "345"  | "534"  | "534" > "345" → return 1   | `"5"` before `"34"`  |
| `"5"`     | `"9"`     | "59"   | "95"   | "95" > "59" → return 1     | `"9"` before `"5"`   |
*/
//          ❌ Comparator: (a + b).compareTo(b + a) (wrong logic)
        /*| Compare a | Compare b | a+b    | b+a    | Result                      | Smaller comes first          |
          | --------- | --------- | ------ | ------ | --------------------------- | ---------------------------- |
          | `"3"`     | `"30"`    | "330"  | "303"  | "330" > "303" → return 1    | `"30"` before `"3"` ❌        |
          | `"30"`    | `"34"`    | "3034" | "3430" | "3034" < "3430" → return -1 | `"30"` stays before `"34"` ❌ |
          | `"34"`    | `"5"`     | "345"  | "534"  | "345" < "534" → return -1   | `"34"` stays before `"5"` ❌  |
          | `"5"`     | `"9"`     | "59"   | "95"   | "59" < "95" → return -1     | `"5"` stays before `"9"` ❌   |*/

/* Overhead: You are creating an object for every number (Node), which introduces unnecessary memory and object creation overhead.
Verbose: More code than necessary.
  static class Node implements Comparable<Node> {
    int number;

    public Node(int number) {
      this.number = number;
    }

    @Override
    public int compareTo(Node o) {
      String first = String.valueOf(this.number) + o.number;
      String second = String.valueOf(o.number) + this.number;
      return second.compareTo(first);
    }
  }*/
  /*Easy and Optimal

    public String largestNumber(List<Integer> nums) {
      List<String> strNums = nums.stream()
              .map(String::valueOf)
              .collect(Collectors.toList());//: O(n), as each number is converted to a string (constant-time per element)

      // Sort using custom comparator
      strNums.sort((a, b) -> (b + a).compareTo(a + b));

      // Edge case: if the largest number is "0", return "0"
      if (strNums.get(0).equals("0")) return "0";

      // Join all strings
      return String.join("", strNums);
    }
  */

}
