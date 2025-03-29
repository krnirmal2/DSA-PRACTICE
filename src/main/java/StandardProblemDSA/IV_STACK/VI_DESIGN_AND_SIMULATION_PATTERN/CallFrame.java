package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

/*
🔹 Simulating Function Calls Using a Stack
In many programming languages, recursion is implemented using an internal call stack. We can simulate this manually using an explicit stack.

🔹 Problem Statement
Simulate function calls using a stack, handling:

Recursive functions

Function parameters and return values

Call execution order (LIFO - Last In First Out)

🔹 Approach
1️⃣ Use a stack to store function calls.

Each call contains the function name, parameters, and state.

2️⃣ Process function calls in a loop (instead of recursion).

Push function calls onto the stack.

Pop calls when they finish execution.

        3️⃣ Use a data structure (Stack<Frame>) to store:

Function name

Arguments (parameters)

Execution state

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
