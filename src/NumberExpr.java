public class NumberExpr implements Expression{
	private String value;
	
	public NumberExpr(String value){
		this.value = value;
	}
	
	@Override
	public String print(){
		return value;
	}
	
	@Override
	public double evaluate(){
		return Double.parseDouble(value);
	}
}
