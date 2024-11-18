package StandardProblemDSA.STACK.CUSTOM_STACK_DESIGN_PATTERN;

/*Problem Overview:
We want to implement a custom stack that supports:
Push: Add an element to the top of the stack.
Pop: Remove and return the topmost element of the stack.
Increment: Increment the bottom k elements of the stack by a given value.*/
public class CustomStackIncrementImp {

    private final int[] stackArray;
    private final int[] incrementArr;
    private int top;

    public CustomStackIncrementImp(int capacity) {
        this.incrementArr = new int[capacity];
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public static void main(String[] args) {
        // Initialize a CustomStack with a max size of 5
        CustomStackIncrementImp stack = new CustomStackIncrementImp(5);

        // Step 1: Perform push operations
        System.out.println("Pushing elements into the stack:");
        stack.push(5);
        stack.push(2);
        stack.push(9);
        System.out.println("Stack after pushes: [5, 2, 9]\n");

        // Step 2: Perform an increment operation
        System.out.println("Incrementing bottom 2 elements by 10:");
        stack.increment(2, 10);
        System.out.println("Expected Stack: [15, 12, 9] (actual increment happens on pop)\n");

        // Step 3: Perform pop operation
        System.out.println("Popping the top element:");
        System.out.println("Popped value: " + stack.pop()); // Output: 9
        System.out.println("Expected Stack: [15, 12] (after pop)\n");

        // Step 4: Perform another increment operation
        System.out.println("Incrementing bottom 2 elements by 20:");
        stack.increment(2, 20);
        System.out.println("Expected Stack: [35, 32] (actual increment happens on pop)\n");

        // Step 5: Push more elements
        System.out.println("Pushing more elements into the stack:");
        stack.push(4);
        stack.push(7);
        System.out.println("Stack after pushes: [35, 32, 4, 7]\n");

        // Step 6: Perform an increment operation
        System.out.println("Incrementing bottom 3 elements by 5:");
        stack.increment(3, 5);
        System.out.println("Expected Stack: [40, 37, 9, 7] (actual increment happens on pop)\n");

        // Step 7: Pop all elements
        System.out.println("Popping all elements:");
        while (true) {
            int value = stack.pop();
            if (value == -1) break; // Stop if stack is empty
            System.out.println("Popped value: " + value);
        }

        System.out.println("All elements popped. Stack is now empty.");
    }

    // implement push operation
    public void push(int element) {
        // check if capacity is not overflow
        if (top == stackArray.length - 1) {
            System.out.println("stack is overflow");
            return;
        }
        top++;
        // if not then we will add
        stackArray[top] = element;
    }

    // now for pop operation we have to do some lazzy update on rquirement as per the question
    /*
    2. pop()
The actual value of the top element is stack[top] + increment[top]. This is because any lazy increments stored in increment[top] must be applied.
Propagate the increment:
Add increment[top] to increment[top - 1], passing the lazy increment to the next lower element.
Reset the current increment:
After the value is popped, reset increment[top] = 0.
Update the top pointer:
Decrease top by 1 to remove the top element.
3. increment(int k, int val)
This operation increments the bottom k elements of the stack by val. If k > size of stack, increment all elements.

Find the limit:

Calculate limit = Math.min(k, top + 1), where top + 1 is the current size of the stack.
Apply lazy increment:

Add val to increment[limit - 1].
This ensures the increment is applied only when the affected elements are popped.
How Lazy Increment Works
Instead of directly updating the stack elements during an increment operation (which can be costly), the increment[] array is used to store the increment values.
The increment is propagated upwards only when the affected elements are popped*/
    public int pop() {
        // check if the stack is empty
        if (top == -1) {
            System.out.println("stack is empty");
            return -1;
        }

        // now we
        // add lazy increment
        int result = stackArray[top] + incrementArr[top];// Add lazy increment value to the actual value
        if (top > 0) {
            incrementArr[top - 1] += incrementArr[top];// propagate increment to the next lower level
        }
        incrementArr[top] = 0; // Reset increment for the poped element
        top--;
        return result; // return the poped value

    }

    public void increment(int noOfElem, int val) {
        int limit = Math.min(noOfElem, top + 1); // Determine how many element to increment
        if (limit > 0) {
            incrementArr[limit - 1] += val;//Add the increment value to the increment  array lazily
        }
    }


}
