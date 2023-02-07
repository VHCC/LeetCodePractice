import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * HashSet
 */
public class _349_Intersection_of_Two_Arrays {

    public static void main(String[] args) {

        int[] num1 = new int[]{1};
        int[] num2 = new int[]{2, 2};

        Instant startTime = Instant.now();
//        System.out.println(intersection(num1, num2));
        System.out.println(Arrays.toString(intersection(num1, num2)));

        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }

    static public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> num1Set = new HashSet<>();

        for (int num : nums1) {
            num1Set.add(num);
        }

        for (int num : nums2) {
            if (!answer.contains(num) && num1Set.contains(num)) {
                answer.add(num);
            }
        }

        int[] ans = new int[answer.size()];
        int i = 0;
        for(Integer num: answer) {
            ans[i++] = num;
        }
        return ans;
    }
}
