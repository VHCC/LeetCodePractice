import java.util.Arrays;

public class _045_Jump_Game_II {
    public static void main(String[] args) {
//        int[] input = new int[]{4,1,1,1};
//        int[] input = new int[]{4,1,1,3,2};
        int[] input = new int[]{1,1,1,4,1,1,1};
//        int[] input = new int[]{2, 3, 0, 1, 4};


        System.out.println(jumpGreat(input));
    }


    public static int jumpGreat(int[] nums) {
        int count = 0;//計步器
        int cur = 0;//當前走到底幾位
        int maxNext = 0;//最大的下一個
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, nums[i] + i);
            System.out.println("i:> " + i + ", maxNext:> " + maxNext);
            //nums[i]+i可以知道跳到第幾步 i=要跳的步數 nums[i]指的是這次能跳的步數
            if (i == cur) {//因為是用nums.length-1 所以這邊要先++
                System.out.println("cur:> " + cur);
                count++;
                cur = maxNext;
            }
        }
        return count;
    }


    public static int jump(int[] nums) {


        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                System.out.println("unreachable i:> " + i);
                return 0;
            }
            reachable = Math.max(reachable, i + nums[i]);
            System.out.println("reachable:> " + reachable + ", i:> " + i);
        }

        return 0;
    }
}
