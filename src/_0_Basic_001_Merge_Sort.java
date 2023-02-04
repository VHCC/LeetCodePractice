import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Best case TO(nlogn)
 * Average case TO(nlogn)
 * Worst case TO(n2)
 * Stable
 */
public class _0_Basic_001_Merge_Sort {

    public static void main(String[] args) {

        long tsSum = 0;
        int times = 1;
        for (int time = 0; time < times; time++) {
            int total = 80000;
            int input[] = new int[total];
            for(int i = 0; i < total; i++) {
                input[i] = (int)(Math.random() * total);
            }

//        int[] input = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
            int[] temp = new int[input.length];

            Instant startTime = Instant.now();
            System.out.println("Original:> " + Arrays.toString(input));
//        mergeSort(input, 0, input.length - 1, answer);

            mergeSortPractise001(input, 0, input.length - 1, temp);

            System.out.println("After Merge Sort:> " + Arrays.toString(input));
            Instant endTime = Instant.now();
            System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
            tsSum += Duration.between(startTime, endTime).toMillis();
        }
        System.out.println(" Average 共耗時：" + tsSum/times + " 毫秒, Total " + tsSum);
    }

    static void mergeSortPractise001(int[] input, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortPractise001(input, left, mid, temp);
            mergeSortPractise001(input, mid + 1, right, temp);
            mergePractise001(input, left, mid, right, temp);
        }


    }

    static void mergePractise001(int[] input, int left, int mid, int right, int[] temp) {
//        System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right);
//        System.out.println("temp:> " + Arrays.toString(temp));
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) { //i,j 都沒有 Travels Done
            if (input[i] < input[j]) { // 左邊比較小
                temp[t] = input[i];
                i++;
                t++;
            } else { // 右邊比較小
                temp[t] = input[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            temp[t] = input[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = input[j];
            j++;
            t++;
        }

//        t = 0;
//        while (t < input.length) {
//            input[t] = temp[t];
//            t++;
//        }

        // (三) 將 answer 陣列的元素 copy 到 arr , 並不是每次都 copy 所有 // TODO 很重要
        t = 0;
        int tempLeft = left; // 用於暫時遍歷 temp 陣列
        while (tempLeft <= right) {
            input[tempLeft++] = temp[t++];
        }

    }


    static void mergeSort(int[] input, int leftIndex, int rightIndex, int[] answer) {
        if (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;

            // 向左遞迴進行分解
            mergeSort(input, leftIndex, mid, answer);

            // 向右遞迴進行分解
            mergeSort(input, mid + 1, rightIndex, answer);

            // 合併
            merge(input, leftIndex, mid, rightIndex, answer);
        }

    }

    // TODO 重頭戲
    static void merge(int[] input, int left, int mid, int right, int[] answer) {
        System.out.println("left:> " + left + ", mid:> " + mid + ", right:> " + right);
        System.out.println("temp:> " + Arrays.toString(answer));
        int i = left; // 初始化i, 左邊有序序列的初始索引
        int j = mid + 1; // 初始化j, 右邊有序序列的初始索引
        int t = 0; // 指向temp陣列的當前索引

        // (一) 左右子序列比大小, 將小的放到temp陣列
        while (i <= mid && j <= right) { // 左右子序列都還沒遍歷到最後時 // TODO travels ALL
            if (input[i] <= input[j]) { // 若左子序列值小於等於右子序列值，則將之放到 temp 陣列中 // TODO 決策點
                answer[t] = input[i]; // TODO 放進解答
                t += 1; // answer陣列索引後移
                i += 1; // 遍歷下一個
            } else { // 右子序列值小於等於左子序列值
                answer[t] = input[j];
                t += 1;
                j += 1;
            }
        }

        // (二) 把有剩餘數據的子序列依次全部放入temp // 各別檢查
        while (i <= mid) { // 左子序列有剩餘的元素
            answer[t] = input[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { // 右子序列有剩餘的元素
            answer[t] = input[j];
            t += 1;
            j += 1;
        }

        // (三) 將 answer 陣列的元素 copy 到 arr , 並不是每次都 copy 所有
        t = 0;
        int tempLeft = left; // 用於暫時遍歷 temp 陣列
        while (tempLeft <= right) {
            input[tempLeft++] = answer[t++];
        }
    }

    static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;


    }

}
