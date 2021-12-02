public class _063_Unique_Paths_II {
    public static void main(String[] args) {

        int[][] obstacleGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        System.out.println(dp.length + " x " + dp[0].length);

        int sumTop = 0;
        int sumLeft = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.println("row:> " + row + ", col:> " + col);
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row == 0) { // 1st row on boarder
                    sumTop = 0;
                } else {
                    sumTop = dp[row - 1][col];
                }
                if (col == 0) { // 1st col on boarder
                    sumLeft = 0;
                } else {
                    sumLeft = dp[row][col - 1];
                }
                dp[row][col] += (sumLeft + sumTop);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
