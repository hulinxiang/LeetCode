package LinkedList.Question86;

public class Solution {
    //    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //
    //    你应当 保留 两个分区中每个节点的初始相对位置。
    // 这道题应该使用尾插法

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


    public ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        // 初始化两个链表的尾节点，开始时都指向各自的虚拟头节点
        ListNode smallTail = smallDummy, largeTail = largeDummy;

        // 遍历原链表
        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }

        // 合并两个子链表
        smallTail.next = largeDummy.next;
        largeTail.next = null;

        return smallDummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.createList(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        ListNode result = solution.partition(head, x);
        solution.printList(result);
    }

    // Helper method to create a list from an array of values
    public ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    // Helper method to print the list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
