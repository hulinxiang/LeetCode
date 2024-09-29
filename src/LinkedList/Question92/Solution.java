package LinkedList.Question92;

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode post = start.next;
        for (int i = 0; i < right - left; i++) {
            //pre 是不动的，start一直往前，以实现头插法
            start.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = start.next;
        }

        return dummy.next;
    }
}
