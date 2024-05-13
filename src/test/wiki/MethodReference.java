package test.wiki;


/**
 * This class demonstrates the use of method references in Java.
 * It includes examples of using both static and non-static methods
 * with method references and lambda expressions.
 */
public class MethodReference {
    public static void main(String[] args) {

        // Using a normal method call within a lambda expression
        LambdaSingleReturnSingleParameter lambda1 = a -> change(a);
        // Using a method reference for a static method (method belongs to a class)
        LambdaSingleReturnSingleParameter lambda2 = MethodReference::change;
        System.out.println("Static method using Lambda Expression: " + lambda1.test(2));
        System.out.println("Static method using Method Reference: " + lambda2.test(2));

        // Non-static methods require an object instance to be called
        MethodReference methodReference = new MethodReference();
        // Using a method reference for a non-static method (method belongs to an object)
        LambdaSingleReturnSingleParameter lambda3 = methodReference::change2;
        System.out.println("Non-static method using Method Reference with single parameter: " + lambda3.test(2));
        // Using a method reference with multiple parameters
        LambdaSingleReturnMultipleParameter lambda4 = methodReference::change3;
        System.out.println("Non-static method using Method Reference with multiple parameters: " + lambda4.test(2, 3));
    }

    private static int change(int a) {
        return a * 2;
    }

    private int change2(int a) {
        return a * 3;
    }

    private int change3(int a, int b) {
        return a * 2 + b * 3;
    }
}
