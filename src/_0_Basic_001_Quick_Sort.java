import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Best case TO(nlogn)
 * Average case TO(nlogn)
 * Worst case TO(n2)
 * Unstable
 */
public class _0_Basic_001_Quick_Sort {

    public static void main(String[] args) {

        long tsSum = 0;
        int times = 1;
        for (int time = 0; time < times; time++) {
            int total = 80000;
            int input[] = new int[total];
            for(int i = 0; i < total; i++) {
                input[i] = (int)(Math.random() * total);
            }

//        int[] input = new int[]{1, 2, 3, 3, 2};

            Instant startTime = Instant.now();
            System.out.println("Original:> " + Arrays.toString(input));
            quickSort(input, 0, input.length - 1);
            System.out.println("After QuickSort:> " + Arrays.toString(input));
            Instant endTime = Instant.now();
            System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
            tsSum += Duration.between(startTime, endTime).toMillis();
        }
        System.out.println(" Average 共耗時：" + tsSum/times + " 毫秒, Total " + tsSum);

    }

    static void quickSort(int[] input, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int i = leftIndex;
            int j = rightIndex + 1;

            while (true) {
                while (i + 1 < input.length && input[++i] < input[leftIndex]) ; // 往右找到比基準點大的數
                while (j - 1 >= 0 && input[--j] > input[leftIndex]) ; // 往左找到比基準點小的數
                if (i >= j) break; // 若i, j 重疊 or i > j 則跳出 // TODO 沒寫到；注意 2023/02/05
                swap(input, i, j); // 找到就SWAP i, j
            }

            swap(input, leftIndex, j);
            quickSort(input, leftIndex, j - 1); // TODO 左右側的 的index位置要注意
            quickSort(input, j + 1, rightIndex); // TODO 右側 index 的位置要注意
        }
    }

    static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
