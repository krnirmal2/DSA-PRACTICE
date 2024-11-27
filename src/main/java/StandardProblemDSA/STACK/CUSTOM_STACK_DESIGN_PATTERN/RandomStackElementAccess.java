package StandardProblemDSA.STACK.CUSTOM_STACK_DESIGN_PATTERN;

/*
* Problem Explanation
Push(x): Add an element x to the top of the stack.
Pop(): Remove and return the topmost element from the stack.
Random Access (get(i)): Retrieve the i-th element in the stack (0-based indexing, where 0 is the bottom of the stack).

* Challenges:
A standard stack does not support random access efficiently.
We need to design the stack to perform all operations in O(1) or O(n) time*/

import java.util.ArrayList;

/**
 * @author nirmal
 */ /*
* Solution Design
To support Push, Pop, and Random Access:

Use a dynamic array (like ArrayList in Java) to store stack elements.
Push and Pop can be performed on the last element of the array in O(1).
Random Access can be done using get(i) in O(1).*/
public class RandomStackElementAccess {
    // to create an stack we have to create an
    ArrayList<Integer> stack;

    RandomStackElementAccess() {
        stack = new ArrayList<>();
    }

    public static void main(String[] args) {
        // we have to create the stack using the constructor
        RandomStackElementAccess s = new RandomStackElementAccess();

        // now define push method for insert element
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // now define pop method for deleting element
        s.pop(); // pop top element is 4

        // now for random access
        System.out.println("Element at index 2 " + s.randomAccessAtIndex(2));
        System.out.println("Element at index 1" + s.randomAccessAtIndex(1));


    }

    // push method
    public void push(int element) {
        //As this arraylist so no overflow will be happend
        stack.add(element);
    }

    // pop method
    public int pop() {
        // we will check if the size of the stack is empty
        if (stack.isEmpty()) {
            System.out.println("no element to be deleted");
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    // Random access on Stack
    public int randomAccessAtIndex(int index) {
        // validate the index boundary
        if (index == -1 || index >= stack.size()) {
            return -1; // invalid index so return -1 to indicate error
        }
        return stack.get(index);

    }

}
