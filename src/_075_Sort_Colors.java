import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _075_Sort_Colors {
    public static void main(String[] args) {
        int[] input = new int[]{2,0,2,1,1,0};
        sortColors(input);
        System.out.println();
    }

    static HashMap<Integer, Integer> set;
    static List<Integer> ans;
    public static void sortColors(int[] nums) {
        ans = new ArrayList<>();
        set = new HashMap<>();
        set.put(0,0);
        set.put(1,0);
        set.put(2,0);
        System.out.println(set);

        for (int n : nums) {
            System.out.println("n:> " + n + ", set.get(" + n + "):> " + set.get(n));
            switch (n) {
                case 0:
                    ans.add(set.get(n), n);
                    break;
                case 1:
                    ans.add(set.get(0), n);
                    break;
                case 2:
                    ans.add(set.get(0) + set.get(1), n);
                    break;
            }

            set.put(n, set.get(n)+1);
            System.out.println(ans);
        }
        System.out.println(set);
        System.out.println(ans);

        int[] newArray = new int[nums.length];
        for (int i = 0; i< nums.length; i++){
            newArray[i] = ans.get(i);
        }

        for (int a: newArray ) {
            System.out.println("a:> " + a);
        }
    }


}
