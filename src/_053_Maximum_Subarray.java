public class _053_Maximum_Subarray {
    public static void main(String[] args) {

//        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] input = new int[]{5,4,-1,7,8};
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArrayGreat(input));
    }

    public static int maxSubArrayGreat(int[] nums) {
        int currMax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]); // 子問題，因為連續，所以只需要連續比較兩個之間
            max = Math.max(max, currMax);
        }
        return max;
    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int sum = nums[start];
            max = Math.max(max, sum);
            for (int end = start + 1; end < nums.length; end++) {
//                System.out.println("start:> " + start + ", end:> " + end);
                sum += nums[end];
                max = Math.max(max, sum);
//                System.out.println("nums[" + (end - start) + "]:> " + nums[end - start] + ", sum:> " + sum);
            }
//            System.out.println("===end:> " + end );
        }

        return max;
    }
}
