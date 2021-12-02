import java.util.*;

public class _047_Permutations_II {
    static public void main(String[] args) {
//        int[] nums = new int[]{1,2,1};
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{-1,2,-1,2,1,-1,2,1};


        System.out.println(permuteUnique(nums));
    }

    static public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> repeatsSet = new HashSet<>();

        HashMap<Integer, Integer> residualMap = new HashMap<>();
        for (int num: nums) {
            residualMap.put(num, residualMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        backTracking(ans, new ArrayList<>(), nums, residualMap, repeatsSet);

        System.out.println(residualMap);
        return ans;
    }


    static public void backTracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums,
                                    HashMap<Integer, Integer> residualMap, Set<List<Integer>> repeatsSet) {
//        System.out.println("repeatsSet:> " + repeatsSet + ", tempListL> " + tempList);
        if (repeatsSet.contains(tempList)) return;
        if (tempList.size() == nums.length) {
//        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i< nums.length; i++) {
            if (residualMap.get(nums[i]) == 0) {
                continue;
            }
//            if (repeatsSet.contains(tempList)) return;
            tempList.add(nums[i]);

            residualMap.put(nums[i], residualMap.get(nums[i]) - 1);
            backTracking(ans, tempList, nums, residualMap, repeatsSet);
            repeatsSet.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            residualMap.put(nums[i], residualMap.get(nums[i]) + 1);
        }

    }
}
