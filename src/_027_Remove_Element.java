import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _027_Remove_Element {

    public static void main(String[] arg0) {
        int[] ints = new int[8];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 3;
        ints[5] = 0;
        ints[6] = 4;
        ints[7] = 2;
        removeElement(ints, 2);

//        int[] ints = new int[4];
//        ints[0] = 3;
//        ints[1] = 2;
//        ints[2] = 2;
//        ints[3] = 3;
//        removeElement(ints, 3);
    }


    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int last = nums.length;

        while (i < last) {
            if (nums[i] == val) {
                nums[i] = nums[last - 1];
                last --;
            } else {
                i ++;
            }

        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
        return 0;
    }
}
