import java.util.Arrays;

public class _081_Search_in_Rotated_Sorted_Array_II {

    public static void main(String[] args) {
//        int[] input = new int[]{1,0,1,1,1};
//        int[] input = new int[]{1,1,3,1};
//        int[] input = new int[]{1,3,1};
        int[] input = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
//        int[] input = new int[]{4, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        int target = 13;
//        int target = 4;

        System.out.println(search(input, target));
    }

    static public boolean search(int[] nums, int target) {
//        Arrays.sort(nums);
        int result = binarySearchUnsorted(nums, target);
        System.out.println(result);
        return (result != -1);
    }


    static public int binarySearchUnsorted(int[] nums, int target) {

        for (int n : nums) {
            System.out.print(n + ",");
        }
        System.out.println("");

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) { // 重點
            mid = left + ((right - left) >> 1);
            System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right);
            if (nums[mid] == target) {
                return mid;
            }

            // left sorted
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    //search left
                    right = mid - 1;
                } else {
                    // search right
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && nums[right] >= target) {
                    //search right
                    left = mid + 1;
                } else {
                    // search left
                    right = mid - 1;
                }
            } else if (nums[left] == nums[mid] && nums[right] == nums[mid]) {// [1,3,1,1,1]
                right --;
                left ++;
            } else if (nums[left] == nums[mid]) { // [1,1,3]
                left = mid + 1;
            } else { // [3,1,1]
                right = mid - 1;
            }



        }
        return -1;
    }


    static public int binarySearch(int[] nums, int target) {

        for (int n : nums) {
            System.out.print(n + ",");
        }
        System.out.println("");

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) { // 重點
            mid = left + ((right - left) >> 1);
            System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
