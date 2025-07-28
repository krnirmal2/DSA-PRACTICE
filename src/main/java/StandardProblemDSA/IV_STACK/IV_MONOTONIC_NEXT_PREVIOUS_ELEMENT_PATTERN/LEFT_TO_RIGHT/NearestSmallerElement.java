package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN.LEFT_TO_RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {
  /*
  Problem:
  Given an array, for each element find the index of the nearest smaller element on its left.
  If no such element exists, store -1.

  Pattern:
  Monotonic Increasing Stack.
  - Traverse from left to right.
  - Maintain a stack of indices where array values are in ascending order.
  - Pop until we find a smaller element.
  - The top of the stack (if any) is the nearest smaller on the left.

  Time Complexity:
  O(n) — each index is pushed and popped at most once.

  Space Complexity:
  O(n) — stack + output list.

  LeetCode Similar Questions:
  - 503. Next Greater Element II
  - 739. Daily Temperatures
  - 84. Largest Rectangle in Histogram (uses nearest smaller elements)

  Follow-up Questions:
  - How to adapt for nearest greater element?
  - Can we do this for a circular array?
  - Can we modify it to return the actual values instead of indices?
  */

  // find the next smaller element in the left side
  public static void main(String[] args) {
    //        ArrayList<Integer> arrayList = new ArrayList<>(List.of(4,7,9,5,8,5,2,7,6));
    ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 3, 0, 2, 5));

    nearestLefSideSmallerElement(arrayList)
        .forEach(
            i -> {
              System.out.println(i);
            });
  }

  private static ArrayList<Integer> nearestLefSideSmallerElement(ArrayList<Integer> arrayList) {
    // create a list where we save all the indexesA
    ArrayList<Integer> indexes = new ArrayList<>();
    // create a stack
    Stack<Integer> stack = new Stack<>();

    // iterate over the array from left to right
    for (int i = 0; i < arrayList.size(); i++) {
      // Keep removing top element from S while the top
      // element is greater than or equal to arr[i]
      // check if the stack is not empty and if the element of the stack top index of arraylist is
      // greater than the current element
      while (!stack.isEmpty() && arrayList.get(stack.peek()) > arrayList.get(i)) {
        //                System.out.println("Stack peek is "+ stack.peek());
        //                System.out.println("Arraylist index "+ arrayList.get(i));
        //                System.out.println("arraylist with index stack peek "+
        // arrayList.get(stack.peek()));

        stack.pop();
      }

      if (stack.isEmpty()) {
        indexes.add(i, -1);
      } else {
        indexes.add(i, stack.peek());
      }

      stack.push(i);
    }

    return indexes;
  }
}
