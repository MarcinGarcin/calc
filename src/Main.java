import java.util.List;
import java.util.ArrayList;
class Main{
	public static void main(String[] args){
		String testVal = "8*123+ (19-81)";
		
		Lexer lexer =new Lexer(testVal);
		List<Token> tokens = lexer.tokenize();
		Parser parser = new Parser(tokens);
		Expression ast = parser.parse():
		System.out.println(ast.print());
	}




}
