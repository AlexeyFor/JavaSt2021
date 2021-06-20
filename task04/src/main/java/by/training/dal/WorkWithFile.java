package by.training.dal;

import java.util.List;

public interface WorkWithFile {

	public List<String> readFileList(String path) throws DALException;
	
	public String readFileString(String path) throws DALException;

	public boolean writeInFile(String savingObj, String path) throws DALException;

}
