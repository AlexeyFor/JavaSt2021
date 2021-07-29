package by.training.task07.service.interpreter;

import by.training.task07.entity.ExpressionElement;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         class for numbers
 *
 */
public class ExpressionNumber implements AbstractExpression {

    

    public ExpressionNumber(ExpressionElement expressionElement) {
	super();
	this.expressionElement = expressionElement;
    }

    private ExpressionElement expressionElement;

    public void setExpressionElement(ExpressionElement expressionElement) {
	this.expressionElement = expressionElement;
    }

    @Override
    public void interpret(Context context) {
	context.add(expressionElement);
    }

}
