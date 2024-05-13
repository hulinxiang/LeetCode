package test.wiki;

/**
 * @author Hu
 */
public class Interface01Impl implements Interface01 {
    @Override
    public void show() {
        System.out.println("COMP6442=====Implement the interface by creating a new class");
    }


    public static void main(String[] args) {
        Interface01 interface01 = new Interface01() {
            @Override
            public void show() {
                System.out.println("COMP6442====Implement the interface using anonymous inner class");
            }
        };
        interface01.show();
    }
}
