public class _066_Plus_One {


    public static void main(String[] arg0) {

//        int[] givenArray = new int[]{4,3,2,1};
//        int[] givenArray = new int[]{1, 0, 0, 0, 0};
//        int[] givenArray = new int[]{1,2,3,4};
//        int[] givenArray = new int[]{1,3,9,9};
        int[] givenArray = new int[]{9, 9, 9, 9};


        for (int i : plusOne2(givenArray)) {
            System.out.println(i + ", ");
        }
    }

    public static int[] plusOne2(int[] givenArray) {
        int carry = 1;
        int[] ans = new int[givenArray.length];

        for (int i = givenArray.length - 1; i >= 0; i--) {
            int result = givenArray[i] + carry;
            if (carry == 1 && result % 10 == 0) {
                ans[i] = 0;
                carry = 1;
            } else {
                carry = 0;
                ans[i] = result;
            }

        }
        if (carry == 1) {
            int[] newAns = new int[givenArray.length + 1];
            newAns[0] = 1;
            for (int j = 0; j < ans.length; j++) {
                newAns[j + 1] = ans[j];
            }
            return newAns;
        }
        return ans;
    }

    public static int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length];

        if (digits[digits.length - 1] < 9) {
            ans = digits;
            ans[ans.length - 1] = digits[digits.length - 1] + 1;

            for (int k = 0; k < ans.length; k++) {
                System.out.println(ans[k]);
            }

            return ans;
        }
        ans = digits.clone();
        int i = 0;
        while (i < digits.length && ans[i] == 9) {
            i++;
            if (i == digits.length) {
                ans = new int[digits.length + 1];
                ans[0] = 1;
            }
        }
        int j = 0;
        while (j < digits.length) {
            ans[ans.length - 1 - j] = (digits[digits.length - 1 - j] + 1) / 10 > 0 ? 0 : (digits[digits.length - 1 - j] + 1);
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
