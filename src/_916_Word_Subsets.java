import java.util.ArrayList;
import java.util.List;

public class _916_Word_Subsets {

//    public static int count = 0;

    public static void main(String[] args) {
        String[] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
//        List<String> list1 = new ArrayList<String>(Arrays.asList(words1));
        String[] words2 = new String[]{"el", "oo"};
        for ( String item : wordSubsets(words1, words2)) {
            System.out.println(item);
        }

//        String[] words2_new = new String[10000];
//
//        for (int index = 0; index < words2.length; index++) {
//            if (words2[index].length() > 1) {
//                for (int subIndex = 0; subIndex < words2[index].length(); subIndex++) {
//                    words2_new[count++] = words2[index].substring(subIndex, subIndex + 1);
//                }
//            } else {
//                words2_new[count++] = words2[index];
//            }
//        }
//
//        System.out.println("count:> " + count);
//        for (int x = 0; x < count; x ++) {
//            System.out.println("words2_new[x]:> " + words2_new[x]);
//            for (int y = 0; y < list1.size(); y ++) {
//
//                if (list1.get(y).indexOf(words2_new[x]) == -1) {
//                    System.out.println("remove:> " + list1.get(y));
//                    list1.remove(list1.get(y));
//                }
//            }
//        }
//        System.out.println(list1.size());
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count(""); // [0, 0, 0, ......, 0]
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        for (String a: A) {
            int[] aCount = count(a);
            boolean isAdd = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) { // 任一個英文字母不符合則淘汰
                    isAdd = false;
                    break;

                }
            }
            if (isAdd) {
                ans.add(a);
            }
        }

        return ans;
    }

    public static int[] count(String S) {
        int[] ans = new int[26]; // 計算英文字母
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }


}
