public class _709_ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello, here, LOVELY"));
    }


    public static String toLowerCase(String str) {
        char[] newValue = new char[str.length()];

        for (int index = 0; index < str.length(); index ++) {
            char tempChar = str.charAt(index);
            if (tempChar >= 'A' && tempChar <= 'Z') {
                tempChar += 32;
            }

            newValue[index] = tempChar;
        }
        return String.valueOf(newValue);
    }

}
