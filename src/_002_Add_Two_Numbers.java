public class _002_Add_Two_Numbers {

    public static void main(String[] arg0) {

        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(7);
        a1.next.next.next = new ListNode(9);
        a1.next.next.next.next = new ListNode(3);

        ListNode a2 = new ListNode(5);
        a2.next = new ListNode(6);
        a2.next.next = new ListNode(4);
        a2.next.next.next = new ListNode(9);

        addTwoNumbers(a1, a2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        ListNode a = l1;
        ListNode b = l2;
        boolean isCarry = false;

        while (a != null || b != null) {
            int x = (a != null) ? a.val : 0;
            int y = (b != null) ? b.val : 0;

            int calcs = isCarry ? (x+y + 1) : (x+y);

            isCarry = calcs / 10 > 0 ? true : false;
            System.out.println("x= " + x + ", y= " + y + ", calc= " + calcs%10 + ", isCarry= " + isCarry);
            curr.next = new ListNode(calcs%10);
            curr = curr.next;

            if (a != null) a = a.next;
            if (b != null) b = b.next;

        }

        if (isCarry) {
            curr.next = new ListNode(1);
        }


        return ans.next;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
