public class _1325_Delete_Leaves_With_a_Given_Value {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);

        root.left = t2;
        root.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;


        System.out.println(removeLeafNodes(root, 2));

    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        System.out.println("node:> " + root.val);



        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }

        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        // first consider deepest situation
        if (root.left == null && root.right == null && root.val == target) {
            System.out.println("remove:> " + root.val);
            root = null;
            return null;
        }

        return root;
    }

    public static TreeNode removeLeafNodesMy(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        // first consider deepest situation
        if (root.left == null && root.right == null && root.val == target) {
            root = null;
            return null;
        }

        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }

        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        return root;
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
