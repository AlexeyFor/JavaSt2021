package by.training.task05.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.dal.DALException;
import by.training.task05.dal.DALProvider;
import by.training.task05.entity.Sphere;
import by.training.task05.entity.SphereListener;
import by.training.task05.entity.SphereListenerImpl;
import by.training.task05.service.creator.CreatorException;
import by.training.task05.service.creator.SphereCreator;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Contains logic for access to Storage of spheres and listeners
 */
public class Repository {

    private static Repository instance = new Repository();

    private Repository() {
    }

    public static Repository getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(Repository.class);

    /**
     * initiate the Repository. Take data from file
     * 
     * @param path
     * @return
     * @throws RepositoryException
     */
    public boolean initiateRepository(String path) throws RepositoryException {
	LOG.info("Start initiateRepository");
	List<String> dataFromFile;
	try {
	    dataFromFile = DALProvider.getInstance().getWorkWithFile().readFileList(path);

	    for (int i = 0; i < dataFromFile.size(); i++) {
		Optional<Sphere> value = fromStringToSphere(dataFromFile.get(i));
		if (value.isPresent()) {
		    Sphere sphere = value.get();
		    putSphere(sphere);
		    SphereListenerImpl tmpListener = new SphereListenerImpl(sphere.getID(),
			    sphere.getRadius());
		    putListener(tmpListener);
		    LOG.debug(
			    "border//////////////////////////////////////////////////////////////");
		}
	    }
	} catch (DALException e) {
	    LOG.debug("can't inintiate the repository");
	    throw new RepositoryException("wrong_path");
	}

	return true;
    }

    /**
     * update sphere from repository
     * 
     * @param sphere
     * @return
     */
    public boolean update(final Sphere sphere) {
	LOG.debug("start update with " + sphere.toString());
	final String sphereName = sphere.getName();
	boolean answer;

	if (Storage.storageSphere.containsKey(sphereName)) {
	    Storage.storageSphere.replace(sphereName, sphere);
	    answer = true;
	} else {
	    LOG.error("object cannot be updated, such object is not present in the repository");
	    answer = false;
	}
	return answer;
    }

    /**
     * add sphere to repository
     * 
     * @param sphere
     * @return
     */
    public boolean add(final Sphere sphere) {
	LOG.debug("start add with " + sphere.toString());
	boolean answer;

	if (Storage.storageSphere.containsKey(sphere.getName())) {
	    LOG.error("object cannot be added, object with the same name already exists");
	    answer = false;
	} else {
	    putSphere(sphere);
	    SphereListenerImpl tmpListener = new SphereListenerImpl(sphere.getID(),
		    sphere.getRadius());
	    putListener(tmpListener);
	    answer = true;
	}
	return answer;
    }

    /**
     * remove sphere from repository
     * 
     * @param sphere
     * @return
     */
    public boolean remove(final Sphere sphere) {
	LOG.debug("start remove with " + sphere.toString());
	boolean answer;
	final String sphereName = sphere.getName();

	if (Storage.storageSphere.containsKey(sphereName)) {
	    Storage.storageListener.remove(sphere.getID());
	    Storage.storageSphere.remove(sphereName);
	    answer = true;
	} else {
	    LOG.error("object cannot be removed, object with such name doesn't exists");
	    answer = false;
	}
	return answer;
    }

    /**
     * Take all spheres from repository
     * 
     * @return
     */
    public List<Sphere> takeAllSpheres() {
	List<Sphere> result = new ArrayList<>();
	for (final Map.Entry<String, Sphere> entry : Storage.storageSphere.entrySet()) {
	    result.add(entry.getValue());
	}
	return result;
    }

    /**
     * get sphere from storage
     * 
     * @param key
     * @return
     * @throws RepositoryException
     */
    public Sphere getSphere(String key) throws RepositoryException {
	if (Storage.storageSphere.containsKey(key)) {
	    return Storage.storageSphere.get(key);
	} else {
	    throw new RepositoryException("Repository doesn't conatain such Sphere");
	}
    }

    /**
     * get sphereListener from storage
     * 
     * @param key
     * @return
     */
    public SphereListener getListener(long key) {
	return Storage.storageListener.get(key);
    }

    /**
     * create Sphere from string Name___x___y___z___radius
     * 
     * @param params
     * @return
     */
    private Optional<Sphere> fromStringToSphere(String str) {
	LOG.debug("start fromStringToSphere with " + str);
	SphereCreator creator = SphereCreator.getInstance();
	Optional<Sphere> result = Optional.empty();
	String params[] = parseDataFromStr(str);

	if (validateDataFromStr(params)) {
	    String name = params[0];
	    double[] paramsXYZRadius = fromStrToDouble(params);
	    double x = paramsXYZRadius[1];
	    double y = paramsXYZRadius[2];
	    double z = paramsXYZRadius[3];
	    double radius = paramsXYZRadius[4];
	    try {
		LOG.debug("start try");
		Sphere tmp = creator.createSphere(name, x, y, z, radius);
		LOG.debug("create tmp");

		result = Optional.of(tmp);
		return result;
	    } catch (CreatorException e) {
		LOG.debug("from fromStringToSphere() can't create sphere, " + e.getMessage());
	    }
	}
	return result;
    }

    /**
     * Name___x___y___z___radius
     * 
     * for name only [0-9 .a-z A-Z -] symbols allowed
     * 
     * @param line
     * @return
     */
    private String[] parseDataFromStr(String line) {
	String[] params;
	params = line.split("___");
	return params;
    }

    /**
     * 
     * @param params
     * @return
     */
    private boolean validateDataFromStr(String[] params) {
	LOG.debug("start validateDataFromStr");
	Validation valid = Validation.getInstance();
	if (params.length == 5) {
	    boolean conditionName = valid.checkName(params[0]);
	    boolean conditionX = valid.checkOneCoordinate(params[1]);
	    boolean conditionY = valid.checkOneCoordinate(params[2]);
	    boolean conditionZ = valid.checkOneCoordinate(params[3]);
	    boolean conditionRadius = valid.checkRadius(params[4]);
	    boolean result = conditionName && conditionX && conditionY && conditionZ
		    && conditionRadius;
	    LOG.debug("validateDataFromStr return " + result);
	    return result;
	}
	return false;
    }

    /**
     * only for initiateRepository! take String [ Name, x, y, z, radius] and return
     * double [ x, y, z, radius]
     * 
     * @param params
     * @return
     */
    private double[] fromStrToDouble(String[] params) {
	// nothig - to keep the old order in params []
	double nothing = Double.NaN;
	double x = Double.valueOf(params[1]);
	double y = Double.valueOf(params[2]);
	double z = Double.valueOf(params[3]);
	double radius = Double.valueOf(params[4]);
	return new double[] { nothing, x, y, z, radius };

    }

    private void putListener(SphereListenerImpl listener) {
	Storage.storageListener.put(listener.getID(), listener);
    }

    private void putSphere(Sphere sphere) {
	Storage.storageSphere.put(sphere.getName(), sphere);
    }

}
