import java.util.ArrayList;
import java.util.List;

public class _039_Combination_Sum {
    static public void main(String[] args) {
        int[] nums = new int[]{1, 2};
        int target = 4;
        System.out.println(combinationSum(nums, target));
    }


    static public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        backTracking(ans, new ArrayList<>(), nums, target, 0);
        return ans;
    }

    static public void backTracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int target, int start) {
//        System.out.println("target:> " + target + ", nums[" + start + "]:> " + nums[start]);
        if (target == 0) {
//            System.out.println(tempList);
            ans.add(new ArrayList<>(tempList));
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(ans, tempList, nums, target - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
