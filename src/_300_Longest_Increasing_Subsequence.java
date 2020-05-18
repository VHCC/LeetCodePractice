import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

//Note:
//
//There may be more than one LIS combination, it is only necessary for you to return the length.
//Your algorithm should run in O(n2) complexity.
//Follow up: Could you improve it to O(n log n) time complexity?
public class _300_Longest_Increasing_Subsequence {

    public static void main(String[] arg0) {

        //        List<String> words = new ArrayList<String>() ;
        int[] ints = new int[6];
//        ints[0] = -2;
//        ints[1] = -1;

//        ints[0] = 2;
//        ints[1] = 2;
//        ints[2] = 2;

        ints[0] = 4;
        ints[1] = 10;
        ints[2] = 4;
        ints[3] = 3;
        ints[4] = 8;
        ints[5] = 9;

//        ints[0] = 10;
//        ints[1] = 9;
//        ints[2] = 2;
//        ints[3] = 5;
//        ints[4] = 3;
//        ints[5] = 7;
//        ints[6] = 101;
//        ints[7] = 18;
//        ints[8] = 19;
        for (int index = 0; index < ints.length; index++) {
            System.out.print(ints[index] + ",");
        }
//        System.out.println(", LIS= " + lengthOfLIS(ints));
        System.out.println(", LIS= " + solution(ints));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] nums_copy = nums.clone();
        int max = 0;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        for (int index = 0; index < nums.length; index++) {
            int increasing_count = 0;
            float diff_pre = 0;
            for (int subIndex = index; subIndex < nums_copy.length; subIndex++) {

                float target = nums_copy[subIndex];
                float target_major = nums[index];

                if ((target - target_major) >= 0.0f) {
//                    System.out.println("target= " + nums[index] + ", target_major= " + nums_copy[subIndex] + ", diff= " + ((target - target_major)));
                    if (((target - target_major)) >= diff_pre) {
//                        System.out.println("add= " + nums_copy[subIndex]);
                        if (target == target_major) {
                            if (subIndex == index) {
                                increasing_count++;
                            }
                        } else {
                            increasing_count++;
                        }
                    }
                    diff_pre = ((target - target_major));
//                    System.out.println("diff_pre= " + diff_pre);
                }
            }

            if (increasing_count >= max) {
                max = increasing_count;
            }

        }


        return max;
    }

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1; //自己一定為1
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {

            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                System.out.println("nums[i]= " + nums[i] + ", nums[j]= " + nums[j]);
                if (nums[i] > nums[j]) {
                    System.out.println(" dp["+ j +"]= " +  dp[j]);
                    max = Math.max(max, dp[j]);
                    System.out.println("max= " + max);
                }
            }

            dp[i] = (max == 0) ? 1 : (max + 1);
            System.out.println("**dp[" + i + "]= " + dp[i]);
            maxLen = Math.max(maxLen, dp[i]);
            System.out.println("maxLen= " + maxLen);
            System.out.println("===========");
        }

        return maxLen;
    }

}
