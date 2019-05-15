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

        List<String> aaa = new ArrayList<>();
        for(int index = 0; index < words.length; index ++) {
//            System.out.println(words[index] + ", length= " + words[index].length());
//            resultMap.put(words[index], words[index].length());
            aaa.add(words[index] );
        }



        return aaa;
    }
}
