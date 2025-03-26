package Sorting;

import java.util.Arrays;
import java.util.List;

public class LargestNoUsingArrangmentOfNO {
  /*🔹 Step-by-Step Breakdown
  1️⃣ Convert Integers to Custom Objects (Node)
    The Node class wraps an integer and implements Comparable<Node>.
    It allows us to define a custom sorting order.
  2️⃣ Custom Sorting Logic (compareTo method)
    Instead of sorting numerically, we compare concatenated strings:
    String first = String.valueOf(this.number) + o.number;
    String second = String.valueOf(o.number) + this.number;
  return second.compareTo(first);
    This ensures the best order to form the largest number.
  3️⃣ Append Sorted Numbers to StringBuffer
    If a number is 0 and it's not the first digit, we skip it to avoid leading zeros.
    Otherwise, we append numbers to strBuf.
  */
  public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
      StringBuffer strBuf = new StringBuffer();
      Node[] num = new Node[A.size()];
      int i = 0;

      // Convert numbers into Node objects
      for (int n : A) {
        num[i] = new Node(n);
        i++;
      }

      // Sort numbers using custom comparator
      Arrays.sort(num);

      // Build the largest number from sorted nodes
      for (Node n : num) {
        if (n.number == 0 && strBuf.length() != 0) continue; // Skip leading zeros
        strBuf.append(n.number);
      }

      return strBuf.toString();
    }

    // Custom class to implement sorting logic
    class Node implements Comparable<Node> {
      int number;

      public Node(int number) {
        this.number = number;
      }

      @Override
      public int compareTo(Node o) {
        // Concatenate numbers in both possible orders
        String first = String.valueOf(this.number) + o.number;
        String second = String.valueOf(o.number) + this.number;

        // Sort in descending lexicographic order to form the largest number
        return second.compareTo(first);
      }
    }

    public void main(String[] args) {
      LargestNumber obj = new LargestNumber();
      List<Integer> numbers = Arrays.asList(3, 30, 34, 5, 9);
      System.out.println("Largest Number: " + obj.largestNumber(numbers));
    }
  }

  /*
  public String largestNumber(final int[] A) {
         ArrayList<String> arrList = new ArrayList<String>();
         int sum = 0;
         int n = A.length;
         for(int i=0;i<n;i++) {
             arrList.add(Integer.toString(A[i]));// Convert numbers to strings
             sum = sum + A[i]; // Calculate sum to check for "all zeros" case
         }
         if (sum == 0) {
             return "0";
         }
         Collections.sort(arrList, new Comparator<String>(){
             public int compare(String a, String b){
                 String firstNum = a+b;
                 String secondNum = b+a;
                 return firstNum.compareTo(secondNum) > 0 ? -1 : 1;
             }
         });
         String result = String.join("", arrList);
         return result;
     }*/

}
