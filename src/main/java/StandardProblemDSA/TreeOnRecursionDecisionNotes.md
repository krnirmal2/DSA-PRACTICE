Ah, I like how you’re thinking 👌
You’ve hit on something really important: **most binary tree problems are just different flavors of recursion**, and many of them map naturally to **Dynamic Programming on Trees (Tree DP)**.

Let’s systematically categorize them.

---

## 🌳 Categories of Recursive Tree Problems

### 1. **Aggregate Value from Subtrees**

👉 Problems where we compute something from left and right children and combine.

* **Examples**:

    * Maximum depth of a tree.
    * Diameter of a binary tree.
    * Maximum / Minimum value in a tree.
    * Sum of all nodes.
* **Pattern**:

  ```java
  int dfs(TreeNode root) {
      if (root == null) return base;
      int left = dfs(root.left);
      int right = dfs(root.right);
      return combine(left, right, root.val);
  }
  ```

---

### 2. **Path-based Problems (Global Answer)**

👉 Problems where you must keep track of a *global best* across recursive calls.

* **Examples**:

    * Maximum Path Sum.
    * Longest Zigzag Path.
    * Diameter (again, but here treated as "max path across node").
* **Pattern**:

  ```java
  int dfs(TreeNode root) {
      if (root == null) return 0;
      int left = Math.max(0, dfs(root.left));
      int right = Math.max(0, dfs(root.right));
      globalMax = Math.max(globalMax, left + right + root.val);
      return Math.max(left, right) + root.val;
  }
  ```

---

### 3. **Decision / Existence Problems**

👉 Problems where recursion returns *boolean* or *existence of path*.

* **Examples**:

    * Does a path with given sum exist?
    * Symmetric Tree check.
    * Balanced Binary Tree.
* **Pattern**:

  ```java
  boolean dfs(TreeNode root, target) {
      if (root == null) return baseCase;
      return combine(dfs(root.left), dfs(root.right), root.val, target);
  }
  ```

---

### 4. **Counting Problems**

👉 Instead of max/min, we **count** possibilities.

* **Examples**:

    * Count paths with given sum.
    * Count leaf nodes.
    * Count number of BSTs with `n` nodes (Catalan).
* **Pattern**:

  ```java
  int dfs(TreeNode root) {
      if (root == null) return 0;
      return dfs(root.left) + dfs(root.right) + (condition ? 1 : 0);
  }
  ```

---

### 5. **DP on Trees (Choice Problems)**

👉 When a node has multiple choices, like “take or skip”.

* **Examples**:

    * House Robber III (choose node or its children).
    * Maximum Independent Set in a tree.
* **Pattern**:

  ```java
  Map<TreeNode, Integer> memo = new HashMap<>();
  int dfs(TreeNode root) {
      if (root == null) return 0;
      if (memo.containsKey(root)) return memo.get(root);

      int take = root.val 
                + dfs(root.left.left) + dfs(root.left.right)
                + dfs(root.right.left) + dfs(root.right.right);
      int skip = dfs(root.left) + dfs(root.right);

      memo.put(root, Math.max(take, skip));
      return memo.get(root);
  }
  ```

---

### 6. **Structural Problems**

👉 Recursion builds or reconstructs tree.

* **Examples**:

    * Serialize / Deserialize Binary Tree.
    * Build Tree from Inorder & Preorder.
    * Flatten Binary Tree to Linked List.
* **Pattern**: recursive construction:

  ```java
  TreeNode build(int[] inorder, int[] preorder) {
      // pick root
      // recursively build left and right
  }
  ```

---

### 7. **Traversal-based Problems**

👉 Problems where recursion’s main job is *visiting nodes in order*.

* **Examples**:

    * Preorder / Inorder / Postorder traversal.
    * Boundary traversal.
    * Morris traversal (without recursion).

---

### 8. **Constraint Propagation Problems**

👉 Recursion carries *extra state/constraints* downward.

* **Examples**:

    * Validate BST (carry min/max range).
    * Sum Root-to-Leaf Numbers.
    * Path Sum II (carry current path).
