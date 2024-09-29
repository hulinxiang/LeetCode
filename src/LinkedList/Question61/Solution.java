package LinkedList.Question61;

public class Solution {

    public class ListNode {
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
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = calLen(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k - 1; i++) {
            end = end.next;
        }
        ListNode pre = dummy;
        while (end.next != null) {
            end = end.next;
            start = start.next;
            pre = pre.next;
        }
        end.next = dummy.next;
        dummy.next = start;
        pre.next = null;
        return dummy.next;
    }

    public int calLen(ListNode head) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

}
