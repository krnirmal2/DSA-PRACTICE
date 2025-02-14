package StandardProblemDSA.LINKEDLIST.DUMMY_NODE_AND_SENTINAL_PATTERN;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
