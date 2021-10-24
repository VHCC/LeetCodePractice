import java.util.ArrayList;
import java.util.List;

public class _998_Maximum_Binary_Tree_II {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(4);
//        TreeNode t2 = new TreeNode(1);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(2);
//
//        root.left = t2;
//        root.right = t3;
//
//        t3.left = t4;

//        TreeNode root = new TreeNode(5);
//        TreeNode t1 = new TreeNode(2);
//        TreeNode t2 = new TreeNode(3);
//        TreeNode t3 = new TreeNode(1);
//
//        root.left = t1;
//        root.right = t2;
//
//        t1.right = t3;

        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(1);

        root.left = t1;
        root.right = t2;

        t1.right = t3;

        System.out.println(insertIntoMaxTreeGreat(root, 3));
    }


    public static TreeNode insertIntoMaxTreeGreat(TreeNode root, int val) {

        if( root == null){
            return new TreeNode(val);
        }

        if( root.val < val ){
            TreeNode node = new TreeNode(val);
            node.left = root;
//            root = node;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);

        return root;

    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
//        System.out.println(reverseTheTreeNode(root));

        List<Integer> ans = reverseTheTreeNode(root);
        ans.add(val);
        System.out.println(ans);
        return constructMaximumBinaryTree(ans);
    }


    public static List<Integer> reverseTheTreeNode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.right == null && root.left == null) {
//            System.out.println("Add:> " + root.val);
//            result.add(root.val);
        }

        if (root.left != null) {
            result.addAll(0, reverseTheTreeNode(root.left));
        }
        result.add(root.val);

        if (root.right != null) {
            result.addAll(result.size(), reverseTheTreeNode(root.right));
        }
        return result;
    }

    public static TreeNode constructMaximumBinaryTree(List<Integer> nums) {

        return getMaxTree(nums, 0, nums.size() - 1);
    }

    public static TreeNode getMaxTree(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootIndex = findLargestIndex(nums, start, end);
        System.out.println("=== add num[" + rootIndex + "] :> " + nums.get(rootIndex) + " ===");
        TreeNode root = new TreeNode(nums.get(rootIndex));
        System.out.println("<=== Add Left");
        root.left = getMaxTree(nums, start, rootIndex - 1);
        System.out.println("Add Right ===>");
        root.right = getMaxTree(nums, rootIndex + 1, end);
        return root;
    }

    public static int findLargestIndex(List<Integer> nums, int start, int end) {
        int max = 0;
        int index = start;
        for (int i = start; i <= end; i ++) {
            if (nums.get(i) > max) {
                max = nums.get(i);
                index = i;
            }
        }
        return index;
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
