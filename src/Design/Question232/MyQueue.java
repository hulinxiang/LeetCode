package Design.Question232;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    public int pop() {
        int ans;
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        ans = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return ans;
    }

    public int peek() {
        int ans;
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        ans = s2.peek();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return ans;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
