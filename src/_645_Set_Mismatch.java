import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class _645_Set_Mismatch {

    public static void main(String[] args) {

//        int[] input = new int[]{3, 0, 1};
        int[] input = new int[]{2, 2};

//        int total = 80000;
//        int heights[] = new int[80000];
//        int input[] = new int[total];
//        for(int i = 0; i < total; i++) {
//            input[i] = (int)(Math.random() * total);
//        }

        Instant startTime = Instant.now();
        System.out.println("Q:> " + Arrays.toString(input));
        System.out.println("Answer:> " + Arrays.toString(findErrorNums(input)));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    static public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        Arrays.sort(nums);
        System.out.println("After sort:> " + Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 2) {
                answer[0] = nums[i];
                answer[1] = nums[i] - 1;
                return answer;
            } else if (nums[i - 1] - nums[i] == 0) {
                answer[0] = nums[i - 1];
                answer[1] = nums[i - 1] + 1;
                return answer;
            }
        }
        return answer;
    }
}
