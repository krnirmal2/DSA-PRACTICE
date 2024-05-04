package StandardProblemDSA.STACK;

public class StackUsingArray {
// Stack implementation Using Array

    // store elements of stack
    private final int[] arr;
    // represent top of stack
    private int top;
    // total capacity of the stack
    private final int capacity;

    // Creating a stack
    StackUsingArray(int size) {
        // initialize the array
        // initialize the stack variables
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Stack: ");
        stack.printStack();

        // remove element from stack
        stack.pop();
        System.out.println("\nAfter popping out");
        stack.printStack();

    }

    // push elements to the top of stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");

            // terminates the program
            System.exit(1);
        }

        // insert element on top of stack
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // pop elements from top of stack
    public int pop() {

        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            // terminates the program
            System.exit(1);
        }

        // pop element from top of stack
        return arr[top--];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
