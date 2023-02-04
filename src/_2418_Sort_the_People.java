import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class _2418_Sort_the_People {


    public static void main(String[] args) {

//        String[] names = new String[]{"Mary", "John", "Emma", "Ichen", "Mark"};
//        int[] heights = new int[]{180, 165, 170, 186, 178};

        String[] names = new String[]{"Mary", "John", "Emma", "A", "B"};
        int[] heights = new int[]{1, 2, 2, 3, 3};

//        String names[] = new String[80000];
//        int heights[] = new int[80000];
//        for(int i = 0; i < 80000; i++) {
//            names[i] = String.valueOf(Math.random() * 80000) + "-MAN";
//            heights[i] = (int)(Math.random() * 80000);
//        }

//        String[] names = new String[]{"Alice","Bob","Bob"};
//        int[] heights = new int[]{155,185,150};

        sortPeople(names, heights);
    }

    static public void sortPeople(String[] names, int[] heights) {

        int nameLength = names.length;
        int heightsLength = heights.length;
        Instant startTime = Instant.now();
        System.out.println("原序列為："+ Arrays.toString(heights));
        System.out.println("原序列為："+ Arrays.toString(names));
        quickSort(heights, names, 0, heightsLength - 1);
        System.out.println("排序後為："+ Arrays.toString(heights));
        System.out.println("排序後為："+ Arrays.toString(names));


        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");
    }

    static void quickSort(int[] input, String[] names, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int i = leftIndex; // 由左至右的索引
            int j = rightIndex + 1; // 由右至左的索引

            while (true) {
                while (i + 1 < input.length && input[++i] > input[leftIndex]) ; // 向右找, 直到找到比基準值大的數
                while (j - 1 >= 0 && input[--j] < input[leftIndex]) ; // 向左找, 直到找到比基準值小的數
                if (i >= j) break; // 若i,j重疊或i超過j後則退出循環
                swap(input, i, j);
                swap(names, i, j);
            }
            swap(input, leftIndex, j); // 基準點與 j 交換
            swap(names, leftIndex, j); // 基準點與 j 交換
            quickSort(input, names, leftIndex, j - 1); // 遞迴排序基準點左子序列
            quickSort(input, names, j + 1, rightIndex); // 遞迴排序基準點右子序列
        }
    }


//    static int[] old(Integer[] input) {
//        int target = input[0];
//        int j = input.length -1;
//        for (int i = 1; i < input.length; i ++) {
//            if (input[i] > target) { // 從左找到比Target大的
//                while(j > i) {
//                    if (input[j] < target) { // 從右找到比Target小的
//                        swap(input, i, j);
//                        break;
//                    }
//                    j --;
//                }
//                if (j <= i) {
//                    swap(input, 0, j);
//                }
//            }
//
//        }
//    }


    static public void swap(int[] rawArray, int leftIndex, int rightIndex) {
        int tmp = rawArray[leftIndex];
        rawArray[leftIndex] = rawArray[rightIndex];
        rawArray[rightIndex] = tmp;
    }

    static public void swap(String[] rawArray, int leftIndex, int rightIndex) {
        String tmp = rawArray[leftIndex];
        rawArray[leftIndex] = rawArray[rightIndex];
        rawArray[rightIndex] = tmp;
    }
}