* **Pattern**:

  ```java
  boolean dfs(TreeNode root, int min, int max) {
      if (root == null) return true;
      if (root.val <= min || root.val >= max) return false;
      return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
  }
  ```

---

## 🧠 Why this is useful for DP?

* **Category 1 & 2** → directly map to bottom-up DP on trees.
* **Category 3 & 4** → counting & boolean DP states.
* **Category 5** → classic “tree DP with choices”.
* **Category 6** → constructive recursion.
* **Category 7 & 8** → constraint-carrying recursion.

---

⚡ So in short, tree problems with recursion usually fall into:

* **Aggregate** (min/max/sum)
* **Path/global**
* **Existence/boolean**
* **Counting**
* **Choice (DP)**
* **Structural/constructive**
* **Traversal**
* **Constraint propagation**

---

Nice — you’re thinking exactly like an interviewer wants. Below I’ll give **compact, generalised Java templates** for the common recursion categories you described. Each template shows:

* the **base case** (what to return when `node == null`),
* the **recursive step** (how to combine child results), and
* a short **note** on common pitfalls.

Use these as quick interview-ready patterns.

# 1) Count nodes (or count condition matches)

Base: `null -> 0`
Pattern: `1 + left + right` (or `cond ? 1 : 0`)

```java
int count(TreeNode node) {
    if (node == null) return 0;                    // base
    int left = count(node.left);
    int right = count(node.right);
    return (condition(node) ? 1 : 0) + left + right;
}
```

Note: `condition(node)` could be `node.val % 2 == 0`, `isLeaf(node)`, etc.

# 2) Sum of subtree values

Base: `null -> 0`
Pattern: `node.val + left + right`

```java
int sum(TreeNode node) {
    if (node == null) return 0;
    int left = sum(node.left);
    int right = sum(node.right);
    return node.val + left + right;
}
```

Pitfall: watch for overflow if values are large — use `long` then.

# 3) Max / Min in subtree

Base: `null -> Integer.MIN_VALUE` (for max) or `Integer.MAX_VALUE` (for min)
Pattern: `Math.max(node.val, Math.max(left, right))`

```java
int maxVal(TreeNode node) {
    if (node == null) return Integer.MIN_VALUE;    // base for max
    int left = maxVal(node.left);
    int right = maxVal(node.right);
    return Math.max(node.val, Math.max(left, right));
}
```

Note: if all values can be negative, `Integer.MIN_VALUE` is correct for base. For min, swap accordingly.

# 4) Global path-based problems (e.g., diameter, max path sum)

Base: `null -> 0` for the *contribution to parent* (often)
Pattern: compute child contributions, update global, return best contribution upwards.

```java
int global; // set appropriately, e.g., Integer.MIN_VALUE for sums

int dfs(TreeNode node) {
    if (node == null) return 0;                  // contribution to parent
    int left = Math.max(0, dfs(node.left));      // drop negative contributions
    int right = Math.max(0, dfs(node.right));
    // update global answer using left and right
    global = Math.max(global, left + right + node.val); 
    // return contribution to parent
    return Math.max(left, right) + node.val;
}
```

Pitfall: use `Math.max(0, ...)` when a negative child should be ignored. Initialize `global` to `Integer.MIN_VALUE` for sums.

# 5) Existence / boolean problems (e.g., path-sum exists, symmetric)

Base: `null -> false` (or `true` depending on problem)
Pattern: combine booleans from children

```java
boolean exists(TreeNode node, int target) {
    if (node == null) return false; 
    if (isLeaf(node) && node.val == target) return true; // leaf check
    return exists(node.left, target - node.val) || exists(node.right, target - node.val);
}
```

Note: choose the base based on semantics (e.g., empty tree may or may not satisfy property).

# 6) Counting paths with sum (prefix-sum + map) — more advanced

Base: treat `null` as contributing nothing; we use a map of prefix sums.

