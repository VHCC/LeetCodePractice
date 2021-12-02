public class _430_Flatten_a_Multilevel_Doubly_Linked_List {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        root.next = n2;
        root.child = n3;


        System.out.println(flatten(root));
    }


    public Node flattenGreat(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node tail = findTail(curr.child);// 找最後一個點
                if (curr.next != null) { // 如果有右邊
                    curr.next.prev = tail; // 連結右邊點的pre
                }

                tail.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node findTail(Node child) {
        while (child.next != null) {
            child = child.next;
        }
        return child;
    }

    public static Node flatten(Node root) {
        if (root == null) return root;
        return findNextNode(root, null);
    }

    public static Node findNextNode(Node root, Node preRight) {
//        System.out.println("root:> " + root.val + ", preNode:> " + preRight.val);
        if (root.next == null && root.child == null) {
            root.next = preRight;
            System.out.println("==lastNode==");
            return root;
        }
        if (root.next != null) {
            root.next = findNextNode(root.next, preRight);
        }

        if (root.child != null) {
            root.next = findNextNode(root.child, root.next);
        } else {
            root.next = findNextNode(root.next, preRight);
        }
        if (preRight != null) {
            preRight.prev = root;
        }
        return root;
    }


    public static class Node {
        public int val;

        public Node prev;
        public Node next;
        public Node child;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            String stringResult = "";
            stringResult += this.val;
            if (this.next != null) {
                stringResult += ", " + this.next.toString();
            }
            return stringResult;
        }

    }
}
