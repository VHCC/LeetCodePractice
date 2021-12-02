import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _833_Find_And_Replace_in_String {

    public static void main(String[] args) {
        String s = "abcbc";
        int[] indices = new int[]{0, 2};
        String[] sources = new String[]{"ab", "bc"};
        String[] targets = new String[]{"eee", "ffff"};


        System.out.println(findReplaceString(s, indices, sources, targets));
    }


    static public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            boolean isDiff = false;
            String temp = "";
            System.out.println(sources[i]);

            for (int j = indices[i]; j < indices[i] + sources[i].length(); j++) {
                System.out.println("j:> " + j + ", chatAt s:> " + s.charAt(j) + ", match:> " + sources[i].charAt(j-indices[i]));
                if (s.charAt(j) != sources[i].charAt(j-indices[i])) {
                    isDiff = true;
                    System.out.println("BREAK!!!");
                    break;
                }
            }

            if (isDiff) continue;

            map.put(indices[i], targets[i]);
            for (int k = 0; k < sources[i].length();k ++) {
                temp += "0";
            }

            CharSequence front = s.subSequence(0, indices[i]);
            CharSequence mid = s.subSequence(indices[i], indices[i] + sources[i].length());
            CharSequence end = s.subSequence(indices[i] + sources[i].length(), s.length());
            System.out.println("front:> " + front + ", mid:> " + mid + ", end:> "+ end);
            s = front + temp + end;
            System.out.println(s);
        }

        for (int l = 0; l < s.length(); l++) {
            if (s.charAt(l) != '0') {
                map.put(l, String.valueOf(s.charAt(l)));
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>(map.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        heap.addAll(map.keySet());
        StringBuffer ans = new StringBuffer();
        while (!heap.isEmpty()) { // 這才是重點
            int c = heap.poll();
            System.out.print(map.get(c) + ", ");
            ans.append(map.get(c));
        }
        System.out.println("DONE");
        System.out.println(map);
        System.out.println(s);
        return String.valueOf(ans);
    }
}
