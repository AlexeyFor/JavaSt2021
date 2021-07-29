package by.training.task07.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Composite for text. Text consists of paragraphs (Component)
 */
public class TextComposite implements Component {

    private static final Logger LOG = LogManager.getLogger(TextComposite.class);

    public TextComposite(List<Component> components) {
	super();
	this.components = components;
    }

    private List<Component> components = new ArrayList<>();

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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((components == null) ? 0 : components.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TextComposite other = (TextComposite) obj;
	if (components == null) {
	    if (other.components != null)
		return false;
	} else if (!components.equals(other.components))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TextComposite [paragraphs=" + components + "]";
    }

}
