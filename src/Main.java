import java.util.List;
import java.util.Scanner;
 
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            String input = scanner.nextLine().trim();
 
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("bye")) {
                break;
            }
 
            if (input.isEmpty()) {
                continue;
            }
 
            try {
                Lexer lexer = new Lexer(input);
                List<Token> tokens = lexer.tokenize();
                Parser parser = new Parser(tokens);
                Expression ast = parser.parse();
                System.out.println("  = " + ast.evaluate());
            } catch (ArithmeticException e) {
                System.out.println("  Errpr: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("  Parse error: " + e.getMessage());
            }
        }
 
        scanner.close();
    }
}