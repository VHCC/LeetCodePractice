public class _494_Target_Sum {
    public static void main(String[] args) {
//        int[] input = new int[]{1};
        int[] input = new int[]{1};
        int target = 2;

        System.out.println(findTargetSumWays(input, target));
    }


    static int ans = 0;

    public static int findTargetSumWays(int[] nums, int target) {
//        if (nums.length == 1) return 1;
        System.out.println(nums.length);

        checkNext(nums, target - nums[0], 0);
//        System.out.println("====");
        checkNext(nums, target + nums[0], 0);

        return ans;
    }

    public static void checkNext(int[] nums, int target, int index) {
//        System.out.println("index:> " + index + ", target:> " + target + ", nums:> " + nums[index]);
        if (target == 0 && index == nums.length - 1) {
//            System.out.println("<<<<ADD>>>>");
            ans++;
            return;
        }
        index += 1;
        if (index >= nums.length) return;

        checkNext(nums, target - nums[index], index);
//        System.out.println(" === sub === ");
        checkNext(nums, target + nums[index], index);

        return;
    }
}
