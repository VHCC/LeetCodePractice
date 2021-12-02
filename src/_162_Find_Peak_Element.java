public class _162_Find_Peak_Element {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,1,5,3,2,1,5};
//        int[] input = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE + 1};

        System.out.println(findPeakElementBinarySearch(input));
    }


    static public int findPeakElementBinarySearch(int[] nums) {


        return 0;
    }

    static public int helper(int start, int end, int[] nums) {
        return 0;
    }



    static public int findPeakElement(int[] nums) {
        int n = nums.length;

        int maxIndex = 0;
        int index = 0;
        int max = nums[0];
        for (int num: nums) {
            max = Math.max(max, num);
            System.out.println("index:> " + index + ", num:> " + num + ", max:> " + max);
            System.out.println("Integer.valueOf(max):> " + Integer.valueOf(max) + ", Integer.valueOf(num):> " + Integer.valueOf(num) );
            System.out.println("equal:> " + (Integer.valueOf(max) == Integer.valueOf(num)));
            System.out.println("equal:> " + (max == num));
            if (max == num || Integer.valueOf(num) == Integer.MAX_VALUE) {
                System.out.println("find max");
                max = num;
                maxIndex = index;
            }
            index ++;
        }
        System.out.println("maxIndex:> " + maxIndex + ", max:> " + max);

        return maxIndex;
    }


}
