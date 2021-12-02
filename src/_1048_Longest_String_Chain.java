import java.util.*;

public class _1048_Longest_String_Chain {

    public static void main(String[] args) {
        // subString 得運用


//        String[] input = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc", "pcxba", "cxpbc"};
//        String[] input = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
//        String[] input = new String[]{"a","b","ba","bca","bda","bdca"};
//        String[] input = new String[]{"bdca","bda","ca","dca","a"};
        String[] input = new String[]{"ab", "ac", "bd", "abc", "abd", "abdd"};
//        String[] input = new String[]{"abcd","dbqca","xbc","pcxbcf","xb","cxbc","pcxbc","xbc","pcxbcf","xb","cxbc","pcxbc"};
//        String[] input = new String[]{"abcd","dbqca","xbc","pcxbcf","xb","cxbc","pcxbc","xbc","pcxbcf","xb","cxbc","pcxbc"};
//        String[] input = new String[]{"abcd","dbqca","xbc","pcxbcf","xb","cxbc","pcxbc","xbc","pcxbcf","xb","cxbc","pcxbc","abcd","dbqca","xbc","pcxbcf","xb","cxbc","pcxbc","xbc","pcxbcf","xb","cxbc","pcxbc","abcd","dbqca","xbc","pcxbcf","xb","cxbc","pcxbc","xbc","pcxbcf","xb","cxbc","pcxbc"};

        System.out.println(longestStrChainGreat(input));
//        PriorityQueue<String> pq=
//                new PriorityQueue<String>(5, (a,b) -> a.length() - b.length());
//        // or pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));
////        pq.add("Apple");
////        pq.add("PineApple");
////        pq.add("Custard Apple");
//        for (String s: input) {
//            pq.add(s);
//        }
//
//        System.out.println(pq);
//        while (pq.size() != 0)
//        {
//            System.out.println(pq.remove());
//        }
    }


    public static int longestStrChainGreat(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap();
        int max = 0;
        for (String word : words) {
            System.out.println("word:> " + word);
            int longestSubstring = 0;
            for (int i = 0; i < word.length(); i++) {
                String subWord = word.substring(0, i) + word.substring(i + 1);
                System.out.println(", subWord:> " + subWord + ", i:> " + i);
                longestSubstring = Math.max(longestSubstring, map.getOrDefault(subWord, 0) + 1);
            }
            map.put(word, longestSubstring);
            System.out.println(map);
            max = Math.max(max, longestSubstring);
        }
        System.out.println(map);
        return max;
    }

    public static int longestStrChain(String[] words) {

//        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> (b.length() - a.length()));
        PriorityQueue<String> queue = new PriorityQueue<>(words.length, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // Assume neither string is null. Real code should
                // probably be more robust
                // You could also just return x.length() - y.length(),
                // which would be more efficient.
                return y.length() - x.length();
            }
        });
        for (String s : words) {
            queue.add(s);
        }

        List<String> stringList = new ArrayList<>();
        while (!queue.isEmpty()) {
            stringList.add(queue.poll());
        }

        System.out.println(stringList);

        int max = 0;

        for (int i = 0; i < stringList.size(); i++) {
            if (!ans.containsKey(stringList.get(i))) {
                for (int j = i + 1; j < stringList.size(); j++) {
                    int submax = 0;
                    if (ans.containsKey(stringList.get(i))) {
                        submax = ans.get(stringList.get(i));
                        ans.put(stringList.get(i), 1);
                    }

                    System.out.print("new check:> " + stringList.get(i) + " ");
                    if (stringList.get(i).length() == stringList.get(j).length() + 1) {

                        System.out.println(", target:> " + stringList.get(j));
                        max = Math.max(max, findMax(i, j, stringList.get(i), stringList));
                    } else {
                        System.out.println("break");
                        continue;
                    }
                }
            }
        }
        return max;
    }

    static HashMap<String, Integer> ans = new HashMap<>();

    public static int findMax(int start, int next, String originString, List stringList) {
        System.out.println("findMax === start:> " + start + ", next:> " + next);
        if (next >= stringList.size()) {
            return ans.getOrDefault(originString, 1);
        }
        String big = (String) stringList.get(start);
        String small = (String) stringList.get(next);
        if (big.length() == small.length() + 1) {
            for (int index = 0; index < small.length(); index++) {
                if (big.charAt(index) != small.charAt(index)) {
                    big = (big.substring(0, index) + (big.substring(index + 1, big.length())));
                    System.out.println("originString:> " + originString + ", newbig:> " + big + ", small:> " + small);
                    if (!big.equals(small)) {
                        findMax(start, next + 1, originString, stringList);
//                        continue;
                        return ans.getOrDefault(originString, 1);
                    } else {
                        System.out.println("can add");
                        ans.put(originString, ans.getOrDefault(originString, 1) + 1);
                        System.out.println(ans);
                        findMax(next, next + 1, originString, stringList);
                        return ans.getOrDefault(originString, 1);
                    }
                }
            }
            System.out.println("all same, count + 1");
            ans.put(originString, ans.getOrDefault(originString, 1) + 1);
            System.out.println(ans);
            findMax(next, next + 1, originString, stringList);
            return ans.getOrDefault(originString, 1);
        } else {
            findMax(start, next + 1, originString, stringList);
        }
        return ans.getOrDefault(originString, 1);
    }
}
