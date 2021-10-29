public class _377_Combination_Sum_IV {

    static int target = 4;
    static int[] nums = new int[]{2,1,3};

//    static int target = 10;
//    static int[] nums = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};

//    static int target = 10;
//    static int[] nums = new int[]{2,1,3};

    //避免重複計算

    public static void main(String[] args) {
        System.out.println("ans:> " + combinationSum4Great(nums, target));
    }

    public static int combinationSum4Great(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int index = 1; index <= target; index++) {// 遍歷所有
            for (int num : nums) {
                if (num <= index) {
//                    System.out.println("index:> " + index + ", ele:> " + ele);
                    System.out.println("dp[" + index + "]:> " + dp[index] + " + dp[" + (index - num) + "]:> " + dp[index - num]);
                    dp[index] += dp[index - num]; // 子問題
                }

            }
//            System.out.println(" ====== dp[" + index + "]:> " + dp[index]);
        }


//        for (int a : dp) {
//            System.out.println("a:> " + a);
//        }
        return dp[target];
    }

//    static int[] ans;
//    public static int combinationSum4My(int[] nums, int target) {
//        if (target > nums.length) {
//            target = nums.length;
//        }
//        ans = new int[nums.length];
//        for (int subTarget = 1; subTarget <= target ; subTarget++) {
//            for (int head = 0; head < nums.length; head ++) {
//                if (subTarget - nums[head] > 0) {
//                    checkSubMy(head, subTarget - nums[head], nums, ans);
//                }
//                if (subTarget - nums[head] == 0) {
//                    ans[head]++;
//                }
//            }
//        }
//        int count = nums.length + 1;
//        System.out.println("count:> " + count);
//
//        for (int a: ans) {
//            System.out.println("origin a:> " + a);
//        }
//
//        for (int index = count; count < target; count++) {
//            int[] result = new int[ans.length];
//            for (int i = 0; i < ans.length; i ++){
//                result[0] += ans[i];
//            }
//        }
//
//        for (int a: ans) {
//            System.out.println("a:> " + a);
//        }
//        return 0;
//    }
//
//    public static void checkSubMy(int head, int subTarget, int[] nums, int[] ans) {
//        if (subTarget == 0) return;
//        for (int pointer = 0; pointer < nums.length; pointer ++) {
//            if (subTarget - nums[pointer] > 0) {
//                checkSubMy(head, subTarget - nums[pointer], nums, ans);
//            }
//            if (subTarget - nums[pointer] == 0) {
//                System.out.println("head:> " + head);
//                ans[head]++;
//            }
//        }
//    }


    public static int combinationSum4(int[] nums, int target) {
        int[] ans = new int[nums.length];
        int[] res = new int[nums.length];
        System.out.println(target);
        for (int head = 0; head < nums.length; head++) {
            if (target - nums[head] > 0) {
                res = checkSub(head, target - nums[head], nums);
            }
            if (target - nums[head] == 0) {
                System.out.println("head:> " + head);
                for (int i = 0; i < res.length; i++) {
                    ans[i] += res[i];
                }
            }
        }

        int result = 0;
        for (int a : ans) {
            System.out.println("a:> " + a);
            result += a;
        }
        return result;
    }

    public static int[] checkSub(int head, int subTarget, int[] nums) {
        int[] ans = new int[nums.length];
        if (subTarget == 0) return ans;
        for (int pointer = 0; pointer < nums.length; pointer++) {
            if (subTarget - nums[pointer] > 0) {
                checkSub(head, subTarget - nums[pointer], nums);
            }
            if (subTarget - nums[pointer] == 0) {
                ans[head]++;
            }
        }
        for (int a : ans) {
            System.out.println("a:> " + a);
        }
        return ans;
    }
}
