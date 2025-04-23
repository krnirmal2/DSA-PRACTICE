package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestNoFromAllArrayElementCanBeFormed {
  // DO NOT MODIFY THE LIST
  public static String largestNumber(final List<Integer> A) {
    StringBuffer strBuf = new StringBuffer();
    Node[] num;
    int i = 0;
    num = new Node[A.size()];
    for (int n : A) {
      num[i] = new Node(n);
      i++;
    }
    // sorts the array lexicographically
    Arrays.sort(num);
    for (Node n : num) {
      if (n.number == 0 && strBuf.length() != 0) continue;
      strBuf.append(n.number);
    }
    return strBuf.toString();
  }

  public static void main(String[] args) {
    List<Integer> a;
    a = new ArrayList<>(List.of(3, 30, 34, 5, 9));
    System.out.println(largestNumber(a));
  }

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
  }
  /*Easy and Optimal

    public String largestNumber(List<Integer> nums) {
      List<String> strNums = nums.stream()
              .map(String::valueOf)
              .collect(Collectors.toList());

      // Sort using custom comparator
      strNums.sort((a, b) -> (b + a).compareTo(a + b));

      // Edge case: if the largest number is "0", return "0"
      if (strNums.get(0).equals("0")) return "0";

      // Join all strings
      return String.join("", strNums);
    }
  */

}
