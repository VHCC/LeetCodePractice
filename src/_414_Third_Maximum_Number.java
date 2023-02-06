import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class _414_Third_Maximum_Number {

    public static void main(String[] args) {

//        int[] input = new int[]{1, 2, 3};
        int[] input = new int[]{};

//        int total = 80000;
//        int heights[] = new int[80000];
//        int input[] = new int[total];
//        for(int i = 0; i < total; i++) {
//            input[i] = (int)(Math.random() * total);
//        }

        Instant startTime = Instant.now();
        System.out.println("answer:> " + thirdMaxMine(input));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    static public int thirdMaxMine(int[] nums) {
        Integer maximum = null;
        Integer maximumSec = null;
        Integer maximumThird = null;
        for (Integer num : nums) {
            if (num.equals(maximum) || num.equals(maximumSec) || num.equals(maximumThird)) continue;
            if (maximum == null || num > maximum) { // max == null || 比最大值更大，所有往後移
                maximumThird = maximumSec;
                maximumSec = maximum;
                maximum = num;
            } else if (maximumSec == null || num > maximumSec) { // 次等判斷， maxSec == null || 比第二大更大，往後移動
                maximumThird = maximumSec;
                maximumSec = num;
            } else if (maximumThird == null || num > maximumThird) {
                maximumThird = num;
            }
        }
        return maximumThird == null ? maximum : maximumThird;
    }

    static public int thirdMaxT(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    static public int thirdMax(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        int maximum = Integer.MIN_VALUE;
        int maximumSec = Integer.MIN_VALUE;
        int maximumThird = Integer.MIN_VALUE;

        System.out.println("Original:> " + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("After Merge Sort:> " + Arrays.toString(nums));

        for (int num : nums) {
            if (!intSet.contains(num)) {
                intSet.add(num);
                if (intSet.size() == 3) {
                    return num;
                }
            }
            if (num > maximum) {
                maximum = num;
            }

        }
        return maximum;
    }


    static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right + 1;

            while(true) {
                while (i + 1 < nums.length && nums[++i] > nums[left]); // nums[++i] < nums[left] 就繼續找
                while (j - 1 >= 0 && nums[--j] < nums[left]); // nums[--j] > nums[left] 就繼續找
                if ( i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, left, j);
            quickSort(nums, left, j - 1);
            quickSort(nums, j + 1, right);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {

            int mid = (left + right) / 2;
            // partition
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    static void merge(int[] nums, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0; // pointer of temp

        while (i <= left && j <= right) { // both
            if (nums[i] < nums[j]) {
                temp[t] = nums[i];
                i++;
                t++;
            } else {
                temp[t] = nums[j];
                j++;
                t++;
            }
        }


        while (i <= mid) {
            temp[t] = nums[i];
            i++;
            t++;
        }

        while(j <= right) {
            temp[t] = nums[j];
            j++;
            t++;
        }

        t = 0;
        int index = left;
        while (index < right) {
            nums[index++] = temp[t++];
        }
    }

}
