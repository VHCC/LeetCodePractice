import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class _169_Majority_Element {

    public static void main(String[] args) {

//        int[] input = new int[]{1};
//        int[] input = new int[]{3, 2, 3};
        int[] input = new int[]{2, 2, 5, 1, 6};

//        int total = 80000;
//        int heights[] = new int[80000];
//        int input[] = new int[total];
//        for(int i = 0; i < total; i++) {
//            input[i] = (int)(Math.random() * total);
//        }

        Instant startTime = Instant.now();
        majorityElementSpace1(input);
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
//        tsSum += Duration.between(startTime, endTime).toMillis();
    }

    static public int majorityElementSpace1(int[] nums) {
        int count = 0;
        int major = nums[0];
        for (int i : nums) {
            if (count == 0) {
                major = i;
                count++;
            } else if (i == major) count++;
            else count--; // TODO 關鍵決策
        }
        System.out.println("major:> " + major);
        return major;

    }

    static public int majorityElement(int[] nums) {
        int maxTarget = Integer.MIN_VALUE;
        int maxTimes = 0;
        int checkTimes = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int checkNum = 0;

        for (int i = 0; i < nums.length; i++) {
            checkNum = nums[i];
            if (countMap.containsKey(checkNum)) {
                checkTimes = countMap.get(checkNum) + 1;
                if (maxTimes < checkTimes) {
                    maxTimes = checkTimes;
                    maxTarget = checkNum;
                }
                countMap.put(checkNum, checkTimes);

            } else {
                countMap.put(checkNum, 1);
                if (maxTimes == 0) {
                    maxTarget = checkNum;
                }
            }
        }

//        System.out.println(countMap);
        System.out.println("maxTarget:> " + maxTarget);
        return maxTarget;
    }
}
