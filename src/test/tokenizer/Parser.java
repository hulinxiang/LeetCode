package test.tokenizer;


import java.util.Scanner;

public class Parser {
    Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }


    public static class IllegalFormatException extends IllegalArgumentException {
        public IllegalFormatException(String errorMessage) {
            super(errorMessage);
        }
    }

    public ResultsShow parse() {
        if (tokenizer.current().getType() != Token.Type.Number) {
            throw new IllegalFormatException("The format is invalid");
        }
        ResultsShow left = new Num(tokenizer.current().getToken());
        tokenizer.proceed();
        ResultsShow dot = new ResultsShow();
        ResultsShow right = new ResultsShow();
        int count = 0;
        while (tokenizer.hasNext()) {
            if (tokenizer.current().getType() == Token.Type.Dot) {
                dot = new Dot();
                tokenizer.proceed();
            } else if (tokenizer.current().getType() == Token.Type.Number) {
                right = new Num(tokenizer.current().getToken());
                tokenizer.proceed();
            }
            count++;
        }
        if (count > 2 || count == 1) {
            throw new IllegalFormatException("The format is invalid");
        }

        return new Expression(left, dot, right);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide a mathematical string to be parsed:");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            // Check if 'quit' is provided.
            if (input.equals("q")) {
                break;
            }

            // Create an instance of the tokenizer.
            Tokenizer tokenizer = new Tokenizer(input);

            // Print out the expression from the parser.
            Parser parser = new test.tokenizer.Parser(tokenizer);
            String parseRes = parser.parse().show();
            System.out.println(parseRes);
            String[] s = parseRes.split("\\|");
            StringBuilder stringBuilder = new StringBuilder();
            for (String a : s) {
                stringBuilder.append(a);
            }
            System.out.println(stringBuilder);
        }

    }

}
