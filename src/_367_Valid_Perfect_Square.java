import java.time.Duration;
import java.time.Instant;

/**
 * Binary Search
 * how to change the right pointer is the most important
 */
public class _367_Valid_Perfect_Square {


    public static void main(String[] args) {
        Instant startTime = Instant.now();
//        System.out.println(isPerfectSquare(7749));
        System.out.println(isPerfectSquare(11*11));
//        System.out.println(isPerfectSquare(46336*46336));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }

    static public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num;

        if (num == 1) return true;

        boolean isAnsPerfect = false;
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println("left:> " + left + ", mid:> " + mid + ", r:> " + right + ", num:> " + num);
            if (mid > (num / mid)) { // TODO 決策點
                right = mid;
            } else {
                if ((mid * mid) == num) {
                    return true;
                }
                left = mid + 1;
            }
        }

        return isAnsPerfect;
    }
}