```java
int countPaths(TreeNode root, int target) {
    Map<Integer,Integer> pref = new HashMap<>();
    pref.put(0, 1); // empty path
    return dfs(root, 0, target, pref);
}
int dfs(TreeNode node, int curr, int target, Map<Integer,Integer> pref) {
    if (node == null) return 0;
    curr += node.val;
    int res = pref.getOrDefault(curr - target, 0);
    pref.put(curr, pref.getOrDefault(curr, 0) + 1);
    res += dfs(node.left, curr, target, pref);
    res += dfs(node.right, curr, target, pref);
    pref.put(curr, pref.get(curr) - 1); // backtrack
    return res;
}
```

Tip: remember to backtrack the map counts after child calls.

# 7) DP with choices (take / skip) — e.g., House Robber III

Base: `null -> {0,0}` (or `{skip, take}`)
Pattern: return two values: best if we take this node, and best if we skip it.

```java
int[] dfs(TreeNode node) { // returns [skip, take]
    if (node == null) return new int[]{0, 0};
    int[] L = dfs(node.left);
    int[] R = dfs(node.right);
    int take = node.val + L[0] + R[0];   // take node => children must be skipped
    int skip = Math.max(L[0], L[1]) + Math.max(R[0], R[1]); // skip node => children can be take/skip
    return new int[]{skip, take};
}
```

Note: returning pair/array avoids global memo and makes DP clear.

# 8) Structural / construct tree (build from traversals)

Base: when index bounds cross, return `null`.
Pattern: pick root, build left and right with proper index ranges.

```java
TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer,Integer> inPos) {
    if (preL > preR || inL > inR) return null; // base
    int rootVal = pre[preL];
    int inIndex = inPos.get(rootVal);
    int leftSize = inIndex - inL;
    TreeNode root = new TreeNode(rootVal);
    root.left = build(pre, preL + 1, preL + leftSize, in, inL, inIndex - 1, inPos);
    root.right = build(pre, preL + leftSize + 1, preR, in, inIndex + 1, inR, inPos);
    return root;
}
```

Tip: index maps (`inPos`) speed lookups and avoid repeated scans.

# 9) Traversal with carrying state (e.g., build path list, root->leaf numbers)

Base: `null` -> return empty list or do nothing.  Use a list passed by reference or return a list.

```java
void dfs(TreeNode node, List<Integer> path, List<List<Integer>> out) {
    if (node == null) return;
    path.add(node.val);
    if (isLeaf(node)) out.add(new ArrayList<>(path));
    else {
        dfs(node.left, path, out);
        dfs(node.right, path, out);
    }
    path.remove(path.size() - 1); // backtrack
}
```

Remember to backtrack (`remove`) after visiting children.

# 10) Constraint propagation (e.g., validate BST with min/max)

Base: `null -> true`
Pattern: pass down constraints (min/max)

