public class _151_Reverse_Words_in_a_String {

    public static void main(String[] arg0) {
//        String input = "the sky is blue";
//        String input = "  hello world  ";
        String input = "  Bob    Loves  Alice   ";
        System.out.println(reverseWordsEx(input));
    }

    public static String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        String[] splitS = s.split(" ");
//        System.out.println(splitS.length);
        for (String S : splitS) {
            if (S.length() == 0) {
//                ans.append(S, 0,5);
                continue;
            }
            ans.insert(0, S);
            System.out.println(S);
            ans.insert(0, " ");
        }
//        System.out.println(ans);
        return ans.substring(1, ans.length());
    }

    public static String reverseWordsEx(String s) {
        StringBuffer ans = new StringBuffer();
        String[] splitS = s.split(" ");
        int end = splitS.length - 1;
        for (String S : splitS) {
            if (!S.isEmpty()) {
                ans.insert(0, " " + S);
            }
        }
        return ans.toString().trim();
    }

    public static String solutionA(String s) {
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int end = words.length - 1;
        for(int i = 0; i<= end; i++){
            if(!words[i].isEmpty()) {
                sb.insert(0, words[i]);
                if(i < end) sb.insert(0, " ");
            }
        }
        return sb.toString();
    }

}
