import java.util.HashMap;
import java.util.Map;

public class _809_Expressive_Words {

    public static void main(String[] args){
        String s = "hl";
        String[] words = new String[]{"hello", "hi", "helo"};

//        String s = "zzzzzyyyyy";
//        String[] words = new String[]{"zzyy","zy","zyy"};

//        String s = "aaabbbaaa";
//        String[] words = new String[]{"a"};

//        String s = "aaabbbaaa";
//        String[] words = new String[]{"a", "ab"};

        System.out.println(expressiveWordsGreat(s, words));
    }


    public static int expressiveWordsGreat(String S, String[] words) {
        Map<Integer, Integer> mapS = new HashMap<>();

        String compS = compress(S, mapS);
        int res = 0;

        for(String word : words) {
            Map<Integer, Integer> mapW = new HashMap<>();
            String compW = compress(word, mapW);
            if(compW.length() != compS.length()) continue;
            boolean valid = true;

            for(int i = 0; i < compW.length(); i++) {
                if(compW.charAt(i) == compS.charAt(i) && mapW.get(i) == mapS.get(i)) continue;
                if(compW.charAt(i) != compS.charAt(i) || mapW.get(i) > mapS.get(i) || mapS.get(i) < 3) {
                    System.out.println("W:> " + compW.charAt(i) + ", S:> " + compS.charAt(i));
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            System.out.println("Add:> " + word);
            res++;

        }
        return res;
    }

    static String compress(String S, Map<Integer, Integer> map) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(builder.length() >= 1 && builder.charAt(builder.length() - 1) == ch) {
                map.put(builder.length() - 1, map.get(builder.length() - 1) + 1);
            } else {
                map.put(builder.length(), map.getOrDefault(builder.length(), 0) + 1);
                builder.append(ch);
            }
        }
        System.out.println("S:> " + S + ", :> " + builder.toString() + ", valueMap:> " + map);
        return builder.toString();
    }



    public static int expressiveWordsB(String s, String[] words) {
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        int pre = s.charAt(0);
        int count = 1;
        for (int index = 0; index < s.length(); index ++){
            if (pre == (int) s.charAt(index)) {
//                targetMap.put(count, targetMap.get(count) == null ? 0 : targetMap.get(count) + 1);
            } else {
//                System.out.println("count:> " + count);
                pre = s.charAt(index);
                count ++;
            }
            targetMap.put(count, targetMap.get(count) == null ? 1 : targetMap.get(count) + 1);
//            System.out.println("s:> " + s.charAt(index) + ", pre:> " + pre + ", pre == (int) s.charAt(index):> " + (pre == (int) s.charAt(index)));

        }
        System.out.println(targetMap);

        int ans = 0;
        for (String word : words) {
            int preSub = word.charAt(0);
            int countSub = 1;
            int wordCount = 0;
            System.out.println("word:> " + word);
            for (int index = 0; index < word.length(); index ++){
                if (preSub == (int) word.charAt(index)) {
                } else {
                    preSub = word.charAt(index);
                    System.out.println("countSub:> " + countSub + ", targetMap:> " + targetMap.get(countSub));
                    System.out.println("wordCount:> " + wordCount);
                    if (wordCount - targetMap.get(countSub) >= 2) {
                        ans ++;
                    }
                    countSub ++;
                }
                wordCount++;
                if (index == word.length() - 1) {
                    System.out.println("countSub:> " + countSub + ", targetMap:> " + targetMap.get(countSub));
                    System.out.println("wordCount:> " + wordCount);
                    if (wordCount - targetMap.get(countSub) >= 2) {
                        ans ++;
                    }
                }
            }
        }


        return ans;
    }




    public static int expressiveWords(String s, String[] words) {
        int[] aplphaBet = new int [27];
        for (char c : s.toCharArray()) {
//            System.out.println("c:> " + c + ", index:> " + (c - 'a' + 1));
            aplphaBet[c - 'a' + 1] ++;
        }
        int ans = 0;
        search: for (String word: words) {
            System.out.println("word:> " + word);
            int[] checkArray = new int [27];
            for (char c : word.toCharArray()) {
                checkArray[c - 'a' + 1]++;
            }
            for (int index = 0; index < aplphaBet.length; index ++){
                System.out.println("index:> " + index + ", aplphaBet[index]:> " + aplphaBet[index]);
                if (checkArray[index] - aplphaBet[index] == -1 ||
                        aplphaBet[index] - checkArray[index] == 1 ||
                        (checkArray[index] > 0 && aplphaBet[index] == 0) ||
                        (aplphaBet[index] > 0 && checkArray[index] == 0)) {
                    continue search;
                }
            }
            ans ++;
        }

        return ans;
    }
}
