package expression;

import java.util.ArrayList;

/*
Token getToken(Expression exp);

public int evaluate(Expression exp) {
    Token tok = getToken(exp);
    switch (tok.type) :
    case (Token.LPAREN) {
        exp.isNew = true;
        exp.value = 0;
        return evaluate(exp);
        }
    case (Token.OPER) {
        switch (Token.OPER) :
        case ("*") {
            exp.value = evaluate(exp) * evaluate(exp);
            return exp.value;
            }
        case ("+") {
            exp.value = evaluate(exp) + evaluate(exp);
            return exp.value;
            }
    case (Token.NUM) {
        exp.value = tok.value;
        return tok.value;
        }
    case (Token.RPAREN) {
        if (exp.isNew) {
            exp.isNew = false;
            return exp.value;
            }
    }

}
 */
public class Expression {
	private ArrayList<Token> tokens = new ArrayList<Token>();
	private int value;
	private boolean isNew;

	public void addToken(Token tok) {
		tokens.add(tok);
	}
	
	private static Token getToken(Expression exp) {
		return exp.tokens.remove(0);
	}
	
	public static int evaluate(Expression exp) {
		Token tok = getToken(exp);
		int op1, op2;
		
		switch (tok.type) {
		case LPAREN:
			exp.value = evaluate(exp);
			break;
		case OPER:
			switch (tok.strValue) {
			case "*":
				op1 = evaluate(exp);
				op2 = evaluate(exp);
				exp.value = op1 * op2;
				break;
			case "+":
				op1 = evaluate(exp);
				op2 = evaluate(exp);
				exp.value = op1 + op2;
				break;
			}
			break;
		case NUM:
			exp.value = tok.numValue;
			break;
		case RPAREN:
			exp.value = evaluate(exp);
			break;
		}
		
		return exp.value;
	}

	@Override
	public String toString() {
		return "Expression [value=" + value + ", isNew=" + isNew + "]";
	}

}
