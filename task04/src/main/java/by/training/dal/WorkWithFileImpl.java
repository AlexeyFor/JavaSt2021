package by.training.dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		File file = new File(path);
		BufferedReader reader = null;
		String line;
		ArrayList<String> list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				list.add(line.trim());
			}
			reader.close();
		} catch (IOException ex) {
			throw new DALException("wrong_path");
		}
		//check for the first invalid character
		String tmp = forFirstUnit(list.get (0));
		list.set (0, tmp);
		return list;
	}
	
	/**
	 * from file to String
	 * 
	 * @param path to the file
	 * @throws MyTxtReaderException
	 */
	public String readFileString(String path) throws DALException {
		LOG.debug("start readFile on path + " + path);
		File file = new File(path);
		BufferedReader reader = null;
		String line;
		StringBuilder result = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				result.append(line.trim());
			}
			reader.close();
		} catch (IOException ex) {
			throw new DALException("wrong_path");
		}
		String resultStr = forFirstUnit(new String(result));
		
		return resultStr;
	}

	/**
	 * save String in file 
	 * @param savingObj
	 * @param path
	 * @return
	 * @throws DALException
	 */
	public boolean writeInFile(String savingObj, String path) throws DALException {

		File file = new File(path);

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(savingObj);
			writer.close();
			return true;
		} catch (IOException ex) {
			throw new DALException("ошибка доступа к файлу");
		}
	}
	
	/**
	 * check for the first invalid character
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
