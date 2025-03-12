///*
//package Programming_constructs.Tree;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class TreeNodes{
//    int val;
//    TreeNodes left;
//     TreeNodes right;
//    // Function to create a new binary tree node having a given key
//    public TreeNodes(int key)
//    {
//        val = key;
//        left = right = null;
//    }
//
//}
//public class VerticalOrderTraversal {
//    // create a tree haveing its node
//
//
//    // so node with level order we need a pair of nodes and integer using constructor
//    public static class TreeNodeWithOrderValuePair{
//        TreeNodes node;
//        int postion;
//        TreeNodeWithOrderValuePair(TreeNodes node, int postion){
//            this.node = node;
//            this.postion = postion;
//        }
//    }
//
//
//    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNodes A) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//
//        // edge cases
//        if (A == null) return result;
//
//        //create a hashMap
//        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
//
//        //create queue
//        Queue<TreeNodeWithOrderValuePair> q = new LinkedList<>();
//
//        // add the first node with level order value zero
//
//
//        // now traverse the whole tree from root to level by level and put eye
//        // above and let see which nodes are visible
//
//        while (!q.isEmpty()) {
//            // take the first node-value pair pop out from the q and then store in temp valiable
//            TreeNodeWithOrderValuePair tempNodeLevelPair = q.poll();
//
//            // take out the node from the above temp node-level variable
//            TreeNodes tempNode = tempNodeLevelPair.node;
//
//            // take out the position from the above node-level variable
//            int currPos = tempNodeLevelPair.postion;
//
//            //If the specified key is not already associated with
//            // a value (or is mapped to null), attempts to compute its value using
//            // the given mapping function and enters it into this map unless null.
////            map.computeIfAbsent(key, k -> new Value(f(k)));
//            hm.computeIfAbsent(currPos,
//                    k ->
//                        new ArrayList<>().add(tempNode.val));
//
//            // now iterate over each node and invrease horizontal distance
//            if (tempNode.left != null) {
//                q.add(new TreeNodeWithOrderValuePair(tempNode.left, currPos - 1));
//            }
//            if (tempNode.right != null) {
//                q.add(new TreeNodeWithOrderValuePair(tempNode.right, currPos + 1));
//            }
//
//        }
//        int maxPos =0 , minPos =0;
//        // find the depth level or vetical distance
//        for(int key: hm.keySet()){
//
//            maxPos = Math.max(maxPos,key);
//            minPos = Math.min(minPos,key);
//        }
//
//        // now check if level order is lower than the
//
//        while(minPos <= maxPos) {
//            result.add(hm.get(minPos++));
//        }
//        return result;
//
//    }
//
//        public static void main (String[]args){
//
////
//            TreeNodes root = new TreeNodes(1);
//            root.left = new TreeNodes(2);
//            root.right = new TreeNodes(3);
//        root.left.left = new TreeNodes(4);
//        root.right.left = new TreeNodes(5);
//        root.right.right = new TreeNodes(6);
//        root.right.left.left = new TreeNodes(7);
//        root.right.left.right = new TreeNodes(8);
//
//        ArrayList<ArrayList<Integer>> result = verticalOrderTraversal(root);
////        for(int i =0;i<result.size();i++){
////            System.out.print(result.get(i)+ " ");
////        }
//
//
//            System.out.println(result);
//        }
//    }
//
//
//*/
