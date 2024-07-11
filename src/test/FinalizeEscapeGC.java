package test;

/**
 * �����������-verbose:gc
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
        // �����һ�������Լ�
        SAVE_HOOK = null;
        System.out.println(SAVE_HOOK);
        System.gc();
        // ��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5���Եȴ���
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }

        // ������δ������������ȫ��ͬ,������һ���Ծ�ȴʧ����
        // һ�������finalize����ֻ�ᱻ����һ��
        SAVE_HOOK = null;
        System.gc();
        // ��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5���Եȴ���
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead : (");
        }
    }
}

