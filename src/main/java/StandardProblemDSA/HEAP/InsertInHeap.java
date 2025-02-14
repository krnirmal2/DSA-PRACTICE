package StandardProblemDSA.HEAP;

public class InsertInHeap {

    public static void main(String[] args) {
        int capacity = 100;
        int[] arr = new int[capacity];
        // initialise some value to the array of heap with heap property
        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 4;
        // int current size of the arrray
        int n = 5;
        // insert 15 to the leap or last of the array
        insetNode(arr, n, 15);
    }

    private static void insetNode(int[] arr, int n, int i) {
        // put the element at the end
        n = n + 1; //increase the capacity
        arr[n - 1] = 15;
        // now after this there is violation in heap property of min heap
        // so we need to apply heapify on this element till the root node
        // node to root heapify
        heapifyBottomUpApproach(arr, n, n - 1);
    }

    private static void heapifyBottomUpApproach(int[] arr, int capacity, int elementAti) {
        // we need to check if the element at i is less or greater than its parent
        // left = 2*parent+1  => parent = (left -1)/2
        int parent = (elementAti - 1) / 2;
        // we got the elemeent parent by the formula ChileElementIndexAti - 1 and divide the result by 2
        if (parent >= 0) {
            if (arr[elementAti] > arr[parent]) {
                // we will recursivly call the function bottom to up with parent till we are not satisfy heap property
                // swaping by temp variable
                int temp = arr[elementAti];
                arr[elementAti] = arr[parent];
                arr[parent] = temp;
                //recursisvly apply heapify
                heapifyBottomUpApproach(arr, capacity, parent);

            }
        }
    }
}
