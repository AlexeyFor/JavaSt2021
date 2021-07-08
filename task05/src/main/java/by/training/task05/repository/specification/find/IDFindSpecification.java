package by.training.task05.repository.specification.find;

import by.training.task05.entity.Sphere;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by ID
 * @param <Sphere>
 */
public class IDFindSpecification extends FindSpecification<Sphere> {

	private Long id;

	public void setId(Long id) {
	    this.id = id;
	}

	public IDFindSpecification(final Long id) {
		this.id = id;
	}

	@Override
	public boolean test(Sphere tmp) {
		Long tmpSphereID = tmp.getID();
		return tmpSphereID.equals(id);
	}

}
