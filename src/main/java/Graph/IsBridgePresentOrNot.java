package Graph;

import java.util.ArrayList;

import static Graph.IsBridgePresentOrNot.Graphs.*;

public class IsBridgePresentOrNot {
    static ArrayList<ArrayList<Integer>> adjcencyList;

    public static void main(String[] args) {
        int noOfVertices = 5;
        ArrayList<ArrayList<Integer>> adjcencyList = new ArrayList<>();

        for (int i = 0; i < noOfVertices; i++)
            adjcencyList.add(new ArrayList<>());
        // Adding edges one by one
        addEdge(adjcencyList, 0, 1);
        addEdge(adjcencyList, 0, 4);
        addEdge(adjcencyList, 1, 2);
        addEdge(adjcencyList, 1, 3);
        addEdge(adjcencyList, 1, 4);
        addEdge(adjcencyList, 2, 3);
        addEdge(adjcencyList, 3, 4);

        // iterate over each node and remove each edge and dfs apply and then add the edges back to it
        for (int i = 0; i < noOfVertices; i++) {
            for (int j = i + 1; j < noOfVertices; j++) {
                // remove edge
                removeEdge(adjcencyList, i, j);
                // now call the dfs to check the conectividyt
                isConnected();
                // add back the edge again to the graph
                addEdge(adjcencyList, i, j);

            }

        }
    }

    // Two way
    //  brute force
//       1.remove each edge and check  if graph is connected or not and then again add the edge
    static class Graphs {
        static int noOfVertices;
        // list of adjcencyListancy
        /* public Graphs(int noOfVertices) {
            this.noOfVertices = noOfVertices;
            adjcencyListcencyList = new ArrayList<>();
            for (int i = 0; i < noOfVertices; i++) {
                adjcencyListcencyList.add(new ArrayList<>());
            }
        }*/

        static void addEdge(ArrayList<ArrayList<Integer>> adjcencyList, int u, int v) {
            adjcencyList.get(u).add(v);
            adjcencyList.get(v).add(u);

        }

        static void removeEdge(ArrayList<ArrayList<Integer>> adjcencyList, int src, int dest) {
            adjcencyList.get(src).remove(dest);
            adjcencyList.get(dest).remove(src);

        }

        public static boolean isConnected() {
            boolean[] visited = new boolean[noOfVertices];
            dfs(0, visited);
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
            return true;

        }

        private static void dfs(int i, boolean[] visited) {
            visited[i] = true;
            for (int u : adjcencyList.get(i)) {
                if (!visited[u]) {
                    dfs(i, visited);
                }
            }
        }
    }


}


