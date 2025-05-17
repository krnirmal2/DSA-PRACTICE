package StandardProblemDSA.VIII_TREE.BST.SERIALISE_DESERAILISE;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialise {
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) return "";
    // Approach
    // create a string and append each value as level order fashion using Queue
    // then and put comma or some delemiter and on null use some null or string key word
    Queue<TreeNode> queue = new LinkedList<>();

    // insert the first node
    queue.add(root);
    StringBuilder s = new StringBuilder();

    // iterate ove rthe whole element and create the string
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll(); // take the current node]

      if (node == null) {
        s.append("n");
        continue;
      }
      s.append(node.val);
      s.append("#");
      queue.add(node.left);
      queue.add(node.right);
    }
    return s.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    // now  we have the serialise string
    // now make it array using toArray and iterate
    // over each and create a tree using level order traversal
    // create a new node using the value and then attach this as
    // the left node of the parrent or current node that hasbeen polled
    if (data == "") return null;
    // first need to put the String data in to the sTring array
    String[] word = data.split("#");
    // create queue
    Queue<TreeNode> q = new LinkedList<>();

    // first need create the root from where we will start
    TreeNode root = new TreeNode(Integer.parseInt(word[0]));
    // also add the root node to queue
    q.add(root);
    // now iterate over the word array and deserialise eac
    // word
    // the node which have value need to put in the queue and create new node

    for (int s = 0; s < word.length; s++) {
      // start from the parrent node
      TreeNode curr = q.poll();
      if (!word[s].equals("n")) {
        // create a a node and put it is current left
        TreeNode left = new TreeNode(Integer.parseInt(word[s]));
        curr.left = left;

        // also add the left
        q.add(left);
      }
      // next elment is right node
      if (!word[++s].equals("n")) {
        // create a a node and put it is current left
        TreeNode right = new TreeNode(Integer.parseInt(word[s]));
        curr.right = right;

        // also add the left
        q.add(right);
      }
    }

    return root;
  }
}

  // Your Codec object will be instantiated and called as such:
  // Codec ser = new Codec();
  // Codec deser = new Codec();
  // TreeNode ans = deser.deserialize(ser.serialize(root));
