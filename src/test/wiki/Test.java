package test.wiki;

public class Test {
    public static void main(String[] args) {
        // Override a concrete class method
        new ConcreteClass01() {
            @Override
            public void show() {
                System.out.println("COMP6442====This is a concrete class");
            }
        }.show();

        // Override an abstract method of an abstract class
        new Interface01() {
            @Override
            public void show() {
                System.out.println("COMP6442====This is an interface");
            }
        }.show();

        // Implement the abstract methods of an interface.
        new AbstractClass01() {
            @Override
            void show() {
                System.out.println("COMP6442====This is an abstract class");
            }
        }.show();

    }
}
