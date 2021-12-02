import java.util.HashMap;
import java.util.Stack;

public class _129_Sum_Root_to_Leaf_Numbers {


    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        TreeNode r1 = new TreeNode(2);
//        TreeNode r2 = new TreeNode(3);

//        root.left = r1;
//        root.right = r2;


        TreeNode root = new TreeNode(4);
//        TreeNode r1 = new TreeNode(9);
//        TreeNode r2 = new TreeNode(0);
//        TreeNode r3 = new TreeNode(5);
//        TreeNode r4 = new TreeNode(1);
//        TreeNode r5 = new TreeNode(3);
//        TreeNode r6 = new TreeNode(9);
//
//        root.left = r1;
//        root.right = r2;
//
//        r1.left = r3;
//        r1.right = r4;
//
//        r2.left = r5;
//        r2.right = r6;

        System.out.println(sumNumbers(root));
    }



    static public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) {
            return root.val;
        }

        Stack<Integer> rootPath = new Stack<>();
        rootPath.push(root.val);

        if (root.left != null) {
            findLeaf(root.left, rootPath);
        }
        if (root.right != null) {
            findLeaf(root.right, rootPath);
        }
        System.out.println(pathMap);



        int total = 0;
        for (Stack path: pathMap.values()) {
            System.out.println(path);

            String num = "";

            while(!path.empty()) {
                num = path.pop().toString() + num;
            }

            if (Integer.valueOf(num) > Integer.MAX_VALUE) {
                total = Integer.MAX_VALUE;
                break;
            }
            total += Integer.valueOf(num);
            if (total > Integer.MAX_VALUE) {
                total = Integer.MAX_VALUE;
                break;
            }
        }
//        System.out.println();

        return total;
    }

    static HashMap<Integer, Stack<Integer>> pathMap = new HashMap();
    static int resultCount = 0;

    static public void findLeaf(TreeNode root, Stack<Integer> path) {
        path.push(root.val);
        if (root.left == null && root.right == null) {
            Stack<Integer> ans = new Stack<>();
            ans.addAll(path);
            pathMap.put(resultCount++, ans);
            path.pop();
            return;
        }

        if (root.left != null) {
            findLeaf(root.left, path);
        }
        if (root.right != null) {
            findLeaf(root.right, path);
        }
        path.pop();
        return;
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