```java
boolean validBST(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
}
// call with: validBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

Tip: use `long` to avoid edge issues with `Integer.MIN_VALUE`/`MAX_VALUE`.

---

## Quick reference table (base returns)

* Count / Sum: `null -> 0`
* Max: `null -> Integer.MIN_VALUE`
* Min: `null -> Integer.MAX_VALUE`
* Existence boolean: `null -> false` (unless empty tree should be `true`)
* Contribution-to-parent for path problems: `null -> 0` (often used with `Math.max(0, ...)`)
* DP pair: `null -> {0,0}` or appropriate neutral pair
* Structural build: `invalid indices -> null`
* Constraint checks: `null -> true`

---

## General tips (avoid common errors)

1. **Decide the return meaning early**: what does the recursive call return to its parent? (count, sum, best contribution, boolean, pair)
2. **Pick correct base value**: e.g. for max use `Integer.MIN_VALUE`, not 0.
3. **Global vs return**: use a global variable when answer is “across nodes” (diameter, max path sum). Otherwise prefer returning values (cleaner for interviews).
4. **Always handle negative values** in path-sum-like problems using `Math.max(0, childContribution)` if negative should be ignored.
5. **Backtrack state** when you carry mutable state (lists, maps, counters) — restore after recursive calls.
6. **Memoize where overlapping subproblems exist** (e.g., subtree-based choices on arbitrary trees use map from node to result).
7. **Use pairs/arrays** to return multiple pieces of info from a single dfs (avoid many globals).
8. **Test leaf cases explicitly** if problem depends on leaf behavior.

---
Excellent question 🚀 — you’ve zoomed into the **core taxonomy of tree problems**.
In fact, almost every binary tree / n-ary tree problem we see in interviews is a permutation of **two axes**:

---

## 🔑 Two Fundamental Axes

1. **What we are measuring over the tree**

    * **Structure / edges** (lengths, paths, diameter, height, depth, distances).
    * **Values on nodes** (sums, counts, min/max values, optimal selections).

2. **How we aggregate**

    * **Local aggregation** → combine children values (sum, max, min).
    * **Global optimization** → keep best across all nodes (max path, diameter).
    * **Decision** → return boolean/existence.
    * **Counting** → number of ways/paths/nodes.
    * **Choice/DP** → take vs skip, min/max optimization with constraints.

---

## 🎯 Categories of Tree Problems

If we cross these two axes, we can systematically list the **main categories**.

---

### **A. Edge/Structure-based Problems**

Work on **distances, lengths, levels, connectivity**.

1. **Basic length/height**

    * Max depth, Min depth, Height of tree.
    * Base: `null -> 0`, Return: `1 + max(left, right)`.

2. **Path length / diameter**

    * Diameter of tree, Longest Zigzag.
    * Global max updated, return height to parent.

3. **Distance / k-related**

    * Distance between two nodes, Nodes at distance K.
    * BFS/DFS hybrid often used.

4. **Counting structural properties**

    * Count edges, Count leaf nodes, Count nodes at level `k`.

---

### **B. Value-based Problems**

Work on **node values**, not structure.

1. **Sum / aggregate**

    * Sum of all nodes, Sum of subtree, Root-to-leaf sum.
    * Base: `null -> 0`, Return: `node.val + ...`.

2. **Max/Min value**

    * Max node value, Min node value, Max root-to-leaf sum.
    * Base: `null -> ±∞`.

3. **Path value optimization**

    * Max path sum, Min path sum, Target path sum.
    * Global tracking + return contribution.

4. **Counting nodes/paths by condition**

    * Count paths with sum, Count nodes satisfying condition.
    * Return counts up tree.

5. **Choice problems (Tree DP)**

    * House Robber III (take vs skip).
    * Maximum independent set in tree.
    * DP state returned per node.

---

### **C. Boolean / Existence Problems**

Questions where recursion returns **true/false**.

* Symmetric tree, Identical trees, Subtree of another tree.
* Path with given sum exists.
* Validate BST.

---

### **D. Constructive / Transformational Problems**

Recursion **builds or transforms tree**.

* Build tree from inorder & preorder.
* Flatten binary tree to linked list.
* Serialize/deserialize tree.
* Mirror tree.

---

### **E. Traversal / Enumeration Problems**

Focus on **visiting order** or **outputting sequences**.

* Preorder, Inorder, Postorder.
* Boundary traversal, Vertical order, Zigzag level order.
* Morris traversal (without stack/recursion).

---

### **F. Constraint-propagation Problems**

Carry **extra parameters** top-down.

* Validate BST (min/max constraints).
* Root-to-leaf number (carry number down).
* Path sum with prefix.

---

### **G. Combinatorial/Counting Substructures**

Count possible trees or subtrees.

* Count unique BSTs (Catalan).
* Count full binary trees with N nodes.
* Number of subtrees with given sum.

---

## 🧩 Meta-View (like DP)

If we abstract, tree recursion/DP problems usually fall into **5 meta categories**:

1. **Maximize/Minimize** → height, max sum, min path, robbing nodes.
2. **Count** → count nodes, paths, ways to build trees.
3. **Boolean decision** → existence, validity, symmetry.
4. **Constructive** → build/rebuild/transform trees.
5. **Traversal** → order/sequence enumeration.

And each meta category is applied on either:

* **structure (edges/lengths)**, or
* **values (sums, counts, selections)**.

That’s why we see the same "recursion skeletons" reused.

---

✅ **Final Answer (taxonomy)**
So, the total **types of tree problems** reduce to:

* **On Structure (edges/lengths)** → height, depth, diameter, distance, count levels.
* **On Values (node values)** → sum, max, min, path-sum, subtree values.
* **Boolean checks** → existence/validity.
* **Counting combinatorial** → number of paths/trees/nodes satisfying condition.
* **Choice/DP** → optimal selection with constraints.
* **Constructive/Transform** → build or change tree.
* **Traversal/Enumeration** → output order or lists.
* **Constraint Propagation** → min/max ranges, prefix sums, path constraints.


Nice — you’re thinking exactly like an interviewer wants. Below I’ll give **compact, generalised Java templates** for the common recursion categories you described. Each template shows:

* the **base case** (what to return when `node == null`),
* the **recursive step** (how to combine child results), and
* a short **note** on common pitfalls.

Use these as quick interview-ready patterns.

# 1) Count nodes (or count condition matches)

Base: `null -> 0`
Pattern: `1 + left + right` (or `cond ? 1 : 0`)

```java
int count(TreeNode node) {
    if (node == null) return 0;                    // base
    int left = count(node.left);
    int right = count(node.right);
    return (condition(node) ? 1 : 0) + left + right;
}
```

Note: `condition(node)` could be `node.val % 2 == 0`, `isLeaf(node)`, etc.

# 2) Sum of subtree values

Base: `null -> 0`
Pattern: `node.val + left + right`

```java
int sum(TreeNode node) {
    if (node == null) return 0;
    int left = sum(node.left);
    int right = sum(node.right);
    return node.val + left + right;
}
```

Pitfall: watch for overflow if values are large — use `long` then.

# 3) Max / Min in subtree

Base: `null -> Integer.MIN_VALUE` (for max) or `Integer.MAX_VALUE` (for min)
Pattern: `Math.max(node.val, Math.max(left, right))`

```java
int maxVal(TreeNode node) {
    if (node == null) return Integer.MIN_VALUE;    // base for max
    int left = maxVal(node.left);
    int right = maxVal(node.right);
    return Math.max(node.val, Math.max(left, right));
}
```

Note: if all values can be negative, `Integer.MIN_VALUE` is correct for base. For min, swap accordingly.

# 4) Global path-based problems (e.g., diameter, max path sum)

Base: `null -> 0` for the *contribution to parent* (often)
Pattern: compute child contributions, update global, return best contribution upwards.

```java
int global; // set appropriately, e.g., Integer.MIN_VALUE for sums

