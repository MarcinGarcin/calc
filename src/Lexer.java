import java.util.ArrayList;
import java.util.List;

class Lexer{
	private final String input;
	private int position = 0;
	
	public Lexer(String input){
		this.input = input;
	}
	public List<Token> tokenize(){
		List<Token> tokens  = new ArrayList<>();
		while(position<input.length()){
			char curr = input.charAt(position);
			if(curr == ' '){
				position++;
				continue;
			}
			
			if(Character.isDigit(curr)||curr=='.'){
				StringBuilder sb = new StringBuilder();
				while(position<input.length()&&(Character.isDigit(input.charAt(position))||input.charAt(position)=='.')){
					sb.append(input.charAt(position));
					position++;
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
			position++;
		}
		tokens.add(new Token(TokenType.EOF, ""));
		return tokens;
	}
}

























