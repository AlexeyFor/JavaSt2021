package by.training.task07.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.ExpressionElement;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         class for operation '~'
 *
 */
public class ExpressionUnaryNegation implements AbstractExpression {

    private static final Logger LOG = LogManager.getLogger(ExpressionUnaryNegation.class);

    /**
     * take two last elements from context, and make operation '~' with them. As the
     * result - add new ExpressionElement in context. Context - class wit deque -
     * reverse Polish notation
     */
    @Override
    public void interpret(Context context) {
	LOG.debug("start interpret ");
	final ExpressionElement firstElement = context.takeLast();
	final int firstElementNumber;
	final int operationResult;

	firstElementNumber = Integer.valueOf(firstElement.getValue());
	operationResult = ~firstElementNumber;

	LOG.debug(String.format("take result %s of operation with first %s ", operationResult,
		firstElementNumber));

	final ExpressionElement result = new ExpressionElement(String.valueOf(operationResult), 0);
	context.add(result);
    }
}
