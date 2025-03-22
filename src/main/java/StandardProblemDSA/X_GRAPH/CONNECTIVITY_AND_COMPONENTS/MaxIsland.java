package StandardProblemDSA.X_GRAPH.CONNECTIVITY_AND_COMPONENTS;

public class MaxIsland {

    public int maxAreaOfIsland(int[][] grid) {
        // Find the size of the grid
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int max = 0; // Initialize max area as 0

        // Iterate over each cell in the grid
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                // If the cell is land and not visited, explore the island
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, visited, r, c); // Find the area of this island
                    max = Math.max(max, area); // Update the max area
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int[] dr = {-1, 1, 0, 0}; // Row movement
        int[] dc = {0, 0, -1, 1}; // Column movement
        int area = 1; // Initialize the current area as 1 (current cell)

        visited[r][c] = true;

        // Explore all four directions
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // Check bounds and if the neighbor is land and not visited
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == 1 && !visited[nr][nc]) {
                area += dfs(grid, visited, nr, nc); // Recur for the neighbor and accumulate area
            }
        }
        return area;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        MaxIsland solution = new MaxIsland();

        // Example grid
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0}
        };

        // Call the maxAreaOfIsland function and print the result
        System.out.println("Max area of an island: " + solution.maxAreaOfIsland(grid));
    }
}
