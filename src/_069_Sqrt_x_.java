import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class _069_Sqrt_x_ {

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        System.out.println(mySqrtBinary(49));
//        System.out.println(mySqrtBinary(2147395598));
//        System.out.println(mySqrtBinary(2147395599));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }

    static public int mySqrtBinary(int x) {
        if (x <= 0) return 0;
        int l = 1, r = x, res = 1;
        while (l < r) {
            int mid = (l + r) / 2;
            System.out.println("l:> " + l + ", mid:> " + mid + ", r:> " + r + ", res:> " + res);
            if (mid > x / mid) {
                r = mid;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        System.out.println("l:> " + l + ", res:> " + res + ", r:> " + r);
        return res;
    }

    static public int mySqrt(int x) {
        if (x == 0) return 0;
        int index = 1;
        while (index <= 46340) {

            if (index * index == x) {
                return index;
            }
            if (x > (index * index) && x < ((index + 1) * (index + 1))) {
                return index;
            }
            index++;
        }

        return 46340;
    }
}
