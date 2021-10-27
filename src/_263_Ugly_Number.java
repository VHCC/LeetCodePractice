public class _263_Ugly_Number {

    public static void main(String[] args) {
        int input = -1000;
        System.out.println("input:> " + input);
        System.out.println(isUgly(input));
    }

    static int[] primes = new int[]{2,3,5};

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        for (int prime : primes) {
            if (n%prime == 0) {
                if(isUgly(n/prime)) {
                    return true;
                }
            }
        }

        return false;
    }
}
