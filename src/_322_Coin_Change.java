import java.util.HashMap;
import java.util.Map;

public class _322_Coin_Change {

    public static void main(String[] args) {
        int[] coins = new int[]{3, 6, 7};
//        int[] coins = new int[]{1,2,5};
        int amounts = 13;
//        int amounts = 11;


        System.out.println(coinChange(coins, amounts));
//        System.out.println(coinChangeGreat(coins, amounts));
    }


    static public int coinChangeGreat(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        return helper(coins, amount, map);
    }

    static private int helper(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) return 0;

        if (map.containsKey(amount)) return map.get(amount);

        int max = Integer.MAX_VALUE;

        for (int coin : coins) {

            int remainder = amount - coin;

            if (remainder >= 0) {
                int temp = helper(coins, remainder, map);

                if (temp != -1) {
                    max = Math.min(max, temp);
                }
            }
        }
        System.out.println("B amount:> " + amount + ", valueMap:> " + map + ", max:> " + max);
        if (max == Integer.MAX_VALUE) {
            map.put(amount, -1);
        } else {
            map.put(amount, max + 1);
        }
        System.out.println("After amount:> " + amount + ", valueMap:> " + map + ", max:> " + max);
        return map.get(amount);
    }


    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    static public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

//        for (int c : coins) {
//            valueMap.put(c, 1);
//        }
        int ans = findMinimum(coins, amount);
        System.out.println(map);

        return ans;
    }

    static public int findMinimum(int[] coins, int amount) {
        if (amount == 0) return 0;

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int max = Integer.MAX_VALUE;
        for (int c : coins) {
            int remainder = amount - c;
            if (remainder >= 0) {
                int temp = findMinimum(coins, remainder);
                if (temp != -1) {
                    max = Math.min(max, temp);
                }
            }
        }
        if (max == Integer.MAX_VALUE) {
            map.put(amount, -1);
        } else {
            map.put(amount, max + 1);
        }
        return map.get(amount);
    }
}
