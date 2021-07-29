package by.training.task07.service.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.ExpressionElement;
import by.training.task07.service.ServiceException;
import by.training.task07.service.expression.ExpressionServiceImpl;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         calculate answer of expression, written in polish Reverse Notation
 *
 */
public class ExpressionCalculator {
    private static final Logger LOG = LogManager.getLogger(ExpressionCalculator.class);

    private final ArrayDeque<ExpressionElement> polishReverseNotation;
    private Context context = new Context();
    private List<AbstractExpression> expressionsList = new ArrayList<>();

    public ExpressionCalculator(ArrayDeque<ExpressionElement> polishReverseNotation) {
	super();
	this.polishReverseNotation = polishReverseNotation;
    }

    public String calculatePolishReverseNotation() {
	LOG.debug("start calculatePolishReverseNotation");
	createExpressionsList();
	expressionsList.forEach(x -> x.interpret(context));
	return context.takeLast().getValue();
    }

    /**
     * take elements from polish Reverse Notation, parse them into
     * AbstractExpression and add to expressionsList
     */
    private void createExpressionsList() {
	polishReverseNotation.forEach(x -> parsePolishReverseNotation(x));
    }

    /**
     * parsing of ExpressionElement
     * 
     * @param element
     */
    private void parsePolishReverseNotation(ExpressionElement element) {
	final int priority = element.getPriority();
	switch (priority) {
	case 0:
	    ExpressionNumber number = new ExpressionNumber(element);
	    expressionsList.add(number);
	    break;
	case 2:
	    ExpressionOR or = new ExpressionOR();
	    expressionsList.add(or);
	    break;
	case 3:
	    ExpressionCircumflex circumflex = new ExpressionCircumflex();
	    expressionsList.add(circumflex);
	    break;
	case 4:
	    ExpressionAmpersand ampersand = new ExpressionAmpersand();
	    expressionsList.add(ampersand);
	    break;
	case 5:
	    additionForShift(element);
	    break;
	case 6:
	    ExpressionUnaryNegation unaryNegation = new ExpressionUnaryNegation();
	    expressionsList.add(unaryNegation);
	    break;
	}
    }

    /**
     * only for << >> >>>
     * 
     * @param element
     */
    private void additionForShift(ExpressionElement element) {
	String value = element.getValue();

	if (value.equals("<<")) {
	    ExpressionLeftShift leftShift = new ExpressionLeftShift();
	    expressionsList.add(leftShift);
	} else if (value.equals(">>>")) {
	    ExpressionRightShiftZeroAppear rightShiftZero = new ExpressionRightShiftZeroAppear();
	    expressionsList.add(rightShiftZero);
	} else if (value.equals(">>")) {
	    ExpressionRightShift rightShift = new ExpressionRightShift();
	    expressionsList.add(rightShift);
	} else {
	    LOG.warn("wrong_operator from additionForShift");
	}
    }
}