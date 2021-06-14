package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.Matrix;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMatrix;

/**
 * request in form:
 * 
 * command___fileName
 * 
 * filename - name of the file from console
 * 
 * @author AlexeySupruniuk
 *
 */

public class ShowMatrixCommand implements Command {

	private static final Logger LOG = LogManager.getLogger(ShowMatrixCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 2) {
			LOG.warn("wrong request");
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1]);

		ShowMatrix show = ShowMatrix.getInstance();
		ServiceProvider provider = ServiceProvider.getInstance();
		Matrix<?> matrix;

		try {
			matrix = provider.getLogic().takeMatrix(request[1]);
			show.showMatrix(matrix);
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		return "0___matrix_show_success";
	}
}
