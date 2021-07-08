package by.training.task05.service.specification_creator;

import java.util.HashMap;
import java.util.Map;

import by.training.task05.repository.specification.Specification;
import by.training.task05.service.ServiceException;

public class SpecificationProvider {

    private static final SpecificationProvider specificationProvider = new SpecificationProvider();

    public static SpecificationProvider getSpecificationProvider() {
	return specificationProvider;
    }

    private Map<String, SpecificationCreator> specifications = new HashMap<String, SpecificationCreator>();

    private SpecificationProvider() {
	// FIND specifications
	specifications.put("FIND X RANGE", new SpecificationXRangeCreator());
	specifications.put("FIND Y RANGE", new SpecificationYRangeCreator());
	specifications.put("FIND Z RANGE", new SpecificationZRangeCreator());
	specifications.put("FIND COORDINATE BEGINING RANGE",
		new SpecificationBegginingRangeCreator());
	specifications.put("FIND ID", new SpecificationIDCreator());
	specifications.put("FIND NAME", new SpecificationNameCreator());
	specifications.put("FIND RADIUS RANGE", new SpecificationRadiusRangeCreator());
	specifications.put("FIND SQUARE RANGE", new SpecificationSquareRangeCreator());
	specifications.put("FIND VOLUME RANGE", new SpecificationVolumeRangeCreator());
	specifications.put("FIND SYMBOLS", new SpecificationSymbolsCreator());
	// sort specifications
	specifications.put("SORT X", new SortSpecificationXCreator());
	specifications.put("SORT Y", new SortSpecificationYCreator());
	specifications.put("SORT Z", new SortSpecificationZCreator());
	specifications.put("SORT NAME", new SortSpecificationNameCreator());
	specifications.put("SORT RADIUS", new SortSpecificationRadiusCreator());
	specifications.put("SORT SQUARE", new SortSpecificationSquareCreator());
	specifications.put("SORT VOLUME", new SortSpecificationVolumeCreator());

	specifications.put("ERROR SPECIFICATION", new ErrorSpecification());

    }

    private SpecificationCreator getSpecificationCreator(String key) {
	if (specifications.containsKey(key)) {
	    SpecificationCreator creator = specifications.get(key);
	    return creator;
	} else {
	    return specifications.get("ERROR SPECIFICATION");
	}
    }

    public Specification getSpecification(String request) throws ServiceException {
	Specification result;
	String[] params;
	String SpecificationName;

	params = request.split("_");
	SpecificationName = params[0];

	SpecificationCreator creator = getSpecificationCreator(SpecificationName);

	result = creator.createSpecification(params);

	return result;
    }
}
