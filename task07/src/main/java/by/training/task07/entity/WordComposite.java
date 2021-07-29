package by.training.task07.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordComposite implements Component {

    private static final Logger LOG = LogManager.getLogger(WordComposite.class);

    private List<Component> components = new ArrayList<>();

    public WordComposite(List<Component> components) {
	super();
	this.components = components;
    }

    @Override
    public String collect() {
	LOG.debug("start collect");
	StringBuilder builder = new StringBuilder("");

	for (Component component : components) {
	    builder.append(component.collect());
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
