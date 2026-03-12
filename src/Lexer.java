import java.util.ArrayList;
import java.util.List;

class Lexer{
	private final String input;
	private int pos = 0;
	
	public Lexer(String input){
		this.input = input;
	}
	public List<Token> tokenize(){
		List<Token> tokens  = new ArrayList<>();
		while(pos<input.length()){
			char curr = input.charAt(pos);
			if(curr == ' '){
				pos++;
				continue;
			}
			
			if(Character.isDigit(curr)||curr=='.'){
				StringBuilder sb = new StringBuilder();
				while(pos<input.length()&&(Character.isDigit(curr)||curr=='.')){
					sb.append(curr);
					pos++;
					curr = input.charAt(pos);
				}
				tokens.add(new Token(TokenType.NUMBER,sb.toString()));
				continue;
			}
			switch(curr){
				case '+': tokens.add(new Token(TokenType.PLUS, "+")); break;
				case '-': tokens.add(new Token(TokenType.MINUS, "-")); break;
				case '*': tokens.add(new Token(TokenType.MUL, "*")); break;
				case '/': tokens.add(new Token(TokenType.DIV, "/")); break;
				case '(': tokens.add(new Token(TokenType.LPAREN, "(")); break;
				case ')': tokens.add(new Token(TokenType.RPAREN, ")")); break;
				default : throw new RuntimeException("Unknwown character " + curr);
			}
			pos++;
		}
		tokens.add(new Token(TokenType.EOF, ""));
		return tokens;
	}
}

























