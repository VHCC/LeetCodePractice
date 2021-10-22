import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _567_Permutation_in_String {
    public static void main(String[] arg0) {
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
//        String s1 = "ab";
//        String s2 = "eidbaooo";

        System.out.println("ANS:> " + checkInclusionMy(s1, s2));
    }

    public static boolean checkInclusionMy(String s1, String s2) {
        List<Integer> s1IntArray = new ArrayList<>();
        HashMap<Integer, Integer> s1Map = new HashMap<>();

        List<Integer> s2IntArray = new ArrayList<>();
        HashMap<Integer, Integer> s2Map = new HashMap<>();

        int s1Total = 0;
        int s2Total = 0;
        boolean isContained = false;

        for (char s : s1.toCharArray()) {
            s1IntArray.add((int) s);
            s1Map.put((int) s, s1Map.get((int) s) == null ? 1 : s1Map.get((int) s) + 1);
            s1Total += (int) s;
        }

        for (char s : s2.toCharArray()) {
            s2IntArray.add((int) s);
        }
        System.out.println(s1IntArray + ", s1Total:> " + s1Total);
        System.out.println(s2IntArray);

        int count = 1;
        for (int index = 0; index < s2IntArray.size(); index++) {
            if (count == s1IntArray.size()) {
                s2Total += s2IntArray.get(index);
                s2Map.put(s2IntArray.get(index), s2Map.get(s2IntArray.get(index)) == null ? 1 : s2Map.get(s2IntArray.get(index)) + 1);
                if (index != s1IntArray.size() -1 ) {
                    int preIndex = index - s1IntArray.size();
                    s2Total -= s2IntArray.get(preIndex);
                    if (s2Map.get(s2IntArray.get(preIndex)) == 1) {
                        s2Map.remove(s2IntArray.get(preIndex));
                    } else {
                        s2Map.put(s2IntArray.get(preIndex), s2Map.get(s2IntArray.get(preIndex)) == null ? 1 : s2Map.get(s2IntArray.get(preIndex)) - 1);
                    }
                }
                System.out.println("count:> " + count + ", s2Total:> " + s2Total + ", index:> " + index);
                if (s1Total == s2Total && s1Map.keySet().equals(s2Map.keySet())) {
                    System.out.println(s1Map);
                    System.out.println(s2Map);
                    System.out.println(s2Map.values());
                    System.out.println(s1Map.keySet());
                    System.out.println(s1Map.keySet().equals(s2Map.keySet()));
                    return true;
                }
            } else {
//                System.out.println("s2Map.get(s2IntArray.get(index)):> " + s2Map.get(s2IntArray.get(index)));
                s2Map.put(s2IntArray.get(index), s2Map.get(s2IntArray.get(index)) == null ? 1 : s2Map.get(s2IntArray.get(index)) + 1);
                s2Total += s2IntArray.get(index);
                count ++;
            }
        }

        return isContained;
    }

    public static boolean checkInclusion(String s1, String s2) {
        List<Integer> s1IntArray = new ArrayList<>();
        HashMap<Integer, Integer> s1Map = new HashMap<>();

        List<Integer> s2IntArray = new ArrayList<>();
        HashMap<Integer, Integer> s2Map = new HashMap<>();

        int s1Total = 0;
        int s2Total = 0;
        boolean isContained = false;

        for (char s : s1.toCharArray()) {
            s1IntArray.add((int) s);
            s1Map.put((int) s, s1Map.get((int) s) == null ? 1 : s1Map.get((int) s) + 1);
            s1Total += (int) s;
        }

        for (char s : s2.toCharArray()) {
            s2IntArray.add((int) s);
        }

        int count = 1;
        for (int index = 0; index < s2IntArray.size(); index++) {
            if (count == s1IntArray.size()) {
                s2Total += s2IntArray.get(index);
                s2Map.put(s2IntArray.get(index), s2Map.get(s2IntArray.get(index)) == null ? 1 : s2Map.get(s2IntArray.get(index)) + 1);
                if (index != s1IntArray.size() -1 ) {
                    int preIndex = index - s1IntArray.size();
                    s2Total -= s2IntArray.get(preIndex);
                    if (s2Map.get(s2IntArray.get(preIndex)) == 1) {
                        s2Map.remove(s2IntArray.get(preIndex));
                    } else {
                        s2Map.put(s2IntArray.get(preIndex), s2Map.get(s2IntArray.get(preIndex)) == null ? 1 : s2Map.get(s2IntArray.get(preIndex)) - 1);
                    }
                }
                if (s1Total == s2Total && s1Map.keySet().equals(s2Map.keySet())) {
                    return true;
                }
            } else {
                s2Map.put(s2IntArray.get(index), s2Map.get(s2IntArray.get(index)) == null ? 1 : s2Map.get(s2IntArray.get(index)) + 1);
                s2Total += s2IntArray.get(index);
                count ++;
            }
        }
        return isContained;
    }

    public boolean solutionGreat (String s1, String s2) { // O(1)
        if(s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(arr1, arr2)) return true;

        int front = 0;
        int back = s1.length();
        while(back < s2.length()){
            arr2[s2.charAt(front) - 'a']--;
            arr2[s2.charAt(back) - 'a']++;

            if(Arrays.equals(arr1, arr2)) return true;
            front++;
            back++;
        }
        return false;
    }
}

// If one string is a permutation of another string then they must one common metric. What is that?
