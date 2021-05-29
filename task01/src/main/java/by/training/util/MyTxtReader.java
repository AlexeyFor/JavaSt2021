package by.training.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.util.exception.MyTxtReaderException;

/**
 * read .txt, return List <String> from document
 * 
 * @author AlexeySupruniuk
 * 
 */
public class MyTxtReader {

	private static final Logger LOG = LogManager.getLogger(MyTxtReader.class);
	private static final MyTxtReader myTxtReader = new MyTxtReader();

	private MyTxtReader() {
	}

	/**
	 * @return MyTxtReader myTxtReader
	 */
	public static MyTxtReader getMyTxtReader() {
		return myTxtReader;
	}

	/**
	 * * from file to ArrayList <String>. every line convert into String
	 * 
	 * @param path to the file
	 * @return List <String> from file
	 * @throws MyTxtReaderException
	 */
	public List<String> readFile(String path) throws MyTxtReaderException {
		LOG.debug("start readFile on path + " + path);
		File file = new File(path);
		BufferedReader reader = null;
		String line;
		ArrayList<String> list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			reader.close();
		} catch (IOException ex) {
			LOG.warn("ошибка доступа к файлу");
			throw new MyTxtReaderException("ошибка доступа к файлу");
		}
		return list;
	}

}
