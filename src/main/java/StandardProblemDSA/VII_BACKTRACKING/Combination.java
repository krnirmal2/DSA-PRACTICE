package StandardProblemDSA.VII_BACKTRACKING;

import java.util.ArrayList;

public class Combination {

  public static void combine(ArrayList<ArrayList<Integer>> result, int[] element, int r) {
    int start = 0;
    backTrack(result, new ArrayList<Integer>(), element, r, start);
  }
/*✅ Approach (Backtracking for Combinations)
You're generating all combinations of size r (like nCr) from the given element[] array using backtracking:
Start with an empty temp list (temp).
At each step, add one element from the remaining elements (from index start onward).
Recurse to build longer combinations.
Once temp.size() == r, you’ve found a valid combination → add it to result.

Then backtrack by removing the last element to explore new branches.*/
  public static void backTrack(
      ArrayList<ArrayList<Integer>> result,
      ArrayList<Integer> temp,
      int[] element,
      int r,
      int start) {
    // check if the temp list is equal to r then we will add to the result
    // ;
    if (temp.size() == r) {
      result.add(new ArrayList<>(temp)); // put whole tmep in the result set
    }
    // now iterate  over each string char by fixing one of them
    for (int i = start; i < element.length; i++) {
      // Add the first character and then so on
      if (i > start && element[i] == element[i - 1]) continue; // ✅ skip duplicates
      temp.add(element[i]);
      // After fixing the first character add the remaining
      backTrack(result, temp, element, r, i + 1); // add the next character which is start
      // back track
      // remove the temp list last character of current
      temp.remove(temp.size() - 1); //
    }
  }

  public static void main(String[] args) {
    int[] element = {1, 2, 4};
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    // size of the combination
    // nCr
    int r = 2;
    // create the function for recursive call
    combine(result, element, r);
  }
}
