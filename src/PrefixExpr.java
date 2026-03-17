public class PrefixExpr implements Expression{
	private TokenType operator;
	private String value;
	
	public PrefixExpr(TokenType operator, String value){
		this.operator = operator;
		this.value = value;
	}
	
	@Override
	public String print(){
		return "(" + operator.name() + " " + value + ")";
	}
	
	@Override
	public double evaluate(){
		double number = Double.parseDouble(value);
		if(operator == TokenType.MINUS){
			return -1 * number;
		}
		else{
			return number;
		}
	}
}
