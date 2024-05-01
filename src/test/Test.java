package test;

public class Test {


    public void test(Student student) {
        student.speak();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test(new Student());
        test.test(new Student() {
            @Override
            public void speak() {
                System.out.println(222222);
            }
        });
        MyInterface.say();
        MyInterface myInterface = new MyInterface() {
            @Override
            public void speak() {
                System.out.println(33333333);
            }
        };
        myInterface.speak();
        myInterface = () -> System.out.println(4444444);
        myInterface.speak();

        TestInterface testInterface = (x, y) -> x - y;
        System.out.println(testInterface.cal(10, 3));

        String a = new String("abcdfhghgfshaifa");
        String b = new String("abcdfhghgfshaifa");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

}
