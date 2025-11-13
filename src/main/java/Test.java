public class Test {
  /*Abhisek Gupta
  16:15
  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
  write a function to check whether these edges make up a valid tree.
  Example 1:
  Input:
  n = 5
  edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

  Output:
  true
  Example 2:
  Input:
  n = 5
  edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

  Output:
  false
  Note:

  You can assume that no duplicate edges will appear in edges.
  Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear togethe
  Discussion with Nirmal Kumar- Backend( Recro)- Round 1*/

  // my approach
  //    valid tree :     1. the no edges should be n-1
  //                    2. there is no cycle in the tree
  //    public static  boolean validTree(List<List<Integer>> adj, int n){
  // edges dfs
  /*
          if(adj.isEmpty()) return false;
          // use dfs
          boolean [] visited = new boolean[];
          for( int i=0;i<adj.size();i++){
              visited[i]= 1;
              dfsUtil(adj.get(i).)
          }


      }
      private static boolean dfsUtil(List<List<Integer>> adj, boolean[] visted){
          if()
      }

      public static void main(String[] args) {
          List<List<Integer>> adjList = new ArrayList<>();
          // create adjacency list
          int n ;
          for(int i=0 ;i<n;i++){
  //            for(int j=0;j<n;j++){
                  adjList.add(new ArrayList<>()) ;
  //            }
          }

          //
  //        for(int[] edges: adjList){
  //            adjList.get(edges).set()
  //
  //
  //        }
  //        for()
          validTree(adjList,n);

      }*/
}
