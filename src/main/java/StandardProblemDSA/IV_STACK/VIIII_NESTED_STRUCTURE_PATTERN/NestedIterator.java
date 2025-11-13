package StandardProblemDSA.IV_STACK.VIIII_NESTED_STRUCTURE_PATTERN;

import java.util.*;

interface NestedInteger {
  boolean isInteger();

  Integer getInteger();

  List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
  private Stack<NestedInteger> stack;

  // ✅ Constructor: Initialize stack with reversed nested list
  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack<>();
    pushListOntoStack(nestedList);
  }

  // ✅ Push list elements onto stack in **reverse order**
  private void pushListOntoStack(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  // ✅ `hasNext()` ensures stack top is an integer
  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger top = stack.peek();
      if (top.isInteger()) return true; // Top is already an integer

      stack.pop(); // Remove the list and expand it
      pushListOntoStack(top.getList());
    }
    return false; // No more elements
  }

  // ✅ `next()` returns the next integer in flattened order
  @Override
  public Integer next() {
    if (hasNext()) {
      return stack.pop().getInteger(); // Get integer from top
    }
    return null;
  }

  public static void main(String[] args) {
    // Example usage
    List<NestedInteger> nestedList =
        Arrays.asList(
            new NestedList(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1))),
            new NestedIntegerImpl(2),
            new NestedList(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1))));

    NestedIterator iterator = new NestedIterator(nestedList);
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }
} /*
  🔹 Dry Run
  Input:
  nestedList = [[1,1],2,[1,1]]
  Stack Processing:
  Step	Stack Content (Top → Bottom)	hasNext()	next() Output
  Initialization	[ [1,1], 2, [1,1] ]	✅ true	-
  Expand [1,1]	[1,1, 2, [1,1]]	✅ true	-
  Pop 1	[1, 2, [1,1]]	✅ true	1
  Pop 1	[2, [1,1]]	✅ true	1
  Pop 2	[[1,1]]	✅ true	2
  Expand [1,1]	[1,1]	✅ true	-
  Pop 1	[1]	✅ true	1
  Pop 1	[]	❌ false	1
          ✅ Final Output: [1,1,2,1,1]
  */

// ✅ Helper classes for testing
class NestedIntegerImpl implements NestedInteger {
  private Integer value;

  public NestedIntegerImpl(int value) {
    this.value = value;
  }

  @Override
  public boolean isInteger() {
    return true;
  }

  @Override
  public Integer getInteger() {
    return value;
  }

  @Override
  public List<NestedInteger> getList() {
    return null;
  }
}

class NestedList implements NestedInteger {
  private List<NestedInteger> list;

  public NestedList(List<NestedInteger> list) {
    this.list = list;
  }

  @Override
  public boolean isInteger() {
    return false;
  }

  @Override
  public Integer getInteger() {
    return null;
  }

  @Override
  public List<NestedInteger> getList() {
    return list;
  }
}
