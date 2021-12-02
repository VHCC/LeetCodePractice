import java.util.*;

public class _1_Google_Interview {

    public static void main(String[] args) {
//        Q1();
//        Q2();
        Q1_Better();
        System.out.println();
    }

    public static void Q1_Better() {
        int target = 1;
        int[] input = new int[]{22, 11, 33, 55, 22};

        int subCounts = 0;
        int duplicateCounts = 0;
        for (int n : input) {
            if (n < target) {
                subCounts++;
            }
            if (n == target) {
                duplicateCounts ++;
            }
        }
        System.out.println("subCounts:> " + subCounts);
        System.out.println("duplicateCounts:> " + duplicateCounts);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < duplicateCounts; i ++) {
            ans.add(subCounts + i);
        }
        System.out.println(ans);
    }

    public static void Q1() {
        int target = 33;
        int[] input = new int[]{22, 11, 33, 55, 22};

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        List<Integer> ans = new ArrayList<>();
        for (int n : input) {
            heap.add(n);
        }

        int index = 0;

        while (!heap.isEmpty()) {
            int check = heap.poll();
            System.out.print(check + ", ");
            if (check == target) {
                ans.add(index);
            }
            index++;
        }
        System.out.println("");
        System.out.println(ans);
    }

    public static void Q2() {
        int [] input = new int[]{11, 11, 22, 22, 33, 33};
        HashMap<Integer, Integer> numCounts = new HashMap<>();


        for (int n : input) {
            numCounts.put(n, numCounts.getOrDefault(n, 0) + 1);
        }

        System.out.println(numCounts);
        System.out.println(numCounts.keySet());
        int max2 = Integer.MIN_VALUE;
        for (int key : numCounts.keySet()) {
            max2 = Math.max(max2, numCounts.get(key));
        }

        List<Integer> targetArray = new ArrayList<>();
        System.out.println(max2);
        for (int key : numCounts.keySet()) {
            if (numCounts.get(key) == max2) {
                targetArray.add(key);
            }
        }

        System.out.println(targetArray);
    }
}
