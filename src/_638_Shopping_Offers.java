import java.util.*;

public class _638_Shopping_Offers {
    public static void main(String[] args) {

        List<Integer> price = new ArrayList<>(Arrays.asList(2,5));
        List<List<Integer>> special = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3,0,5)),
                new ArrayList<>(Arrays.asList(1,2,10))));
        List<Integer> needs = new ArrayList<>(Arrays.asList(3,2));
        System.out.println(shoppingOffers(price, special, needs));
    }

    static Map<List<Integer>, Integer> map = new HashMap<>(); // 记忆数组

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return help(price, special, needs); // 递归求解
    }

    public static int help(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int cost = 0; // 总花费
        // needs中每个商品都单独购买得到的总花费
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        System.out.println("cost:> " + cost + ", map:> " + map + ", needs:> " + needs);
        // 如果总花费为0，返回0。
        if (cost == 0) return 0;
        // 记忆数组中包含当前购物清单的最优花费，直接返回该值
        if (map.containsKey(needs)) return map.get(needs);
        // 遍历每一个礼包
        for (List<Integer> list : special) {
            System.out.println("list:> " + list);
            // 当前礼包价格
            int p = list.get(list.size() - 1);
            // 如果礼包价格大于等于当前最优总花费，跳过
            if (p >= cost) continue;
            // 新建一个购物清单
            List<Integer> needList = new ArrayList<>();
            // 循环当前礼包中的每种商品数量
            for (int i = 0; i < list.size() - 1; i++) {
                // 礼包中当前商品数量大于购物清单中该商品数量
                // 该礼包无法购买
                if (list.get(i) > needs.get(i)) break;
                // 将购买后剩余未购买的数量加入新的购物清单
                needList.add(needs.get(i) - list.get(i));
            }
            // 当前礼包购买的情况下
            System.out.println("needList:> " + needList + ", needs:> " + needs);
            if (needList.size() == needs.size()) {
                // 购买当前礼包的价格加上剩下未购买商品所需的价格为总花费价格
                // 更新最小花费值。
                int p_help =  p + help(price, special, needList);
                System.out.println("cost:> " + cost + ", p + help:> " + p_help);
                cost = Math.min(cost, p_help);
            }
        }
        // 将当前购物清单需要的最少花费存入记忆数组
        map.put(needs, cost);
        return cost;
    }
}
