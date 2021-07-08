package by.training.task05.dal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkWithFileImpl implements WorkWithFile {

	private static final Logger LOG = LogManager.getLogger(WorkWithFileImpl.class);
	private static final WorkWithFileImpl instance = new WorkWithFileImpl();

	private WorkWithFileImpl() {
	}

	public static WorkWithFileImpl getInstance() {
		return instance;
	}

	/**
	 * from file to ArrayList <String>. every line convert into String
	 * 
	 * @param path to the file
	 * @return List <String> from file
	 * @throws MyTxtReaderException
	 */
	public List<String> readFileList(String path) throws DALException {
		LOG.debug("start readFile on path + " + path);
		Path pathFile = Paths.get(path);
		List<String> result = new ArrayList<>();

		try (Stream<String> lineStream = Files.newBufferedReader(pathFile).lines()) {

			result = lineStream.collect(Collectors.toList());

		} catch (IOException ex) {
			throw new DALException("wrong_path");
		}
		// check for the first invalid character
		String tmp = forFirstUnit(result.get(0));
		result.set(0, tmp);
		return result;
	}

	/**
	 * check for the first invalid character
	 * 
	 * @param str
	 * @return
	 */
	private String forFirstUnit(String str) {

		char mas[];
		mas = str.toCharArray();

		if (mas[0] == 65279) {
			char masWithoutFirst[] = new char[mas.length - 1];
			for (int i = 0; i < masWithoutFirst.length; i++) {
				masWithoutFirst[i] = mas[i + 1];
			}
			String firstUnit = new String(masWithoutFirst);
			return firstUnit;
		} else {
			return str;
		}
	}

}
