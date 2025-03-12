package StandardProblemDSA.BACKTRACKING;

public class KnightsTour {

    static int N = 8;

    // These arrays represent the possible moves of a knight
    static int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    // Method to check if (x, y) is within the chessboard boundaries and unvisited
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // Recursive utility function to solve the Knight's Tour problem
    static boolean solveKTUtil(int x, int y, int moveCount, int[][] board) {
        if (moveCount == N * N) // All cells are visited
            return true;

        // Try all 8 possible moves
        for (int i = 0; i < 8; i++) {// with below two move next possible move
            int nextX = x + moveX[i];// go to next x
            int nextY = y + moveY[i];// go to next y

            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;

                // Recursive call to solveKTUtil for the next move
                if (solveKTUtil(nextX, nextY, moveCount + 1, board))
                    return true;

                // Backtracking
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    // Solves the Knight's Tour problem using Backtracking
    public static void solveKT() {
        int[][] board = new int[N][N];

        // Initialize board with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Starting position of the knight
        int startX = 0, startY = 0;
        board[startX][startY] = 0;

        // Call the utility function to solve the Knight's Tour problem
        if (!solveKTUtil(startX, startY, 1, board)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(board);
        }
    }

    // Function to print the solution
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKT();
    }
}
