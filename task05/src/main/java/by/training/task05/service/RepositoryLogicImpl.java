package by.training.task05.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;
import by.training.task05.repository.RepositoryException;
import by.training.task05.repository.RepositoryFindSortLogic;
import by.training.task05.repository.specification.Specification;
import by.training.task05.service.specification_creator.SpecificationProvider;
import by.training.task05.service.specification_creator.SpecificationXRangeCreator;
import by.training.task05.service.specification_creator.SpeсificationValidator;

public class RepositoryLogicImpl implements RepositoryLogic {

    private static RepositoryLogic instance = new RepositoryLogicImpl();

    private RepositoryLogicImpl() {
    }

    public static RepositoryLogic getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(RepositoryLogicImpl.class);

    SpecificationProvider specificationProvider = SpecificationProvider.getSpecificationProvider();

    /**
     * request in form: name_doubleMin_doubleMax
     */
    @Override
    public List<Sphere> repositoryQuery(String[] specificaionsStr) throws ServiceException {
	RepositoryFindSortLogic repositoryFindSort = RepositoryFindSortLogic.getInstance();

	List<Specification> specifications = fromStringArrayToSpecificationList(specificaionsStr);
	List<Sphere> result = repositoryFindSort.query(specifications);
	return result;
    }

    /**
     * take String [] and convert it into List<Specification> start converting from
     * the [1], not from [0]! Because array will be from controller!
     * 
     * @param specificaionsStr
     * @return List<Specification>
     * @throws ServiceException
     */
    private List<Specification> fromStringArrayToSpecificationList(String[] specificaionsStr)
	    throws ServiceException {

	List<Specification> result = new ArrayList<Specification>();
	// Attention, i = 1!
	for (int i = 1; i < specificaionsStr.length; i++) {
	    Specification tmp;
	    try {
		tmp = specificationProvider.getSpecification(specificaionsStr[i]);
		result.add(tmp);
	    } catch (ServiceException e) {
		LOG.debug("minimal value can't be more than maximim value");
		throw new ServiceException("can't create specification " + e.getMessage());
	    }
	}
	return result;
    }

    @Override
    public boolean intiateRepository(String path) throws ServiceException {
	Repository repository = Repository.getInstance();
	boolean answer = false;
	try {
	    answer = repository.initiateRepository(path);
	} catch (RepositoryException e) {
	    throw new ServiceException(e.getMessage());
	}

	return answer;
    }

    @Override
    public Sphere takeSphereFromRepository(String name) throws ServiceException {
	Sphere result;
	Repository repository = Repository.getInstance();
	try {
	    result = repository.getSphere(name);
	    return result;
	} catch (RepositoryException e) {
	    LOG.debug("can't find sphere from takeSphereFromRepository");
	    throw new ServiceException(e.getMessage());
	}

    }

}
