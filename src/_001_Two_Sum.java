import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _001_Two_Sum {

    public static void main(String[] arg0) {
        int target = 6;
        int[] input = new int[]{3,3};


        for (int i: twoSum20211104(input, target)) {

            System.out.print(i + ", ");
        }
    }

    public static int[] twoSum20211104(int[] nums, int target) {

        List<Integer> intArray = new ArrayList<>();
        for (int i: nums) {
            intArray.add(i);
        }

        System.out.println(intArray);

        int ans = 0;
        int ans2 = 0;
        int temp = 0;
        for (int index = 0; index < intArray.size(); index ++) {
            temp = intArray.get(index);
            intArray.set(index, Integer.MAX_VALUE);
            int res = target - nums[index];
            int checkExit = -1;
            System.out.println("res:> " + res);
            checkExit = intArray.indexOf(res);
            if (checkExit > 0) {
                ans = index;
                ans2 = checkExit;
                System.out.println(index);
            }
            intArray.set(index, temp);
        }
        return new int[]{ans,ans2};
    }



    public static void twoSum(int[] nums, int target) {
        List<Integer> ans = new ArrayList<Integer>();


        int n = nums.length;
        int i = 0;

        while (i < n) {
            int elements_first = nums[i];
            int j = i + 1;
            while (j < n) {
                int elements_seconed = nums[j];
                if ((elements_first + elements_seconed) == target) {
                    ans.add(i);
                    ans.add(j);
                    break;
                }
                j++;
            }
            i++;

        }
        System.out.println(ans);
    }

    // use HashMap
    public static int[] solutionMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(complement);
                System.out.println(map);
                System.out.println(i);
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
