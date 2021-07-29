package by.training.task07.entity;

public interface Component {
    /**
     * get all components together as String
     * 
     * @return String
     */
    String collect();

    boolean add(Component c);

    boolean remove(Component c);
    
    int CountComponents ();

    Object getChild(int index);
}
