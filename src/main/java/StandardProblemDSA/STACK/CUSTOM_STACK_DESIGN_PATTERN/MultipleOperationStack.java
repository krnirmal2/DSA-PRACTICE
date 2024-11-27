package StandardProblemDSA.STACK.CUSTOM_STACK_DESIGN_PATTERN;

import java.util.Stack;

/*
* Designing special stacks with multiple functionalities involves creating a stack with added capabilities beyond basic
 push and pop operations. Some common additional functionalities include
Get Minimum in O(1): A stack that can return the minimum element in constant time.
Get Maximum in O(1): A stack that can return the maximum element in constant time.
Middle Element Access: Retrieve or delete the middle element of the stack in O(1).
Increment Operation: Increment specific elements lazily (similar to a previous task).
Custom Functionalities: Like duplicating the top element, reversing the stack, etc.
* */
public class MultipleOperationStack {

    //min/max get element ==> we need to track the min and max stack array
    // each time during push and pop
    Stack<Integer> stack;
    Stack<Integer> minStack;
    Stack<Integer> maxStack;

    public MultipleOperationStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public static void main(String[] args) {
        // we need to create the object of multiOperation Stack

        MultipleOperationStack ms = new MultipleOperationStack();
        // now add the element in to the stack
        ms.push(1);
        ms.push(2);
        ms.push(5);
        ms.push(3);
        ms.push(-1);

        // now for element get min and max
        System.out.println("min in the stack : " + ms.getMin()); // return -1
        System.out.println("Max  in the stack : " + ms.getMax()); // return 5

        // now pop element and we will check the current min and max

        ms.pop();
        // now for element get min and max
        System.out.println("min in the stack : " + ms.getMin()); // return -1
        System.out.println("Max  in the stack : " + ms.getMax()); // return 5

        ms.pop();
        // now for element get min and max
        System.out.println("min in the stack : " + ms.getMin()); // return -1
        System.out.println("Max  in the stack : " + ms.getMax()); // return 5


    }

    public void push(int element) {
        // check if the minStack  has minimum value till each element entry or not
        if (minStack.isEmpty() || maxStack.isEmpty()) {
            minStack.add(element);
            maxStack.add(element);
            stack.add(element);
            return;
        }
        // if the element is small from the peak element of the minstack then add that element other wise
        // continue the element which is already min
        boolean minValue = element <= minStack.peek() ? minStack.add(element) : minStack.add(minStack.peek());
        // if the element is greater tha already pick eleemnt in max stack then add other wise add already present stack
        boolean maxValue = element >= maxStack.peek() ? maxStack.add(element) : maxStack.add(maxStack.peek());

        //at the end add the element in the stack
        stack.add(element);
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. No minimum value.");
        }
        return minStack.peek();
    }

    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. No maximum value.");
        }
        return maxStack.peek();
    }

    // pop
    public int pop() {
        // during pop we need to check both min and max  should be also
        // updated
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }

        if (!minStack.isEmpty()) {
            minStack.pop();
        }
        if (!maxStack.isEmpty()) {
            maxStack.pop();
        }
        return stack.pop();

    }
}
