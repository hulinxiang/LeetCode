package LinkedList.Question86;

public class Solution {
    //    ����һ�������ͷ�ڵ� head ��һ���ض�ֵ x �������������зָ���ʹ������ С�� x �Ľڵ㶼������ ���ڻ���� x �Ľڵ�֮ǰ��
    //
    //    ��Ӧ�� ���� ����������ÿ���ڵ�ĳ�ʼ���λ�á�
    // �����Ӧ��ʹ��β�巨

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
        // ������������ͷ�ڵ�
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        // ��ʼ�����������β�ڵ㣬��ʼʱ��ָ����Ե�����ͷ�ڵ�
        ListNode smallTail = smallDummy, largeTail = largeDummy;

        // ����ԭ����
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

        // �ϲ�����������
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
