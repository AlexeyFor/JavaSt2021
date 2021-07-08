package by.training.task05.entity;

import by.training.task05.repository.Repository;

public class SphereListenerCatalog {

    private static SphereListenerCatalog instance = new SphereListenerCatalog();

	private SphereListenerCatalog() {
	}

	public static SphereListenerCatalog getInstance() {
		return instance;
	}
	
	public void callListener (long id, double radius) {
	    Repository.getInstance().getListener(id).update(radius);
	}
}
