import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class _932_Beautiful_Array {
    public static void main(String[] arg0) {


//        int n = 1; // [1]
//        int n = 2; // [1,2]
//        int n = 3; // [1,3,2]
//        int n = 4; // [1,3,2]
//        int n = 4; // [1,3,2,4]
//        int n = 25; // [1,9,5,3,7,2,6,4,8]
//        int n = 15; // [1,9,5,13,3,11,7,15,2,10,6,14,4,12,8]
//        int n = 10; // [1,9,5,3,7,2,10,6,4,8]
        beautifulArray(10);
    }

    public static int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int count = 0;
        while (ans.size() < n) {
            System.out.println(" === Loop === ");
            List<Integer> t = new ArrayList<>();
            for (int num : ans) {
//                System.out.println("check1:> " + num);
                if (num * 2 - 1 <= n) {
                    count ++;
                    System.out.println("add odd:> " + (num * 2 - 1));
                    t.add((num * 2 - 1));
                }
            }
            for (int num : ans) {
//                System.out.println("check2:> " + num);
                if (num * 2 <= n) {
                    count ++;
                    System.out.println("add even:> " + (num * 2));
                    t.add((num * 2));
                }
            }
            ans = t;
            System.out.println("ans:> " + ans);
        }
        System.out.println(ans);
        System.out.println("count:> " + count);

        int[] res = new int[ans.size()];
        for (int index = 0; index < ans.size(); index++) {
            res[index] = ans.get(index);
        }

        return res;
    }

    public int[] beautifulArrayGreat(int n) {
        int[] answer = new int[n];
        if(n == 1) {
            answer[0] = 1;
            return answer;
        }
        int[] right =beautifulArray(n/2);
        int[] left = beautifulArray((n+1)/2);

        for(int i=left.length; i<n; i++) {      //This loop adds all even elements at end
            answer[i] = right[i-left.length] * 2;
        }
        for(int i=0; i<left.length; i++) {      //This loop adds all odd elements at start
            answer[i] = left[i] * 2 - 1;
        }
        return answer;
    }
}

//nums is a permutation of the integers in the range [1, n].
//For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
