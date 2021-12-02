import java.util.Arrays;
import java.util.HashMap;

public class _033_Search_in_Rotated_Sorted_Array {


    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{1};
//        int[] nums = new int[]{12, 13, 3, 7, 8, 10};
        int target = 0;
//        int target = 6;
        System.out.println(binarySearchUnsorted(nums, target));
    }


    public static int binarySearchUnsorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right) ;
            if (nums[mid] == target) {
                return mid;
            }
            // right sorted
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // search right
                } else {
                    right = mid - 1; // search  unsorted left
                }
            }

            // left sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // search left
                } else {
                    left = mid + 1; // search unsorted right
                }
            }

        }
        return -1;
    }

    public int searchGreat(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[l]) {// stable left
                if (target <= nums[m] && target >= nums[l]) r = m;
                else l = m + 1;
            } else { // stable right
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }


    static HashMap<Integer, Integer> valueMap = new HashMap<>();

    static public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            valueMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return -1;
        }
        System.out.println("index:> " + index);
        int value = nums[index];
        return valueMap.get(value);

    }


    static public int binarySearch(int[] nums, int start, int end, int target) {
        for (int n : nums) {
            System.out.print(n + ", ");
        }
        System.out.println("");

        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
//            System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right) ;
            if (nums[mid] == target) {
//                System.out.println("RETURN:> " + mid);
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
