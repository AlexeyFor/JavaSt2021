package by.training.task05.repository;

import java.util.HashMap;
import java.util.Map;

import by.training.task05.entity.Sphere;
import by.training.task05.entity.SphereListener;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         storage for all spheres and their listeners
 *
 */
public class Storage {

	protected static Map<String, Sphere> storageSphere = new HashMap<>();
	protected static Map<Long, SphereListener> storageListener = new HashMap<>();
}
