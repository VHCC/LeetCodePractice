public class _226_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);

        root.left = t2;
        root.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        System.out.println("Node:> " + root.val);
        TreeNode temp = new TreeNode(0);
        boolean isLeftDone = false;
        boolean isRightDone = false;

        if (root.left == null) isLeftDone = true;
        if (root.right == null) isRightDone = true;

        if (!isLeftDone) {
            System.out.println("<====Left");
            invertTree(root.left);
            isLeftDone = true;
        }

        if (!isRightDone) {
            System.out.println("Right====>");
            invertTree(root.right);
            isRightDone = true;
        }

        if (isLeftDone && isRightDone) {
            if (root.left != null && root.right != null) {
                System.out.println("Node:> " + root.val + ", left:> " + root.left.val + ", right:> " + root.right.val);
            }
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null && root.right != null) {
                System.out.println("***Change*** Node:> " + root.val + ", left:> " + root.left.val + ", right:> " + root.right.val);
            }
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
