public class _029_Divide_Two_Integers {

    public static void main(String[] arg0) {

        System.out.println(solutionA ());
    }

    public static int solutionC () {
        int dividend = -2147483648;
        int divisor = -1;
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                System.out.println("tmp:> " + tmp + ", tmp >> 1 = " + (tmp >> 2));
                System.out.println("count:> " + count + ", count >> 1 = " + (count >> 2));
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    public int solutionB () {
        int dividend = -2147483648;
        int divisor = -1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow

        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }

    public static int solutionA () {
        int dividend = 72;
        int divisor = 5;

        long ans = 0;
        boolean isMinus = false;

        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            isMinus = true;
        }

        long Dividend = Math.abs((long) dividend);

        long Divisor = Math.abs((long) divisor);

        while (Dividend >= Divisor) {
            long temp = Divisor;
            long cnt = 1;
            while (Dividend >= temp) {
                System.out.println("===");
                System.out.println("cnt:> " + cnt);
                System.out.println("temp:> " + temp);
                Dividend -= temp;
                System.out.println("Dividend:> " + Dividend);
                ans += cnt;
                System.out.println("ans:> " + ans);
                cnt <<= 1;
                temp <<= 1;
            }
        }

        if (isMinus) {
            ans = -ans;
        }

        long INT_MIN = -(1 << 31);

        long INT_MAX = (1 << 31) - 1;

        if (ans < INT_MIN || ans > INT_MAX) {
            ans = INT_MAX; // For this problem, assume that your function returns 231 − 1 when the division result overflows.
        }

        System.out.println(ans);
        return (int) ans;
    }
}
