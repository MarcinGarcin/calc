public class BinaryExpr implements Expression{
	private Expression left;
	private TokenType operator;
	private Expression right;

	public BinaryExpr(Expression left, TokenType operator, Expression right){
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
	
	@Override
	public String print(){
		return "(" + left.print() + " " + operator.name() + " " + right.print() + ")";
	}
}
