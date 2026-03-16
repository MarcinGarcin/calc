import java.util.List;

public class Parser{
	private List<Token> tokens;
	private int position = 0;

	public Parser(List<Token> tokens){
		this.tokens = tokens;
	}

	public Expression parse(){
		return expression();
	}
	
	private Expression expression(){
		Expression left = term();
		Token token = match(TokenType.PLUS, TokenType.MINUS);
		
		while(token != null){
			Expression right = term();
			left = new BinaryExpr(left, token.type, right);
			token = match(TokenType.PLUS, TokenType.MINUS);
		}
		return left;
	}

	private Expression term(){
		Expression left = factor();
		Token token = match(TokenType.MUL, TokenType.DIV);

		while(token != null){
			Expression right = factor();
			left = new BinaryExpr(left, token.type, right);
			token = match(TokenType.MUL, TokenType.DIV);
		}
		return left;
	}
	
	private Expression factor(){
		Token numToken = match(TokenType.NUMBER);
		if(numToken != null){
			return new NumberExpr(numToken.value);
		}
		
		if(match(TokenType.LPAREN) != null){
			Expression expr = expression();
			match(TokenType.RPAREN);
			return expr;
		}	
		throw new RuntimeException("Error at position: " + position); 
	}
	
	private Token match(TokenType... expectedTypes){
		if(position < tokens.size()){
			Token current = tokens.get(position);
			for(TokenType type: expectedTypes){
				if(current.type ==type){
					position++;
					return current;
				}
			}

		}
		return null;
	}

}
