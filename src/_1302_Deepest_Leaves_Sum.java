
public class _1302_Deepest_Leaves_Sum {

    public static void main(String[] args) {
//[1,2,3,4,5,null,6,7,null,null,null,null,8]
//[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//        System.out.println("Qq");
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4,
//                new TreeNode(7, null, null),
//                null),
//                new TreeNode(5,
//                        null,
//                        null)), new TreeNode(3, null, new TreeNode(6,
//                null,
//                new TreeNode(8, null, null))));

        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        root.left = t2;
        root.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = null;
        t3.right = t6;

        t4.left = t7;
        t4.right = null;

        t5.left = null;
        t5.right = null;

        t6.left = null;
        t6.right = t8;

        t7.left = null;
        t7.right = null;

        t8.left = null;
        t8.right = null;

        System.out.println(deepestLeavesSum(root));
    }

    private static int maxLevel = 0;
    private static int deepestLevelSum = 0;

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        calculateSumAtLevel(root, 0);
        return deepestLevelSum;
    }

    private static void calculateSumAtLevel(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxLevel) { // 找到更深一層，重新計算
            System.out.println("reset level:> " + level);
            deepestLevelSum = 0;
            maxLevel = level;
        }
        if (level == maxLevel) {
            System.out.println("level:> " + level + ", val:> " + root.val);
            deepestLevelSum = deepestLevelSum + root.val;
        }
        calculateSumAtLevel(root.left, level + 1);
        calculateSumAtLevel(root.right, level + 1);
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
