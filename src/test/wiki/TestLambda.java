package test.wiki;

/**
 * Basic syntax for Lambda expressions
 *
 * @author Hu
 */
public class TestLambda {
    public static void main(String[] args) {

        // 1. No argument No return
        LambdaNoneReturnNoneParameter lambda1 = () -> {
            System.out.println("No argument No return");
        };
        lambda1.test();

        // 2. One argument No return
        LambdaNoneReturnSingleParameter lambda2 = (int i) -> {
            System.out.println("One argument No return:" + i);
        };
        lambda2.test(1024);


        // 3. Multi arguments No return
        LambdaNoneReturnMultipleParameter lambda3 = (int a, int b) ->
        {
            System.out.println("Multi arguments No return:" + (a + b));
        };
        lambda3.test(1000, 24);

        // 4. No argument One return
        LambdaSingleReturnNoneParameter lambda4 = () -> {
            return 1024;
        };
        int res = lambda4.test();
        System.out.println("No argument One return:" + res);

        // 5. One argument One return
        LambdaSingleReturnSingleParameter lambda5 = (int a) -> {
            return a;
        };
        int res2 = lambda5.test(1024);
        System.out.println("One argument One return:" + res2);

        // 6. Multi arguments One return
        LambdaSingleReturnMultipleParameter lambda6 = (int a, int b) -> {
            int sum = a + b;
            return sum;
        };
        int res3 = lambda6.test(1000, 24);
        System.out.println("Multi arguments One return:" + res3);

    }
}
