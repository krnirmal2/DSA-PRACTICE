package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

/*
Problem:
Design a browser history system that supports visiting URLs, going back, and moving forward in history.
Operations:
- visit(url): Go to a new URL.
- back(steps): Move back by 'steps' pages.
- forward(steps): Move forward by 'steps' pages.

Pattern:
Two-Stack pattern — one for back navigation, one for forward navigation.

Approach:
- Use backStack to track pages we can go back to.
- Use forwardStack to track pages we can go forward to.
- On visit(): push current page to backStack, clear forwardStack.
- On back(n): pop from backStack to forwardStack, update current page.
- On forward(n): pop from forwardStack to backStack, update current page.

Time Complexity:
- O(steps) for back and forward (pop/push per step).
- O(1) for visit() and getCurrentPage().

Space Complexity:
- O(n) for storing history in stacks.

LeetCode Similar Questions:
- 1472. Design Browser History
- 155. Min Stack
- 232. Implement Queue using Stacks

Follow-up Questions:
- How would you implement this with O(1) back/forward operations using a doubly linked list?
- Can you make it memory-efficient by limiting the maximum history size?
- How would you implement a "go to specific page in history" feature?
*/

public class BrowserHistory {
  private final Stack<String> backStack;
  private final Stack<String> forwardStack;
  private String currentPage;

  // ✅ Constructor
  public BrowserHistory(String homepage) {
    backStack = new Stack<>();
    forwardStack = new Stack<>();
    currentPage = homepage; // Initial homepage
  }

  // ✅ Visit a new URL
  public void visit(String url) {
    backStack.push(currentPage); // Store current page
    currentPage = url; // Update to new page
    forwardStack.clear(); // Reset forward history
  }

  // ✅ Move `steps` back in history
  public String back(int steps) {
    while (steps > 0 && !backStack.isEmpty()) {
      forwardStack.push(currentPage); // Store current page in forward stack
      currentPage = backStack.pop(); // Move back
      steps--;
    }
    return currentPage;
  }

  // ✅ Move `steps` forward in history
  public String forward(int steps) {
    while (steps > 0 && !forwardStack.isEmpty()) {
      backStack.push(currentPage); // Store current page in back stack
      currentPage = forwardStack.pop(); // Move forward
      steps--;
    }
    return currentPage;
  }

  // ✅ Get Current Page
  public String getCurrentPage() {
    return currentPage;
  }

  public static void main(String[] args) {
    BrowserHistory browser = new BrowserHistory("google.com");

    browser.visit("leetcode.com");
    browser.visit("github.com");
    System.out.println(browser.back(1)); // leetcode.com
    System.out.println(browser.forward(1)); // github.com
    browser.visit("stackoverflow.com"); // Visit clears forward history
    System.out.println(browser.back(2)); // google.com
    System.out.println(browser.forward(1)); // leetcode.com
  }
  /*🔹 Execution Flow
  Action	Back Stack (←)	Current Page	Forward Stack (→)
  visit("leetcode.com")	["google.com"]	leetcode.com	[]
  visit("github.com")	["google.com", "leetcode.com"]	github.com	[]
  back(1)	["google.com"]	leetcode.com	["github.com"]
  forward(1)	["google.com", "leetcode.com"]	github.com	[]
  visit("stackoverflow.com")	["google.com", "leetcode.com", "github.com"]	stackoverflow.com	[]
  back(2)	["google.com"]	leetcode.com	["stackoverflow.com", "github.com"]
  forward(1)	["google.com", "leetcode.com"]	github.com	["stackoverflow.com"]
  */
}
