import java.util.*;

public class _894_All_Possible_Full_Binary_Trees {
    public static void main(String[] args) {

        System.out.println(allPossibleFBTMy(19).size());
    }

    static List<TreeNode> ans = new ArrayList<>();


    static Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();

        //n is even
        //when n is even, can't have any FBT
        if (N % 2 == 0) {
            return res;
        }
        if (cache.containsKey(N)) {
//            System.out.println("get cache, N:> " + N);
            return cache.get(N);
        }
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        N = N - 1;
        for (int i = 1; i < N; i += 2) { // Deepest-First
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
//            System.out.println("get right done ===>");
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        cache.put(N + 1, res);
        System.out.println("add cache:> " + (N +1) + ", res:> " + res.size());
        return res;
    }


    public static HashMap<Integer, List<TreeNode>> cacheMy;

    public static List<TreeNode> allPossibleFBTMy(int n) {
        cacheMy = new HashMap<>();
        return solutionMy(n);
    }

    public static List<TreeNode> solutionMy(int nodeNumber) {
        List<TreeNode> ans = new ArrayList<>();
        //n is even
        //when n is even, can't have any FBT
        if (nodeNumber % 2 == 0) {
            return ans;
        }

        if (cacheMy.containsKey(nodeNumber)) {
//            System.out.println("get cache, nodeNumber:> " + nodeNumber);
            return cacheMy.get(nodeNumber);
        }

        if (nodeNumber == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        nodeNumber -= 1;

        for (int index = 1; index < nodeNumber; index += 2) {
            List<TreeNode> leftList = solutionMy(index);
            List<TreeNode> rightList = solutionMy(nodeNumber - index);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode checkNode = new TreeNode(0);
                    checkNode.left = left;
                    checkNode.right = right;
                    ans.add(checkNode);
                }
            }
        }

        cacheMy.put(nodeNumber + 1, ans);
        System.out.println("add cache:> " + (nodeNumber +1) + ", res:> " + ans.size());
        return ans;


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
