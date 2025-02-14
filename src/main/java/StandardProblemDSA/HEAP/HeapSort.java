package StandardProblemDSA.HEAP;

public class HeapSort {

    // Heapify function to maintain the Max Heap property
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize the largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if the left child exists and is greater than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if the right child exists and is greater than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != i) {
            // Swap root and the largest
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to sort an array using Heap Sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (largest) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility function to print an array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function to test the Heap Sort algorithm
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
