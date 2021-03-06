package by.training.cycle29;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.cycle37.Cycle37Logic;
import by.training.service.ArrayLogic;
import by.training.service.ShowArray;
import by.training.util.MyTxtReader;
import by.training.util.SearchDataInStr;
import by.training.util.exception.MyTxtReaderException;
import by.training.util.exception.SearchDataInStrException;

/**
 * methods for finding common digits from two numbers. Numbers are in the file
 * 
 * @author AlexeySupruniuk
 *
 */
public class Cycle29Logic {

	private static final Logger LOG = LogManager.getLogger(Cycle29Logic.class);

	private int[] takeTwoIntFromTxt(String path) throws SearchDataInStrException, MyTxtReaderException {
		LOG.info("takeTwoIntFromTxt started");

		MyTxtReader reader = MyTxtReader.getMyTxtReader();
		SearchDataInStr search = SearchDataInStr.getSearchDataInStr();
		int[] masResult = new int[2];

		try {
			LOG.debug("trying get numbers");
			List<String> list = reader.readFile(path);
			masResult[0] = search.searchInt(list.get(0), "first int: ");
			masResult[1] = search.searchInt(list.get(1), "second int: ");
			return masResult;
		} catch (MyTxtReaderException e) {
			LOG.error(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.error(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * get two int and and return common digits for two numbers
	 * 
	 * @param mas
	 * @return List with repeated numbers
	 */
	private List<Integer> findEqalsNumInTwoInt(int mas[]) {
		LOG.debug("start findEqalsNumInTwoInt with " + mas[0] + " " + mas[1]);

		Cycle37Logic logic = new Cycle37Logic();
		List<Integer> firstNum = logic.fromIntToIntList(mas[0]);
		List<Integer> secondNum = logic.fromIntToIntList(mas[1]);

		List<Integer> result;

		ArrayLogic arraysLogic = ArrayLogic.getArrayLogic();
		result = arraysLogic.findEqalsFromTwoArrays(firstNum, secondNum);

		return result;
	}

	/**
	 * get path to txt file with two numbers and return common digits for two
	 * numbers
	 * 
	 * @param path
	 * @return
	 * @throws MyTxtReaderException
	 * @throws SearchDataInStrException
	 */
	public int[] coommonDiggitsFromTwoIntTxt(String path) throws MyTxtReaderException, SearchDataInStrException {
		LOG.info("start coommonDiggitsFromTwoIntTxt");

		ArrayLogic arraysLogic = ArrayLogic.getArrayLogic();
		try {
			int[] twoNum = takeTwoIntFromTxt(path);
			List<Integer> list = findEqalsNumInTwoInt(twoNum);
			int[] result = arraysLogic.fromListToArray(list);
			return result;
		} catch (MyTxtReaderException e) {
			LOG.error(e.getMessage());
			throw new MyTxtReaderException(e);
		} catch (SearchDataInStrException e) {
			LOG.error(e.getMessage());
			throw new SearchDataInStrException(e);
		}
	}

	/**
	 * get path to txt file with two numbers and show common digits for two numbers
	 * 
	 * @param path
	 */
	public void execute(String path) {
		LOG.info("start execute");

		ShowArray show = ShowArray.getShowArray();

		try {
			int[] result;
			result = coommonDiggitsFromTwoIntTxt(path);
			show.showArray(result);
		} catch (MyTxtReaderException e) {
			System.out.println("wrong path");
		} catch (SearchDataInStrException e) {
			System.out.println("wrong data");
		}
	}
}
