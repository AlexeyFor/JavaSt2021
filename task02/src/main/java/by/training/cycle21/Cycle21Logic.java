package by.training.cycle21;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.IntervalLogic;
import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * 
 * @author AlexeySupruniuk
 * @see service//IntervalLogic
 */
public class Cycle21Logic {

	private static final Logger LOG = LogManager.getLogger(Cycle21Logic.class);

	private double[] getThreeDoubleFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("getThreeDoubleFromTxt started");

		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();
		double[] masResult = new double[3];

		try {
			LOG.debug("trying get numbers");
			List<String> list = reader.readFile(path);
			masResult[0] = search.searchDouble(list.get(0), "start a: ");
			masResult[1] = search.searchDouble(list.get(1), "start b: ");
			masResult[2] = search.searchDouble(list.get(2), "step h: ");

			return masResult;
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * count function x - Math.sin(x);
	 * 
	 * @param x
	 * @return
	 */
	public double countFunction(double x) {
		double result = x - Math.sin(x);
		return result;
	}

	/**
	 * get parameters (start, end, step) from txt file, check them, get all steps
	 * for this interval and count function. Result as List<double[]>, where [0] =
	 * x, and [1] = F(x)
	 * 
	 * @param path
	 * @return
	 * @throws MyTxtReaderException
	 * @throws SearchDataInStrException
	 */
	public List<double[]> countFunctionWithParamFromTxt(String path)
			throws MyTxtReaderException, SearchDataInStrException {

		LOG.info("start countFunctionWithParamFromTxt");
		IntervalLogic logic = IntervalLogic.getIntervalLogic();
		List<double[]> result = new ArrayList<double[]>();

		try {
			double[] parameters = getThreeDoubleFromTxt(path);
			double startA = parameters[0];
			double endB = parameters[1];
			double stepH = parameters[2];
			double[] stepsForFunction = logic.getIntervalsStep(startA, endB, stepH);

			for (double temp : stepsForFunction) {
				result.add(new double[] { temp, countFunction(temp) });
			}
		} catch (MyTxtReaderException e) {
			LOG.warn(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.warn(e.getMessage());
			throw new SearchDataInStrException(e);
		}
		return result;
	}

	/**
	 * get parameters (start, end, step) from txt file, check them, get all steps
	 * for this interval and count function. Result as List<double[]>, where [0] =
	 * x, and [1] = F(x). Show the whole result
	 * 
	 * @param path
	 */
	public void showCуcle21(String path) {

		List<double[]> result = new ArrayList<double[]>();

		try {
			result = countFunctionWithParamFromTxt(path);
		} catch (MyTxtReaderException e) {
			System.out.println("wrong file");
		} catch (SearchDataInStrException e) {
			System.out.println("wrong data");
		}

		if (result.size() == 0) {
			System.out.println("check entered parameters");
		} else {
			result.forEach(x -> System.out.println(x[0] + "    " + x[1]));
		}
	}
}
