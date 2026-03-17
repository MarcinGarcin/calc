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
	@Override
    	public double evaluate() {
        	double leftVal = left.evaluate();
        	double rightVal = right.evaluate();

        	switch (operator) {
            		case PLUS: return leftVal + rightVal;
            		case MINUS: return leftVal - rightVal;
            		case MUL: return leftVal * rightVal;
            		case DIV: 
            		    if (rightVal == 0) {
                    		throw new ArithmeticException("Division by zero");
                		}
                		return leftVal / rightVal;
            		default: throw new RuntimeException("Unknown operator: " + operator);
        	}
    	}	
}