int dfs(TreeNode node) {
    if (node == null) return 0;                  // contribution to parent
    int left = Math.max(0, dfs(node.left));      // drop negative contributions
    int right = Math.max(0, dfs(node.right));
    // update global answer using left and right
    global = Math.max(global, left + right + node.val); 
    // return contribution to parent
    return Math.max(left, right) + node.val;
}
```

Pitfall: use `Math.max(0, ...)` when a negative child should be ignored. Initialize `global` to `Integer.MIN_VALUE` for sums.

# 5) Existence / boolean problems (e.g., path-sum exists, symmetric)

Base: `null -> false` (or `true` depending on problem)
Pattern: combine booleans from children

```java
boolean exists(TreeNode node, int target) {
    if (node == null) return false; 
    if (isLeaf(node) && node.val == target) return true; // leaf check
    return exists(node.left, target - node.val) || exists(node.right, target - node.val);
}
```

Note: choose the base based on semantics (e.g., empty tree may or may not satisfy property).

# 6) Counting paths with sum (prefix-sum + map) — more advanced

Base: treat `null` as contributing nothing; we use a map of prefix sums.

```java
int countPaths(TreeNode root, int target) {
    Map<Integer,Integer> pref = new HashMap<>();
    pref.put(0, 1); // empty path
    return dfs(root, 0, target, pref);
}
int dfs(TreeNode node, int curr, int target, Map<Integer,Integer> pref) {
    if (node == null) return 0;
    curr += node.val;
    int res = pref.getOrDefault(curr - target, 0);
    pref.put(curr, pref.getOrDefault(curr, 0) + 1);
    res += dfs(node.left, curr, target, pref);
    res += dfs(node.right, curr, target, pref);
    pref.put(curr, pref.get(curr) - 1); // backtrack
    return res;
}
```

Tip: remember to backtrack the map counts after child calls.

# 7) DP with choices (take / skip) — e.g., House Robber III

Base: `null -> {0,0}` (or `{skip, take}`)
Pattern: return two values: best if we take this node, and best if we skip it.

```java
int[] dfs(TreeNode node) { // returns [skip, take]
    if (node == null) return new int[]{0, 0};
    int[] L = dfs(node.left);
    int[] R = dfs(node.right);
    int take = node.val + L[0] + R[0];   // take node => children must be skipped
    int skip = Math.max(L[0], L[1]) + Math.max(R[0], R[1]); // skip node => children can be take/skip
    return new int[]{skip, take};
}
```

Note: returning pair/array avoids global memo and makes DP clear.

# 8) Structural / construct tree (build from traversals)

Base: when index bounds cross, return `null`.
Pattern: pick root, build left and right with proper index ranges.

```java
TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer,Integer> inPos) {
    if (preL > preR || inL > inR) return null; // base
    int rootVal = pre[preL];
    int inIndex = inPos.get(rootVal);
    int leftSize = inIndex - inL;
    TreeNode root = new TreeNode(rootVal);
    root.left = build(pre, preL + 1, preL + leftSize, in, inL, inIndex - 1, inPos);
    root.right = build(pre, preL + leftSize + 1, preR, in, inIndex + 1, inR, inPos);
    return root;
}
```

Tip: index maps (`inPos`) speed lookups and avoid repeated scans.

# 9) Traversal with carrying state (e.g., build path list, root->leaf numbers)

Base: `null` -> return empty list or do nothing.  Use a list passed by reference or return a list.

```java
void dfs(TreeNode node, List<Integer> path, List<List<Integer>> out) {
    if (node == null) return;
    path.add(node.val);
    if (isLeaf(node)) out.add(new ArrayList<>(path));
    else {
        dfs(node.left, path, out);
        dfs(node.right, path, out);
    }
    path.remove(path.size() - 1); // backtrack
}
```

Remember to backtrack (`remove`) after visiting children.

# 10) Constraint propagation (e.g., validate BST with min/max)

Base: `null -> true`
Pattern: pass down constraints (min/max)

```java
boolean validBST(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
}
// call with: validBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

