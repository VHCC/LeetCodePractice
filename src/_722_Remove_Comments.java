import java.util.ArrayList;
import java.util.List;

public class _722_Remove_Comments {

    public static void main (String[] args){
        String[] input = new String[]{"/*Test program */", "int main()", "{ ",
                "  // variable declaration ", "int a, b, c;", "/* This is a test",
                "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//        String[] input2 = new String[]{"a/*comment", "line", "more_comment*/b", " //nono"};
        String[] input2 = new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};

//        System.out.println((int)'/'); // 47
//        System.out.println((int)'*'); // 42
//        /* = 89
//        // = 94
//        */ = 89

//        String testS = "/*Test program */";

        System.out.println(removeComments(input2));

    }

    static public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();

        StringBuffer sb = new StringBuffer();

        boolean isInBlock = false;
        boolean isInLine = false;

        for (String testS : source) {

            char preChar = '0';
            for (char s: testS.toCharArray()) {
                System.out.print(s);
                if (s == '/' && preChar == '/') {
                    System.out.println(" ,FIND:> //, FIND line comments");
                    isInLine = true;
                    sb.delete(sb.length() - 1, sb.length());
                    continue;
                } else if (s == '/' && preChar == '*') {
                    System.out.println(" , FIND:> */, end In block");
                    isInBlock = false;
                    continue;
                } else if (s == '*' && preChar == '/') {
                    if (isInBlock) {
                        preChar = s;
                        continue;
                    }
                    System.out.println(" , FIND:> /*, start In block");
                    sb.delete(sb.length() - 1, sb.length());
                    isInBlock = true;
                    continue;
                }

                if (!isInBlock) {
                    if (!isInLine) {
                        sb.append(s);
                    }
                }
                preChar = s;
            }
            isInLine = false;

            System.out.println("");

            if (!isInBlock) {
                if (sb.length() != 0 ) {
                    ans.add(sb.toString());
                }
                sb.delete(0, sb.length());
            }
        }

        return ans;
    }
}
