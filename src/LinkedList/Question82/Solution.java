package LinkedList.Question82;


import java.util.HashMap;

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

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            hashMap.put(p.val, hashMap.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode dummy = new ListNode(0, head);
        p = head;
        ListNode pre = dummy;
        while (p != null) {
            if (hashMap.get(p.val) > 1) {
                pre.next = p.next;
                p = pre.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }


        return dummy.next;

    }
}
