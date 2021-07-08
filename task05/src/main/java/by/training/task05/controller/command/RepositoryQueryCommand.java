package by.training.task05.controller.command;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.controller.Command;
import by.training.task05.entity.Sphere;
import by.training.task05.service.RepositoryLogic;
import by.training.task05.service.ServiceException;
import by.training.task05.service.ServiceProvider;
import by.training.task05.view.ShowSphere;

/**
 * One can combine any of three query in one command, example:
 * 
 * command___name_doubleMin_doubleMax___name_ID___name___name
 * 
 * request in form:
 * 
 * 1) command___name_doubleMin_doubleMax___name_doubleMin_doubleMax ...
 * 
 * name_doubleMin_doubleMax - query to repository, where:
 * 
 * name - name of Find specification
 * 
 * doubleMin - minimum range limit
 * 
 * doubleMax - maximum range limit
 * 
 * 2) command___name_SphereName___name_Symbols___name_ID...
 * 
 * where:
 * 
 * name - name of Find specification
 * 
 * Symbols - searching characters in the Sphere.name
 * 
 * ID - searching ID in the Sphere.ID
 * 
 * 3) command___name___name...
 * 
 * name - name of Sort specification
 * 
 * @author AlexeySupruniuk
 *
 */
public class RepositoryQueryCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(InitiateRepositoryCommand.class);

    @Override
    public String execute(String[] request) {
	final int MIN_REQUEST_NUMBER = 2;
	if (request.length < MIN_REQUEST_NUMBER) {
	    LOG.warn("wrong request");
	    return "1___wrong_request";
	}
	LOG.debug("start execute with " + Arrays.toString(request));

	RepositoryLogic repositoryLogic = ServiceProvider.getInstance().getRepositoryLogic();
	ShowSphere show = ShowSphere.getInstance();

	try {
	    List<Sphere> result;
	    result = repositoryLogic.repositoryQuery(request);
	    show.showListOfSpheres(result);
	} catch (ServiceException e) {
	    LOG.error("from execute, " + e.getMessage());
	    return "1___" + e.getMessage();
	}

	return "0___query_success";

    }
}
