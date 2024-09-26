package LinkedList.Question141;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;
        int mark = 0;
        while (true) {
            if (low == fast) {
                mark = 1;
                break;
            }
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return mark == 1;
    }
}