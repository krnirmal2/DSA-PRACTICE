Below is an integrated outline for common linked‐list operations. In this design, all methods are encapsulated within a single class (for example, `LinkedListOperations`), allowing for code reuse and easy maintenance. Each problem is described with:

- **Problem Statement:** What the operation requires.
- **Brute Force Approach:** A conceptual explanation.
- **Optimal Approach:** A clear, minimal code snippet (Java-like pseudocode).
- **Time and Space Complexity:** Analysis of the solution.
- **Example:** A brief example to illustrate usage.

---

## 1. Insertion Operations

### a. Insert Node at the Beginning

**Problem Statement:**  
Add a new node at the start of the list.

**Brute Force Approach:**
- Create a new node.
- Point its `next` to the current head.
- Update the head pointer to the new node.

**Optimal Approach (Java/Pseudocode):**
```java
public class LinkedListOperations {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    ListNode head; // head pointer of the list

    // Insert at the beginning.
    public void insertAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    // Other methods below...
}
```

**Complexity:**
- **Time:** O(1)
- **Space:** O(1)

**Example:**
- **List before:** 3 → 5 → 7
- **Insert 2 at beginning → List after:** 2 → 3 → 5 → 7

---

### b. Insert Node at the End

**Problem Statement:**  
Add a new node at the end of the list.

**Brute Force Approach:**
- Traverse the list to find the last node.
- Attach the new node after the last node.

**Optimal Approach (Java/Pseudocode):**
```java
public void insertAtEnd(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
        head = newNode;
        return;
    }
    ListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
}
```

**Complexity:**
- **Time:** O(n) (n = number of nodes)
- **Space:** O(1)

**Example:**
- **List before:** 2 → 3 → 5
- **Insert 7 at end → List after:** 2 → 3 → 5 → 7

---

### c. Insert Node at a Specific Position

**Problem Statement:**  
Add a new node at a given position (e.g., at index 2).

**Brute Force Approach:**
- Traverse the list until the node before the target position.
- Adjust pointers to insert the new node in between.

**Optimal Approach (Java/Pseudocode):**
```java
public void insertAtPosition(int value, int position) {
    ListNode newNode = new ListNode(value);
    if (position == 0) {
        newNode.next = head;
        head = newNode;
        return;
    }
    ListNode current = head;
    // Traverse to node at position-1.
    for (int i = 0; i < position - 1 && current != null; i++) {
        current = current.next;
    }
    if (current == null) {
        // Position is out of bounds; handle appropriately.
        return;
    }
    newNode.next = current.next;
    current.next = newNode;
}
```

**Complexity:**
- **Time:** O(n) in the worst-case
- **Space:** O(1)

**Example:**
- **List before:** 2 → 3 → 5 → 7
- **Insert 4 at position 2 → List after:** 2 → 3 → 4 → 5 → 7

---

## 2. Deletion Operations

### a. Delete Node with a Given Value

**Problem Statement:**  
Remove the first occurrence of a node with a given value.

**Brute Force Approach:**
- Traverse the list, keeping track of the previous node.
- When a node with the given value is found, adjust pointers to bypass it.
- Handle the case when the node to be deleted is the head.

**Optimal Approach (Java/Pseudocode):**
```java
public void deleteNodeByValue(int value) {
    if (head == null) return;
    
    // If head is the node to be deleted.
    if (head.val == value) {
        head = head.next;
        return;
    }
    
    ListNode current = head;
    while (current.next != null && current.next.val != value) {
        current = current.next;
    }
    // If the node is found, bypass it.
    if (current.next != null) {
        current.next = current.next.next;
    }
}
```

**Complexity:**
- **Time:** O(n)
- **Space:** O(1)

**Example:**
- **List before:** 2 → 3 → 4 → 5
- **Delete node with value 4 → List after:** 2 → 3 → 5

---

### b. Delete Node without Head Pointer

**Problem Statement:**  
Given only a pointer/reference to a node (that is not the tail) in a singly-linked list, delete that node.

**Brute Force Approach:**
- Normally, deletion requires access to the previous node; however, without the head, copy data from the next node and bypass it.

**Optimal Approach (Java/Pseudocode):**
```java
public void deleteNodeWithoutHead(ListNode node) {
    if (node == null || node.next == null) {
        // Can't delete the node if it's null or the last node.
        return;
    }
    // Copy the next node's value into the current node.
    node.val = node.next.val;
    // Bypass the next node.
    node.next = node.next.next;
}
```

**Complexity:**
- **Time:** O(1)
- **Space:** O(1)

**Example:**
- **List before:** 2 → 3 → 4 → 5
- **Given pointer to node with value 4, deletion → List after:** 2 → 3 → 5  
  *(Note: The node originally containing 4 now contains 5, and the original node with value 5 is removed.)*

---

### Overall Summary

All these linked list methods are implemented within a single class (`LinkedListOperations`). This design approach ensures:

- **Reusability:** Common node structure and utility methods are shared.
- **Modularity:** Each operation (insertion or deletion) is implemented in a separate method.
- **Clarity:** Both brute force ideas and optimal code solutions are outlined with complexity analysis and simple examples.

This unified class design simplifies the management of various linked list operations and makes it easier to maintain or extend the functionality as needed.