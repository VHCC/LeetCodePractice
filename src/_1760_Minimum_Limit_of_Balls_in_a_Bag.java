import java.util.Arrays;

public class _1760_Minimum_Limit_of_Balls_in_a_Bag {

    public static void main(String[] args) {
        int[] input = new int[]{100,200,4000,500,100,200};
        int maxOperation = 5;

        int end = 100_000_000;

        System.out.println(minimumSizeGreat(input, maxOperation));

    }

    static public int minimumSizeGreat(int[] nums, int maxOperations) {
        //initiate the boundary for possible answers, here if you let minAns=1 it will still work for most cases except for some corner cases. We make max=100000000 because nums[i] <= 10^9. You can choose to sort the array and make the max= arr.max, at the price of time consumption.
        //The answer should be the minimized max value.
        int min = 0;
        int max = (int) Math.pow(10, 9);

        //Compared with minAns<max or minAns <= max, minAns + 1 < max will avoid infinite loops e.g. when minAns = 2, max = 3
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            System.out.println("max:> " + max + ", mid:> " + mid + ", minAns:> " + min);
            //count indicates the operation times with atmost mid balls in bag.
            int count = 0;
            for (int num : nums) {
                //this is the same as Math. ceil(a/mid) - 1=> math.ceil(a/mid) gives the number of divided bags, we subtract the number by 1 to get the subdivision operation times.
//                System.out.println("a:> " + a);
                count += (num - 1) / mid; // 分袋
            }
            //if count < maxOperations, max WOULD be further minimized and set to mid;
            //if count = maxOperations, max still COULD be further minimized and set to mid.
            //so we combine < and = cases together in one if condition
            if (count <= maxOperations) {
                //max = mid - 1 will not work in this case becasue mid could be the correct answer.
                //To not miss the correct answer we set a relatively "loose" boundary for max and minAns.
                max = mid;
            } else {
                min = mid;
            }
        }
        //Now we find the minimized max value
        return max;
    }


    static public int minimumSize(int[] nums, int maxOperations) {

        int a = 17;
        int b = 7;

        System.out.println(Arrays.binarySearch(nums, 9 >> 5));

        System.out.println(9 >> 2);
        return 0;
    }


}
