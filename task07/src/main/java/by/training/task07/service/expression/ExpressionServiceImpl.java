package by.training.task07.service.expression;

import java.util.ArrayDeque;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.ExpressionElement;
import by.training.task07.service.ServiceException;
import by.training.task07.service.interpreter.ExpressionCalculator;

public class ExpressionServiceImpl implements ExpressionService {

    private static ExpressionServiceImpl instance = new ExpressionServiceImpl();

    private ExpressionServiceImpl() {
    }

    public static ExpressionServiceImpl getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(ExpressionServiceImpl.class);

    ExpressionFomLexemeService expressionService = ExpressionFomLexemeService.getInstance();
    ExpressionPolish expressionPolish = ExpressionPolish.getInstance();

    @Override
    public String calculateExpressionInString(String expression) throws ServiceException {
	LOG.info("start calculateExpressionInLexeme with " + expression.toString());
	// convert lexeme into List with expressionElements
	List<ExpressionElement> expressionElements = expressionService
		.fromStringToExpressionList(expression);

	// convert List with expressionElements into polish Reverse Notation deque
	ArrayDeque<ExpressionElement> polishReverseNotation = expressionPolish
		.fromListElementToPolishDeque(expressionElements);

	// calculate result
	ExpressionCalculator calculator = new ExpressionCalculator(polishReverseNotation);
	String answer = calculator.calculatePolishReverseNotation();

	return answer;

    }

}
