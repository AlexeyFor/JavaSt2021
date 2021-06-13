package by.training.controller.command;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.controller.Command;
import by.training.entity.Matrix;
import by.training.service.MatrixCalculation;
import by.training.service.ServiceException;
import by.training.service.ServiceProvider;
import by.training.view.ShowMatrix;

/**
 * request in form:
 * 
 * command___fileName1___fileName2
 * 
 * filename - name of the file from console
 * 
 * 
 * @author AlexeySupruniuk
 *
 */
public class MatrixMultiplicationCommand<T extends Number> implements Command {

	private static final Logger LOG = LogManager.getLogger(MatrixMultiplicationCommand.class);

	@Override
	public String execute(String[] request) {

		if (request.length != 3) {
			return "1___wrong_request";
		}

		LOG.debug("start execute with " + request[1] + " " + request[2]);

		String firstMatrixFile = request[1];
		String secondMatrixFile = request[2];
		ServiceProvider provider = ServiceProvider.getInstance();
		Matrix<T> firstMatrix;
		Matrix<T> secondMatrix;

		try {
			// get two Matrix
			firstMatrix = provider.getLogic().takeMatrix(firstMatrixFile);
			secondMatrix = provider.getLogic().takeMatrix(secondMatrixFile);
			// calculate result of their multiplication
			MatrixCalculation calc = provider.getMatrixCalculation();
			Matrix<BigDecimal> result = calc.matrixMultiplication(firstMatrix, secondMatrix);

			ShowMatrix show = ShowMatrix.getInstance();
			show.showMatrix(result);
		} catch (ServiceException e) {
			LOG.error("from execute, " + e.getMessage());
			return "1___" + e.getMessage();
		}

		return "0___matrix_multiplication_success";

	}
}
