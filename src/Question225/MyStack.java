package Question225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    private int rear = -1;
    private int save;

    public MyStack() {
        queue = new LinkedList<>();
        rear = 0;
    }

    public void push(int x) {
        queue.add(x);
        rear++;
    }

    public int pop() {
        save = rear;
        while (rear > 1) {
            queue.add(queue.poll());
            rear--;
        }
        rear = save - 1;
        return queue.poll();
    }

    public int top() {
        int ans;
        save = rear;
        while (rear > 1) {
            queue.add(queue.poll());
            rear--;
        }
        rear = save;
        ans = queue.peek();
        queue.add(queue.poll());
        return ans;
    }

    public boolean empty() {
        return queue.isEmpty();
    }


    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
