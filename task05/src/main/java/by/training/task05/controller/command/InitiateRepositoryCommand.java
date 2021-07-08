package by.training.task05.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.controller.Command;
import by.training.task05.service.RepositoryLogic;
import by.training.task05.service.ServiceException;
import by.training.task05.service.ServiceProvider;

/**
 * request in form:
 * 
 * command___fileName
 * 
 * @author AlexeySupruniuk
 *
 */
public class InitiateRepositoryCommand implements Command {

    private static final Logger LOG = LogManager.getLogger(InitiateRepositoryCommand.class);

    @Override
    public String execute(String[] request) {
	final int MAX_REQUEST_NUMBER = 2;

	if (request.length != MAX_REQUEST_NUMBER) {
	    LOG.warn("wrong request");
	    return "1___wrong_request";
	}
	LOG.debug("start execute with " + request[1]);
	boolean answer = false;

	String fileName = request[1];

	RepositoryLogic repositoryLogic = ServiceProvider.getInstance().getRepositoryLogic();

	try {
	    answer = repositoryLogic.intiateRepository(fileName);
	} catch (ServiceException e) {
	    LOG.error("from execute, " + e.getMessage());
	    return "1___" + e.getMessage();
	}

	if (answer) {
	    return "0___intiate_success";
	} else {
	    return "1___intiate_failed";
	}

    }
}
