public class _064_Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(input));
    }


    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                int leftSum = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                int topSum = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(leftSum, topSum);
                System.out.println("i:> " + i + ", j:> " + j +
                        ", leftSum:> " + leftSum + ", topSum:> " + topSum + ", grid[i][j]:> " + grid[i][j]);
            }
        }
        return grid[row - 1][col - 1];
    }


    public static int minPathSumGreat(int[][] grid) {
        if (grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int leftSum = (j > 0) ? grid[i][j - 1] : Integer.MAX_VALUE;
                int topSum = (i > 0) ? grid[i - 1][j] : Integer.MAX_VALUE;
                if (i == 0 && j == 0) continue;
                grid[i][j] += Math.min(leftSum, topSum);
                System.out.println("i:> " + i + ", j:> " + j + ", leftSum:> " + leftSum + ", topSum:> " + topSum + ", grid[i][j]:> " + grid[i][j]);
            }
        }
        return grid[row - 1][col - 1];
    }
}
