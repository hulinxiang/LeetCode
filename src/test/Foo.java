package test;

public class Foo implements Runnable {
    private boolean[] values = new boolean[]{true, false, true, true};
    private int nextIndex = 0;
    private int trues = 0;
    private int falses = 0;

    private int claimNext() {
        return nextIndex++;
    }

    private synchronized void update(boolean truth) {
        if (truth) {
            trues += 1;
        } else {
            falses += 1;
        }
    }

    @Override
    public void run() {
        int i = 0;
        while ((i = claimNext()) < values.length) {
            update(values[i]);
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(foo, "t1");
        Thread t2 = new Thread(foo, "t2");
        t1.start();
        t2.start();
        System.out.println("trues-----------");
        System.out.println(foo.trues);
        System.out.println("falses-----------");
        System.out.println(foo.falses);
    }
}
