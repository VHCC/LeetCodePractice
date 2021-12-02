import java.util.ArrayList;
import java.util.List;

public class _077_Combinations {

    public static void main(String[] args) {
        int n = 20;
        int k = 2;
        System.out.println(combine(n, k));
    }

    static public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i ++) {
            nums[i] = i + 1;
        }

        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("");

        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, ans, new ArrayList<>(), 0, k);
        return ans;
    }

    static public void backTracking(int[] nums, List<List<Integer>> ans, List<Integer> tempList, int start, int width) {
        if (tempList.size() == width) {
//            ans.add(tempList);
            ans.add(new ArrayList<>(tempList));
        }
//        ans.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i ++) {
            tempList.add(nums[i]);
            backTracking(nums, ans, tempList, i + 1, width);
            tempList.remove(tempList.size() - 1);
        }

    }
}
