package test.thread;

public class B extends A {
    public B() {
        System.out.println("B is constructing...");
    }

    @Override
    public void run() {
        System.out.println("B is running...");
    }

    public static void main(String[] args) {
        A a = new B();
        a.run();
    }


}
