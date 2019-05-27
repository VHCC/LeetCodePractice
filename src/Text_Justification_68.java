import java.util.*;

public class Text_Justification_68 {

    public static void main(String[] arg0) {

        //        List<String> words = new ArrayList<String>() ;
        String[] words = new String[7];
        words[0] = "This";
        words[1] = "is";
        words[2] = "an";
        words[3] = "example";
        words[4] = "of";
        words[5] = "text";
        words[6] = "justification";
        result(words, 16);
    }

    private static void result(String[] words, int L) {
        List<String> ans = new ArrayList<String>();

        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = words[i].length();
            int j = i + 1;
            while (j < n && len + 1 + words[j].length() <= L) {
                len += 1 + words[j].length();
                j++;
            }
            System.out.println("i= " + i + ", j= " + j + ", n= " + n);

            String line = words[i];
            if (j == n) { // if this is the last line, the corner case.
                for (int k = i + 1; k < n; k++) {
                    line += " " + words[k];
                }
                while (line.length() < L) {
                    line += " ";
                }
            } else {
                int extraWhite = L - len;
                int whiteNum = j - i - 1;
                System.out.println("extraWhite= " + extraWhite);
                System.out.println("whiteNum= " + whiteNum);

                if (whiteNum == 0) { // if this line has only one word
                    while (line.length() < L) {
                        line += " ";
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        line += " ";
                        for (int p = 0; p < extraWhite/whiteNum; p++) {
                            line += " ";
                        }
                        if (k - i <= extraWhite%whiteNum) {
                            line += " ";
                        }
                        line += words[k];
                    }
                }
            }
            ans.add(line);

            i = j;
        }
        System.out.println(ans);
//        return ans;
    }

}
