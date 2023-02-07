import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _202_Happy_Number {


    public static void main(String[] args) {


//        int[] input = new int[]{1, 2, 3, 3, 2};

        Instant startTime = Instant.now();
        isHappy(19);
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }

    static public boolean isHappy(int n) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            elementMap.put(i, i * i);
        }




        return true;
    }


    static void checkSplit(int n) {
//        String value = String.valueOf(i);
    }
}
