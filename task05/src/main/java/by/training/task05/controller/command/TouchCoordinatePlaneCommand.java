package by.training.task05.controller.command;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.controller.Command;
import by.training.task05.entity.Sphere;
import by.training.task05.service.RepositoryLogic;
import by.training.task05.service.ServiceException;
import by.training.task05.service.ServiceProvider;
import by.training.task05.service.SphereLogic;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         command___SphereName
 *
 */
public class TouchCoordinatePlaneCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(InitiateRepositoryCommand.class);

    @Override
    public String execute(String[] request) {
	final int MAX_REQUEST_NUMBER = 2;

	if (request.length != MAX_REQUEST_NUMBER) {
	    LOG.warn("wrong request");
	    return "1___wrong_request";
	}
	LOG.debug("start execute with " + Arrays.toString(request));

	SphereLogic SphereLogic = ServiceProvider.getInstance().getSphereLogic();
	RepositoryLogic repositoryLogic = ServiceProvider.getInstance().getRepositoryLogic();
	String result;

	String sphereName = request[1];
	Sphere sphere;
	try {
	    sphere = repositoryLogic.takeSphereFromRepository(sphereName);
	    result = SphereLogic.sphereTouchCoordinatePlanes(sphere);

	    if (result.length() > 1) {
		return "0___touch_coordinates" + result;
	    } else {
		return "0___don't_touch_coordinates";
	    }
	} catch (ServiceException e) {
	    LOG.warn("wrong request");
	    return "1___not_in_repository";
	}

    }
}
