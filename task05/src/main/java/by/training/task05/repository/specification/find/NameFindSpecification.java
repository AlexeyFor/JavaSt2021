package by.training.task05.repository.specification.find;

import by.training.task05.entity.Sphere;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by name
 * @param <Sphere>
 */
public class NameFindSpecification extends FindSpecification<Sphere> {

    private String sphereName;

    public NameFindSpecification(String sphereName) {
	this.sphereName = sphereName;
    }

    public void setSphereName(String sphereName) {
	this.sphereName = sphereName;
    }

    @Override
    public boolean test(Sphere tmp) {
	String tmpSphereName = tmp.getName();
	return tmpSphereName.equals(sphereName);
    }

}
