import java.util.*;

public class _451_Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String input = "dafadfadfadfadfadfadgfxcvxbvxvb";
        System.out.println(frequencySortGreat(input));


        // TODO Auto-generated method stub
//        Queue<Integer> queue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer j, Integer i) {
//                // TODO Auto-generated method stub
//                System.out.println("compare:> i= " + i + ", j= " + j);
////                int result = i % 2 - j % 2;
////                if (result == 0)
////                    result = j - i;
////                return result;
//                return i - j;
//            }
//        });
//        for (int i = 0; i < 10; i++) {
//            System.out.println("add i:> " + i);
//            queue.offer(i);
//        }
//
//        System.out.println(queue);
//        for (int i = 0; i < 10; i++) {
//            System.out.print(queue.poll());
//            System.out.println(queue);
//        }



    }


    public static String frequencySortGreat(String s) {
        // Count the occurence on each character
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        System.out.println(cnt);

        // Build heap
//        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (cnt.get(b) - cnt.get(a))); // 後者 - 前者 大到小
//        heap.addAll(cnt.keySet());

        PriorityQueue<Character> heap = new PriorityQueue<>(cnt.size(), new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return cnt.get(o1) - cnt.get(o2);
            }
        });

        heap.addAll(cnt.keySet());

        System.out.println(heap);

        // Build string
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) { // 這才是重點
            char c = heap.poll();
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String frequencySort(String s) {
        int[] array = new int[s.length()];

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(Integer.valueOf(c), countMap.get(Integer.valueOf(c)) != null ? (countMap.get(Integer.valueOf(c)) + 1) : 1);
        }
        System.out.println(countMap);

        int[] countArray = new int[countMap.size()];
        int index = 0;
        for (int count : countMap.values()) {
            countArray[index++] = count;
        }


        Arrays.sort(countArray);
//        for (int c : countArray) {
//            System.out.println(c);
//        }

        String ans = "";
        for (int i = countArray.length - 1; i >= 0; i--) {
            for (int key : countMap.keySet()) {
//                System.out.println(count);
                if (countArray[i] == countMap.get(key)) {
                    int targetCount = 0;
                    System.out.println(countArray[i] + ", key:> " + key + ", countMap.get(key):> " + countMap.get(key));
                    while (targetCount++ < countArray[i]) {
                        ans += (char) key;
                    }
                    countMap.put(Integer.valueOf(key), -1);
                }
            }
        }


        return ans;
    }

}
