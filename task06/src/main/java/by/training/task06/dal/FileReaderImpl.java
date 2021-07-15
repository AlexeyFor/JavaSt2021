package by.training.task06.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Logics for working with file
 */
public class FileReaderImpl implements FileReaderInterface {

    private static final Logger LOG = LogManager.getLogger(FileReaderImpl.class);

    private FileReaderImpl() {
    }

    private static class SingletonHolder {
	public static final FileReaderImpl HOLDER_INSTANCE = new FileReaderImpl();
    }

    public static FileReaderImpl getInstance() {
	return SingletonHolder.HOLDER_INSTANCE;
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
	// check for the first invalid character
	String tmp = forFirstUnit(list.get(0));
	list.set(0, tmp);
	return list;
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

	if (mas.length > 0) {
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
	} else {
	    return str;
	}
    }
}
