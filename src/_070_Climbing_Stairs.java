public class _070_Climbing_Stairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    static int[] steps = new int[]{1, 2};

    public static int climbStairs(int n) {
        n += 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int step : steps) {
                if (i >= step) { // 子問題
                    System.out.println("i:> " + i + ", step:> " + step);
                    System.out.println("dp[" + i + "]:> " + dp[i] + ", dp[" + (i - step) + "]:> " + dp[i - step]);
                    dp[i] += dp[i - step];
                }
            }
        }

        for (int a: dp) {
            System.out.println("a:> " + a);
        }

        return dp[n-1];
    }
}
