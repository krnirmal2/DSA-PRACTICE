package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 Problem: Flatten Nested List Iterator.

 Given a nested list of integers (which can contain integers or other nested lists),
 implement an iterator to flatten it and iterate over the integers sequentially.

 Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

 Pattern:
    - Stack
    - Iterator Design Pattern
    - Lazy Flattening

 Similar LeetCode Problems:
    - 341. Flatten Nested List Iterator
    - 255. Verify Preorder Sequence in Binary Search Tree (stack usage)
    - 94. Binary Tree Inorder Traversal (iterator design)
Flatten 2D Vector
Medium
Zigzag Iterator
Medium
Mini Parser
Medium
Array Nesting
Medium
 Follow-up Questions:
    - How to implement using recursion instead of stack?
    - Can this be done with O(1) space (iterator only)?
    - How to modify for nested dictionaries/maps?
    - How to handle very deep nesting efficiently?

 Time Complexity: O(n), n = total integers in nested structure (amortized over calls)
 Space Complexity: O(d), d = max depth of nesting (stack space)
*/
// Step 1 : create an interface which contain method
//  isInteger, getInteger and getList of nestedInteger
interface NestedInteger {
  boolean isInteger();

  Integer getInteger();

  List<NestedInteger> getList();
}

// Step 2 : implement the library Iterator<Integer> to the class NestedIterator
class NestedIterator implements Iterator<Integer> {
  // step 3 : take a stack and for next and has next and inset operation
  private final Stack<NestedInteger> stack;

  // Step 4: push all the value to stack of nested list
  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack<>();
    pushToStack(nestedList);
  }

  private void pushToStack(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i)); // Push in reverse order
    }
  }

  // Step 5 : next function will pop the first element from the stack
  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  // step 6 : has nexxt will check if the their is element or not in the top if it is integer
  // then return true else pop the top element and push the nested list values one by one in to the
  // stack
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
