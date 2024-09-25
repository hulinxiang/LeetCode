package Stack.Question155;


import java.util.LinkedList;
import java.util.List;

public class MinStack {

    /**
     * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
     * <p>
     * ʵ�� MinStack ��:
     * <p>
     * MinStack() ��ʼ����ջ����
     * void push(int val) ��Ԫ��val�����ջ��
     * void pop() ɾ����ջ������Ԫ�ء�
     * int top() ��ȡ��ջ������Ԫ�ء�
     * int getMin() ��ȡ��ջ�е���СԪ�ء�
     */

    private List<Integer> current; //����ʵ�ʴ洢��ջ��Ԫ��
    private List<Integer> save; //������ջ��Ӧ����СԪ��
    private int index;

    public MinStack() {
        current = new LinkedList<>();
        save = new LinkedList();
        index = 0;
    }

    public void push(int val) {
        if (index == 0 || val < save.get(index - 1)) {
            current.add(val);
            save.add(val);
            index++;
        } else {
            current.add(val);
            save.add(save.get(index - 1));
            index++;
        }
    }

    public void pop() {
        index--;
        current.remove(index);
        save.remove(index);

    }

    public int top() {
        return current.get(index - 1);
    }

    public int getMin() {
        return save.get(index - 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}