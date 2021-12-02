import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_Word_Break {
    public static void main(String[] args) {
//        String s = "applepenapple";
//        String s = "penpenbapplepenbapple";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        List<String> wordDict = new ArrayList<>();
//        wordDict.add("pen");
//        wordDict.add("b");
//        wordDict.add("apple");
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");

        System.out.println(wordBreakGG(s, wordDict));
    }

    static public boolean wordBreakGG(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashSet<>());
    }

    static private boolean dfs(String s, List<String> wordDict, Set<String> checked) {
        if (s.isEmpty()) return true;
        if (checked.contains(s)) {
            if (s.length() <= 5) {
                System.out.println("CONTAINS:>>> " + s + " ");
            }
            return false;
        }
        System.out.println("add:> " + s);
        checked.add(s);

        for (String w : wordDict) {
            if (s.length() <= 5) {
                System.out.print("s:> " + s + ", startsWith:> " + s.startsWith(w) + ", w:> " + w + " ");
            }
            if (s.startsWith(w) && dfs(s.substring(w.length()), wordDict, checked)) return true;
        }
        System.out.println("DONE FALSE!!!");
        return false;
    }

    public static boolean wordBreakMy(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] check = new boolean[s.length()];
//        check[0] = true;

        int length = s.length();
        System.out.println("length:> " + length);
        for (int end = 0; end < length; end++) {
            System.out.println("end===== " + end);
            for (int start = 0; start <= end; start++) {
                String sub = s.substring(start, end + 1);
                System.out.println(sub);
                if (set.contains(sub)) {
                    if ((start == 0 || check[start - 1])) {
                        check[end] = true;
                        System.out.println("start:> " + start + ", end:> " + end + ", sub:> " + sub);
                    }
                }
            }
        }
        return check[length - 1];

    }


    public static boolean wordBreakGreat(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        int length = s.length();
        // dp[i]代表[0,i]字符串在字典中是否可以查到
        boolean[] dp = new boolean[length];
        System.out.println("dp:> " + dp.length);

        for (int end = 0; end < length; end++) {
            System.out.println("end:>>>>> " + end);
            for (int start = 0; start <= end; start++) {
                // 字串
                String sub = s.substring(start, end + 1);
                // 字典中存在字串
                System.out.println("sub:> " + sub);
                if (set.contains(sub)) {
                    // 上一节也在字典中存在
                    System.out.println("start:>>>> " + start);
                    if (start == 0 || dp[start - 1]) {
                        System.out.println("count==>, sub:> " + sub + ", end:> " + end);
                        dp[end] = true;
                        break;
                    }
                }
            }
        }
        return dp[length - 1];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        String targetString = s;
        int targetIndex = 0;
        int totalIndex = 0;
        next:
        for (String word : wordDict) {
            System.out.println("word:> " + word);
            int containTimes = 0;
            while (totalIndex < s.length()) {
                targetIndex = 0;
//                System.out.println("targetIndex:> " + targetIndex);
                for (int index = 0; index < word.length(); index++) {
//                    System.out.println("targetString.charAt(index):> " + targetString.charAt(index));
                    if (word.length() > targetString.length()) return false;
                    if (targetString.charAt(index) != word.charAt(index)) {
                        if (containTimes == 0) return false;
                        continue next;
                    }
                    if (index == word.length() - 1) {
                        containTimes++;
                        System.out.println("[" + targetString + "], contained:> " + word + ", containTimes:> " + containTimes);
                        targetIndex += word.length();
                        totalIndex += word.length();
                    }
                }

                System.out.println("targetString:> " + targetString + ", targetIndex:> " + targetIndex);
                targetString = targetString.substring(targetIndex, targetString.length());
                System.out.println("targetString:> " + targetString + ", targetIndex:> " + targetIndex + ", totalIndex:> " + totalIndex);
            }
        }

        return true;
    }
}
