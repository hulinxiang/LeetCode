package test.wiki;

/**
 * This class is used to demonstrate Lambda expressions with syntax simplification.
 */
public class TestSimplifiedLambda {
    public static void main(String[] args) {

        // Parameter simplification
        // 1. Parameter simplification
        // Since the parameters are already defined in the interface, the types of parameters in Lambda expressions can be omitted.
        // Note: If type omission is required, all parameter types must be omitted, otherwise it will result in an error.
        // Omitting parameter types is not advisable in anonymous inner classes.
        LambdaNoneReturnMultipleParameter lambda1 = (a, b) -> {
            System.out.println(a + b);

        };

        // 2. Simplification of parentheses for parameters
        // If there is only one parameter in the parameter list (no more, no less), then parentheses can be omitted.
        // Parameter types can still be omitted.
        LambdaNoneReturnSingleParameter lambda2 = a -> {
            System.out.println(a);
        };

        // 3. Omission of method braces
        // Similar to if or while statements, if the statement block contains only one statement, then braces can be omitted.
        // The previous simplification method is still valid.
        LambdaNoneReturnSingleParameter lambda3 = a -> System.out.println(a);

        // 4. If the interface's only method has only one return statement, then braces can be omitted.
        // But when omitting braces, return must be omitted simultaneously.
        LambdaSingleReturnNoneParameter lambda4 = () -> 10;

    }
}
