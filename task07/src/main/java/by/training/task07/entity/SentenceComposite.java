package by.training.task07.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Composite for sentence. Text consists of lexems (Component)
 */
public class SentenceComposite implements Component {

    private static final Logger LOG = LogManager.getLogger(SentenceComposite.class);

    private List<Component> components = new ArrayList<>();

    public SentenceComposite(List<Component> components) {
	super();
	this.components = components;
    }

    @Override
    public String collect() {
	final String space = " ";
	LOG.debug("start collect");
	StringBuilder builder = new StringBuilder("");
	boolean flag = false;

	for (Component component : components) {
	    flag = true;
	    builder.append(component.collect());
	    builder.append(space);
	}
	// delete last space
	if (flag) {
	    builder.deleteCharAt(builder.length() - 1);
	}
	String result = new String(builder);
	return result;
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
