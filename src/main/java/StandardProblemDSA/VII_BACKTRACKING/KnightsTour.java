package StandardProblemDSA.VII_BACKTRACKING;

public class KnightsTour {
  /*Problem Statement:
  Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited.
          Example:
  Input :
  N = 8
  Output:
          0  59  38  33  30  17   8  63
          37  34  31  60   9  62  29  16
          58   1  36  39  32  27  18   7
          35  48  41  26  61  10  15  28
          42  57   2  49  40  23   6  19
          47  50  45  54  25  20  11  14
          56  43  52   3  22  13  24   5
          51  46  55  44  53   4  21  12

  Time Complexity :
There are N2 Cells and for each, we have a maximum of 8 possible moves to choose from, so the worst running time is O(8N^2).
Auxiliary Space: O(N2)
Important Note:
No order of the xMove, yMove is wrong, but they will affect the running time of the algorithm drastically. For example, think of the case where the 8th choice of the move is the correct one, and before that our code ran 7 different wrong paths. It’s always a good idea a have a heuristic than to try backtracking randomly. Like, in this case, we know the next step would probably be in the south or east direction, then checking the paths which lead their first is a better strategy

 Warnsdorff’s algorithm for Knight’s tour problem
          */
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
    for (int i = 0; i < 8; i++) { // with below two move next possible move
      int nextX = x + moveX[i]; // go to next x
      int nextY = y + moveY[i]; // go to next y

      if (isSafe(nextX, nextY, board)) {
        board[nextX][nextY] = moveCount;

        // Recursive call to solveKTUtil for the next move
        if (solveKTUtil(nextX, nextY, moveCount + 1, board)) return true;

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
