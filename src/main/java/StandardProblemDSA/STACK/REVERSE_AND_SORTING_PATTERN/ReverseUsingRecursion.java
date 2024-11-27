package StandardProblemDSA.STACK.REVERSE_AND_SORTING_PATTERN;

import java.util.Stack;

public class ReverseUsingRecursion {

    public static void stackReverse(Stack<Integer> st) {
        // we will take out each element from the stack using each function call
        if (st.isEmpty()) {
            return;
        }

        int temp = st.pop();
        stackReverse(st);

        // After the stack get empty we will try to insert element in the bottom of the stack
        insertAtBottom(st, temp);
    }

    public static void insertAtBottom(Stack<Integer> st, int new_element) {
        // if the stack is empty then push the element in the stack
        if (st.isEmpty()) {
            st.push(new_element);
        } else {
            // pop the element in the top of the stack and then we will insert the new element in the bottom
            int temp = st.pop();
            insertAtBottom(st, new_element);
            // put the new element in the stack
            st.push(temp);
        }

    }

    public static void main(String[] args) {
        // need to reverse a stack 1,2,3,4,5
        // to 5,4,3,2,1
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        st.forEach(System.out::println);
        // now reverse the stack using recursion
        stackReverse(st);
        st.forEach(System.out::println);
    }

    // Reverse function using recursion
/*    public static void reverseStack(int[] stack, int n) {
        if (n == 0) {
            return; // Base case: Stop when stack is empty
        }

        // Step 1: Pop the top element
        int topElement = stack[n - 1];

        // Step 2: Recursively reverse the remaining stack
        reverseStack(stack, n - 1);

        // Step 3: Insert the popped element at the bottom of the stack
        insertAtBottom(stack, n - 1, topElement);
    }

    // Helper function to insert an element at the bottom of the stack
    private static void insertAtBottom(int[] stack, int size, int element) {
        if (size == 0) {
            stack[0] = element; // Base case: Insert at the bottom
            return;
        }

        // Pop the current top
        int top = stack[size - 1];

        // Recursively insert the element at the bottom
        insertAtBottom(stack, size - 1, element);

        // Restore the current top
        stack[size] = top;
    }

    public static void main(String[] args) {
        // Representing the stack as an array
        int[] stack = {1, 2, 3, 4, 5};
        int size = stack.length;

        System.out.print("Original Stack: ");
        printStack(stack, size);

        // Reverse the stack
        reverseStack(stack, size);

        System.out.print("Reversed Stack: ");
        printStack(stack, size);
    }

    // Utility function to print the stack
    private static void printStack(int[] stack, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }*/
}
