package expression;

public class Token {
	public static enum Type {LPAREN, OPER, NUM, RPAREN};
	public Type type;
	public int numValue;
	public String strValue;

	public Token(int numValue) {
		this.type = Type.NUM;
		this.numValue = numValue;
	}
	
	public Token(String operator) {
		this.type = Type.OPER;
		this.strValue = operator;
	}
	
	public Token(Type paren) {
		this.type = paren;
		
		switch (paren) {
		case LPAREN:
			strValue = "(";
			break;
		case RPAREN:
			strValue = ")";
			break;
		case NUM:
			break;
		case OPER:
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", numValue=" + numValue + ", strValue=" + strValue + "]";
	}
}
