package by.training.task07.entity;

public class SymbolComponent implements Component {

    private char value;

    public SymbolComponent(char value) {
	super();
	this.value = value;
    }

    public char getValue() {
	return value;
    }

    public void setValue(char value) {
	this.value = value;
    }

    @Override
    public String toString() {
	return "Symbol [value=" + value + "]";
    }

    @Override
    public String collect() {
	return String.valueOf(value);
    }

    @Override
    public boolean add(Component c) {
	throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component c) {
	throw new UnsupportedOperationException();

    }

    @Override
    public Object getChild(int index) {
	throw new UnsupportedOperationException();

    }
    
    @Override
    public int CountComponents() {
	return 1;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + value;
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
	SymbolComponent other = (SymbolComponent) obj;
	if (value != other.value)
	    return false;
	return true;
    }

}
