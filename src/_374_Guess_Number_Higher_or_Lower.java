import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */
public class _374_Guess_Number_Higher_or_Lower {

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        System.out.println(guessNumber(2126753390));
//        System.out.println(guessNumber(10));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }

    static public int guessNumber(int n) {
        System.out.println(binarySearch(n));
        return 0;
    }

    static public int binarySearch(int num) {

        int left = 1;
        int right = num;
        Long plus = Long.valueOf(left) + Long.valueOf(right);
        int mid = (int) ((plus) / 2);
        int count = 0;
        while (left < right) {
            plus = Long.valueOf(left) + Long.valueOf(right);
            mid = (int) ((plus) / 2);
//            System.out.println("left:> " + left + ", mid:> " + mid +
//                    ", right:> " + right + ", plus:> " + plus);
            if (guess(mid) == -1) { // 繼續往左找
                right = mid;
            } else if (guess(mid) == 1) { //繼續往右找
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return num;
    }

    static int guess(int i) {
        int picked = 1702766719;
        if (i > picked) {
            return -1;
        } else if (i < picked) {
            return 1;
        } else {
            return 0;
        }
    }
}
