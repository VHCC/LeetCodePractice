import java.util.Arrays;

public class _704_Binary_Search {

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 7, 9, 11, 13, 19, 55, 69};
        int target = -1;

        System.out.println(search(input, target));
    }

    public int searchGreat(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static public int search(int[] nums, int target) {
        int n = nums.length;
        System.out.println("n:> " + n);
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);

        return binarySearch(nums, 0, n - 1, target);
    }

    static public int binarySearch(int[] nums, int start, int end, int target) {

        int mid = start + ((end - start) >> 1);
        System.out.println("start:> " + start + ", mid[" + mid + "]:> " + nums[mid] + ", end:> " + end);
        if (mid == start) {
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }


        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid, end, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid, target);
        }


        return -1;
    }
}
