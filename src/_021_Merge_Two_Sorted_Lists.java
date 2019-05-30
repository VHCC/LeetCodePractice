public class _021_Merge_Two_Sorted_Lists {

    public static void main(String[] arg0) {

        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(4);

        ListNode a2 = new ListNode(1);
        a2.next = new ListNode(3);
        a2.next.next = new ListNode(4);

        ListNode dummyHead = new ListNode(0);
//        mergeTwoLists(a1, a2);
        mergeTwoListsMaster(a1, a2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans; // indicator
        ListNode p = l1;
        ListNode q = l2;

        while (p != null || q != null) {
            if (p == null && q == null) {
                break;
            }
            int x = (p != null) ? p.val : 999;
            int y = (q != null) ? q.val : 999;
            System.out.println("x= " + x + ", y= " + y);
            if (x > y || x == y) {
                curr.next = new ListNode(y);
                curr = curr.next;
                if (q.next != null) {
                    q = q.next;
                } else {
                    q = null;
                }
            } else if (y > x) {
                curr.next = new ListNode(x);
                curr = curr.next;
                if (p.next != null) {
                    p = p.next;
                } else {
                    p = null;
                }
            }
        }
        return ans.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoListsMaster(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode runner = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                runner.next = l1;
                l1 = l1.next;
            }
            else{
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        while(l1 != null){
            runner.next = l1;
            runner = runner.next;
            l1 = l1.next;
        }
        while(l2 != null){
            runner.next = l2;
            runner = runner.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
