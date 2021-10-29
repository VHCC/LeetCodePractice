public class _055_Jump_Game {
    public static void main(String[] args) {

//        int [] input = new int[]{1,1,0};
        int[] input = new int[]{0, 1};
//        int [] input = new int[]{1,2};
//        int[] input = new int[]{2, 3, 1, 1, 0, 4};
//        int [] input = new int[]{2,5,0,0};
//        int [] input = new int[]{3,2,1,0,4,3,2,1,0,4,3,2,1,0,4,3,2,1,0,4};

        System.out.println(canJumpGreat(input));
    }

    public static boolean canJumpGreat(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]); // 子問題：能到達的最遠距離
        }
        return true;
    }


    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return true;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = nums[i];
            int sumIndex = nums[i];
            if (sumIndex >= n) return true;
            while (sumIndex < n) {
                System.out.println("i:> " + i + ", index:> " + index + ", sumIndex:> " + sumIndex);
                sumIndex += nums[index];
                index += nums[index];
                if (sumIndex >= n) {
                    return true;
                }
                if (nums[index] == 0) break;
            }
        }

        return false;
    }
}
