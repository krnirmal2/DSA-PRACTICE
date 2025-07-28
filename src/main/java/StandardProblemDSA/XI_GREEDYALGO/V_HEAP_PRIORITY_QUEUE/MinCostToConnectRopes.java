package StandardProblemDSA.XI_GREEDYALGO.V_HEAP_PRIORITY_QUEUE;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    /*Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
        The cost to connect two ropes is the sum of their lengths.
    Examples:
    Input: arr[] = [4, 3, 2, 6]
    Output: 29
    Explanation: We can connect the ropes in following ways.
    1) First connect ropes of lengths 2 and 3. Which makes the array [4, 5, 6]. Cost of this operation 2 + 3 = 5.
    2) Now connect ropes of lengths 4 and 5. Which makes the array [9, 6]. Cost of this operation 4 + 5 = 9.
    3) Finally connect the two ropes and all ropes have connected. Cost of this operation 9 + 6 =15. Total cost is 5 + 9 + 15 = 29.
    This is the optimized cost for connecting ropes.
    Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first
    (we get three rope of 3, 2 and 10), then connect 10 and 3 (we get two rope of 13 and 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
    Connect-n-ropes-with-minimum-cost

    Input: arr[] = [10]
    Output: 0
    Explanation: Since there is only one rope, no connections are needed, so the cost is 0.*/
    public static int minCost(int[] arr) {
        if (arr.length <= 1) return 0;

        // step 1 : create a minheap and put the sort array element into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer element : arr) {
            pq.add(element);
        }

        // till pq.size() doesn't equal to 1 continue to add
        int mincost = 0;
        while (pq.size() > 1) {
            // step 2 : take above two element and add them and return after sum up the value
            int firstElement = pq.poll();
            int secondElement = pq.poll();

            int sum = firstElement + secondElement;
            mincost += sum;
            pq.add(sum);
        }
        return mincost;
    }
}
