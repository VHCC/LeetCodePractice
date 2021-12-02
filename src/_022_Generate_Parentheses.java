import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _022_Generate_Parentheses {

    public static void main(String[] args) {

        int size = 3;

//        String a = "((()))";
//        a = a.substring(0, 3) + "(1)" + a.substring(3, a.length());
//        System.out.println(a);

        System.out.println(generateParenthesisGreat(3));
    }


    static public List<String> generateParenthesisGreat(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    static public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            System.out.println("open:> " + open + ", close:> " + close + ", str:> " + str);
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    static public List<String> generateParenthesis(int size) {
        List<String> ans = new ArrayList<>();
        Set<String> repeatsSet = new HashSet<>();
        backTracking(size, ans, "", repeatsSet, 0);
        return ans;
    }

    static public void backTracking(int size, List<String> ans, String tempString, Set<String> repeatsSet, int start) {
        System.out.println("start:> " + start + ", tempString:> " + tempString);
        if (start == size) {
            return;
        }
        tempString = tempString.substring(0, start) + "()" + tempString.substring(start, tempString.length());
        ans.add(tempString);
        for (int i = start; i < size; i++) {
            backTracking(size, ans, tempString, repeatsSet, i + 1);
            tempString = tempString.concat("()");
        }
    }

}
