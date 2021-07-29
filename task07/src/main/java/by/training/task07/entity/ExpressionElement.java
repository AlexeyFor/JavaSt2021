package by.training.task07.entity;

public class ExpressionElement {

    private String value;
    private int priority = 0;

    public ExpressionElement() {
	super();
    }

    public ExpressionElement(String value, int priority) {
	super();
	this.value = value;
	this.priority = priority;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public int getPriority() {
	return priority;
    }

    @Override
    public String toString() {
	return "ExpressionElement [value=" + value + ", priority=" + priority + "]";
    }

}
