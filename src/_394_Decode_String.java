import java.util.ArrayList;
import java.util.List;

public class _394_Decode_String {


    public static void main(String[] args) {
        String input = "abc3[cd]xyz";
//        String input = "3[a2[c]]4[b5[d]]";
//        String input = "abc";

        System.out.println(decodeString(input));
    }

    static public String decodeString(String s) {
//        System.out.println((int) '1'); // 49
//        System.out.println((int) '9'); // 57

        List<String> ans = new ArrayList<>();

        boolean isStartSquare = false;
        int countMultiSquare = 0;
        boolean startCount = false;
        int multiCount = 0;
        StringBuffer snippet = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                if (isStartSquare) {
                    countMultiSquare++;
                    snippet.append(c);
                }
//                ans.add(snippet.toString());
//                snippet.delete(0, snippet.length());
                isStartSquare = true;
                continue;
            }
            if (c == ']') {
                System.out.println("countMultiSquare:> " + countMultiSquare);
                if (countMultiSquare > 0) {
                    countMultiSquare--;
                    snippet.append(c);
                    continue;
                }
                System.out.println("multiCount:> " + multiCount);
                String tempSnippet = "";
                for (int i = 0; i < multiCount; i ++) {
                    tempSnippet += snippet;
                }

                ans.add(tempSnippet.toString());
                snippet.delete(0, snippet.length());
                isStartSquare = false;
                startCount = false;
                continue;
            }
            if (c >= 47 && c <= 57) {

                if (!isStartSquare) {
                    if (snippet.length() > 0) {
                        ans.add(snippet.toString());
                        snippet.delete(0, snippet.length());
                    }

                }

                if (startCount) {
                    if (!isStartSquare) {
                        multiCount = (multiCount * 10) + Integer.valueOf(String.valueOf(c));
                    } else {
                        snippet.append(c);
                    }
//
                    continue;
                }


                multiCount = Integer.valueOf(String.valueOf(c));
                startCount = true;
                System.out.println("constants:> " + c);
//                snippet.append(multiCount);
                continue;
            }
            snippet.append(c);
        }

        if (snippet.length() > 0) {
            ans.add(snippet.toString());
        }
        System.out.println(ans);

        String ansString = "";
        for (String ss : ans) {
            ansString += ss;
        }
        if (ansString.contains("[")) {
            ansString = decodeString(ansString);
        }

        return ansString;
    }
}
