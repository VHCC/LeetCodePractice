import java.util.ArrayList;
import java.util.List;

public class Two_Sum_1 {

    public static void main(String[] arg0) {

        //        List<String> words = new ArrayList<String>() ;
        int[] ints = new int[7];
        ints[0] = 2;
        ints[1] = 7;
        ints[2] = 11;
        ints[3] = 15;
        twoSum(ints, 22);
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
}
