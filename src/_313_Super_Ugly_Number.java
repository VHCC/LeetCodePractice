import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _313_Super_Ugly_Number {

    public static void main(String[] args) {
        int index = 7;
//        System.out.println("maxLength:> " + maxLength);
//        System.out.println("maxLength:> " + 1092889481);
        System.out.println(nthSuperUglyNumberGreat(index, primes));
    }


    public static int nthSuperUglyNumberGreat(int n, int[] primes) {

        int[] primesCounts = new int[primes.length];
        int[] dp = new int[n];

//        System.out.println("count:> " + primesCounts.length);
//        System.out.println("primes:> " + primes.length);
//        System.out.println("dp:> " + dp.length);
//        System.out.println("dp[1]:> " + dp[1]);
        dp[0] = 1;

        System.out.print("init dp:> [");
        for (int a : dp) {
            System.out.print(a + ",");
        }
        System.out.println("]");

        for (int i = 1; i < n; i++) {
            int currUglyNumber = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                currUglyNumber = Math.min(currUglyNumber, dp[primesCounts[j]] * primes[j]); // 精華
                System.out.println("j:> " + j + ", dp[count[j]] * primes[j]:> " + dp[primesCounts[j]] * primes[j]);
            }
            for (int j = 0; j < primesCounts.length; j++) {
                if (currUglyNumber == dp[primesCounts[j]] * primes[j]) {
                    System.out.println("j:> " + j + ", currUglyNumber:> " + currUglyNumber + ", === GET ===");
                    ++primesCounts[j];
//                    break;
                }
            }
            dp[i] = currUglyNumber;
//            System.out.println("i:> " + i + ", dp[" + i + "]:> " + dp[i]);
            System.out.print("count= [");
            for (int a : primesCounts) {
                System.out.print(a + ",");
            }
            System.out.println("]");
            System.out.print("i:> " + i + ", [");
            for (int a : dp) {
                System.out.print(a + ",");
            }
            System.out.println("]");
        }
        System.out.print("count= [");
        for (int a : primesCounts) {
            System.out.print(a + ",");
        }
        System.out.println("]");


        System.out.print("dp= [");
        for (int a : dp) {
            System.out.print(a + ",");
        }
        System.out.println("]");

        return dp[n - 1];
    }

    public static int nthSuperUglyNumberGG(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int currUglyNumber = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                currUglyNumber = Math.min(currUglyNumber, dp[count[j]] * primes[j]);
            }

            for (int j = 0; j < count.length; j++) {
                if (currUglyNumber == dp[count[j]] * primes[j]) {
                    ++count[j];
                }
            }

            dp[i] = currUglyNumber;
        }

        return dp[n - 1];

    }

    static List<Integer> uglyList;

    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || n > maxLength) {
            return 1;
        }
        uglyList = new ArrayList<>();
        uglyList.add(1);

        for (int index = 2; index < maxLength; index++) {
            if (isUgly(index)) {
                uglyList.add(index);
                if (n == uglyList.size()) break;
            }
        }
        System.out.println(uglyList + ", size:> " + uglyList.size());
        return uglyList.get(n - 1);
    }

    static int maxLength = Integer.MAX_VALUE;
    static int[] primes = new int[]{2, 3, 5};
//    static int[] primes = new int[]{2, 7, 13, 19};
//    static int[] primes = new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (primeMap.containsKey(n)) return true;

        for (int prime : primes) {
            if (n % prime == 0) {
                if (isUgly(n / prime)) {
                    primeMap.put(n, true);
                    primeMap.put(n << 1, false);
//                    primeMap.put(n << 2, true);
//                    primeMap.put(n << 3, true);
//                    primeMap.put(n << 4, true);
//                    primeMap.put(n << 5, true);
                    System.out.println("n:> " + n + ", n << 1 :> " + (n << 1) + ", prime:> " + prime);
//                    System.out.println("n:> " + n + ", uglyList:> " + uglyList.size() + ", n - (n - 1):> "
//                            + (n - uglyList.get(uglyList.size() - 1)));
                    return true;
                }
            }
        }

        return false;
    }

    static HashMap<Integer, Boolean> primeMap = new HashMap<>();
}
