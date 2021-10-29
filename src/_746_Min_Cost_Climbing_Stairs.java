import java.util.HashMap;

public class _746_Min_Cost_Climbing_Stairs {


    public static void main(String[] args) {

        int[] input = new int[]{10, 15, 20};
//        int[] input = new int[]{1,100,1,1,1,100,1,1,100,1};


        System.out.println(minCostClimbingStairsMy(input));
    }

    public static int minCostClimbingStairsClean(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        return Math.min(cost[0], cost[1]);
    }

    public static int minCostClimbingStairsMy(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int finalCost = Math.min(findFianlCostMy(cost, 0), findFianlCost(cost, 1));

        System.out.println("finalCost:> " + finalCost);

        return finalCost;

    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int findFianlCostMy(int[] cost, int index) {
//        System.out.println("index:> " + index);
        if (index >= cost.length) {
            return 0;
        }
        if (map.containsKey(index)) return map.get(index);
        int final1 = findFianlCost(cost, (index + 1));
        int final2 = findFianlCost(cost, (index + 2));

        System.out.println("i:> " + index + ", 1:> " + final1);
        System.out.println("i:> " + index + ", 2:> " + final2);

        map.put(index, cost[index] + Math.min(final1, final2));

        return map.get(index);
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int finalCost = Math.min(findFianlCost(cost, 0), findFianlCost(cost, 1));
        return finalCost;

    }

    public static int findFianlCost(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (map.containsKey(index)) return map.get(index);
        int final1 = findFianlCost(cost, (index + 1));
        int final2 = findFianlCost(cost, (index + 2));

        map.put(index, cost[index] + Math.min(final1, final2));

        return map.get(index);
    }
}
