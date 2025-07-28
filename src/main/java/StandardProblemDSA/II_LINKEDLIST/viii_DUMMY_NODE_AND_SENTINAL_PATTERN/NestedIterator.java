package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 Problem: Flatten Nested List Iterator.

 Given a nested list of integers (which can contain integers or other nested lists),
 implement an iterator to flatten it and iterate over the integers sequentially.

 Example:
 Input: [[1,1],2,[1,1]]
 Output: 1, 1, 2, 1, 1

 Pattern:
    - Stack
    - Iterator Design Pattern
    - Lazy Flattening

 Similar LeetCode Problems:
    - 341. Flatten Nested List Iterator
    - 255. Verify Preorder Sequence in Binary Search Tree (stack usage)
    - 94. Binary Tree Inorder Traversal (iterator design)

 Follow-up Questions:
    - How to implement using recursion instead of stack?
    - Can this be done with O(1) space (iterator only)?
    - How to modify for nested dictionaries/maps?
    - How to handle very deep nesting efficiently?

 Time Complexity: O(n), n = total integers in nested structure (amortized over calls)
 Space Complexity: O(d), d = max depth of nesting (stack space)
*/

interface NestedInteger {
  boolean isInteger();

  Integer getInteger();

  List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
  private final Stack<NestedInteger> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack<>();
    pushToStack(nestedList);
  }

  private void pushToStack(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i)); // Push in reverse order
    }
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger top = stack.peek();
      if (top.isInteger()) {
        return true; // If the top is an integer, return true
      }
      stack.pop(); // Remove the list
      pushToStack(top.getList()); // Flatten the list
    }
    return false;
  }
}