Tip: use `long` to avoid edge issues with `Integer.MIN_VALUE`/`MAX_VALUE`.

---

## Quick reference table (base returns)

* Count / Sum: `null -> 0`
* Max: `null -> Integer.MIN_VALUE`
* Min: `null -> Integer.MAX_VALUE`
* Existence boolean: `null -> false` (unless empty tree should be `true`)
* Contribution-to-parent for path problems: `null -> 0` (often used with `Math.max(0, ...)`)
* DP pair: `null -> {0,0}` or appropriate neutral pair
* Structural build: `invalid indices -> null`
* Constraint checks: `null -> true`

---

## General tips (avoid common errors)

1. **Decide the return meaning early**: what does the recursive call return to its parent? (count, sum, best contribution, boolean, pair)
2. **Pick correct base value**: e.g. for max use `Integer.MIN_VALUE`, not 0.
3. **Global vs return**: use a global variable when answer is “across nodes” (diameter, max path sum). Otherwise prefer returning values (cleaner for interviews).
4. **Always handle negative values** in path-sum-like problems using `Math.max(0, childContribution)` if negative should be ignored.
5. **Backtrack state** when you carry mutable state (lists, maps, counters) — restore after recursive calls.
6. **Memoize where overlapping subproblems exist** (e.g., subtree-based choices on arbitrary trees use map from node to result).
7. **Use pairs/arrays** to return multiple pieces of info from a single dfs (avoid many globals).
8. **Test leaf cases explicitly** if problem depends on leaf behavior.

Excellent question 🚀 — you’ve zoomed into the **core taxonomy of tree problems**.
In fact, almost every binary tree / n-ary tree problem we see in interviews is a permutation of **two axes**:

---

## 🔑 Two Fundamental Axes

1. **What we are measuring over the tree**

    * **Structure / edges** (lengths, paths, diameter, height, depth, distances).
    * **Values on nodes** (sums, counts, min/max values, optimal selections).

