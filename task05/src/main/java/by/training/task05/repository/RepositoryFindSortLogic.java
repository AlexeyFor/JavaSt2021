package by.training.task05.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.specification.Specification;
import by.training.task05.repository.specification.find.FindSpecification;
import by.training.task05.repository.specification.sort.SortSpecification;

/**
 * 
 * @author AlexeySupruniuk
 *
 *         Logic for searching and sorting elements of Repository
 */
public class RepositoryFindSortLogic {

    private static RepositoryFindSortLogic instance = new RepositoryFindSortLogic();

    private RepositoryFindSortLogic() {
    }

    public static RepositoryFindSortLogic getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(RepositoryFindSortLogic.class);

    /**
     * take both FindSpecification and SearchSpecification. Can sort the found
     * result
     * 
     * @param specifications
     * @return
     */
    public List<Sphere> query(final List<Specification> specifications) {
	LOG.info("start query");
	List<Sphere> result = new ArrayList<Sphere>();
	List<Sphere> tmpList = takeSpheres();
	List<FindSpecification<Sphere>> listFind = new ArrayList<FindSpecification<Sphere>>();
	List<SortSpecification> listSort = new ArrayList<SortSpecification>();

	for (int i = 0; i < specifications.size(); i++) {
	    if (specifications.get(i) instanceof FindSpecification) {
		listFind.add((FindSpecification<Sphere>) specifications.get(i));
	    }
	    if (specifications.get(i) instanceof SortSpecification) {
		listSort.add((SortSpecification) specifications.get(i));
	    }
	}

	result = findSpheres(listFind, tmpList);
	result = sortSpheres(listSort, result);
	return result;
    }

    /**
     * Find Spheres, conjuct all conditions from specifications
     * 
     * @param specifications
     * @param tmpList
     * @return
     */
    private List<Sphere> findSpheres(final List<FindSpecification<Sphere>> specifications,
	    List<Sphere> tmpList) {

	List<Sphere> result = new ArrayList<Sphere>();

	// check for find conditions
	if (!specifications.isEmpty()) {
	    FindSpecification<Sphere> resultSpecification = specifications.get(0);

	    if (specifications.size() > 1) {
		for (int i = 1; i < specifications.size(); i++) {
		    resultSpecification = resultSpecification.and(specifications.get(i));
		}
	    }

	    result = tmpList.stream().filter(resultSpecification).collect(Collectors.toList());
	} else {
	    result = tmpList;
	}

	return result;
    }

    /**
     * sort Spheres, conjuct all comparators from specifications
     * 
     * @param specifications
     * @param spheres
     * @return
     */
    private List<Sphere> sortSpheres(final List<SortSpecification> specifications,
	    List<Sphere> spheres) {

	List<Sphere> result = spheres;

	// check for sort conditions
	if (!specifications.isEmpty()) {
	    Comparator<Sphere> resultComparator = comparatorConjuction(specifications);
	    result.sort(resultComparator);
	}

	return result;

    }

    /**
     * conjuction, join of Comparators
     * 
     * @param specifications
     * @return
     */
    private Comparator<Sphere> comparatorConjuction(final List<SortSpecification> specifications) {
	Comparator<Sphere> result = specifications.get(0).get();

	if (specifications.size() > 1) {
	    for (int i = 1; i < specifications.size(); i++) {
		result = result.thenComparing(specifications.get(i).get());
	    }
	}
	return result;
    }

    private List<Sphere> takeSpheres() {
	List<Sphere> tmpList = new ArrayList<Sphere>();
	// get all spheres
	for (final Map.Entry<String, Sphere> entry : Storage.storageSphere.entrySet()) {
	    tmpList.add(entry.getValue());
	}

	return tmpList;
    }

}
