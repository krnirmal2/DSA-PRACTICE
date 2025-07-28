package StandardProblemDSA.VIII_TREE.BST.PARENT_MAP;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.*;

/*863. All Nodes Distance K in Binary Tree
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
        Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
Constraints:
The number of nodes in the tree is in the range [1, 500].
        0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
        0 <= k <= 1000

Approach:
    1. Build a parent map using BFS to record each node’s parent (since TreeNode has only left/right references).
    2. Perform BFS starting from the target node.
    3. Maintain a visited map to avoid revisiting nodes.
    4. Traverse level by level; once the current level == k, all nodes currently in the queue are at distance k.
    5. Collect these nodes’ values into the result list.

Pattern:
    - BFS traversal + parent pointer tracking.
    - Similar to "burning tree" or "nodes at distance K" problems.

Similar LeetCode Problems:
    - 863. All Nodes Distance K in Binary Tree
    - "Burning Tree" variant (interview favorite)

Time Complexity:
    - O(n): Each node is visited once while building the parent map and once during BFS.
    - Building parent map: O(n)
    - BFS traversal: O(n)

Space Complexity:
    - O(n):
        - Parent map stores one entry per node.
        - Visited map stores up to n nodes.
        - BFS queue holds at most O(n) nodes.

Follow-up Questions:
    - Can we do this without extra parent map? → Yes, by performing DFS and passing parent references.
    - How to optimize if there are multiple queries on the same tree? → Precompute all parent links once and reuse.


        */
public class NodeATDistanceKinUpAndDown {

  // Definition for a binary tree node.
  // Approach
  // 1. we will create parent map using BFS each node because from parent need to go all nodes
  // 2. create a visited Map to check if the node has been visited or not
  // 3. now use BFS and go for each node from the target node and then put them
  // in queue and also mark as visited in visited map
  // 4. when we reached dist = k-1 then we are actully found all the node which are already
  // 5. present in the queue , those element are the distance k
  // 6. iterate over teh queue till it is not empty , add to the result list
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // parent map
    Map<TreeNode, TreeNode> map = new HashMap<>();
    parentMap(root, map);

    // now we have the target node
    Queue<TreeNode> q = new LinkedList<>();
    // need one map for vistited
    Map<TreeNode, Boolean> visited = new HashMap<>();
    // now we will use bfs and check the node distance k
    q.offer(target);
    int level = 0;
    visited.put(target, true);
    while (!q.isEmpty()) {
      int currLevelQueSize = q.size();

      if (level == k) break;
      level++;
      // we have to each traversal of the current  level which will
      // give size of the queue
      for (int i = 0; i < currLevelQueSize; i++) {
        TreeNode curr = q.poll();
        if (curr.left != null && !visited.containsKey(curr.left)) {
          q.add(curr.left);
          visited.put(curr.left, true);
        }
        if (curr.right != null && !visited.containsKey(curr.right)) {
          q.add(curr.right);
          visited.put(curr.right, true);
        }
        TreeNode parent = map.get(curr);
        if (parent != null && !visited.containsKey(parent)) {
          q.add(parent);
          visited.put(parent, true);
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!q.isEmpty()) {
      result.add(q.poll().val);
    }
    return result;
  }

  public void parentMap(TreeNode root, Map<TreeNode, TreeNode> map) {
    // use Bfs traversal
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      if (curr.left != null) {
        map.put(curr.left, curr);
        q.offer(curr.left);
      }
      if (curr.right != null) {
        map.put(curr.right, curr);
        q.offer(curr.right);
      }
    }
  }
}
