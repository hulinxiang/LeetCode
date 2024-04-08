package test;

public class Student extends Person implements MyInterface {

    @Override
    public int addAge(int addition) {
        super.age += addition;
        return super.age;
    }

    @Override
    public void speak() {
        System.out.println(11111);
    }
}
