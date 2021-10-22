import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _372_Super_Pow {

    public static final int MOD = 1337;

    public static void main(String[] arg0) {
        int a = Integer.MAX_VALUE;
        int[] b = {2,0,0};
        System.out.println(superPow(a,b));
    }

    public static int superPow(int a, int[] b) {
        if (a == 0) return a;
        if (b.length == 0) return 1;
        a = a % MOD;
        int res = powMod(a, b[0]);
        for(int i = 1; i < b.length; i++)
            res = (powMod(res, 10) * powMod(a, b[i])) % MOD;
        return res;
    }

    public static int powMod(int a, int b) {
        if(b == 0) return 1;
        a = a % MOD;
        int res = a;
        for(int i = 1; i < b; i++)
            res = res * a % MOD;
        return res;
    }

}
