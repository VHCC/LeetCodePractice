
import java.util.*;

public class _015_3Sum {
    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4, 0, 1, -1, 2, -1, 3};
        System.out.println(threeSumClean(input));

    }

    public static List<List<Integer>> threeSumClean(int[] nums) {

        int target = 0;
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return sol;
        }
        Arrays.sort(nums); // 關鍵排序
//        Arrays.parallelSort(nums);
        for (int i = 0; i <= nums.length - 1; i++) {

            int remaining = target - nums[i]; // 目標
            int front = i + 1;
            int back = nums.length - 1;

            while (front < back) { // Two Pointer
                int twoSum = nums[front] + nums[back];
                System.out.println("twoSum:> " + twoSum + ", remaining:> " + remaining);
                if (twoSum < remaining) front++;
                else if (twoSum > remaining) back--;
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[front]);
                    triplet.add(nums[back]);
                    sol.add(triplet);
                    System.out.println("triplet:>> " + triplet);

                    while (front < back && nums[front] == triplet.get(1)) front++; // 找到 「正算的」下一個數
                    while (front < back && nums[back] == triplet.get(2)) back--; // 找到「後回算的」下一個數
                }
            }
            while (i + 1 <= nums.length - 1 && nums[i] == nums[i + 1]) i++; // fix 數的推薦
        }
        return sol;
    }

    public static List<List<Integer>> threeSumGreat(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums); // 直接排序，關鍵。
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break; // ??
            int j = i + 1;
            int k = nums.length - 1; // 從後面來
            while (j < k) { // j, k pointer 比較
                int sum = nums[i] + nums[j] + nums[k]; // 目標子問題
                if (sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k])); // 決策A
                if (sum <= 0) while (nums[j] == nums[++j] && j < k) ; // 決策B
                if (sum >= 0) while (nums[k--] == nums[k] && j < k) ; // 決策C
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) ;
        }
        return result;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        HashMap<HashSet, Boolean> set = new HashMap<>();

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> ansTemp;
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> tempSet = new HashSet<>();

        int temp1 = 0;
        int temp2 = 0;
        for (int start = 0; start < nums.length; start++) {
            temp1 = numList.get(start);

            numList.set(start, Integer.MIN_VALUE);
            for (int end = start + 1; end < nums.length; end++) {
                int sum = (0 - temp1);
                temp2 = numList.get(end);
                tempSet.add(temp1);
                tempSet.add(temp2);
                sum -= temp2;
                numList.set(end, Integer.MIN_VALUE);
                System.out.println("temp1:> " + temp1 + ", temp2:> " + temp2 + ", target:> " + sum);
                tempSet.add(sum);
                System.out.println("tempSet:> " + tempSet);
                if (numList.contains((sum)) && !set.containsKey(tempSet)) {
                    System.out.println("======= ADD:> " + ", temp1:> " + temp1 + ", temp2:> " + temp2 + ", sum:> " + sum);
                    ans.add(temp1);
                    ans.add(temp2);
                    ans.add(sum);
                    set.put(new HashSet(ans), true);
                    ansTemp = new ArrayList<>();
                    ansTemp.add(temp1);
                    ansTemp.add(temp2);
                    ansTemp.add(sum);
                    ansList.add(ansTemp);
                    ans.clear();
                }
                tempSet.clear();
                numList.set(end, temp2);
            }
            tempSet.clear();
            numList.set(start, temp1);
        }
//        System.out.println(set);
//        System.out.println(ansList.size());
//        System.out.println(ansList);

        return ansList;
    }
}
