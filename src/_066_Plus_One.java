import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class _066_Plus_One {


    public static void main(String[] arg0) {

        int[] ints = new int[4];
        ints[0] = 4;
        ints[1] = 3;
        ints[2] = 2;
        ints[3] = 1;

        plusOne(ints);
    }

    public static int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length];

        if (digits[digits.length -1] < 9) {
            ans = digits;
            ans[ans.length -1] = digits[digits.length - 1] + 1;

            for (int k = 0; k < ans.length; k++) {
                System.out.println(ans[k]);
            }

            return ans;
        }
        ans = digits.clone();
        int i = 0;
        while (i < digits.length && ans[i] == 9) {
            i ++;
            if (i == digits.length) {
                ans = new int[digits.length + 1];
                ans[0] = 1;
            }
        }
        int j = 0;
        while (j < digits.length) {
            ans[ans.length -1 - j] = (digits[digits.length - 1 - j]  + 1 )/ 10 > 0 ? 0 : (digits[digits.length - 1 - j]  + 1 );
//            System.out.println(digits[digits.length - 1 - j]);
            if (digits[digits.length - 1 - j] != 9) {
                break;
            }
            j++;
        }

        for (int k = 0; k < ans.length; k++) {
            System.out.println(ans[k]);
        }

        return ans;
    }
}
