package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

/*
Problem:
Simulate recursive and nested function calls using an explicit stack, imitating how a programming language internally manages function calls.

Pattern:
Manual call stack simulation using Stack — follows LIFO order (Last-In-First-Out).

Approach:
1. Use a Stack<CallFrame> to represent the call stack.
2. Each CallFrame stores:
      - function name
      - arguments (parameters)
3. Push the initial function call onto the stack.
4. While the stack is not empty:
      - Pop the top frame (current function).
      - Execute it (print or perform logic).
      - Push new calls onto the stack if the current function makes nested calls.
5. Continue until all calls are processed.

Time Complexity:
O(n), where n is the total number of calls simulated. Each frame is pushed and popped exactly once.

Space Complexity:
O(n), for the stack holding active CallFrames.

Similar LeetCode Questions:
- 224. Basic Calculator (stack-based expression evaluation)
- 394. Decode String (nested call simulation)
- 682. Baseball Game (stack operations)

Follow-up Questions:
- How would you return values from these simulated function calls?
- How can this be extended to support multiple recursive branches?
- How to detect and handle stack overflow for deep recursion?
*/

public class CallFrame {
  String functionName;
  int param;

  CallFrame(String functionName, int param) {
    this.functionName = functionName;
    this.param = param;
  }
}

class NestedFunctionCalls {

  public static void simulateFunctionCalls() {
    Stack<CallFrame> stack = new Stack<>();

    // Simulate calling f1(3)
    stack.push(new CallFrame("f1", 3));

    while (!stack.isEmpty()) {
      CallFrame frame = stack.pop();

      System.out.println("Executing " + frame.functionName + "(" + frame.param + ")");

      // Simulating nested calls
      if (frame.functionName.equals("f1") && frame.param > 0) {
        stack.push(new CallFrame("f2", frame.param - 1));
      } else if (frame.functionName.equals("f2") && frame.param > 0) {
        stack.push(new CallFrame("f3", frame.param - 1));
      }
    }
  }

  public static void main(String[] args) {
    simulateFunctionCalls();
  }
}
