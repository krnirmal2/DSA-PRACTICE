package StandardProblemDSA.HEAP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestUsingMinHeap {

    public static List<Integer> kLargest(int[] arr, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Traverse the rest of the array
        for (int i = k; i < arr.length; i++) {

            // If current element is larger than
            // the smallest in heap
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Extract elements from the heap
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        // Reverse the list for descending order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        List<Integer> res = kLargest(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}