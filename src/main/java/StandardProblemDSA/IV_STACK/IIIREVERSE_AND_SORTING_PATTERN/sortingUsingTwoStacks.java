package StandardProblemDSA.IV_STACK.IIIREVERSE_AND_SORTING_PATTERN;

import java.util.Stack;

public class sortingUsingTwoStacks {
  /*
  Problem:
  Sort an array or stack using only two stacks (no extra data structures allowed).

  Pattern:
  Stack manipulation + auxiliary stack.
  - Use an extra stack to maintain elements in sorted order.
  - Pop from input stack and insert into the correct position in the temporary stack.

  Time Complexity:
  O(n²) — worst case, each element might be moved back and forth between stacks.

  Space Complexity:
  O(n) — for the auxiliary stack.

  LeetCode Similar Questions:
  - 155. Min Stack (stack with extra space)
  - 147. Insertion Sort List (similar insertion logic)

  Follow-up Questions:
  - Can you implement stack sorting in O(n log n) time (e.g., using merge sort)?
  - Can you do it without using another stack (recursion-based sort)?
  - What if elements are streamed (online sorting)?
  */

  public static Stack<Integer> sortStack(Stack<Integer> input) {
    Stack<Integer> tmpStack = new Stack<Integer>();

    while (!input.empty()) {
      // pop out the
      // first element
      int tmp = input.peek();
      input.pop();

      // while temporary stack is
      // not empty and top of stack
      // is smaller than temp
      while (!tmpStack.empty() && tmpStack.peek() < tmp) {
        // pop from temporary
        // stack and push it
        // to the input stack
        input.push(tmpStack.peek());
        tmpStack.pop();
      }

      // push temp in
      // temporary of stack
      tmpStack.push(tmp);
    }

    return tmpStack;
  }

  public static void sortArrayUsingStacks(int[] arr, int n) {
    // push array elements
    // to stack
    Stack<Integer> input = new Stack<Integer>();
    for (int i = 0; i < n; i++) input.push(arr[i]);

    // Sort the temporary stack
    Stack<Integer> tmpStack = sortStack(input);

    // Put stack elements
    // in arrp[]
    for (int i = 0; i < n; i++) {
      arr[i] = tmpStack.peek();
      tmpStack.pop();
    }
  }

  // Driver Code
  public static void main(String[] args) {
    int[] arr = {10, 5, 15, 45};
    int n = arr.length;

    sortArrayUsingStacks(arr, n);

    for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
  }
} /*
  🔹 Steps for Your Approach
  Iterate over the array, pick each element one by one.

  Push elements into S1 as long as they are in increasing order.

  When encountering a smaller element,

  Move all larger elements from S1 to tempStack.

  Push the smaller element into S1 at the correct position.

  Move all elements from tempStack back into S1.

  Continue this process for all elements.

          After iteration, S1 contains sorted elements.

  🔹 Java Code Implementation
          java
  Copy
          Edit
  import java.util.Stack;

  public class SortingUsingTwoStacksCustom {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
      Stack<Integer> tempStack = new Stack<>(); // Temporary stack

      while (!input.isEmpty()) {
        int current = input.pop(); // Pick element from input stack

        // Move elements from S1 (input) to tempStack if they are greater than current
        while (!tempStack.isEmpty() && tempStack.peek() > current) {
          input.push(tempStack.pop());
        }

        // Insert the current element into the correct position in tempStack
        tempStack.push(current);

        // Move all elements from input (if any) back to tempStack
        while (!input.isEmpty() && (tempStack.isEmpty() || tempStack.peek() <= input.peek())) {
          tempStack.push(input.pop());
        }
      }

      return tempStack; // S1 now contains the sorted elements
    }

    public static void sortArrayUsingStacks(int[] arr) {
      Stack<Integer> input = new Stack<>();

      // Push elements into the stack
      for (int num : arr) {
        input.push(num);
      }

      // Sort using two stacks
      Stack<Integer> sortedStack = sortStack(input);

      // Store sorted elements back into the array
      for (int i = arr.length - 1; i >= 0; i--) {
        arr[i] = sortedStack.pop();
      }
    }

    public static void main(String[] args) {
      int[] arr = {10, 5, 15, 45, 2, 8};

      // Sort array using two stacks
      sortArrayUsingStacks(arr);

      // Print sorted array
      for (int num : arr) {
        System.out.print(num + " ");
      }
    }
  }
  🔹 Explanation with Example
  Input:
  java
          Copy
  Edit
          arr = {10, 5, 15, 45, 2, 8}
  Step-by-Step Execution
  Step	Action	S1 (Sorted)	tempStack (Temporary)
          1	Push 10	[10]	[]
          2	Push 5, pop 10 to tempStack, insert 5	[5]	[10]
          3	Push 10 back from tempStack	[5, 10]	[]
          4	Push 15	[5, 10, 15]	[]
          5	Push 45	[5, 10, 15, 45]	[]
          6	Push 2, pop all to tempStack, insert 2	[2]	[5, 10, 15, 45]
          7	Push all back to S1	[2, 5, 10, 15, 45]	[]
          8	Push 8, pop 10, 15, 45 to tempStack, insert 8	[2, 5, 8]	[10, 15, 45]
          9	Push all back to S1	[2, 5, 8, 10, 15, 45]	[]
  Final Output:
  Copy
          Edit
  2 5 8 10 15 45
          🔹 Complexity Analysis
  Operation	Complexity
  Iterating through elements	O(N)
  Pushing & Popping in Stacks	O(N²) (Worst-case, similar to insertion sort)
  Total Complexity	O(N²)*/
