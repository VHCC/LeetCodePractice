import java.util.List;

public class _328_Odd_Even_Linked_List {
    public static void main(String[] arg0) {
        ListNode root = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        root.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(practiceAgain(root).toString());
    }

    public static ListNode practiceAgain(ListNode head) {
        if (head != null) {
            ListNode p1 = head, p2 = head.next, pre = p2;
            while (p2 != null && p2.next != null) {
                p1.next = p2.next;
                p1 = p1.next; // change pointer head
                p2.next = p1.next;
                p2 = p2.next; // change pointer
            }
            p1.next = pre;
        }
        return head;
    }


    private static ListNode oddLastNode;
    private static ListNode searchNode;
    private static ListNode evenLastNode;
    private static ListNode tempNode;

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode resultNode = new ListNode(head.val);
        if (head.next != null) {
            resultNode.next = new ListNode(head.next.val);
        }

        searchNode = head;
        oddLastNode = resultNode;
        evenLastNode = resultNode;
//        evenLastNode = resultNode.next;
        int searchCount = 1;

        while (searchNode.next != null) { // start from index = 2; space complexity = O(N)
            searchNode = searchNode.next;
            searchCount++;
            if (searchCount%2 ==0) {
                //even
                tempNode = new ListNode(searchNode.val);
                evenLastNode.next = tempNode;
                evenLastNode = tempNode;
            } else {
                // odd
                tempNode = new ListNode(searchNode.val);
                tempNode.next = oddLastNode.next;
                oddLastNode.next = tempNode;
                oddLastNode = tempNode;
            }
        }
        return resultNode;
    }



    public static ListNode solutionGreat(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next, pre = p2;
        while (p2 != null && p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = pre;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
