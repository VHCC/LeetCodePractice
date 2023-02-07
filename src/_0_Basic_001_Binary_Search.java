import javax.xml.bind.annotation.XmlID;
import java.util.Arrays;

/**
 * to search the index
 * must be sorted array
 */

public class _0_Basic_001_Binary_Search {


    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 10, 89, 1000, 1234};

        binarySearch(input, 1000);
    }

    // 前提是input已經排序過 由小到大
    static void binarySearch(int[] nums, int target) {

        if (nums.length <= 0) {
            System.out.println("input not valid");
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        if (target == nums[left]) {
            System.out.println("target:> " + target + ", index:> " + left);
            return;
        }

        if (target == nums[right]) {
            System.out.println("target:> " + target + ", index:> " + right);
            return;
        }

        int middle = (left + right) / 2; // TODO 找 middle Index
        while (nums[middle] != target) { // TODO 注意條件式
            if (target < nums[middle]) { // target 在左側
                right = middle;
            }

            if (nums[middle] < target) { // target 在右側
                left = middle;
            }
            middle = (left + right) / 2;
            if (middle == right || middle == left) { // 找不到的情形
                System.out.println("target dose not exist in.");
                return;
            }
        }
        System.out.println("target:> " + target + ", index:> " + middle);

    }

}
