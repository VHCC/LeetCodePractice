import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _113_Path_Sum_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);

        root.left = t2;
        root.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;

        t4.left = t7;
        t4.right = t8;

        t6.left = t9;
        t6.right = t10;

        System.out.println(pathSum(root, 22));
    }


    public static List<List<Integer>> pathSumGreat(TreeNode root, int sum) {
        if (root == null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }

    private static List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public static void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        System.out.println("node:> " + root.val);
        path.push(root.val);
        if (root.left == null && root.right == null) {
            System.out.println("path:> " + path);
            if (sum == root.val) {
                System.out.println("add path:> " + path);
                resultList.add(new ArrayList<Integer>(path));
            }
        }// deepest edge case.

        if (root.left != null) pathSumInner(root.left, sum - root.val, path);
        System.out.println("go right:>>>" + ", node:> " + root.val);
        if (root.right != null) pathSumInner(root.right, sum - root.val, path);
        path.pop();
    }


    public static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        Stack<Integer> path = new Stack<>();
        getPathInner(root, targetSum, path);
        return ans;
    }

    public static void getPathInner(TreeNode root, int targetSum, Stack path) {
        path.push(root.val);
        if (root.left == null && root.right == null) { // deepest node
            System.out.println("targetSum:> " + targetSum + ", path:> " + path);
            if (root.val == targetSum) {
                System.out.println("add:> " + path);
                ans.add(new ArrayList<Integer>(path));
            }
        }

        if (root.left != null) {
            getPathInner(root.left, targetSum - root.val, path);
        }
        if (root.right != null) {
            getPathInner(root.right, targetSum - root.val, path);
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
