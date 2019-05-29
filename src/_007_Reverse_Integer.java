public class _007_Reverse_Integer {

    public static void main(String[] arg0) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        long ans = 0;

        while(x != 0) {
            ans = ans * 10  + x%10;
            x /= 10;
        }

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }

        System.out.println((int)ans);

        return 0;
    }
}
