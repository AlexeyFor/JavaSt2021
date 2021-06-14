package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.MyArray;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMyArray;


/**
 * request in form:
 * 
 * command___fileName___ascending___saving___show
 * 
 * filename - name of the file from console
 * 
 * saving - save the result of sorting
 * 
 * show - show the result of sorting on console
 * 
 * @author AlexeySupruniuk
 *
 */
public class ShellSortingCommand <T extends Comparable<T>> implements Command {

	private static final Logger LOG = LogManager.getLogger(BubbleSortingCommand.class);

	@Override
	public String execute(String[] request) {
		
		if (request.length != 5) {
			return "1___wrong_request";
		}
		LOG.debug("start execute with " + request[1] + " " + request[2] + " " + request[3] + " " + request[4]);
		
		String fileName = request[1];
		boolean ascending = Boolean.valueOf(request[2]);
		boolean saving = Boolean.valueOf(request[3]);
		boolean show = Boolean.valueOf(request[4]);
		LOG.debug("get ascending " + ascending + " ,saving " + saving + " ,show " + show);

		ServiceProvider provider = ServiceProvider.getInstance();
		try {
			MyArray<T> array = provider.getLogic().takeMyArray(fileName);

			if (ascending) {
				provider.getShellSorting().sortIncr(array);
			} else {
				provider.getShellSorting().sortDecr(array);
			}

			if (saving) {
				LOG.debug("saving array");
				provider.getLogic().saveMyArray(array, fileName);
			}

			if (show) {
				LOG.debug("showing array");
				ShowMyArray showArr = ShowMyArray.getInstance();
				showArr.showMyArrayInRow(array, 50);
			}

		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		return "0___shell_sort_success";
	}

}
