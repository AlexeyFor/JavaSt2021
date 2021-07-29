package by.training.task07.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Composite for paragraph. Text consists of sentences (Component)
 */
public class ParagraphComposite implements Component {

    private static final Logger LOG = LogManager.getLogger(ParagraphComposite.class);

    private List<Component> components = new ArrayList<>();

    public ParagraphComposite(List<Component> components) {
	super();
	this.components = components;
    }

    @Override
    public String collect() {
	final String space = " ";
	LOG.debug("start collect");
	StringBuilder builder = new StringBuilder(" ");
	boolean flag = false;

	for (Component component : components) {
	    flag = true;
	    builder.append(component.collect());
	    builder.append(space);
	}
//	 delete last space and add \n
	if (flag) {
	    builder.deleteCharAt(builder.length() - 1);
	    builder.append("\r\n");
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
	ParagraphComposite other = (ParagraphComposite) obj;
	if (components == null) {
	    if (other.components != null)
		return false;
	} else if (!components.equals(other.components))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ParagraphComposite [components=" + components + "]";
    }

}
