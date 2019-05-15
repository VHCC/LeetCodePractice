import java.util.*;

public class Text_Justification_68 {

    public static void main(String[] args) {

//        List<String> words = new ArrayList<String>() ;
        String[] words = new String[7];
        words[0] = "This";
        words[1] = "is";
        words[2] = "an";
        words[3] = "example";
        words[4] = "of";
        words[5] = "text";
        words[6] = "justification";
        System.out.println(fullJustify(words, 20));
    }

//    private static HashMap<String, Integer> resultMap = new HashMap<>() ;

    public static List<String> fullJustify(String[] words, int maxWidth) {





        List<String> result = new ArrayList<>();
        for(int index = 0; index < words.length; index ++) {
            if (index == 0) {
                result.add("\n" + "   \"" + words[index] + "\"");
            } else if (index == words.length - 1) {
                result.add("\n" + "   \"" +  words[index] + "\"\n");
            } else {
                result.add("\n" + "   \"" +  words[index] + "\"");
            }
        }

        return result;
    }

}
