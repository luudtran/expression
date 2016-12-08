package expression;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEvaluate1() {
		Expression exp = new Expression();
		exp.addToken(new Token(Token.Type.LPAREN));
		exp.addToken(new Token("*"));
		exp.addToken(new Token(Token.Type.LPAREN));
		exp.addToken(new Token("+"));
		exp.addToken(new Token(3));
		exp.addToken(new Token(5));
		exp.addToken(new Token(Token.Type.RPAREN));
		exp.addToken(new Token(7));
		exp.addToken(new Token(Token.Type.RPAREN));
		
		assertEquals(56, Expression.evaluate(exp));
	}

	@Test
	public void testEvaluate2() {
		Expression exp = new Expression();
		exp.addToken(new Token(Token.Type.LPAREN));
		exp.addToken(new Token("*"));
		exp.addToken(new Token(Token.Type.LPAREN));
		exp.addToken(new Token("+"));
		exp.addToken(new Token(2));
		exp.addToken(new Token(4));
		exp.addToken(new Token(Token.Type.RPAREN));
		exp.addToken(new Token(6));
		exp.addToken(new Token(Token.Type.RPAREN));
		
		assertEquals(36, Expression.evaluate(exp));
	}

}
