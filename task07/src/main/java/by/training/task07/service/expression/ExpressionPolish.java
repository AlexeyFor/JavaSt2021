package by.training.task07.service.expression;

import java.util.ArrayDeque;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.ExpressionElement;

public class ExpressionPolish {

    private static ExpressionPolish instance = new ExpressionPolish();

    private ExpressionPolish() {
    }

    public static ExpressionPolish getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(ExpressionPolish.class);

    private ArrayDeque<ExpressionElement> resultStack = new ArrayDeque<>();
    private ArrayDeque<ExpressionElement> stackForOperators = new ArrayDeque<>();

    /**
     * take List<ExpressionElement> and return ArrayDeque as reverse polish notation
     * 
     * @param elements
     * @return
     */
    public ArrayDeque<ExpressionElement> fromListElementToPolishDeque(
	    List<ExpressionElement> elements) {

	LOG.debug("start fromListElementToPolishDeque");

	int priority;
	for (int i = 0; i < elements.size(); i++) {
	    priority = elements.get(i).getPriority();
	    if (priority == 0) {
		resultStack.add(elements.get(i));
	    } else if (priority == 1 || priority == 7) {
		addBracketsOperators(elements.get(i));
	    } else {
		addOperator(elements.get(i));
	    }
	    LOG.debug("resultStack" + resultStack.toString());
	}

	while (!stackForOperators.isEmpty()) {
	    resultStack.add(stackForOperators.getLast());
	    stackForOperators.removeLast();
	}

	return resultStack;
    }

    private void addOperator(ExpressionElement element) {
	final int priority = element.getPriority();

	if (stackForOperators.isEmpty()) {
	    stackForOperators.add(element);
	} else if (checkOperatorsPriotity(priority)) {
	    stackForOperators.add(element);
	} else {
	    addOperatorsToResultStack(element);
	}
    }

    /**
     * only for ( and )
     * 
     * @param element
     */
    private void addBracketsOperators(ExpressionElement element) {
	final int priority = element.getPriority();
	if (priority == 1) {
	    stackForOperators.add(element);
	} else if (priority == 7) {
	    while (stackForOperators.getLast().getPriority() != 1) {
		resultStack.add(stackForOperators.getLast());
		stackForOperators.removeLast();
	    }
	    if (stackForOperators.getLast().getPriority() == 1) {
		stackForOperators.removeLast();
	    }
	}

    }

    private void addOperatorsToResultStack(ExpressionElement element) {
	final int priority = element.getPriority();

	while (stackForOperators.getLast().getPriority() >= priority) {
	    resultStack.add(stackForOperators.getLast());
	    stackForOperators.removeLast();
	    if (stackForOperators.isEmpty()) {
		break;
	    }
	}
	stackForOperators.add(element);

    }

    /**
     * eсли приоритет операции находящейся на вершине стека меньше заданной - true
     * 
     * @param elementPriority
     * @return
     */
    private boolean checkOperatorsPriotity(int elementPriority) {

	return stackForOperators.getLast().getPriority() < elementPriority;

    }

}
