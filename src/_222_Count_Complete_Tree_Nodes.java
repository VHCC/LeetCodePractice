
import java.util.HashMap;

public class _222_Count_Complete_Tree_Nodes {
    public static void main(String[] args){

//        [1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

//        root.left = t2;
//        root.right = t3;
//
//        t2.left = t4;
//        t2.right = t5;
//
//        t3.left = null;
//        t3.right = t6;
//
//        t4.left = t7;
//        t4.right = null;
//
//        t5.left = null;
//        t5.right = null;
//
//        t6.left = null;
//        t6.right = t8;

//        t7.left = null;
//        t7.right = null;
//
//        t8.left = null;
//        t8.right = null;

        root.left = t2;
        root.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

//        System.out.println(countNodesGreat(root));
        System.out.println(countNodesGreat(root));
        System.out.println("timeCount:> " + timeCount);
//        System.out.println(visitedMap);
    }


    public static int countNodesGreat(TreeNode root) {
        if (root == null) {
            return 0;
        }
        timeCount++;
        System.out.println("node:> " + root.val);
        int l = leftHeight(root.left);
        int r = leftHeight(root.right);
        if (l == r) { // left side is full
            System.out.println("(1<<l):> " + (1<<l));
            int result = countNodesGreat(root.right) + (1<<l);
            return result;
        }
        System.out.println("(1<<r):> " + (1<<r));
        int result = countNodesGreat(root.left) + (1<<r);
        return result;
    }

    private static int leftHeight(TreeNode node) {
        timeCount++;
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        System.out.println("h:> " + h);
        return h;
    }



    public static HashMap<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
    public static int count = 0;
    public static int timeCount = 0;

    public static int countNodesMy(TreeNode root) {
        timeCount++;
        if (root == null || (visitedMap.get(root.hashCode()) == null ? false : visitedMap.get(root.hashCode()))) return count;
        System.out.println("node val:> " + root.val);
        count++;
        visitedMap.put(root.hashCode(), true);
        System.out.println(visitedMap);
        System.out.println("root.left:> " + root.left);
        System.out.println("root.left != null:> " + root.left == null);
        while(root.left != null && (visitedMap.get(root.left.hashCode()) == null ? true : !visitedMap.get(root.left.hashCode()))) {
            countNodesMy(root.left);
            System.out.println("next val:> " + root.val);
        }
        System.out.println("left done, node val:> " + root.val);
        while(root.right != null && (visitedMap.get(root.right.hashCode()) == null ? true : !visitedMap.get(root.right.hashCode()))) {
            countNodesMy(root.right);
        }
        System.out.println("right done, node val:> " + root.val);
        return count;
    }

    public static int countNodes(TreeNode root) {
        if (root == null || (visitedMap.get(root.hashCode()) == null ? false : visitedMap.get(root.hashCode()))) return count;
        count++;
        visitedMap.put(root.hashCode(), true);
        while(root.left != null && (visitedMap.get(root.left.hashCode()) == null ? true : !visitedMap.get(root.left.hashCode()))) {
            countNodes(root.left);
        }
        while(root.right != null && (visitedMap.get(root.right.hashCode()) == null ? true : !visitedMap.get(root.right.hashCode()))) {
            countNodes(root.right);
        }
        return count;
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
