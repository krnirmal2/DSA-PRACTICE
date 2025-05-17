package StandardProblemDSA.X_GRAPH.VI_DISJOIN_SET;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
/*oblem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
(Sometimes it may be asked to find the MST as well, where in the MST the edge-informations will be stored in the form {u, v}(u = starting node, v = ending node).)

Example 1:

Input Format:
V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}


Result: 16
Explanation:
The minimum spanning tree for the given graph is drawn below:
MST = {(0, 1), (0, 3), (1, 2), (1, 4)}


Example 2:

Input Format:
V = 5, edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}


Result: 5
Explanation:
The minimum spanning tree is drawn below:

MST = {(0, 2), (1, 2), (2, 3), (3, 4)}*/

    static class Pair {
        int v;
        int wt;
        Pair(int v, int wt){
            this.v  = v;
            this.wt = wt;
        }
    }

    // lets say the spanningtree give that is
    static int spanningTree(int V, int E, int edges[][]){
        // store the eges and graph to the Adj list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0 ;i<V;i++){
            adj.add(new ArrayList<>());
        }
        // iterate over the edge and collect the vertices and nodes
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new Pair (v, wt));
            adj.get(v).add( new Pair(u, wt));

        }
        // now add all this so now use priority queue and bfs to hadle the prims total mst
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt -b.wt);// sort by wt

        // inset the first element v in the node
        pq.add(new Pair(0,0));

        // track for the visited  node
        int [] vis = new int[V];
        int sum =0;
        while(!pq.isEmpty()){
            // take the first node
            Pair node = pq.poll();
            int v=node.v;
            int wt=node.wt;
            if(vis[v]==1)
                continue;
            // now add the summ
            sum +=wt;
            // mark that node as visited
            vis[node.v] =1;
            // iterate over the adja
            for(Pair neighbor :adj.get(v)){
                if(vis[neighbor.v]==0){
                    pq.add(new Pair(neighbor.v, neighbor.wt));
                }

            }


        }
return sum;



    }
    public static void main (String[] args) {
        int graph[][] = new int[][] {{0,1,5},
                {1,2,3},
                {0,2,1}};

        // Function call
        System.out.println(spanningTree(3,3,graph));
    }
}
