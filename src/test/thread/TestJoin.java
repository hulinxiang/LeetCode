package test.thread;

public class TestJoin extends Thread {
    private String name;

    public TestJoin(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread - " + name + ": " + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin1 = new TestJoin("1");
        TestJoin testJoin2 = new TestJoin("2");
        testJoin1.start();
        testJoin2.start();
    }


}


