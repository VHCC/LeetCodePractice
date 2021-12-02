import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _089_Gray_Code {

    static public void main(String[] args) {
        int n = 2;

        int mask = Integer.parseInt("1011", 2);
        int ans  = Integer.parseInt("1101", 2);
        System.out.println(ans ^ mask);

        System.out.println(grayCodeGreat(n));
    }


    public static List<Integer> grayCodeGreat(int n) {
        List<Integer> code = new ArrayList<Integer>();
        code.add(0);
        genCodes(code, n, 0, 1 << n);
        return code;
    }

    public static void genCodes(List<Integer> code, int n, int curr, int size) {
//        System.out.println("size:> " + size);
        if (code.size() == size) return;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            int el = (curr ^ mask);
            System.out.println("curr:> " + curr + ", mask:> " + mask + ", el:> " + el);
            if (!code.contains(el)) {
                System.out.println("ADD:> " + el);
                code.add(el);
                genCodes(code, n, el, size);
                if (code.size() == size) return;
                code.remove(new Integer(el));
            }
        }
    }


    static public List<Integer> grayCode(int n) {
        char[] nums = new char[]{'0', '1'};
        List<StringBuffer> ans = new ArrayList<>();
        Set<List<Integer>> repeatsSet = new HashSet();
        backTracking(ans, new StringBuffer(), nums, n, 0);
        System.out.println(ans);
//        int foo = Integer.parseInt("1001", 2);
//        System.out.println(foo);
        return null;
    }

    static public void backTracking(List<StringBuffer> ans, StringBuffer tempString, char[] nums, int n, int start) {
        System.out.println("tempString:> " + tempString);
//        System.out.println(repeatsSet);
//        if (!repeatsSet.contains(tempList)){
//        if (tempList.size() < n) {
//            ans.add(new ArrayList<>(tempList));
//        }
//        System.out.println("tempString:> " + tempString + ", length:> " + tempString.length());
        if (tempString.length() == n) {
//            System.out.println("ADD tempString:> " + tempString + ", length:> " + tempString.length());
            ans.add(new StringBuffer(tempString));
//            System.out.println(ans);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            System.out.println("nums[i]:> " + nums[i]);
            tempString.append(nums[i]);
            System.out.println("origin:> " + tempString + ", tempString.length():> " + tempString.length());
            backTracking(ans, tempString, nums, n, i);
            tempString = new StringBuffer(tempString.substring(0, tempString.length() - 1));
            System.out.println("after sub:> " + tempString);
        }
    }
}
