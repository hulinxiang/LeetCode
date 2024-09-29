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
        // pre �Ĵ�����Ϊ��ͳһ����
        ListNode pre = dummy;
        ListNode end = head;
        ListNode start = head;
        ListNode next;

        while (end != null) {
            // �ҵ���ǰ���group�����һ����Ҫ��ת�Ľڵ�
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            next = end.next;
            // �ѵ�ǰ���group�Ͽ�
            end.next = null;
            // ��ת������������
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            start = start.next;
            end = start;
        }
        return dummy.next;

    }

    // ��ת����
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
