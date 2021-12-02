public class _209_Minimum_Size_Subarray_Sum {

    // 順序不能變，不需要sorting


    public static void main(String[] args) {
        int target = 24;
        int[] input = new int[]{1, 2, 4, 3, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLenGreat(target, input));
    }


    static public int minSubArrayLenGreat(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int res = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        for (int i = 0; i < n; i++) {
            int target = s + sum[i];
            int border = binarySearch(sum, target, 0, n);
            System.out.println("target:> " + target + ", border:> " + border + ", i:> " + i);
            if (border > 0) res = Math.min(res, border - i);
        }
        return (res != Integer.MAX_VALUE ? res : 0);
    }


    static public int binarySearch(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;

//            if (nums[mid] == target) {
//                return right;
//            } else if (nums[mid] > target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }


        }
        if (right == nums.length - 1 && nums[right] < target) return -1;
        return right;
    }

//    static public int binarySearch(int[] nums, int target, int start, int end) {
//        //find the index of first element that is bigger than or equals target
//        int left = start;
//        int right = end;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] >= target) right = mid;
//            else left = mid + 1;
//        }
//        if (right == nums.length - 1 && nums[right] < target) return -1;
//        return right;
//    }


    static int minAns = 100_000;

    static public int minSubArrayLen(int target, int[] nums) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (target > total) {
            return 0;
        }

        return findSum(target, nums, 0, nums.length - 1);
    }

    static public int findSum(int target, int[] nums, int start, int end) {
        int mid = start + ((end - start) >> 1);
        System.out.println("start:> " + start + ", mid:> " + mid + ", end:> " + end);
        int midValue = nums[mid];
        if (midValue == target) return 1;

        int leftSum = 0;
        System.out.print("Left[");
        for (int i = start; i < mid; i++) {
            System.out.print(nums[i] + ",");
            leftSum += nums[i];
        }
        System.out.println(midValue + "]");


        int rightSum = 0;
        System.out.print("Right[" + midValue + ",");
        for (int j = mid + 1; j < (end + 1); j++) {
            System.out.print(nums[j] + ",");
            rightSum += nums[j];
        }
        System.out.println("]");

        System.out.println("midValue:> " + midValue + ", leftSum:> " + (leftSum + midValue) + ", rightSum:> " + (midValue + rightSum));

        if ((leftSum + midValue) == target) {
            System.out.println("<=== CHECK LEFT, minAns:> " + minAns + ", check point:> " + (mid - start + 1));
            minAns = Math.min(minAns, (mid - start + 1));
        }
//
        if ((midValue + rightSum) == target) {
            System.out.println("<=== CHECK RIGHT, minAns:> " + minAns + ", check point:> " + (end - mid + 1));
            minAns = Math.min(minAns, (end - mid + 1));
        }

        if ((leftSum + midValue) > target) {
            System.out.println("<=== find NEXT SUB LEFT");
            findSum(target, nums, start, mid);
        }

        if ((midValue + rightSum) > target) {
            System.out.println("find NEXT SUB RIGHT ===>");
            findSum(target, nums, mid, end);
        }
//
        if ((leftSum + midValue) >= target && (rightSum + midValue) >= target) {
            minAns = Math.min(minAns, Math.min((mid - start + 1), (end - mid + 1)));
        }

        System.out.print("minAns:> " + minAns);
        System.out.println(", start:> " + start + ", mid:> " + mid + ", end:> " + end);
        return minAns;
    }

//    public int findSum(int target, int[] nums, int start, int end) {
//        int mid = start + ((end - start) >> 1);
//        int midValue = nums[mid];
//
//        int leftSum = 0;
//        for (int i = start; i < mid; i++) {
//            leftSum += nums[i];
//        }
//
//
//        int rightSum = 0;
//        for (int j = mid + 1; j < (end + 1); j++) {
//            rightSum += nums[j];
//        }
//
//        if ((leftSum + midValue) == target) {
//            minAns = Math.min(minAns, (mid - start + 1));
//        }
////
//        if ((midValue + rightSum) == target) {
//            minAns = Math.min(minAns, (end - mid + 1));
//        }
//
//        if ((leftSum + midValue) > target) {
//            findSum(target, nums, start, mid);
//        }
//
//        if ((midValue + rightSum) > target) {
//            findSum(target, nums, mid, end);
//        }
////
//        if ((leftSum + midValue) >= target && (rightSum + midValue) >= target) {
//            minAns = Math.min(minAns, Math.min((mid - start + 1), (end - mid + 1)));
//        }
//
//        return minAns;
//    }

}
