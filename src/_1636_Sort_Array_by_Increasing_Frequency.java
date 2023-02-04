import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1636_Sort_Array_by_Increasing_Frequency {

    public static void main(String[] args) {

//        int[] input = new int[]{-1,1,-6,4,5,-6,1,4,1};
//        int[] input = new int[]{1,1,2,2,2,3};
//        int[] input = new int[]{1,2, 3, 3, 2};
        int[] input = new int[]{-8, -10, -8, -8};

        System.out.println("原序列為：" + Arrays.toString(input));
        frequencySort(input);
    }

    static public void frequencySort(int[] nums) {

        int maxTimes = 0;
        int minTimes = Integer.MAX_VALUE;
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (frequencyCount.containsKey(nums[i])) {
                frequencyCount.put(nums[i], frequencyCount.get(nums[i]) + 1);
            } else {
                frequencyCount.put(nums[i], 1);
            }
            maxTimes = Math.max(frequencyCount.get(nums[i]), maxTimes);
        }
        System.out.println(frequencyCount);

        Map<Integer, ArrayList> frequencyTimesArray = new HashMap<>();

        for (Integer value : frequencyCount.values()) {

        }

        for (Integer integer : frequencyCount.keySet()) {
            if (frequencyTimesArray.containsKey(frequencyCount.get(integer))) { // 若有相同次數的 Key
                frequencyTimesArray.get(frequencyCount.get(integer)).add(integer);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(integer);
                frequencyTimesArray.put(frequencyCount.get(integer), temp);
                minTimes = Math.min(frequencyCount.get(integer), minTimes);
            }
        }

        System.out.println(frequencyTimesArray);
        System.out.println("maxTimes:> " + maxTimes);
        System.out.println("minTimes:> " + minTimes);

        int[] answer = new int[nums.length];
        int startSize = 0;
        int i = minTimes;
        int preSizeAll = 0;
        int groupCount = 0;
        while (i <= maxTimes) {
            ArrayList<Integer> target = frequencyTimesArray.get(i);
            if (target == null) {
                i++;
                continue;
            }
            for (int index = 0; index < target.size(); index++) {
                for (int times = 1; times <= i; times++) {
                    answer[startSize++] = target.get(index);
                    groupCount++;
                }
            }
            System.out.println(Arrays.toString(answer));
            System.out.println("left:> " + preSizeAll);
            System.out.println("right:> " + (preSizeAll + groupCount - 1));
//            quickSort(answer, preSizeAll, preSizeAll + ((i - minTimes) * target.size()) - 1);
            quickSort(answer, preSizeAll,  (preSizeAll + groupCount - 1));
            preSizeAll = preSizeAll + groupCount;
            System.out.println("groupCount:> " + groupCount);
            System.out.println("preIndex:> " + preSizeAll);
            groupCount = 0;
            i++;
        }

        System.out.println(Arrays.toString(answer));
    }

    static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right + 1;

            // 基準值 = nums[left]; 固定不變
            while (true) {
                while (i + 1 < nums.length && nums[++i] > nums[left]) ; // i指標不能超過數列 && 持續往右找到比 基準值大的數
                while (j - 1 >= 0 && nums[--j] < nums[left]) ; // j 指標不小於等於數列 && 持續往左找到比 基準值小的數
                if (i >= j) break; //若 ij重疊，或是 i> j 則完成一次子陣列搜尋與SWAP
                swap(nums, i, j); // 每找到一組就SWAP i, j
            }

            // 完成一次子陣列搜尋則 基準值與j SWAP
            swap(nums, left, j);

            // 分成兩組持續quick sort
            quickSort(nums, left, j - 1);
            quickSort(nums, j + 1, right);
        }
    }

    static void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }

}
