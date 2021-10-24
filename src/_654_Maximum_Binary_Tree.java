import java.util.HashMap;
import java.util.Stack;

public class _654_Maximum_Binary_Tree {

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

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        System.out.println(constructMaximumBinaryTree(nums));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return getMaxTree(nums, 0, nums.length - 1);
    }

    public static TreeNode getMaxTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootIndex = findLargestIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = getMaxTree(nums, start, rootIndex - 1);
        root.right = getMaxTree(nums, rootIndex + 1, end);
        return root;
    }

    public static int findLargestIndex(int[] nums, int start, int end) {
        int max = 0;
        int index = start;
        for (int i = start; i <= end; i ++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static TreeNode getMaxTreeMy(int[] nums, int start, int end) {
//        System.out.println("start:> " + start + ", end:> " + end);
        if (start > end) {
            return null;
        }
        int rootIndex = findLargestIndexMy(nums, start, end);
        System.out.println("=== add num[" + rootIndex + "] :> " + nums[rootIndex] + " ===");
        TreeNode root = new TreeNode(nums[rootIndex]);
        System.out.println("<=== Add Left");
        root.left = getMaxTreeMy(nums, start, rootIndex - 1);
        System.out.println("Add Right ===>");
        root.right = getMaxTreeMy(nums, rootIndex + 1, end);
        return root;
    }

    public static int findLargestIndexMy(int[] nums, int start, int end) {
        int max = 0;
        int index = start;
        for (int i = start; i <= end; i ++) {
//            System.out.println("nums[i]:> " + nums[i] + ", max:> " + max);
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
//        System.out.println("start:> " + start + ", end:> " + end + ", maxIndex:> " + index);
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
