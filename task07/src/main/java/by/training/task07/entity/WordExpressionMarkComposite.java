package by.training.task07.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.service.ServiceException;
import by.training.task07.service.expression.ExpressionServiceImpl;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Composite for word/expression/mark. Text consists of symbols
 *         (Component)
 */
public class WordExpressionMarkComposite implements Component {

    private static final Logger LOG = LogManager.getLogger(WordExpressionMarkComposite.class);

    private List<Component> components = new ArrayList<>();
    // if word or mark - true, if expression - false
    private boolean wordMarkOrExpressionFlag;

    public WordExpressionMarkComposite(List<Component> components,
	    boolean wordMarkOrExpressionFlag) {
	super();
	this.components = components;
	this.wordMarkOrExpressionFlag = wordMarkOrExpressionFlag;
    }

    @Override
    public String collect() {
	LOG.debug("start collect");
	StringBuilder builder = new StringBuilder("");

	for (Component component : components) {
	    builder.append(component.collect());
	}
	String result = new String(builder);

	if (wordMarkOrExpressionFlag) {
	    return result;
	} else {
	    ExpressionServiceImpl expressionCalculator = ExpressionServiceImpl.getInstance();
	    try {
		return expressionCalculator.calculateExpressionInString(result);
	    } catch (ServiceException e) {
		LOG.warn("exception in collect() " + e.getMessage());
		return "wrong expression";
	    }
	}

    }

    @Override
    public boolean add(Component c) {
	LOG.debug("add " + c.toString());
	components.add(c);
	return true;
    }

    @Override
    public boolean remove(Component c) {
	LOG.debug("remove " + c.toString());
	if (components.contains(c)) {
	    components.remove(c);
	    return true;
	} else {
	    LOG.debug("from remove(), wrong component");
	    return false;
	}
    }

    @Override
    public Component getChild(int index) {
	return components.get(index);
    }

    @Override
    public int CountComponents() {
	return components.size();
    }

}