2. **How we aggregate**

    * **Local aggregation** → combine children values (sum, max, min).
    * **Global optimization** → keep best across all nodes (max path, diameter).
    * **Decision** → return boolean/existence.
    * **Counting** → number of ways/paths/nodes.
    * **Choice/DP** → take vs skip, min/max optimization with constraints.

---

## 🎯 Categories of Tree Problems

If we cross these two axes, we can systematically list the **main categories**.

---

### **A. Edge/Structure-based Problems**

Work on **distances, lengths, levels, connectivity**.

1. **Basic length/height**

    * Max depth, Min depth, Height of tree.
    * Base: `null -> 0`, Return: `1 + max(left, right)`.

2. **Path length / diameter**

    * Diameter of tree, Longest Zigzag.
    * Global max updated, return height to parent.

3. **Distance / k-related**

    * Distance between two nodes, Nodes at distance K.
    * BFS/DFS hybrid often used.

4. **Counting structural properties**

    * Count edges, Count leaf nodes, Count nodes at level `k`.

---

### **B. Value-based Problems**

Work on **node values**, not structure.

1. **Sum / aggregate**

    * Sum of all nodes, Sum of subtree, Root-to-leaf sum.
    * Base: `null -> 0`, Return: `node.val + ...`.

2. **Max/Min value**

    * Max node value, Min node value, Max root-to-leaf sum.
    * Base: `null -> ±∞`.

3. **Path value optimization**

    * Max path sum, Min path sum, Target path sum.
    * Global tracking + return contribution.

4. **Counting nodes/paths by condition**

    * Count paths with sum, Count nodes satisfying condition.
    * Return counts up tree.

5. **Choice problems (Tree DP)**

    * House Robber III (take vs skip).
    * Maximum independent set in tree.
    * DP state returned per node.

---

### **C. Boolean / Existence Problems**

Questions where recursion returns **true/false**.

* Symmetric tree, Identical trees, Subtree of another tree.
* Path with given sum exists.
* Validate BST.

---

### **D. Constructive / Transformational Problems**

Recursion **builds or transforms tree**.

* Build tree from inorder & preorder.
* Flatten binary tree to linked list.
* Serialize/deserialize tree.
* Mirror tree.

---

### **E. Traversal / Enumeration Problems**

Focus on **visiting order** or **outputting sequences**.

* Preorder, Inorder, Postorder.
* Boundary traversal, Vertical order, Zigzag level order.
* Morris traversal (without stack/recursion).

---

### **F. Constraint-propagation Problems**

Carry **extra parameters** top-down.

* Validate BST (min/max constraints).
* Root-to-leaf number (carry number down).
* Path sum with prefix.

---

### **G. Combinatorial/Counting Substructures**

Count possible trees or subtrees.

* Count unique BSTs (Catalan).
* Count full binary trees with N nodes.
* Number of subtrees with given sum.

---

## 🧩 Meta-View (like DP)

If we abstract, tree recursion/DP problems usually fall into **5 meta categories**:

1. **Maximize/Minimize** → height, max sum, min path, robbing nodes.
2. **Count** → count nodes, paths, ways to build trees.
3. **Boolean decision** → existence, validity, symmetry.
4. **Constructive** → build/rebuild/transform trees.
5. **Traversal** → order/sequence enumeration.

And each meta category is applied on either:

* **structure (edges/lengths)**, or
* **values (sums, counts, selections)**.

That’s why we see the same "recursion skeletons" reused.

---

✅ **Final Answer (taxonomy)**
So, the total **types of tree problems** reduce to:

* **On Structure (edges/lengths)** → height, depth, diameter, distance, count levels.
* **On Values (node values)** → sum, max, min, path-sum, subtree values.
* **Boolean checks** → existence/validity.
* **Counting combinatorial** → number of paths/trees/nodes satisfying condition.
* **Choice/DP** → optimal selection with constraints.
* **Constructive/Transform** → build or change tree.
* **Traversal/Enumeration** → output order or lists.
* **Constraint Propagation** → min/max ranges, prefix sums, path constraints.

