public class _200_Number_of_Islands {

    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1', '1'},
//                {'0', '1'},
//        };

        char[][] grid = new char[][]{
                {'1', '0', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
        };


        System.out.println(numIslands(grid));
    }

    static public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCounts = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                islandCounts += findIsland(row, col, grid, visited);
            }
        }

        return islandCounts;
    }

    static public int findIsland(int row, int col, char[][] grid, boolean[][] visited) {
        System.out.println("grid[" + row + "][" + col + "]:> " + grid[row][col]);
        if (grid[row][col] == '0' || visited[row][col]) {
            return 0;
        } else {
            visited[row][col] = true;
            // top
            if (row != 0) {
                findIsland(row - 1, col, grid, visited);
            }
            // left
            if (col != 0) {
                findIsland(row, col - 1, grid, visited);
            }
            // down
            if (row != (grid.length - 1)) {
                findIsland(row + 1, col, grid, visited);
            }
            // right
            if (col != (grid[0].length - 1)) {
                findIsland(row, col + 1, grid, visited);
            }
        }
        return 1;
    }
}
