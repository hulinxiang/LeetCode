package LinkedList.Question25;


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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        // pre 的存在是为了统一操作
        ListNode pre = dummy;
        ListNode end = head;
        ListNode start = head;
        ListNode next;

        while (end != null) {
            // 找到当前这个group的最后一个需要反转的节点
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            next = end.next;
            // 把当前这个group断开
            end.next = null;
            // 反转并且重新连上
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            start = start.next;
            end = start;
        }
        return dummy.next;

    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode start = head;
        ListNode post = start.next;
        while (post != null) {
            start.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = start.next;
        }


        return pre.next;
    }


}
