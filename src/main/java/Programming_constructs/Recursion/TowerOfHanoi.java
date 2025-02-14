package Programming_constructs.Recursion;

public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: If there's only one disk, move it directly
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move top n-1 disks from source to auxiliary
        solveHanoi(n - 1, source, destination, auxiliary);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        System.out.println("Steps to solve Tower of Hanoi for " + n + " disks:");
        solveHanoi(n, 'A', 'B', 'C'); // A: Source, B: Auxiliary, C: Destination
    }
}

