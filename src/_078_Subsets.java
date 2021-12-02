import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _078_Subsets {
    // backTracking

    static public void main(String[] args) {
        int[] inputs = new int[]{1,2,2};

//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(), inputs, 0);
//        System.out.println(list);

        System.out.println(subsets(inputs));
    }



    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        backTrackingMy(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    static  void backTrackingMy(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
        if (!ans.contains(tempList)) {
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i ++) {
            tempList.add(nums[i]);
            backTrackingMy(ans, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
















    static private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
