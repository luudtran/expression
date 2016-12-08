# expression

Given a prefix expression like:
`( * ( + 3 5 ) 7)`

and a function that returns a token each time you call it,
with a token stream being tuples like:

~~~~
{LPAREN, "(")}
{OPER, "*"}
{LPAREN, "(")}
{OPER, "+"}
{NUM, 3}
{NUM, 5}
{RPAREN, ")"}
{NUM, 7}
{RPAREN, ")"}
~~~~

Write an evaluator that returns the result of the expression.

~~~~
func (cxt *EvalContext) eval(ts *TokenStream) (int, error) {
    t, _ := ts.nextToken()
    switch t.tokType {
    case lparen:
        cxt.curState = inExpr
        return cxt.eval(ts)
    case operator:
        if cxt.curState == inExpr {
            opand1, _ := cxt.eval(ts)
            opand2, _ := cxt.eval(ts)
            i, _ := applyOper(t.tokValue, opand1, opand2)
            cxt.curState = outExpr
            cxt.curVal = i
            return cxt.eval(ts)
        } else {
            return -1, errors.New("bad expr state")
        }
    case symbol:
        i, _ := strconv.Atoi(t.tokValue)
        return i, nil
    case rparen:
        if cxt.curState == outExpr {
            return cxt.curVal, nil
        } else {
            return -1, errors.New("bad expr state")
        }

    }
    return -1, errors.New("failed to parse token")
}

func applyOper(operator string, operand1 int, operand2 int) (int, error) {
    switch operator {
    case "*":
        return (operand1 * operand2), nil
    case "+":
        return (operand1 + operand2), nil
    case "/":
        return (operand1 / operand2), nil
    case "-":
        return (operand1 - operand2), nil
    }

    return -1, errors.New("failed to apply operator")
}
~~~~
