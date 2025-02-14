package StandardProblemDSA.STACK.MONOTONIC_PATTERN;

public class MonotonicPattern {
    /*### Monotonic Stack Patterns Overview

Monotonic stack patterns are commonly used to solve problems that require maintaining a specific order (increasing or decreasing)
 while efficiently handling queries related to comparisons, such as finding the **next greater/smaller element**, **nearest larger/smaller element**, etc.
 The monotonic stack approach helps achieve optimal solutions with **O(n)** time complexity by using a single traversal.

---

### Key Concepts of Monotonic Stacks

1. **Monotonic Increasing Stack:**
   - Elements are stored in **increasing order** (from bottom to top of the stack).
   - Used to find the **next smaller element** or solve problems requiring smaller values.

2. **Monotonic Decreasing Stack:**
   - Elements are stored in **decreasing order** (from bottom to top of the stack).
   - Used to find the **next greater element** or solve problems requiring larger values.

3. **Advantages:**
   - Efficient for problems with constraints like "next/previous greater/smaller element."
   - Avoids redundant comparisons using the stack's monotonic property.

---

### Common Patterns and Problems

#### 1. **Next Greater Element (NGE)**
- **Problem:** For each element in the array, find the next greater element to the right. If none, return `-1`.
- **Stack Type:** Monotonic **Decreasing** Stack.
- **Approach:**
  - Traverse the array from **right to left**.
  - Maintain a stack where the **top** contains the next greater element for upcoming elements.
  - Push/pop as necessary to maintain order.

**Code Example:**
```java
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```

---

#### 2. **Next Smaller Element (NSE)**
- **Problem:** For each element in the array, find the next smaller element to the right. If none, return `-1`.
- **Stack Type:** Monotonic **Increasing** Stack.
- **Approach:**
  - Traverse the array from **right to left**.
  - Maintain a stack where the **top** contains the next smaller element for upcoming elements.

**Code Example:**
```java
public int[] nextSmallerElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() >= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```

---

#### 3. **Previous Greater Element (PGE)**
- **Problem:** For each element in the array, find the previous greater element to the left. If none, return `-1`.
- **Stack Type:** Monotonic **Decreasing** Stack.
- **Approach:**
  - Traverse the array from **left to right**.
  - Maintain a stack where the **top** contains the previous greater element.

**Code Example:**
```java
public int[] previousGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```

---

#### 4. **Previous Smaller Element (PSE)**
- **Problem:** For each element in the array, find the previous smaller element to the left. If none, return `-1`.
- **Stack Type:** Monotonic **Increasing** Stack.
- **Approach:**
  - Traverse the array from **left to right**.
  - Maintain a stack where the **top** contains the previous smaller element.

**Code Example:**
```java
public int[] previousSmallerElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && stack.peek() >= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```

---

#### 5. **Daily Temperatures (Span of Warmer Days)**
- **Problem:** For each day, find the number of days until a warmer temperature. Return `0` if none exists.
- **Stack Type:** Monotonic **Decreasing** Stack.
- **Approach:**
  - Traverse the array from **left to right**.
  - Store indices in the stack, and calculate spans based on the temperature comparison.

**Code Example:**
```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int prevIndex = stack.pop();
            result[prevIndex] = i - prevIndex;
        }
        stack.push(i);
    }
    return result;
}
```

---

#### 6. **Stock Span Problem**
- **Problem:** For each day, calculate the maximum number of consecutive days (including the current day) the price has been less than or equal to today's price.
- **Stack Type:** Monotonic **Decreasing** Stack.
- **Approach:**
  - Traverse from **left to right**.
  - Use a stack to store indices and calculate spans.

**Code Example:**
```java
public int[] stockSpan(int[] prices) {
    int n = prices.length;
    int[] span = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
            stack.pop();
        }
        span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
    }
    return span;
}
```



### General Steps for Monotonic Stack Problems
1. **Choose the Stack Type:**
   - Increasing or Decreasing, based on the problem's requirement (greater/smaller comparisons).
2. **Traverse in the Appropriate Direction:**
   - **Left to Right:** For previous element queries.
   - **Right to Left:** For next element queries.
3. **Push/Pop Elements Based on Condition:**
   - Maintain monotonicity by pushing/popping elements based on comparisons.
4. **Update Result Array:**
   - Use stack indices or element values to compute the required result.

---

### Common Applications
- **Sliding Window Problems**
- **Histogram Problems (Largest Rectangle in Histogram)**
- **Rainwater Trapping**
- **Stock Span Problems**
- **Temperature or Span Queries**

---
The **"Largest Rectangular Area in a Histogram"** problem follows the **Monotonic Decreasing Stack Pattern**. Here's a detailed breakdown of how it works and why it uses this pattern:

---

### **Monotonic Decreasing Stack Pattern**
1. **Definition**:
   - A **monotonic decreasing stack** ensures that elements in the stack are in strictly decreasing order of their heights.
   - For this problem, it means that we store indices of histogram bars in such a way that the heights of the bars at these indices are always in decreasing order.

2. **Why Monotonic Decreasing Stack?**
   - When calculating the largest rectangle area, the key is to identify the **first smaller bar to the left** and the **first smaller bar to the right** for each bar. These smaller bars determine the boundaries of the rectangle that can be formed with the current bar as the smallest height.
   - A decreasing stack helps efficiently maintain and retrieve these boundaries as we traverse the histogram.

---

### **Step-by-Step Explanation of the Pattern**

#### **Algorithm Overview**
1. **Traverse the histogram**:
   - For each bar, maintain a stack that keeps track of the indices of bars in decreasing order of their heights.
   - When encountering a bar shorter than the bar at the top of the stack, calculate the area using the height of the bar at the top of the stack as the smallest height.

2. **Area Calculation**:
   - The width of the rectangle is determined by the distance between the **previous smaller bar** and the **next smaller bar**.
   - The height of the rectangle is the height of the bar at the top of the stack.

3. **Continue Until All Bars Are Processed**:
   - At the end, process any remaining bars in the stack to ensure all potential rectangles are calculated.

---








### **Key Observations**
1. **Left and Right Boundaries**:
   - The **previous smaller element** is the bar that was added to the stack before the current bar.
   - The **next smaller element** is identified when a shorter bar is encountered.

2. **Efficiency**:
   - Each bar is pushed and popped from the stack at most once, resulting in an **O(n)** time complexity.

---

### **Dry Run Example**

#### Input Histogram
```text
[2, 1, 5, 6, 2, 3]
```

#### Steps
1. **Initialize an empty stack** and start traversing the histogram.
2. Push indices into the stack while maintaining a **monotonic decreasing order**.
3. If a bar is smaller than the bar at the top of the stack:
   - Pop the stack.
   - Calculate the rectangle area using the popped bar's height as the smallest height.

| Index | Stack       | Action                          | Calculated Area |
|-------|-------------|---------------------------------|-----------------|
| 0     | [0]         | Push 0 (height 2).             | -               |
| 1     | []          | Pop 0, calculate area (2 * 1). | 2               |
| 1     | [1]         | Push 1 (height 1).             | -               |
| 2     | [1, 2]      | Push 2 (height 5).             | -               |
| 3     | [1, 2, 3]   | Push 3 (height 6).             | -               |
| 4     | [1, 2]      | Pop 3, calculate area (6 * 1). | 6               |
| 4     | [1]         | Pop 2, calculate area (5 * 2). | 10              |
| 4     | [1, 4]      | Push 4 (height 2).             | -               |
| 5     | [1, 4, 5]   | Push 5 (height 3).             | -               |

At the end, process the remaining elements in the stack to calculate their areas.

---

### **Code**
Here’s the implementation of the **Monotonic Stack Pattern** for this problem:

```java
public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
        int h = (i == n) ? 0 : heights[i]; // Treat a height of 0 at the end.
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }

    return maxArea;
}
```

---

### **Why Use the Monotonic Decreasing Stack?**
- Ensures that we can efficiently calculate the left and right boundaries for each bar.
- Optimizes the time complexity to **O(n)**, as each bar is pushed and popped at most once.
- Avoids the need for nested loops or additional space for boundary arrays.

Let me know if you'd like a more detailed diagram or further clarification!
*/
}
