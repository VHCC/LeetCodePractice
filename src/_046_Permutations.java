import java.util.*;

public class _046_Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};


        System.out.println(permute(nums));
    }

    static public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> repeats = new HashMap<>();
        backTracking(ans, new ArrayList<>(), nums, repeats);
        return ans;
    }

    public static void backTracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums, HashMap<Integer, Integer> repeats) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (repeats.containsKey(nums[i]) && repeats.get(nums[i]) != 0) {
                continue;
            }
            repeats.put(nums[i], 1);
            tempList.add(nums[i]);
            backTracking(ans, tempList, nums, repeats);
            repeats.put(nums[i] , repeats.get(nums[i]) - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
