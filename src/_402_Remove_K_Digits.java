import java.util.Stack;

public class _402_Remove_K_Digits {

    public static void main(String[] args) {

//        String input = "14322191432219";
//        String input = "1432219143221914322191432219";
//        String input = "111111";
        String input = "12345";
//        int k = 11;
//        int k = 4;
//        int k = 3;
        int k = 2;

        System.out.println(removeKdigitsGreat(input, k));
    }

    public static String removeKdigitsGreat(String num, int k) {
        char[] arr=num.toCharArray();
        Stack<Character> s = new Stack<>();
        // 循环每个字符
        for(int i=0;i<num.length();i++){
            // 如果栈元素个数大于0并且k大于0，并且当前元素大于栈顶元素
            while(s.size()>0&&k>0&&arr[i]<s.peek()){
                s.pop(); // 栈顶元素pop出栈
                k--; // k减一
            }
            // 如果栈内元素个数为0，并且当前数字是0，跳过（前导零）
            if(s.size()==0&&arr[i]=='0') continue;
            // 将当前数字入栈
            s.push(arr[i]);
        }
        // 如果k仍大于0
        while(k>0&&s.size()>0){
            // 从栈顶pop出k个最大数
            s.pop();
            k--;
        }
        // 如果栈内元素个数为空，返回0
        if(s.size()==0) return "0";
        // 将栈内元素组成字符串返回
        StringBuilder sb=new StringBuilder();
        while(s.size()>0) sb.append(s.pop());
        sb.reverse();
        return sb.toString();
    }
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        String ans = num;
        for (int i = 0; i < k; i++) {

//            String a = ans.substring(0 + 1);
//            String b = ans.substring(0, 1) + ans.substring(2, ans.length());
//
//            long d = Math.minAns(Long.valueOf(a), Long.valueOf(b));
            ans = subCheck(ans);
//            System.out.println("a:> " + a + ", b:> " + b + ", ans:> " + ans);
        }
        System.out.println("ans:> " + ans + ", ans.length():> " + ans.length());
        int n = ans.length();
        for (int j = 0 ; j < n; j ++) {
            System.out.println("j:> " + j + ", ans:> " + (int) ans.charAt(0));
            if (ans.charAt(0) == 48) {
                ans = ans.substring(1);
//                System.out.println("ans:> " + ans);
            } else {
//                System.out.println("QQ ans:> " + ans);
                if (ans.equals("")) return "0";
                return ans;
            }
        }
        if (ans.equals("")) return "0";
        return ans;
    }

    public static String subCheck(String num) {
        for (int i = 0; i < num.length()- 1; i++) {
            if (!num.substring(i, i + 1).equals(num.substring(i + 1, i + 2))) {
                String a = num.substring(0, i) + num.substring(i + 1, num.length());
                String b = num.substring(0, i + 1) + num.substring(i + 2, num.length());
//                long d = Math.minAns(Long.valueOf(a), Long.valueOf(b));
                for (int j = 0; j< a.length(); j++) {
                    if (a.charAt(j) < b.charAt(j)) {
                        System.out.println("i:> " + i + ", a:> " + a + ", b:> " + b + ", ans:> " + a);
                        return a;
                    } else {
                        System.out.println("i:> " + i + ", a:> " + a + ", b:> " + b + ", ans:> " + b);
                        return b;
                    }
                }

//                return String.valueOf(d);
            }
//            System.out.println("===NEXT===");
        }
        return num.substring(1, num.length());
//        return num;
    }

}
