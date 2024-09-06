package test.thread;

import java.util.concurrent.atomic.AtomicInteger;

class TestThread {
    public static void main(String[] args) {
        Object o = new Object();
        AtomicInteger i = new AtomicInteger(0);


        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    i.incrementAndGet();
                    System.out.println("BBBBBBBBBBBBBBB");
                    o.notifyAll();
                }
            }
        };

        Runnable runnableC = new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    i.incrementAndGet();
                    System.out.println("CCCCCCCCCCCC");
                    o.notifyAll();
                }
            }
        };

        Runnable runnableD = new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    i.incrementAndGet();
                    System.out.println("DDDDDDDDDDDDDD");
                    o.notifyAll();
                }
            }
        };

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                runnableB.run();
                runnableC.run();
                runnableD.run();
                synchronized (o) {
                    while (i.get() < 3) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("AAAAAAAAAAAAA");
            }
        };

        runnableA.run();

    }
}
