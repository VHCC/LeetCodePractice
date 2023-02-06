import java.time.Duration;
import java.time.Instant;

public class _268_Missing_Number {


    public static void main(String[] args) {

//        int[] input = new int[]{3, 0, 1};
        int[] input = new int[]{9,6,4,2,3,5,7,0,1};

//        int total = 80000;
//        int heights[] = new int[80000];
//        int input[] = new int[total];
//        for(int i = 0; i < total; i++) {
//            input[i] = (int)(Math.random() * total);
//        }

        Instant startTime = Instant.now();
        missingNumber(input);
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    static public int missingNumber(int[] nums) {
        int range = nums.length;
        int sum = 0;
        for(int i = 0; i <= range; i ++) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("sum from 0 ~ " + range + " :> " + sum) ;
        int target = sum;
        for(int num : nums) {
            target -= num;
        }
        System.out.println("missing target:> " + target);
        return target;
    }
}
