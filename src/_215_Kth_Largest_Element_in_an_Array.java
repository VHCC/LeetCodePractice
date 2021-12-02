import java.util.Arrays;

public class _215_Kth_Largest_Element_in_an_Array {

    public static void main(String[] args) {
        int[] intput = new int[]{};
        int index = 0;

        System.out.println(findKthLargest(intput, index));
    }

    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
