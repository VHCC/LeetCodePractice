import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * HashSet.contain = O(1)
 */
public class _217_Contains_Duplicate {

    public static void main(String[] args) {

        long tsSum = 0;
        int times = 50;
        for (int time = 0; time < times; time++) {
            int total = 80000;
            int input[] = new int[total];
            for(int i = 0; i < total; i++) {
                input[i] = (int)(Math.random() * total);
            }

//        int[] input = new int[]{1, 2, 3, 3, 2};
//            int[] input = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 2};

            Instant startTime = Instant.now();
            System.out.println("Original:> " + Arrays.toString(input));
            containsDuplicateSet(input);
            System.out.println("After QuickSort:> " + Arrays.toString(input));
            Instant endTime = Instant.now();
            System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
            tsSum += Duration.between(startTime, endTime).toMillis();
        }
        System.out.println(" Average 共耗時：" + tsSum / times + " 毫秒, Total " + tsSum);
    }

    static public boolean containsDuplicateSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (Integer num : nums) {
            if (numSet.contains(num)) {
                return true;
            } else {
                numSet.add(num);
            }
        }
        return false;
    }

    static public boolean containsDuplicate(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i - 1] - nums[i] == 0) {
                return true;
            }
        }
        return false;
    }

    static public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right + 1;
            while (true) {
                while (i + 1 < nums.length && nums[++i] < nums[left]) ;
                while (j - 1 >= 0 && nums[--j] > nums[left]) ;
                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, left, j);
            quickSort(nums, left, j - 1);
            quickSort(nums, j + 1, right);
        }
    }

    static public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
