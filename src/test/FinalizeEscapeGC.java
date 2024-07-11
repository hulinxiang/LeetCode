package test;

/**
 * 虚拟机参数：-verbose:gc
 */
public class FinalizeEscapeGC
{
    public String name;
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public FinalizeEscapeGC(String name) {
        this.name = name;
    }

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        System.out.println(this);
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC("leesf");
        System.out.println(SAVE_HOOK);
        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.out.println(SAVE_HOOK);
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }

        // 下面这段代码与上面的完全相同,但是这一次自救却失败了
        // 一个对象的finalize方法只会被调用一次
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }
    }
}

