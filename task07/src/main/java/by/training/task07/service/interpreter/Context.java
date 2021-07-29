package by.training.task07.service.interpreter;

import java.util.ArrayDeque;

import by.training.task07.entity.ExpressionElement;

/**
 * class wit dequeue - reverse Polish notation
 * 
 * @author AlexeySupruniuk
 *
 */
public class Context {

    private ArrayDeque<ExpressionElement> contextValues = new ArrayDeque<>();

    public ExpressionElement takeLast() {
	return contextValues.pollLast();
    }

    public void add(ExpressionElement expressionElement) {
	contextValues.add(expressionElement);
    }
}
