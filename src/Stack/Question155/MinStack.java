package Stack.Question155;


import java.util.LinkedList;
import java.util.List;

public class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     */

    private List<Integer> current; //代表实际存储的栈中元素
    private List<Integer> save; //代表与栈对应的最小元素
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