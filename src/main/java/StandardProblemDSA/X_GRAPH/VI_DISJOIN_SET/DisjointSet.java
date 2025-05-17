package StandardProblemDSA.X_GRAPH.VI_DISJOIN_SET;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    // find two component, of the
    // check if the two vertex belongs to same component or not
    // find and parent using Rank or Size
    //Way 1 start implementing using Rank

    //initaitl conf
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        // initail configurataion
        for(int i=0;i<=n ;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // find utlimate parent of a node using path compression
    public  int findUparent(int node){
        // if already have the ultimate parent then retunrn
        if(node== parent.get(node)){
            return node;
        }
        // else do path compression by findeing ultimate parent by
        // recursion
        int ultimParent = findUparent(parent.get(node));

        // set all the node parent to the ulitmate parent
        parent.set(node,ultimParent);
        return parent.get(node);

    }

    // unioin of u to v
    void unionByRank(int u, int v){
        // find both ultimate parent
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);

        // belong to same component then retun
        if(ulp_u == ulp_v) return ;
        //if rank of u is lesser than rank v
        // means we join u to v by seting parent of u as v
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
        //
    }


    public void unionBySize(int u, int v) {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);
        if (ulp_u == ulp_v) return;
        //if size of u size is less thant v than attached u to v
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);// attached u to v
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // increase the size of the v as
        } else {
            parent.set(ulp_v, ulp_u);// else attached to u
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));// increase the size of u
        }
    }
    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUparent(3) == ds.findUparent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUparent(3) == ds.findUparent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
