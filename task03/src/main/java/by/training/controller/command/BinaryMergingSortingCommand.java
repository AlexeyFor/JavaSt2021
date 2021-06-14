package by.training.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.MyArray;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMyArray;

public class BinaryMergingSortingCommand <T extends Comparable<T>> implements Command {

	private static final Logger LOG = LogManager.getLogger(BinaryMergingSortingCommand.class);

	@Override
	public String execute(String[] request) {
		
		if (request.length != 5) {
			LOG.warn("wrong request");
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
				provider.getBinaryMergingSorting().sortIncr(array);
			} else {
				provider.getBinaryMergingSorting().sortDecr(array);
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

		return "0___binary_merge_sort_success";
	}

}
