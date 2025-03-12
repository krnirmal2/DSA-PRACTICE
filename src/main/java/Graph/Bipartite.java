package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    //pass the adjancy list and no. of vertices
    public static void isBipartite(ArrayList<ArrayList<Integer>> vertexes, int noOfvertex) {
        // create some datastructure for colouring and traversing of nodes
        // coloured with -1 means Blue
        int[] col = new int[noOfvertex];
        Arrays.fill(col, -1);

        //create a queue with vertex with its color
        Queue<Pairs> queue = new LinkedList<>();

        // initialise the first vertex with Red color ==0
        for (int i = 0; i < noOfvertex; i++) { // loop if the graph is not connected
            if (col[i] == -1) { // if the vertx is not colour
                // color the vertex with red
                int currentVertex = col[i];
                int currentVertexColor = 0;
                queue.add(new Pairs(currentVertex, currentVertexColor));

                // put the first color as red =0
                col[i] = 0;
                while (!queue.isEmpty()) {// queue is not empty till then we will continue
                    Pairs p = queue.poll();
                    int parentVertx = p.vertex;
                    int parentColor = p.color;
                    // now take the current node and iterate over its neighbour
                    for (int j : vertexes.get(parentVertx)) {
                        if (col[j] == parentColor) {
                        }
                        // if uncoloured then color them wtih blue
                        col[j] = (parentColor == 1) ? 0 : 1;
                        queue.add(new Pairs(j, col[j]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //create the main function with graphancancy list of vertex
        int noOfvertex = 5;
        // loop them in a 2d array
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // create the blank graphancy list of each vertex
        for (int i = 0; i < noOfvertex; i++) {
            graph.add(new ArrayList<>());
        }

        //instantaite them
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(0);
        graph.get(3).add(2);


    }

    // create a pair of class
    static class Pairs {
        int vertex;
        int color;

        public Pairs(int vertex, int color) {
            this.vertex = vertex;
            this.color = color;
        }
    }
}
