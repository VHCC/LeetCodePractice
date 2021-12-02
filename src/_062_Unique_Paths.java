public class _062_Unique_Paths {
    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        System.out.println(uniquePaths2(m, n));
    }

    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        dp[1][1] = Integer.MIN_VALUE;
        System.out.println(dp.length + " x " + dp[0].length);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int topSum = 0;
                int leftSum = 0;
                if (dp[row][col] == Integer.MIN_VALUE) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row == 0) {
                    topSum = 0;
                } else {
                    topSum = dp[row - 1][col];
                }
                if (col == 0) {
                    leftSum = 0;
                } else {
                    leftSum = dp[row][col - 1];
                }
                System.out.print("B, dp[" + row + "][" + col + "]:> " + dp[row][col] + ", After:> ");
                dp[row][col] += (topSum + leftSum);
                System.out.println("dp[" + row + "][" + col + "]:> " + dp[row][col]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        System.out.println(dp.length + " x " + dp[0].length);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int topSum = 0;
                int leftSum = 0;
                if (col == 0) {
                    topSum = 0;
                } else {
                    topSum = dp[row][col - 1];
                }
                if (row == 0) {
                    leftSum = 0;
                } else {
                    leftSum = dp[row - 1][col];
                }
                System.out.println("dp[" + row + "][" + col + "]:> " + dp[row][col]);
                dp[row][col] += (topSum + leftSum);
                System.out.println("dp[row][col]:> " + dp[row][col]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
