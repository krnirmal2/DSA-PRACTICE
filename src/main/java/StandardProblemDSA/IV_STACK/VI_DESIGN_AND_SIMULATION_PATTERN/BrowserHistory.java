package StandardProblemDSA.IV_STACK.VI_DESIGN_AND_SIMULATION_PATTERN;

import java.util.Stack;

/*🔹 Approach
1️⃣ Use Two Stacks:

backStack → Stores previous pages (for back navigation).

forwardStack → Stores forward pages (for forward navigation).

2️⃣ Operations:

visit(url):

Push the current page into backStack (if it exists).

Clear the forwardStack (since we can't move forward anymore).

back(n):

Move n steps back by popping from backStack and pushing to forwardStack.

forward(n):

Move n steps forward by popping from forwardStack and pushing to backStack.*/
public class BrowserHistory {
  private Stack<String> backStack;
  private Stack<String> forwardStack;
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
